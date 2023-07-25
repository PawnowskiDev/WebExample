package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCookies")
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String key = request.getParameter("key");
        String value = request.getParameter("value");

        if (key == null || value == null) {
            throw new IllegalArgumentException("Both partameters are required");
        }

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        response.getWriter().println("Cookie set");

    }
}
