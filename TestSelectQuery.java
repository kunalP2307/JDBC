import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class TestSelectQuery {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String query;
		try {
			System.out.println("Using Database first_db");
			System.out.println("Connecting \\- ");
			Class.forName(Config.classname);
			Connection con = DriverManager.getConnection(Config.url,Config.username,Config.password);
			System.out.println("Connected /\\: "+con);
			Statement st = con.createStatement();
			ResultSet rs;
			
			System.out.println("Performing Operations on Table Person ");
			System.out.println("\n\n\t 1-Show All Records"
								+"\n\t 2-Search By Name");
			System.out.print("\n\n\tSelect Operation : ");
			int choice = sc.nextInt();
			if(choice == 1) {
				
				query = "Select * from Person";
				rs  = st.executeQuery(query);
				showRecords(rs);
			}
			else if(choice == 2) {
				
				query = "select * from Person where Name=?";
				System.out.print("\t Enter the Name to Search the Record : ");
				String name = sc.next();
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, name);
				rs = pst.executeQuery();
				showRecords(rs);
			}
			else {
				System.out.println("\tInvalid Choice...!");
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void showRecords(ResultSet rs) {
		
		try {
			if(!rs.next())
				System.out.println("\n\tNo Records Found : ");
			else {
				System.out.println("\n\t"+"Name"+"\t"+"Age"+"\t"+"Gender");
				System.out.println("\t------------------------------"+"\n");
				do{
					System.out.println("\t"+rs.getString(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3));
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
