package in.tushar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.tushar.dao.LoginDAO;
import in.tushar.dto.RegrestationDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // Get data from login.jsp
            String emailId = req.getParameter("emailId");
            String password = req.getParameter("pswId");

            RegrestationDTO dto = new RegrestationDTO();
            dto.setEmail(emailId);
            dto.setPsw(password);

            // Call DAO method
            LoginDAO dao = new LoginDAO();
            boolean status = dao.check(dto);

            // Set response content type
            res.setContentType("text/html");
            PrintWriter writer = res.getWriter();

            if (status) {
                // Set session attribute for user authentication
                req.getSession().setAttribute("name", emailId);
                res.sendRedirect("index.jsp");  // Redirect to index.jsp
            } else {
                req.getSession().setAttribute("message", "Wrong email or password");
                RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                dispatcher.forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
