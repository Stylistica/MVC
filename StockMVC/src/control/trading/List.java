package control.trading;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sqlite.SQLiteConfig;

import model.DbConnection;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 HttpSession session = request.getSession();
			boolean access;	
			 if(session.getAttribute("login")==null)
					access=false;
				
			 else
					 access=(boolean)session.getAttribute("login");
			System.out.print(access);	
			 
			 if(access==true)
				{

				 DbConnection a=new DbConnection();
					ArrayList al=a.getRanking();
					request.setAttribute("s", al);
					HashMap a2=a.getUser(1);
					request.setAttribute("s1", a2);
				
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/trading/List.jsp");
				    view.forward(request, response); 

}
				else
				{
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/root/ReLogin.jsp");
				    view.forward(request, response); 

					}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setAttribute("a",100);
		//request.setAttribute("List",100);
		 HttpSession session = request.getSession();
			boolean access;	
			 if(session.getAttribute("login")==null)
					access=false;
				
			 else
					 access=(boolean)session.getAttribute("login");
			System.out.print(access);	
			 
			 if(access==true)
				{

				 DbConnection a=new DbConnection();
					ArrayList al=a.getRanking();
					request.setAttribute("s", al);
					HashMap a2=a.getUser(1);
					request.setAttribute("s1", a2);
				
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/trading/List.jsp");
				    view.forward(request, response); 

}
				else
				{
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/root/ReLogin.jsp");
				    view.forward(request, response); 

					}


	}

}
