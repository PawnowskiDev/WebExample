package pl.coderslab.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/post2")
public class Form2 extends HttpServlet {

    private final List<String> swearwords = List.of("chorera", "dupa", "kurwa", "motyla noga");

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String agree = request.getParameter("agree");
        String text = request.getParameter("text");

        if (agree == null) {
            for (String swear : swearwords) {
                if (text.contains(swear)) {
                    text = text.replaceAll(swear, "*".repeat(swear.length()));
                }
            }
        }
            response.getWriter().println(text);
    }
}
