package control.market;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MarketTwitter
 */
@WebServlet("/MarketTwitter")
public class MarketTwitter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarketTwitter() {
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

				 RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/market/MarketTwitter.jsp");
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

				 RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/market/MarketTwitter.jsp");
				    view.forward(request, response); 
}
				else
				{
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/root/ReLogin.jsp");
				    view.forward(request, response); 

					}


	}

}
