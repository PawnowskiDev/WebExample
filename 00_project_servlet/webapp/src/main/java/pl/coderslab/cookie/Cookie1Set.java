package pl.coderslab.cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setCookie")
public class Cookie1Set extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException {

        // tworzymy nowe ciasteczko o nazwie User i z wartością CodersLab
        Cookie cookie = new Cookie("User", "CodersLab");

        // ustawiamy żywotność na 24h
        cookie.setMaxAge(86400);

        // odpowiedz
        response.addCookie(cookie);
    }
}
