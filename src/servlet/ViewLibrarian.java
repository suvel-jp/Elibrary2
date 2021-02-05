package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.LibrarianBean;
import dao.LibrarianDao;
@WebServlet("/ViewLibrarian")
public class ViewLibrarian extends HttpServlet{

	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		  PrintWriter out=resp.getWriter();
		  
		  out.print("<!DOCTYPE>");
		  out.print("<html>");
		  out.print("<head>");
		  out.print("<title>View Librarian</title>");
		  out.print("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css' />");
		  out.print("</head>");
		  out.print("<body style='background-color=gray;'>");
		  
		   RequestDispatcher rq=req.getRequestDispatcher("navhome.html");
		   rq.include(req, resp);
		  
		  List<LibrarianBean> list= LibrarianDao.view();
		  
		 out.print("<h4 align='center'>Librarian List</h4>"); 
		  out.print("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
		  
		for(LibrarianBean bean:list){
			
			out.print("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td><td><a href='EditLibrarianForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteLibrarian?id="+bean.getId()+"'>Delete</a></td></tr>");
			
		}
		 
	   out.println("</table>");
		
		out.println("</div>");
	
		out.close();
		
		
	}
	   
	
	
}
