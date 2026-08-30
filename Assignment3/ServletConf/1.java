import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"/configContext"},
    initParams = {
        @WebInitParam(name = "configUser", value = "Admin"),
        @WebInitParam(name = "configEmail", value = "admin@example.com")
    }
)
public class ConfigContextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Obtain ServletConfig and ServletContext objects
        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>ServletConfig and ServletContext</title></head>");
        out.println("<body>");

        // 2. Display ServletConfig Parameters (Servlet-specific)
        out.println("<h2>ServletConfig Init Parameters</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");

        Enumeration<String> configParams = config.getInitParameterNames();
        while (configParams.hasMoreElements()) {
            String paramName = configParams.nextElement();
            String paramValue = config.getInitParameter(paramName);
            out.println("<tr>");
            out.println("<td>" + paramName + "</td>");
            out.println("<td>" + paramValue + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        // 3. Display ServletContext Parameters (Application-wide)
        out.println("<h2>ServletContext Init Parameters</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Parameter Name</th><th>Parameter Value</th></tr>");

        Enumeration<String> contextParams = context.getInitParameterNames();
        while (contextParams.hasMoreElements()) {
            String paramName = contextParams.nextElement();
            String paramValue = context.getInitParameter(paramName);
            out.println("<tr>");
            out.println("<td>" + paramName + "</td>");
            out.println("<td>" + paramValue + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}