package pl.coderslab.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post4")
public class Form4 extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");

        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        int cInt = Integer.parseInt(c);

        int delta = bInt * bInt - 4 * aInt * cInt;

        if (delta < 0) {
            response.getWriter().println("Delta mniejsza od 0, brak rozwiązań");
        } else if (delta == 0) {
            int x0 = -bInt / 2 * aInt;
            response.getWriter().println("Jedno miejsce zerowe: " + x0);
        } else {
            double x1 = (-bInt - Math.sqrt(delta)) / 2 * aInt;
            double x2 = (-bInt + Math.sqrt(delta)) / 2 * aInt;
            response.getWriter().println("Dwa rozwiązania : " + x1 + "oraz : " + x2);
        }
    }
}
