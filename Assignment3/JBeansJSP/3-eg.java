import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpBean emp = (EmpBean) request.getAttribute("empBean");
        String action = (String) request.getAttribute("action");

        // Fallback reading if accessed directly
        if (action == null) {
            action = request.getParameter("action");
        }

        String message = "";

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) {
                message = "Database connection failed.";
            } else if ("insert".equalsIgnoreCase(action)) {
                String query = "INSERT INTO emp (id, name, designation) VALUES (?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setInt(1, emp.getId());
                    ps.setString(2, emp.getName());
                    ps.setString(3, emp.getDesignation());
                    int rows = ps.executeUpdate();
                    message = (rows > 0) ? "Record inserted successfully!" : "Failed to insert record.";
                }
            } else if ("update".equalsIgnoreCase(action)) {
                String query = "UPDATE emp SET name = ?, designation = ? WHERE id = ?";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setString(1, emp.getName());
                    ps.setString(2, emp.getDesignation());
                    ps.setInt(3, emp.getId());
                    int rows = ps.executeUpdate();
                    message = (rows > 0) ? "Record updated successfully!" : "Record with given ID not found.";
                }
            } else if ("delete".equalsIgnoreCase(action)) {
                String query = "DELETE FROM emp WHERE id = ?";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setInt(1, emp.getId());
                    int rows = ps.executeUpdate();
                    message = (rows > 0) ? "Record deleted successfully!" : "Record with given ID not found.";
                }
            }
        } catch (SQLException e) {
            message = "Database Error: " + e.getMessage();
        }

        request.setAttribute("resultMessage", message);
        displayAllRecords(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        displayAllRecords(request, response);
    }

    private void displayAllRecords(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<EmpBean> empList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            if (con != null) {
                String query = "SELECT id, name, designation FROM emp ORDER BY id ASC";
                try (PreparedStatement ps = con.prepareStatement(query);
                     ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        EmpBean e = new EmpBean();
                        e.setId(rs.getInt("id"));
                        e.setName(rs.getString("name"));
                        e.setDesignation(rs.getString("designation"));
                        empList.add(e);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("empList", empList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayRecords.jsp");
        dispatcher.forward(request, response);
    }
}