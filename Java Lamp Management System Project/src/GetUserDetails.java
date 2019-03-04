import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GetUserDetails {
   public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		//read user entered data
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter email id:");
		String id = scanner.nextLine();
		System.out.println("User id="+id);
		System.out.println("Please enter password to get details:");
		String pwd = scanner.nextLine();
		System.out.println("User password="+pwd);
		printUserData(id,pwd);
   }

   private static void printUserData(String id, String pwd) throws ClassNotFoundException, SQLException{		
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root","");
                Statement stmt = con.createStatement();
		String query = "select * from login where username = '"+id+"' and password='"+pwd+"'";
		System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);		
		while(rs.next()){
			System.out.println("City="+rs.getString("city")+",password="+rs.getString("password"));
                        
		}

		
	}

}