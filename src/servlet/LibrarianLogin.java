package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LibrarianDao;

@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out=resp.getWriter();
		
		
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Librarian Section</title>");
		out.print("</head>");
        out.print("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css' />");
		out.print("<body>");
		
		String email =req.getParameter("email");
		String password=req.getParameter("password");
		
		if(LibrarianDao.authenticate(email, password)){
			
			HttpSession session=req.getSession();
			session.setAttribute("email", email);
			
			
			RequestDispatcher rq=req.getRequestDispatcher("navlibrarian.html");
			rq.include(req, resp);
			
			
			
		}
		
		else{
			
			RequestDispatcher rq=req.getRequestDispatcher("navhome.html");
			rq.include(req, resp);
			out.print("<div class='container'>");
			out.print("<h3>Invalidate Email or Password</h3>");
			
	      	RequestDispatcher rq1=req.getRequestDispatcher("librarianloginform.html");
			rq1.include(req, resp);
			
			out.print("</div>");
			
			
		}
        
		
		
		
		
	}
	
	
}
