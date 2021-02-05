package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IssueBookForm")
public class IssuebBookForm extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Issue Book Form</title>");
		out.print("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css' />");
		out.print("</head>");
		out.print("<body>");
		
		RequestDispatcher rd=req.getRequestDispatcher("navlibrarian.html");
		rd.include(req, resp);
		
		out.print("<div class='container'>");
		RequestDispatcher rd2=req.getRequestDispatcher("issuebookform.html");
		rd2.include(req, resp);
		out.print("</div>");
		
		
		
		
	}
	
}
