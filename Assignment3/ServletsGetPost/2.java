import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showParams")
public class ShowParametersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Handle POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Common logic for both GET and POST requests
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Submitted Request Parameters</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 30px; background-color: #f8f9fa; }");
        out.println("table { width: 70%; border-collapse: collapse; margin: 20px auto; background-color: #ffffff; }");
        out.println("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
        out.println("th { background-color: #198754; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("h2, p { text-align: center; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Request Parameters Received</h2>");
        out.println("<p><strong>HTTP Method:</strong> " + request.getMethod() + "</p>");

        // getParameterMap() handles single values and multi-value fields (checkboxes, multi-selects)
        Map<String, String[]> paramMap = request.getParameterMap();

        if (paramMap.isEmpty()) {
            out.println("<p style='color: red;'>No parameters were received in this request.</p>");
        } else {
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>Parameter Name</th><th>Parameter Value(s)</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                String paramName = entry.getKey();
                String[] paramValues = entry.getValue();

                // Format multiple values cleanly (e.g., [value1, value2])
                String displayValue = (paramValues.length > 1) 
                        ? Arrays.toString(paramValues) 
                        : (paramValues.length == 1 ? paramValues[0] : "<i>empty</i>");

                out.println("<tr>");
                out.println("<td><strong>" + paramName + "</strong></td>");
                out.println("<td>" + displayValue + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}