package in.tushar.servlet;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.tushar.dao.RegrestationDAO;
import in.tushar.dto.RegrestationDTO;

@WebServlet("/regrestation")
public class RegrestationServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		
		
		try {
			//get the data from the regerster jsp page
			String firstName = req.getParameter("fname");
			String lastName = req.getParameter("lname");
			String emailId = req.getParameter("email");
			String password = req.getParameter("psw");
			
			RegrestationDTO dto = new RegrestationDTO();
			dto.setFname(firstName);
			dto.setLname(lastName);
			dto.setEmail(emailId);
			dto.setPsw(password);
			
			//call the dao method
			RegrestationDAO dao = new RegrestationDAO();
			boolean status = dao.save(dto);
			
			//sent message to the client
			PrintWriter writer =res.getWriter();
			String msg = null;
			
			if(status == false){
				writer.append("Already Existing user");
			}
			else{
				res.sendRedirect("http://localhost:8082/Animated_Online_Book_Stor/login.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
