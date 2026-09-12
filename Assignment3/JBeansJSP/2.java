import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param = request.getParameter("operation");
        String targetPage;

        try {
            int value = Integer.parseInt(param);
            request.setAttribute("inputValue", value);

            if (value < 10) {
                targetPage = "page1.jsp";
            } else if (value > 10 && value < 99) {
                targetPage = "page2.jsp";
            } else {
                targetPage = "errorPage.jsp";
            }
        } catch (NumberFormatException e) {
            targetPage = "errorPage.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
        dispatcher.forward(request, response);
    }
}