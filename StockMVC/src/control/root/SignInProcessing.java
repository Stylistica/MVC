package control.root;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sqlite.SQLiteConfig;

import model.DbConnection;

/**
 * Servlet implementation class SignInProcessing
 */
@WebServlet("/SignInProcessing")
public class SignInProcessing extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInProcessing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("reached");        
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		 HttpSession session = request.getSession();
		
	
System.out.print("password="+password);
boolean access;
//password="admin";
	//	System.out.print(username+password);
		//System.out.print("SignInProcessing Reached");
//boolean access=(boolean)session.getAttribute("login");
if(password.contains("admin"))
{
	System.out.println("true");
	boolean a=true;
	session.setAttribute("login",a);
	access=true;
}else
{

	System.out.println("false");
	boolean a=false;
	session.setAttribute("login",a);
	access=false;
	
}
//access=true;
//session.setAttribute("login",access);

if(access==true)
{
		RequestDispatcher view = request.getRequestDispatcher("/Home.do");
	   view.forward(request, response); 
}
else
{
	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/root/ReLogin.jsp");
    view.forward(request, response); 

	}
	}

}
