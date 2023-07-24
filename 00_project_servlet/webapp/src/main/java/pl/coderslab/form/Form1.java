package pl.coderslab.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post1")
public class Form1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String surname = request.getParameter("surname");

        PrintWriter out = response.getWriter();
        out.println("Witaj");
        out.println(firstName + " ");
        out.println(surname);

    }
}
