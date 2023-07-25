package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/cookie52")
public class Cookie52 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean cookieFound = false;

        for (Cookie c : cookies) {
            if ("cookie51".equals(c.getName())) {
                cookieFound = true;
                c.setMaxAge(0);
                resp.addCookie(c);
                break;
            }
        }

        if (cookieFound) {
            resp.getWriter().println("Witamy na stronie Cookie52");
        } else {
            String message = "FirstVisitCookie51";
            resp.sendRedirect("/cookie51?msg=" + URLEncoder.encode(message, StandardCharsets.UTF_8));
        }
    }
}
