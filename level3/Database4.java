package level3;
import java.sql.*;
import java.util.Scanner;

public class Database4 {

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
			
			System.out.println("Update Student data:");
			System.out.println("Enter rno , sname and mark:");
			int rno=scan.nextInt();
			String sname=scan.next();
			float mark=scan.nextFloat();
		
			int result=st.executeUpdate("update student set sname='"+sname+"',mark="+mark+" where regno="+rno);
			if(result>0)
				System.out.println("successfully updated check your db");
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
