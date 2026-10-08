package level3;
import java.sql.*;

public class Database1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Accepted");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chettinad", "root", "admin");
			System.out.println("Connection Success");
			//---------statement------>purpose----->to write sql queries
			Statement st=con.createStatement();
			//-----ResultSet---> purpose---->to store sql data row wise
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();st.close();con.close();
			
		
		}
		catch(Exception e)
		{
			System.out.println("Error Reason:"+e.toString());
		}

	}

}
