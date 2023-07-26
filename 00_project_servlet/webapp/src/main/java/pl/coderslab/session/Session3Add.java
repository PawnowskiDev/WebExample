package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToSession")
public class Session3Add extends HttpServlet {

    public static final String KEYS = "_keys";

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        List<String> keys = (List<String>) session.getAttribute(KEYS);
        if (keys == null) {
            keys = new ArrayList<>();
        }

        if (KEYS.equals(key)) {
            throw new IllegalArgumentException("Provide other key name");
        }

        session.setAttribute(key, value);
        keys.add(key);
        session.setAttribute(KEYS, keys);
    }
}
