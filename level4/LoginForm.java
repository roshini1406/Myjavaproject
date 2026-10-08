package level4;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
	JLabel tit,l1,l2;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2;
	Font myfont=new Font("arial",Font.BOLD,35);
	LoginForm()
	{
		setTitle("Roshini Application Login Form");
		setLayout(null);
		tit=new JLabel("Login Form");
		tit.setFont(myfont);
		l1=new JLabel("Enter User Name/Id:");
		l2=new JLabel("Enter Password:");
		t1=new JTextField();
		p1=new JPasswordField();
		b1=new JButton("Login/SignIn");
		b2=new JButton("Reset");
		tit.setBounds(300,100,250,50);
		l1.setBounds(300,200,150,30);
		l2.setBounds(300,250,150,30);
		t1.setBounds(450,200,150,30);
		p1.setBounds(450,250,150,30);
		b1.setBounds(450,300,130,30);
		b2.setBounds(650,300,100,30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		add(tit);add(l1);add(l2);add(t1);add(p1);add(b1);add(b2);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f1=new LoginForm();
		f1.setSize(900,700);
		f1.setVisible(true);
		f1.setEnabled(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(t1.getText().equals("Roshini") && p1.getText().equals("roshini@123"))
					{
				//JOptionPane.showMessageDialog(null,  "Valid User!!!");
				this.setVisible(false);
				JFrame obj=new SimpleGui();
				obj.setSize(1000,700);
				obj.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid User/Password");
			}
		}
		else
		{
			t1.setText("");
			p1.setText("");
			t1.requestFocus();
			
		}
		
	}

}
