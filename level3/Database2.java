package level3;
import java.sql.*;
import java.util.Scanner;

public class Database2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Accepted");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chettinad", "root", "admin");
			System.out.println("Connection Success");
			//---------statement------>purpose----->to write sql queries
			Statement st=con.createStatement();
			
			System.out.println("Enter rno , student name and mark:");
			int rno=scan.nextInt();
			String sname=scan.next();
			float mark=scan.nextFloat();
			
			
			int result=st.executeUpdate("insert into student values("+rno+", '"+sname+"', "+mark+")");
			if(result>0)
				System.out.println("successfully inserted check your db");
			else
				System.out.println("no record inserted");				
			
			
			st.close();con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error Reason:"+e.toString());
		}

	}

}
