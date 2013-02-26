package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnetion {
	public void display(){System.out.print("hloa");}
	
	public String print(){
	    // load the sqlite-JDBC driver using the current class loader
	    try {
			Class.forName("org.sqlite.JDBC");
		
	    Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:stock.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	      
	     statement.executeUpdate("drop table if exists person");
	      statement.executeUpdate("create table person (id integer, name string)");
	      statement.executeUpdate("insert into person values(3, 'msd')");
	      statement.executeUpdate("insert into person values(4, 'ud')");
	      ResultSet rs = statement.executeQuery("select * from person");
	      String s=null;
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("name = " + rs.getString("name"));
	        System.out.println("id = " + rs.getInt("id"));
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
	 public static void main(String[] args) 
	  {
		 DbConnetion s1=new DbConnetion();
			s1.print();
			s1.display();
			}

}
