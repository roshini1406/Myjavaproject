package level3;
import java.sql.*;
import java.util.Scanner;

public class Database3 {

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
			
			System.out.println("Enter rno to be deleted:");
			int rno=scan.nextInt();
		
			int result=st.executeUpdate("delete from student where regno="+rno);
			if(result>0)
				System.out.println("successfully deleted check your db");
			else
				System.out.println("no record found in db");				
			
			
			st.close();con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error Reason:"+e.toString());
		}

	}

}
