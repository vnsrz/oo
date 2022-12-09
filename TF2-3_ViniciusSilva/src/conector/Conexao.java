package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pandemia?useTimezone=true&serverTimezone=UTC", "root", "root");

		} catch (SQLException e) {
			System.out.println("Sem conectar!\n" + e.getMessage());
		
		} catch (ClassNotFoundException e) {
			System.out.println("Falha na Conex�o!\n" + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
}
