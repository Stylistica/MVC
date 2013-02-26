package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.sqlite.SQLiteConfig;



public class DbConnection {
	  Connection connection;
	 void DBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection("jdbc:sqlite:stock.db",config.toProperties());
		
	}
	public void display(){System.out.print("helloa");}
	
	public ArrayList resultSetToArrayList(ResultSet rs) throws SQLException
	{
		  ResultSetMetaData md = rs.getMetaData();
		  int columns = md.getColumnCount();
		  ArrayList list = new ArrayList(50);
		  while (rs.next())
		  {
		     HashMap row = new HashMap(columns);
		     for(int i=1; i<=columns; ++i){           
		      row.put(md.getColumnName(i),rs.getObject(i));
		     }
		      list.add(row);
		  }
		 return list;
	}
	
	
	
	public void print() throws SQLException
	{
	    // load the sqlite-JDBC driver using the current class loader
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	     // statement.executeUpdate("drop table if exists user");
	    //  statement.executeUpdate("drop table if exists transact");
	 //  statement.executeUpdate("create table USER (email_id string NOT NULL PRIMARY KEY, name string,password string NOT NULL ,amount real DEFAULT '10000')");
	 //   statement.executeUpdate("create table TRANSACT (tid integer NOT NULL PRIMARY KEY, email_id string ,BUY_SELL BOOLEAN ,stock string ,quantity integer, time text,price real ,  FOREIGN KEY(email_id) REFERENCES USER(email_id))");
	     //statement.executeUpdate("insert into USER(email_id,name,password) values('ud', 'msd','345')");
	    // statement.executeUpdate("insert into TRANSACT values(1, 'ud',true, 'AAPL',100,'10:30',345.47)");
	   ResultSet rs = statement.executeQuery("select * from user");
	   ArrayList li=resultSetToArrayList(rs);
	   HashMap row = new HashMap();
	   row=(HashMap)li.get(1);
	  System.out.println(row.get("amount"));
	   
	   /*   while(rs.next())
	      {
	       // read the result set
	        System.out.println("name = " + rs.getString("email_id"));
	        System.out.println("id = " + rs.getString("name"));
	      }*/
	 }
	
	public ArrayList getRanking() throws SQLException, ClassNotFoundException
	{
		Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection("jdbc:sqlite:stock.db",config.toProperties());
		Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30); 
	   // statement.executeUpdate("insert into TRANSACT (userID,stock,quantity,_time,buy_sell,price) values  (1,'AAPL',20,'12:30',1,342.9)");
	    ResultSet rs = statement.executeQuery("select userID,email_id,name,amount from user order by amount desc");
		ArrayList li=resultSetToArrayList(rs);
		return li;
	}
	
	
	
	public HashMap getUser(int uid) throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement("select email_id,name,amount from user where userID= ?");
		statement.setInt(1,uid);	    
	    ResultSet rs = statement.executeQuery();
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    HashMap row = new HashMap(columns);
	    for(int i=1; i<=columns; ++i)          
	    	row.put(md.getColumnName(i),rs.getObject(i));
		return row;
	}
	
	
	
	public float getAmount(int uid)throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement("select amount from user where userID= ?");
		statement.setInt(1,uid);
		ResultSet rs = statement.executeQuery();
		return rs.getInt(1);
	}
	
	
	
	public void buy(int uid , String stock,int quantity, float buyPrice ,boolean shortsell) throws SQLException, ClassNotFoundException
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
        String strDate = sdf.format(cal.getTime());
        PreparedStatement statement ;
        Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection("jdbc:sqlite:stock.db",config.toProperties());
      //  System.out.println("Current date in String Format: " + strDate);
		try
		{
		statement = connection.prepareStatement("insert into TRANSACT(userID,stock,quantity,_time,buy_sell,price) values ( ?,?, ?, ?,1,?)");
		statement.setInt(1, uid);
		statement.setString(2, stock);
		statement.setInt(3,quantity);
		statement.setString(4,strDate);
		statement.setFloat(5, buyPrice);
		statement.executeUpdate();
		statement.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		PreparedStatement  stmt;
		ResultSet rs=null;
		try
		{
			 stmt = connection.prepareStatement("select * from PortFolio where userID= ? and stock = ? and Price=? and shortsell=?");
				stmt.setInt(1, uid);
		stmt.setString(2, stock);
		stmt.setFloat(3, buyPrice);
		stmt.setBoolean(4, shortsell);
		 rs=stmt.executeQuery();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		if(!rs.next())
		{
			statement = connection.prepareStatement("insert into portfolio values(?,?,?,?,0)");
			statement.setInt(1, uid);
			statement.setString(2, stock);
			statement.setInt(3,quantity);
			statement.setFloat(4, buyPrice);
			statement.executeUpdate();
			statement.close();
		}
		else
		{
			statement = connection.prepareStatement("update portfolio set quantity = quantity + ? where userID= ? and stock=? and Price=?");
			statement.setInt(1,quantity);
			statement.setInt(2, uid);
			statement.setString(3, stock);
			statement.setFloat(4, buyPrice);
			statement.executeUpdate();
			statement.close();
		}
				
	}
	
	public void sell(int uid , String stock,int quantity, float sellPrice ,float buyPrice,boolean shortsell) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection("jdbc:sqlite:stock.db",config.toProperties());
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
        String strDate = sdf.format(cal.getTime());
      //  System.out.println("Current date in String Format: " + strDate);
		PreparedStatement statement = connection.prepareStatement("insert into TRANSACT(userID,stock,quantity,_time,buy_sell,price) values ( ?,?, ?, ?,1,?)");
		statement.setInt(1, uid);
		statement.setString(2, stock);
		statement.setInt(3,quantity);
		statement.setString(4,strDate);
		statement.setFloat(5, sellPrice);
		statement.executeUpdate();
		statement.close();
		PreparedStatement  stmt = connection.prepareStatement("select quantity from PortFolio where userID= ? and stock = ? and Price=? and shortsell=?");
		stmt.setInt(1, uid);
		stmt.setString(2, stock);
		stmt.setFloat(3, buyPrice);
		stmt.setBoolean(4, shortsell);
		ResultSet rs=stmt.executeQuery();
		int x=rs.getInt(1);
		if(x==quantity)
		{
			statement = connection.prepareStatement("delete from  portfolio where userID= ? and stock = ? and Price=? and shortsell=?");
			statement.setInt(1, uid);
			statement.setString(2, stock);
			statement.setFloat(3, buyPrice);
			statement.setBoolean(4, shortsell);
			statement.executeUpdate();
			statement.close();
		}
		else
		{
			statement = connection.prepareStatement("update portfolio set quantity = quantity - ? where userID= ? and stock=? and Price=?");
			statement.setInt(1,quantity);
			statement.setInt(2, uid);
			statement.setString(3, stock);
			statement.setFloat(4, buyPrice);
			statement.executeUpdate();
			statement.close();
		}
	}
	
	
	public void updateAmt(int uid,float amount) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection("jdbc:sqlite:stock.db",config.toProperties());
		PreparedStatement statement = connection.prepareStatement("update user set amount = ? where userID = ?");
		statement.setFloat(1, amount);
		statement.setInt(2,uid);
		statement.executeUpdate();
		statement.close();
		
		
	}
	public void addUser(String name,String email_id , String Password) throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection("jdbc:sqlite:stock.db",config.toProperties());
        PreparedStatement statement = connection.prepareStatement("insert into user(name,email_ID,password) values (?,?,?)");
        
		statement.setString(1, name);
		statement.setString(2,email_id);
		statement.setString(3,Password);
		statement.executeUpdate();
		statement.close();
        
	}
	
	public ArrayList getTransactions(int uid) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection("jdbc:sqlite:stock.db",config.toProperties());
		PreparedStatement statement = connection.prepareStatement("select * from transact where userId= ? ");
		statement.setInt(1,uid);	    
	    ResultSet rs = statement.executeQuery();
		ArrayList li=resultSetToArrayList(rs);
		return li;
	}
	
	
	
	
	 
	    
	
	 public static void main(String[] args) throws SQLException, ClassNotFoundException 
	  {
		 DbConnection s1=new DbConnection();
	//	s1.sell(1, "AAPL", 40, 340.4f, 340.4f, false);
	  //System.out.println(s1.getTransactions(1));
	 // s1.addUser("msd", "ud", "abc");
	  System.out.println(s1.getRanking() );
	  System.out.println(s1.getTransactions(1));
			s1.display();
			}


}
