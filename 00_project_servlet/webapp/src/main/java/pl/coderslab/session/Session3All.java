package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllSessions")
public class Session3All extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<String> keys = (List<String>) session.getAttribute(Session3Add.KEYS);

        if (keys != null) {
            for (String k : keys) {
                response.getWriter().println(k + ": " + session.getAttribute(k));
            }
        }
    }
}
