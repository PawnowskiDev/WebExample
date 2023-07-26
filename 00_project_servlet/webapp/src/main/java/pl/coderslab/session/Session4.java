package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session4")
public class Session4 extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            return;
        }

        response.setContentType("text/plan;charset=utf-8");
        double sum = 0;
        for (CartItem ci : cart) {
            double ciPrice = ci.getQuantity() * ci.getPrice();
            sum += ciPrice;
            response.getWriter().printf("%s - %d x %.2fzł = %02.2fzł%n", ci.getName(), ci.getQuantity(), ci.getPrice(), ciPrice);
        }
        response.getWriter().printf("SUMA: %.2fzł", sum);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        CartItem cartItem = new CartItem(name, quantity, price);
        cart.add(cartItem);
        session.setAttribute("cart", cart);
        resp.sendRedirect("/session4");
    }
}

