import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class TestUpdateQuery {
	public static void main(String Args[]) {
		
		Scanner sc = new Scanner(System.in);
		String query = "UPDATE Person SET Age = ? where Name = ?";
		try {
			System.out.println("Connecting \\ ");
			Class.forName(Config.classname);
			Connection con = DriverManager.getConnection(Config.url,Config.username,Config.password);
			System.out.println("Connected : "+con);
			System.out.println("Using Database first_db");
			
			PreparedStatement pts = con.prepareStatement(query);
			System.out.print("\n\t Enter the Person Name to Update the Age");
			String name = sc.next();
			
			System.out.print("\n\t Enter the Age To be Updated : ");
			int age = sc.nextInt();
			
			pts.setInt(1,age);
			pts.setString(2,name);
			
			int no = pts.executeUpdate();
			
			System.out.println(no+" Rows Affected");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
