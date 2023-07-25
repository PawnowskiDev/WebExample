package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteCookie")
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        Cookie user = null;

        for (Cookie c : cookies) {
            if ("User".equals(c.getName())) {
                user = c;
                break;
            }
        }
        if (user == null) {
            response.getWriter().println("BRAK");
        } else {
            user.setMaxAge(0);
            response.addCookie(user);
            response.getWriter().println("Ciasteczko usunięte");
        }
    }
}
