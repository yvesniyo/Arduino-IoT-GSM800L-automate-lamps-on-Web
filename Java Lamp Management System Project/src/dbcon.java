
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class dbcon {
    public static void  main(String [] args) throws ClassNotFoundException, SQLException{
        System.out.println("Hello Yves");
        String n="3";
        String name="hello world";
        dbcon(n);
        yves(name);
    }

    public static void dbcon(String id) throws ClassNotFoundException, SQLException{



	Class.forName("com.mysql.jdbc.Driver");

	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo","root","");
	Statement stmt;
        stmt = conn.createStatement();
	//String 	query="SELECT * FROM login";
        //String 	query="INSERT INTO login(username,password,city) VALUES('Mahoko','a','Rubavu')";
	String query="UPDATE login set username='Evra' where username='Mahoko'";
        stmt.executeUpdate(query);
        
	/*while(rs.next()){
		//n++;
		System.out.println(" Username : "+rs.getString("username")+" Password :"+rs.getString("password"));
                
	}*/



}
    public static void yves(String name){
        //System.out.println("The name is :"+name);
    }
}
