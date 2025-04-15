package in.tushar.servlet;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.tushar.util.ConnectionFactory;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		String query = "select image from products where id = ?";
		
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement psmt =con.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet rs =psmt.executeQuery();
			
			if(rs.next()) {
				byte[] imgData = rs.getBytes("image");
				res.setContentType("image/jpeg");
				OutputStream out = res.getOutputStream();		
				out.write(imgData);
				out.close();
			}
			psmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
