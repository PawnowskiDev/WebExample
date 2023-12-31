package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


@WebServlet ("/Get2")
public class Get2 extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      Map<String, String[]> parametrMap = request.getParameterMap();

      for (Map.Entry<String, String[]> kv : parametrMap.entrySet()) {
          response.getWriter().append(kv.getKey())
                  .append("\n")
                  .append(Arrays.toString(kv.getValue()))
                  .append("\n");
      }
    }
}

