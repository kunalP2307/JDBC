import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String Agrs[]) {
		
		try {
			System.out.println("Connecting");
			Class.forName(Config.classname);
			Connection con = DriverManager.getConnection(Config.url,Config.username,Config.password);
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
