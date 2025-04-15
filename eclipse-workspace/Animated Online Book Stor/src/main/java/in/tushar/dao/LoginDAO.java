package in.tushar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.tushar.dto.RegrestationDTO;
import in.tushar.util.ConnectionFactory;

public class LoginDAO {
	
	public static String query = "select * from regrestation where email = ? and psw = ?";
	
	public static boolean check(RegrestationDTO dto) throws Exception{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psmt =con.prepareStatement(query);
		
		psmt.setString(1, dto.getEmail());
		psmt.setString(2, dto.getPsw());
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next())
			return true;
		else
			return false;
		
	}

}
