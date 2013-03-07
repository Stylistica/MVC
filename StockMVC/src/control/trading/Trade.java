package control.trading;
import model.DbConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Trade
 */
@WebServlet("/Trade")
public class Trade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trade() {
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

					System.out.print("hellow");  
					DbConnection db=new DbConnection();
					//db.sell(1, "AAPL", 40, 340.4f, 340.4f, false);
					//db.buy(1, "AAPL", 40, 340.4f,  false);
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/trading/Trade.jsp");
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


		 HttpSession session = request.getSession();
			boolean access;	
			 if(session.getAttribute("login")==null)
					access=false;
				
			 else
					 access=(boolean)session.getAttribute("login");
			System.out.print(access);	
			 
			 if(access==true)
				{

					System.out.print("hellow");  
					DbConnection db=new DbConnection();
					//db.sell(1, "AAPL", 40, 340.4f, 340.4f, false);
					//db.buy(1, "AAPL", 40, 340.4f,  false);
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/trading/Trade.jsp");
				    view.forward(request, response); 

}
				else
				{
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/root/ReLogin.jsp");
				    view.forward(request, response); 

					}

	}

}
