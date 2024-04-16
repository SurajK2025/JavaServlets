package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection con;

	public static Connection getConnection() {

		try {
			if(con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String user="root", pass="root", url="jdbc:mysql://localhost:3306/student_manager";
				con = DriverManager.getConnection(url, user, pass);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
