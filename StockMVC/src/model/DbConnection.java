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
	public void display(){System.out.print("hloa");}
	
	public String print(){
	    // load the sqlite-JDBC driver using the current class loader
	    try {
			Class.forName("org.sqlite.JDBC");
		
	    Connection connection = null;
	    try
	    {
	      SQLiteConfig config = new SQLiteConfig();  
		  config.enforceForeignKeys(true);  
	      connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	      //statement.executeUpdate("drop table if exists person");
	     // statement.executeUpdate("create table person (id integer, name string)");
	     // statement.executeUpdate("insert into person values(3, 'msd')");
	     // statement.executeUpdate("insert into person values(4, 'abccccccccccccccccccccccccccccccc')");
	      ResultSet rs = statement.executeQuery("select * from user");
	      String s=null;
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("name = " + rs.getString("name"));
	        System.out.println("id = " + rs.getInt("userid"));
	        s= rs.getString("name");
	        
	      }
	      return s;
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	    } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	    
	}
	
	public ArrayList resultSetToArrayList(ResultSet rs) 
	{
		  ResultSetMetaData md = null;
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  int columns = 0;
		try {
			columns = md.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  ArrayList list = new ArrayList(50);
		  try {
			while (rs.next())
			  {
			    HashMap row = new HashMap(columns);
			     for(int i=1; i<=columns; ++i){           
			      row.put(md.getColumnName(i),rs.getObject(i));
			     }
			      list.add(row);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	}
	public ArrayList getRanking() 
	{
		try {
				Class.forName("org.sqlite.JDBC");
		
	    Connection connection = null;
	    try
	    {
	      SQLiteConfig config = new SQLiteConfig();  
		  config.enforceForeignKeys(true);  
	      connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	      //statement.executeUpdate("drop table if exists person");
	     // statement.executeUpdate("create table person (id integer, name string)");
	     // statement.executeUpdate("insert into person values(3, 'msd')");
	     // statement.executeUpdate("insert into person values(4, 'abccccccccccccccccccccccccccccccc')");
	      ResultSet rs = statement.executeQuery("select * from user order by amount");
	      ArrayList li=resultSetToArrayList(rs);
	      return li;
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try{
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	    } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}	
	public ArrayList getTransactions(int uid) 
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select * from transact where userId= ? ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			statement.setInt(1,uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	    ResultSet rs = null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList li=resultSetToArrayList(rs);
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	public void test()
	{
	
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("insert into user(name,email_ID,password) values (?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		try {
			statement.setString(1, "vivek");
			statement.setString(2,"vivek");
			statement.setString(3,"asd");
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public ArrayList getPortFolio(int uid) 
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select * from Portfolio where userId= ? ");
			statement.setInt(1,uid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    
	    ResultSet rs = null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList li=resultSetToArrayList(rs);
		return li;
	}
	public void addUser(String name,String email_id , String Password) 
	{	Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("insert into user(name,email_ID,password) values (?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		try {
			statement.setString(1, name);
			statement.setString(2,email_id);
			statement.setString(3,Password);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	public void updateAmt(int uid,float amount)
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("update user set amount = ? where userID = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.setFloat(1, amount);
			statement.setInt(2,uid);
			statement.executeUpdate();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void sell(int uid , String stock,int quantity, float sellPrice ,float buyPrice,boolean shortsell) 
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
        String strDate = sdf.format(cal.getTime());
      //  System.out.println("Current date in String Format: " + strDate);
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("insert into TRANSACT(userID,stock,quantity,_time,buy_sell,price) values ( ?,?, ?, ?,1,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.setInt(1, uid);
			statement.setString(2, stock);
			statement.setInt(3,quantity);
			statement.setString(4,strDate);
			statement.setFloat(5, sellPrice);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("select quantity from PortFolio where userID= ? and stock = ? and Price=? and shortsell=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	@SuppressWarnings("resource")
	public void buy(int uid , String stock,int quantity, float buyPrice ,boolean shortsell) 
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
        String strDate = sdf.format(cal.getTime());
        PreparedStatement statement ;
        Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	public float getAmount(int uid)
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select amount from user where userID= ?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.setInt(1,uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return 0;
		}
	}	
	public HashMap getUser(int uid) 
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select email_id,name,amount from user where userID= ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap row = null;
		try {
			statement.setInt(1,uid);
			ResultSet rs = statement.executeQuery();
		    ResultSetMetaData md = rs.getMetaData();
		    int columns = md.getColumnCount();
		    row = new HashMap(columns);
		    for(int i=1; i<=columns; ++i)          
		    	row.put(md.getColumnName(i),rs.getObject(i));
		    connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	   	return row;
	}
		
	public String getPassword(String emailId)
	{
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLiteConfig config = new SQLiteConfig();  
		config.enforceForeignKeys(true);  
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\v1v3k\\Downloads\\MVC-master\\MVC-master\\StockMVC\\stock.db",config.toProperties());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select password from user where email_ID= ?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.setString(1,emailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) 
	  {
		 DbConnection s1=new DbConnection();
		 ArrayList al=s1.getPortFolio(1);
		 System.out.print(al);
		 s1.test();
			//s1.print();
			//s1.display();
			}

}
