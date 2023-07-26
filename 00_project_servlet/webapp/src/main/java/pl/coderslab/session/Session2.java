package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form method=\"post\">");
        out.println("<input type=\"number\" name=\"mark\" />");
        out.println("<input type=\"submit\"/>");
        out.println("</form>");
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Integer> marks = (List<Integer>) session.getAttribute("marks");
        if (marks == null) {
            marks = new ArrayList<>();
        }

        String mark = request.getParameter("mark");
        int parsed = Integer.parseInt(mark);
        marks.add(parsed);
        session.setAttribute("marks" , marks);
        double sum = 0;

        for (Integer i : marks) {
            sum += i;
        }

        response.getWriter().println("Marks: " + marks + "Average: " + (sum / marks.size()));
    }
}
