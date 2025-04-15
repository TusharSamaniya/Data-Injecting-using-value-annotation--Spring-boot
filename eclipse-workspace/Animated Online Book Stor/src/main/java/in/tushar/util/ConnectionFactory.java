package in.tushar.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	private static DataSource ds = null;
	
	public static Connection getConnection() throws Exception{
		if(ds == null) {
			FileInputStream fis = new FileInputStream("C:\\Users\\tusha\\eclipse-workspace\\Animated Online Book Stor\\dbconfig.properties");
			Properties p = new Properties();
			p.load(fis); //"C:\Users\tusha\eclipse-workspace\Animated Online Book Stor\dbconfig.properties"
			
			String url = p.getProperty("db.url");
			String name = p.getProperty("db.uname");
			String psw = p.getProperty("db.psw");
			String driver = p.getProperty("db.driver");
			
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(url);
			config.setUsername(name);
			config.setPassword(psw);
			config.setDriverClassName(driver);
			
			ds = new HikariDataSource(config);
		}
		Connection con = ds.getConnection();
		return con;
	}

}
