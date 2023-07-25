package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        writer.println("<ul>");
        for (Cookie c : cookies) {
            writer.printf("<li>%s - %s", c.getName(), c.getValue());
            writer.printf("<a href=\"/removeCookie?name=%s\">Usuń</a></li>", c.getName());
        }
        writer.println("</ul>");
    }
}
