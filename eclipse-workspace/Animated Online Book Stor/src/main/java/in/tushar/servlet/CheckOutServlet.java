package in.tushar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.tushar.dao.OrderDao;
import in.tushar.dto.Order;
import in.tushar.dto.Products;
import in.tushar.dto.ShopingCart;
import in.tushar.util.ConnectionFactory;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            @SuppressWarnings("unchecked")
            ArrayList<ShopingCart> cart_list = (ArrayList<ShopingCart>) request.getSession().getAttribute("cart-list");
            Products auth = (Products) request.getSession().getAttribute("auth");

            if (cart_list != null && auth != null) {
                OrderDao oDao = new OrderDao(ConnectionFactory.getConnection());

                for (ShopingCart c : cart_list) {
                    Order order = new Order();
                    order.setId(c.getId());
                    order.setUid(auth.getId());
                    order.setQunatity(c.getQuantity());
                    order.setDate(formatter.format(date));

                    boolean result = oDao.insertOrder(order);
                    if (!result) {
                        out.println("Order failed for product ID: " + c.getId());
                        return;
                    }
                }

                cart_list.clear();
                response.sendRedirect("orders.jsp");
            } else {
                if (auth == null) {
                    response.sendRedirect("login.jsp");
                } else {
                    response.sendRedirect("shopping-cart.jsp"); // Adjust if your JSP file name is different
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
