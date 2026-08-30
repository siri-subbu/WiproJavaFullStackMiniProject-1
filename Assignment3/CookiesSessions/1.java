import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessionVisitorCheck")
public class SessionVisitorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the current session, or create one if it doesn't exist
        HttpSession session = request.getSession(true);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Visitor Tracking</title></head>");
        out.println("<body>");

        // isNew() returns true if the client has not yet joined the session
        if (session.isNew()) {
            out.println("<h2>Welcome, you are visiting for the first time</h2>");
        } else {
            out.println("<h2>Welcome Back</h2>");
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}