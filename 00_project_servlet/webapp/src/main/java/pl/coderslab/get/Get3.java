package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Get3")
public class Get3 extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Pobieramy wartości parametrów "width" i "height" z zapytania HTTP
        String w = request.getParameter("width");
        String h = request.getParameter("height");

        // Jeśli wartość parametru "width" nie została przekazana w zapytaniu, ustawiamy ją na domyślną wartość "5"
        if (w == null) {
            w = "5";
        }

        // Jeśli wartość parametru "height" nie została przekazana w zapytaniu, ustawiamy ją na domyślną wartość "10"
        if (h == null) {
            h = "10";
        }

        // Konwertujemy pobrane wartości parametrów "width" i "height" na liczby całkowite
        int width = Integer.parseInt(w);
        int height = Integer.parseInt(h);

        // Generujemy tabelę wynikową o podanej szerokości i wysokości
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                response.getWriter().append(String.valueOf( i * j )).append(" ");
            }
        // Po wygenerowaniu jednego wiersza tabeli, przechodzimy do następnego wiersza w odpowiedzi HTTP
            response.getWriter().println();
        }


    }
}
