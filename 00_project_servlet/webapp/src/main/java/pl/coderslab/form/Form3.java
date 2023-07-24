package pl.coderslab.form;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet("/getForm3")
public class Form3 extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServerException, IOException {
        String page = request.getParameter("page");
        int parsed = Integer.parseInt(page);

        for (int i = 1; i <= parsed / 2; i++) {
            if (parsed % i == 0) {
                response.getWriter().println();
            }
        }
        response.getWriter().println(parsed);
    }


}
