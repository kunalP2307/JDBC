import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TestConnection {
	public static void main(String Agrs[]) {
		
		final String url = "jdbc:mysql://localhost:3306/first_db";
		final String username = "root";
		final String password = "Kunal@123";
		
		try {
			System.out.println("Connecting");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected : "+con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
