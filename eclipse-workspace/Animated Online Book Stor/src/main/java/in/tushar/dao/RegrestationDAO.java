package in.tushar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.tushar.dto.RegrestationDTO;
import in.tushar.util.ConnectionFactory;

public class RegrestationDAO {
	
	private static String query = "insert into regrestation (fname, lname, email, psw) values (?, ?, ?, ?)";
	
	public static boolean save(RegrestationDTO dto) throws Exception{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psmt = con.prepareStatement(query);
		
		psmt.setString(1, dto.getFname());
		psmt.setString(2, dto.getLname());
		psmt.setString(3, dto.getEmail());
		psmt.setString(4, dto.getPsw());
		
		int count = psmt.executeUpdate();
		psmt.close();
		con.close();
		return count > 0;
	}

}
