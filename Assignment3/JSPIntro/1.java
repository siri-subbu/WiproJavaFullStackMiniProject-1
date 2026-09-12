import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int limit = Integer.parseInt(request.getParameter("limit"));
        ArrayList<Integer> primeList = new ArrayList<>();

        // Generate prime numbers less than the given number
        for (int i = 2; i < limit; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }

        // Store the list and input limit in request scope
        request.setAttribute("primes", primeList);
        request.setAttribute("inputLimit", limit);

        // Forward request and response to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayPrimes.jsp");
        dispatcher.forward(request, response);
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}