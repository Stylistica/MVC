package control.root;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DbConnection;

/**
 * Servlet implementation class SignUpProcessing
 */
@WebServlet("/SignUpProcessing")
public class SignUpProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpProcessing() {
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

		String username = request.getParameter("Name");
		String password = request.getParameter("Email");
		String email=request.getParameter("Password");
		DbConnection a=new DbConnection();
		a.addUser(username, password, email);
		
		System.out.print("SignUpProcessing Reached");
		
		 HttpSession session = request.getSession();
//			boolean access=(boolean)session.getAttribute("login");
	boolean		access=true;
			if(access==true)
			{

				RequestDispatcher view = request.getRequestDispatcher("/intro.jsp");
			    view.forward(request, response); 
	}
			else
			{
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/root/SignUp.jsp");
			    view.forward(request, response); 

				}
			

	}

}
