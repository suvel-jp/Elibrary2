package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddLibrarianForm")
public class AddLibrarianForm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Librarian Form</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css'/>");
		out.println("</head>");
		out.println("<body>");
		
		RequestDispatcher rq=req.getRequestDispatcher("navadmin.html");
		rq.include(req, resp);
		
		
		
		out.print("<div class='container'>");
		 rq=req.getRequestDispatcher("addlibrarianform.html");
		 out.print("</div>");
		out.print("</body>");
		
		
	}
	
	
}
