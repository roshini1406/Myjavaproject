package level4;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class SimpleGui extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5;
	SimpleGui(){
		setLayout(null);
		setTitle("Roshini application");
		l1=new JLabel("Enter roll number: ");
		l2=new JLabel("Enter student name : ");
		l3=new JLabel("Enter mark:");
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		
		
		b1 = new JButton("Search/Find");
		b2 = new JButton("Insert/Save");
		b3 = new JButton("Delete/Remove");
		b4 = new JButton("Update/Edit");
		b5 = new JButton("Clear");
		
		
		l1.setBounds(0,100,200,30);
		l2.setBounds(0,200,200,30);
		l3.setBounds(0,300,200,30);
		t1.setBounds(250, 100, 200, 30);
		t2.setBounds(250,200,200,30);
		t3.setBounds(250,300,200,30);
		b1.setBounds(600, 100, 150, 30);
		b2.setBounds(600, 200, 150, 30);
		b3.setBounds(600,300,150,30);
		b4.setBounds(600,400,150,30);
		b5.setBounds(600,500,150,30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		add(l1); add(l2);add(l3);
		add(t1);add(t2);add(t3);
		add(b1);add(b2);add(b3);add(b4);add(b5);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f1=new SimpleGui();
		f1.setSize(700,500);
		f1.setEnabled(true);
		f1.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//search function
		
		
		if (e.getSource()==b1)
		{
		//JOptionPane.showMessageDialog(this ,"you clicked to search");
		if (t1.getText().length()>0)
		{
		int rno = Integer.parseInt(t1.getText());
		search(rno);
		}
		else
		{
			JOptionPane.showMessageDialog(this ,"roll number should be filled");
		}
		}
		
		
		
		// insert function
		
		if (e.getSource()==b2)
		{
		//JOptionPane.showMessageDialog(this ,"you clicked insert");
			if (t1.getText().length()>0 && t2.getText().length()>0 && t3.getText().length()>0) {
		int rno = Integer.parseInt(t1.getText());
		String sname = t2.getText();
		float mark = Float.parseFloat(t3.getText());
		insert(rno,sname,mark);
			}
			else {
				JOptionPane.showMessageDialog(this ,"all feilds must be filled");
			}
			
			
		//delete function
			
			
		}
		if (e.getSource()==b3)
		{
		//JOptionPane.showMessageDialog(this ,"you clicked delete");
		if (t1.getText().length()>0) {
		int rno = Integer.parseInt(t1.getText());
		delete(rno);
		}
		else
		{
			JOptionPane.showMessageDialog(this ,"roll number must be filled");
		}
		}
		
		//update function
		
		
		if (e.getSource()==b4)
		{
		//JOptionPane.showMessageDialog(this ,"you clicked to update");
			if (t1.getText().length()>0 && t2.getText().length()>0 && t3.getText().length()>0) {
				int rno = Integer.parseInt(t1.getText());
				String sname = t2.getText();
				float mark = Float.parseFloat(t3.getText());
				update(rno,sname,mark);
				}
				else
				{
					JOptionPane.showMessageDialog(this ,"roll number must be filled");
				}
				
			
		}
		
		
		//clear function
		if (e.getSource()==b5)
		{
		//JOptionPane.showMessageDialog(this ,"you clicked to update");
		clear();
		}
		
		
		
	}
	Statement dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chettinad","root","admin");
			Statement st  =con.createStatement();
			return st;
		}
		catch(Exception e) {}
		return null;
			
			
	}
	void search(int rno) {
		try 
		{
			Statement st= dbConnection();
			ResultSet rs = st.executeQuery("select * from student where regno="+rno);
			
			if(rs.next())
			{
			 //JOptionPane.showMessageDialog(this, rs.getString(2)+ " "+ rs.getString(3));
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
			}
			else {
				JOptionPane.showMessageDialog(this,rno +" "+"data not found");
			}
			rs.close(); st.close();
			}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, e.toString());
		}
		
	}
	
	void insert(int rno,String sname,float mark)
	{
		try 
		{
			Statement st= dbConnection();
			int Result = st.executeUpdate("insert into student values("+rno+",'"+sname+"',"+mark+")");
			JOptionPane.showMessageDialog(this,"data inserted successfully");
			clear();
			st.close();
			}
	catch(Exception e)
		{
			System.out.println("Error Reason:"+e.toString());
		}
		
	}
	
	void delete(int rno)
	{
		try 
		{
		
			Statement st= dbConnection();
			int Result = st.executeUpdate("delete from student where regno ="+rno);
			if (Result>0)
			{
				JOptionPane.showMessageDialog(this,"data deleted successfully");
				clear();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"roll no : "+ rno+" "+"data not found");
			}
			st.close();
			}
	
		catch(Exception e)
		{
			System.out.println("Error Reason:"+e.toString());
		}
		
		
	}
	void update(int rno,String sname,float mark)
	{
		try 
		{
			Statement st= dbConnection();
			int Result = st.executeUpdate("update student set sname ='"+sname+"',mark = "+mark+" where regno = " +rno+""  );
			//int Result = st.executeUpdate("update student set regno="+rno+" where sname = '"+sname+"'"  );
			if (Result>0)
			{
				JOptionPane.showMessageDialog(this,"data updated successfully");
				clear();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"roll no : "+ rno+" "+"data not found");
			}
			
			
			
			
			st.close();
			}
	
		
		catch(Exception e)
		{
			System.out.println("Error Reason:"+e.toString());
		}
		
	}
	void clear()
	{
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t1.requestFocus();
		
	}
}