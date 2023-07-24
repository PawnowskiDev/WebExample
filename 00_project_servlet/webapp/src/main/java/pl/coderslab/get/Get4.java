package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/Get4")
public class Get4 extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // Pobieramy mapę zawierającą parametry przekazane w zapytaniu HTTP.
        // Kluczem w mapie będzie nazwa parametru, a wartością tablica łańcuchów znaków zawierających wartości parametru.
        Map<String, String[]> parameterMap = request.getParameterMap();

        // Iterujemy przez wszystkie wpisy w mapie, czyli przez wszystkie parametry przekazane w zapytaniu HTTP.
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            // Wypisujemy nazwę parametru do odpowiedzi HTTP.
            // Wartość parametru to tablica łańcuchów znaków, więc jeśli dany parametr
            // był przekazywany wielokrotnie z różnymi wartościami, zostaną one wyświetlone osobno.
            response.getWriter().append(entry.getKey()).append(":").println();

            // Iterujemy przez wszystkie wartości danego parametru.
            for (String s : entry.getValue()) {
                // Wypisujemy każdą wartość parametru z wcięciem, aby wyglądało to bardziej czytelnie.
                response.getWriter().append("\t- ").append(s).println();
            }
        }
    }
}
