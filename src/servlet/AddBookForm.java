package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddBookForm")
public class AddBookForm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css' />");
		out.println("</head>");
		out.println("<body >");
		
		
		RequestDispatcher rq=req.getRequestDispatcher("navlibrarian.html");
		rq.include(req, resp);
		
		out.print("<div class='container'>");
		RequestDispatcher rq1=req.getRequestDispatcher("addbookform.html");
		rq1.include(req, resp);
		out.print("</div>");
		
	}
	
}
