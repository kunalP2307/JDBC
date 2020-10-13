import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;          
import java.util.Scanner;

public class TestInsertQuery {
	public static void main(String ars[]){
		
		String query = "insert into Person (Name,Age,Gender) values(?,?,?)";
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Using Database first_db ");
			Class.forName(Config.classname);
			System.out.println("Connecting \\ ");
			Connection con = DriverManager.getConnection(Config.url,Config.username,Config.password);
			System.out.println("Connected : "+con);
			PreparedStatement pts = con.prepareStatement(query);
			
			
			System.out.println("\n\t Enter the Values to Insert the Record in Table Person : ");
			System.out.print("\t Person Name : ");
			pts.setString(1,sc.next());
			System.out.print("\t Person Age :");
			pts.setInt(2, sc.nextInt());
			System.out.print("\t Person Gender : ");
			pts.setString(3,sc.next());
			int rowsInserted = pts.executeUpdate();
			System.out.println("\t"+rowsInserted +" Rows Inserted");
		
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
