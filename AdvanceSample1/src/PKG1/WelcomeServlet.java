package PKG1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("userName");  
		    out.println("Welcome "+n+"   ");  
		    
		 
		 /*   ServletContext application=getServletContext();  
		    
		    out.print("Context...."+application.getInitParameter("name"));*/
		    
		    //Code for Hidden Forms
		    
		    out.print("<form action='Servlet2'>");  
	        out.print("<input type='hidden' name='uname' value='"+n+"'>");  
	        out.print("<input type='submit' value='go'>");  
	        out.print("</form>");  
	        
	        //appending the username in the query string---Rewritting URL 
	      //  out.print("<a href='Servlet2?uname="+n+"'>visit</a>");  
		    
		 //   response.sendRedirect("http://www.google.com");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
