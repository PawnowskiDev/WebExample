package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Get1")
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String start = request.getParameter("start");
        String end = request.getParameter("end");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Get1</title></head>");
        out.println("<body>");


        if (start != null && end != null) {
            try {
                int startNumber = Integer.parseInt((start));
                int endNumber = Integer.parseInt((end));

                if ((startNumber < +endNumber)) {
                    for (int i = startNumber; i <= endNumber; i++) {
                        out.println("<p>" + i + "</p>");
                    }
                } else {
                    out.println("<p> Parametr START musi być mnniejszy lób równy paramterowi END </p>");
                }
            } catch (NumberFormatException e) {
                out.println("<p> Błędne wartości parametrów");
            }
        } else {
            out.println("<> BRAK </p>");
        }

        out.println("</body><body>");
    }
}