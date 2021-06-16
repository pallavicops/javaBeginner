package javaBeginner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
 
import javax.swing.*;
///import net.proteanit.sql.DbUtils;
public class Library {
	 public static class ex{
	        public static int days=0;
	            }
	 
	    public static void main(String[] args) {
	         
	        login();
	        //create();
	    }
	    public static void login() {
	        
	        JFrame f=new JFrame("Login");//creating instance of JFrame  
	        JLabel l1,l2;  
	        l1=new JLabel("Username");  //Create label Username
	        l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
	         
	        l2=new JLabel("Password");  //Create label Password
	        l2.setBounds(30,50, 100,30);    
	         
	        JTextField F_user = new JTextField(); //Create text field for username
	        F_user.setBounds(110, 15, 200, 30);
	             
	        JPasswordField F_pass=new JPasswordField(); //Create text field for password
	        F_pass.setBounds(110, 50, 200, 30);
	        JButton login_but=new JButton("Login");//creating instance of JButton for Login Button
	        login_but.setBounds(130,90,80,25);//Dimensions for button
	        login_but.addActionListener(new ActionListener() {  //Perform action
	             
	            public void actionPerformed(ActionEvent e){ 
	     
	            String username = F_user.getText(); //Store username entered by the user in the variable "username"
	            String password = F_pass.getText(); //Store password entered by the user in the variable "password"
	             
	            if(username.equals("")) //If username is null
	            {
	                JOptionPane.showMessageDialog(null,"Please enter username"); //Display dialog box with the message
	            } 
	            else if(password.equals("")) //If password is null
	            {
	                JOptionPane.showMessageDialog(null,"Please enter password"); //Display dialog box with the message
	            }
	            else { //If both the fields are present then to login the user, check wether the user exists already
	                System.out.println("Login connect");
	                Connection connection=connect();  //Connect to the database
	                try
	                {
	                Statement stmt = connection.createStatement();
	                  stmt.executeUpdate("USE LIBRARY"); //Use the database with the name "Library"
	                  String st = ("SELECT * FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'"); //Retreive username and passwords from users
	                  ResultSet rs = stmt.executeQuery(st); //Execute query
	                  if(rs.next()==false) { //Move pointer below
	                      System.out.print("No user");  
	                      JOptionPane.showMessageDialog(null,"Wrong Username/Password!"); //Display Message
	     
	                  }
	                  else {
	                      f.dispose();
	                    rs.beforeFirst();  //Move the pointer above
	                    while(rs.next())
	                    {
	                      String admin = rs.getString("ADMIN"); //user is admin
	                      //System.out.println(admin);
	                      String UID = rs.getString("UID"); //Get user ID of the user
	                      if(admin.equals("1")) { //If boolean value 1
	                          admin_menu(); //redirect to admin menu
	                      }
	                      else{
	                          user_menu(UID); //redirect to user menu for that user ID
	                      }
	                    }
	                    }
	                  }
	                  catch (Exception ex) {
	                       ex.printStackTrace();
	              }
	              }
	          }               
	          });
	       
	           
	          f.add(F_pass); //add password
	          f.add(login_but);//adding button in JFrame  
	          f.add(F_user);  //add user
	          f.add(l1);  // add label1 i.e. for username
	          f.add(l2); // add label2 i.e. for password
	           
	          f.setSize(400,180);//400 width and 500 height  
	          f.setLayout(null);//using no layout managers  
	          f.setVisible(true);//making the frame visible 
	          f.setLocationRelativeTo(null);
	           
	      }
	    public static Connection connect()
	    {
	    try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            //System.out.println("Loaded driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=edureka");
	            //System.out.println("Connected to MySQL");
	            return con;
	     } 
	     catch (Exception ex) {
	            ex.printStackTrace();
	     }
	    return null;
	    }
	    public static void create() {
	        try {
	        Connection connection=connect();
	        ResultSet resultSet = connection.getMetaData().getCatalogs();
	        //iterate each catalog in the ResultSet
	            while (resultSet.next()) {
	              // Get the database name, which is at position 1
	              String databaseName = resultSet.getString(1);
	              if(databaseName.equals("library")) {
	                  //System.out.print("yes");
	                  Statement stmt = connection.createStatement();
	                  //Drop database if it pre-exists to reset the complete database
	                  String sql = "DROP DATABASE library";
	                  stmt.executeUpdate(sql);
	              }
	            }
	            Statement stmt = connection.createStatement();
	            
	            String sql = "CREATE DATABASE LIBRARY"; //Create Database
	            stmt.executeUpdate(sql); 
	            stmt.executeUpdate("USE LIBRARY"); //Use Database
	            //Create Users Table
	            String sql1 = "CREATE TABLE USERS(UID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(30), PASSWORD VARCHAR(30), ADMIN BOOLEAN)";
	            stmt.executeUpdate(sql1);
	            //Insert into users table
	            stmt.executeUpdate("INSERT INTO USERS(USERNAME, PASSWORD, ADMIN) VALUES('admin','admin',TRUE)");
	            //Create Books table
	            stmt.executeUpdate("CREATE TABLE BOOKS(BID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, BNAME VARCHAR(50), GENRE VARCHAR(20), PRICE INT)");
	            //Create Issued Table
	            stmt.executeUpdate("CREATE TABLE ISSUED(IID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, UID INT, BID INT, ISSUED_DATE VARCHAR(20), RETURN_DATE VARCHAR(20), PERIOD INT, FINE INT)");
	            //Insert into books table
	            stmt.executeUpdate("INSERT INTO BOOKS(BNAME, GENRE, PRICE) VALUES ('War and Peace', 'Mystery', 200),  ('The Guest Book', 'Fiction', 300), ('The Perfect Murder','Mystery', 150), ('Accidental Presidents', 'Biography', 250), ('The Wicked King','Fiction', 350)");
	             
	      resultSet.close();
	      }
	       catch (Exception ex) {
	           ex.printStackTrace();
	  }
	    }
	    public static void user_menu(String UID) {
	        
	        
	        JFrame f=new JFrame("User Functions"); //Give dialog box name as User functions
	        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit user menu on closing the dialog box
	        JButton view_but=new JButton("View Books");//creating instance of JButton  
	        view_but.setBounds(20,20,120,25);//x axis, y axis, width, height 
	        view_but.addActionListener(new ActionListener() { 
	            public void actionPerformed(ActionEvent e){
	            	   JFrame f = new JFrame("Books Available"); //View books stored in database
	                   //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                    
	                    
	                   Connection connection = connect();
	                   String sql="select * from BOOKS"; //Retreive data from database
	                   try {
	                       Statement stmt = connection.createStatement(); //connect to database
	                        stmt.executeUpdate("USE LIBRARY"); // use librabry
	                       stmt=connection.createStatement();
	                       ResultSet rs=stmt.executeQuery(sql);
	                       JTable book_list= new JTable(); //show data in table format
	                       book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                         
	                       JScrollPane scrollPane = new JScrollPane(book_list); //enable scroll bar
	        
	                       f.add(scrollPane); //add scroll bar
	                       f.setSize(800, 400); //set dimensions of view books frame
	                       f.setVisible(true);
	                       f.setLocationRelativeTo(null);
	                   } catch (SQLException e1) {
	                       // TODO Auto-generated catch block
	                        JOptionPane.showMessageDialog(null, e1);
	                   }               
	                    
	           }
	           }
	           );
	            
	           JButton my_book=new JButton("My Books");//creating instance of JButton  
	           my_book.setBounds(150,20,120,25);//x axis, y axis, width, height 
	           my_book.addActionListener(new ActionListener() { //Perform action
	               public void actionPerformed(ActionEvent e){
	                    
	                      
	                   JFrame f = new JFrame("My Books"); //View books issued by user
	                   //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                   int UID_int = Integer.parseInt(UID); //Pass user ID
	        
	                   //.iid,issued.uid,issued.bid,issued.issued_date,issued.return_date,issued,
	                   Connection connection = connect(); //connect to database
	                   //retrieve data
	                   String sql="select distinct issued.*,books.bname,books.genre,books.price from issued,books " + "where ((issued.uid=" + UID_int + ") and (books.bid in (select bid from issued where issued.uid="+UID_int+"))) group by iid";
	                   String sql1 = "select bid from issued where uid="+UID_int;
	                   try {
	                       Statement stmt = connection.createStatement();
	                       //use database
	                        stmt.executeUpdate("USE LIBRARY");
	                       stmt=connection.createStatement();
	                       //store in array
	                       ArrayList books_list = new ArrayList();
	                       ResultSet rs=stmt.executeQuery(sql);
	                       JTable book_list= new JTable(); //store data in table format
	                       book_list.setModel(DbUtils.resultSetToTableModel(rs)); 
	                       //enable scroll bar
	                       JScrollPane scrollPane = new JScrollPane(book_list);
	        
	                       f.add(scrollPane); //add scroll bar
	                       f.setSize(800, 400); //set dimensions of my books frame
	                       f.setVisible(true);
	                       f.setLocationRelativeTo(null);
	                   } catch (SQLException e1) {
	                       // TODO Auto-generated catch block
	                        JOptionPane.showMessageDialog(null, e1);
	                   }               
	               }
	           }
	           );
	            
	            
	            
	           f.add(my_book); //add my books
	           f.add(view_but); // add view books
	           f.setSize(300,100);//400 width and 500 height  
	           f.setLayout(null);//using no layout managers  
	           f.setVisible(true);//making the frame visible 
	           f.setLocationRelativeTo(null);
	           }
}
