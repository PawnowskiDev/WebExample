package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet14")
public class Servlet14 extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        String browser = request.getHeader("User-Agent");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Servlet14</title></head>");
        out.println("<body>");
        out.println("<h1>Informacje o kliencie:</h1>");
        out.println("<p>Adres IP: " + ip + "</p>");
        out.println("<p>Przeglądarka: " + browser + "</p>");
        out.println("</body></html>");
    }

}
