import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/headers")
public class RequestHeadersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HTTP Request Headers</title>");
        out.println("<style>");
        out.println("table { width: 80%; border-collapse: collapse; margin: 20px auto; font-family: Arial, sans-serif; }");
        out.println("th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }");
        out.println("th { background-color: #0d6efd; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("h2 { text-align: center; font-family: Arial, sans-serif; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h2>HTTP Request Headers and Values</h2>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
        out.println("</thead>");
        out.println("<tbody>");

        // Retrieve all header names sent with the request
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);

            out.println("<tr>");
            out.println("<td><strong>" + headerName + "</strong></td>");
            out.println("<td>" + headerValue + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}