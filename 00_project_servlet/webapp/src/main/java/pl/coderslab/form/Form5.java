package pl.coderslab.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post5")
public class Form5 extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String degrees = request.getParameter("degrees");
        String conversionType = request.getParameter("conversionType");
        double parsed = Double.parseDouble(degrees);
        double converted = 0;

        if ("celcToFahr".equals(conversionType)) {
            converted = 32 + 9.0 / 5 * parsed;
        } else if ("fahrToCelc".equals(conversionType)) {
            converted = 5.0 / 9 * (parsed - 32);
        }
        response.getWriter().println("Stopnie po konwersji: %.2f\", converted");
    }
}
