package com.pjt;

	
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Statement;
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;

	public class Miniproject2 extends JFrame implements ActionListener
	{
	   JFrame f1;
	   JPanel p1;                                                        // declaration
	   JLabel l1,l2,l3,l4,l5,l6;
	   JTextField t1,t2,t3,t4,t5,t6;
	   JButton b1,b2,b3;
		
	   Miniproject2()                                                // initialize all controls
	   {
		   f1 = new JFrame("Library Mgmt");
		   p1 = new JPanel();
		   l1 = new JLabel("Username : ");
		   l2 = new JLabel("Password : ");
		   
		   l3 = new JLabel("ID : ");
		   l4 = new JLabel("Title : ");
		   l5 = new JLabel("Price : ");
		   l6 = new JLabel("ID : ");
		   
		   t1 = new JTextField("0",10);
		   t2 = new JTextField("0",10);
		   b1 = new JButton("Book Details");
		   b2 = new JButton("Add Book");
		   b3 = new JButton("Remove Book");
		   t3 = new JTextField("0",10);
		   t4 = new JTextField("0",10);
		   t5 = new JTextField("0",10);
		   t6 = new JTextField("0",10);
		   p1.add(l1); p1.add(t1);
		   p1.add(l2); p1.add(t2);
		   p1.add(b1);
		   
		   p1.add(l3);p1.add(t3);p1.add(l4);p1.add(t4);p1.add(l5);p1.add(t5);
		   p1.add(b2);
		   
		   p1.add(l6);p1.add(t6);
		   p1.add(b3);
		   
		   f1.add(p1);
		   f1.setSize(300,300);
		   f1.setVisible(true);
		   
		   b1.addActionListener(new ActionListener()
		   {
			public void actionPerformed(ActionEvent e)            // login action
			{
				String n1 = t1.getText();
				String n2 = t2.getText();
				
				if(n1.equals("123") && n2.equals("abc"))
				{
					try 
					{
					     Class.forName("com.mysql.cj.jdbc.Driver");
					     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kavya@4597");
						 Statement st = con.createStatement();
						 ResultSet rs =  st.executeQuery("select * from book_details");
						 System.out.println("\n Book details : ");
					     while(rs.next())
					     {
					    	 System.out.println("ID : "+rs.getInt(1)+" Name  :"+rs.getString(2)+"  Price :"+rs.getDouble(3));						    	 
					     }
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				else
				{
				     System.out.println("\n Incorrect ID or password");	
				}
				
			}	   
		   });


		   
		   b2.addActionListener(new ActionListener()
				   {
					public void actionPerformed(ActionEvent e)            // login action
					{
						String n3 = t3.getText();  int id = Integer.parseInt(n3);
						String title = t4.getText();
						String n5 = t5.getText();  double price = Double.parseDouble(n5);
						
							try 
							{
							     Class.forName("com.mysql.cj.jdbc.Driver");
							     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kavya@4597");
								 String st = "insert into book_details values(?,?,?)";
								 PreparedStatement pst = con.prepareStatement(st);
								 pst.setInt(1,id);
								 pst.setString(2,title);
								 pst.setDouble(3,price);
								 
								 int i = pst.executeUpdate();
								 if(i != 0)
								 System.out.println("Book Added Successfully ");
								 else
									 System.out.println("Book not added ");	 
							    
							}catch(Exception ex)
							{
								ex.printStackTrace();
							}
						
					}	   
				   });
		   
		   b3.addActionListener(new ActionListener()
		   {
			public void actionPerformed(ActionEvent e)            // login action
			{
				int n = Integer.parseInt(t6.getText());
				
				   try 
					{
					     Class.forName("com.mysql.cj.jdbc.Driver");
					     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Kavya@4597");
					     String st = "DELETE FROM book_details where id = ?";
					     PreparedStatement pst = con.prepareStatement(st); 
					     pst.setInt(1,n);
					   	     
						 int i = pst.executeUpdate();
						 if(i != 0)
						 System.out.println("Book Removed Successfully ");
						 else
							 System.out.println("Book not removed ");	 
					    
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
			    }
		   });

		   
	}
		public static void main(String[] args)
		{
			new Miniproject2();                                       // invoke the constructor
		}
		public void actionPerformed(ActionEvent e) 
		{
			
		}

	}
	