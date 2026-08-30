import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessionTracker")
public class SessionTrackerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Get current session or create a new one
        HttpSession session = request.getSession(true);

        // 2. Track visit count
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount = visitCount + 1;
        }

        // Save updated count back into the session
        session.setAttribute("visitCount", visitCount);

        // 3. Retrieve session metadata
        String sessionId = session.getId();
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessedTime = new Date(session.getLastAccessedTime());
        int maxInactiveInterval = session.getMaxInactiveInterval();
        boolean isNew = session.isNew();

        // 4. Display output in a table
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Tracking</title></head>");
        out.println("<body>");

        out.println("<h2>Session Details & Visit Tracker</h2>");

        out.println("<table border='1'>");
        out.println("<tr><th>Property</th><th>Value</th></tr>");
        
        out.println("<tr><td>Visit Count</td><td>" + visitCount + "</td></tr>");
        out.println("<tr><td>Session ID</td><td>" + sessionId + "</td></tr>");
        out.println("<tr><td>Is New Session?</td><td>" + isNew + "</td></tr>");
        out.println("<tr><td>Creation Time</td><td>" + creationTime + "</td></tr>");
        out.println("<tr><td>Last Accessed Time</td><td>" + lastAccessedTime + "</td></tr>");
        out.println("<tr><td>Max Inactive Interval (seconds)</td><td>" + maxInactiveInterval + "</td></tr>");
        
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}