package pl.coderslab.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet("/session1Set")
public class Session1Set extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServerException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("counter", 0);
    }
}
