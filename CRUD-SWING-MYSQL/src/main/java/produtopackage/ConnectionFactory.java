package produtopackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/Estoque";
		try {
			return DriverManager.getConnection(url,"root","idnt123");
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
