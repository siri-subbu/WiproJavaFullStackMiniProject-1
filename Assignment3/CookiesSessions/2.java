import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/displayCookies")
public class DisplayCookiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Retrieve cookies from the request
        Cookie[] cookies = request.getCookies();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>All Cookies</title></head>");
        out.println("<body>");

        // 2. Check if cookies exist
        if (cookies == null || cookies.length == 0) {
            out.println("<h2>No Cookies</h2>");
        } else {
            out.println("<h2>Available Cookies</h2>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Cookie Name</th>");
            out.println("<th>Cookie Value</th>");
            out.println("</tr>");

            for (Cookie cookie : cookies) {
                out.println("<tr>");
                out.println("<td>" + cookie.getName() + "</td>");
                out.println("<td>" + cookie.getValue() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}