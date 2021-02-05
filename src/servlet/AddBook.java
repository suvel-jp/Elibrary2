package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import dao.BookDao;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out= resp.getWriter();
		
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Add Book Form");
		out.print("</head>");
		out.print("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css' />");
		out.print("<body>");
		
		
		RequestDispatcher rq=req.getRequestDispatcher("navlibrarian.html");
		rq.include(req, resp);
		
		out.print("<div class='container'>");
		
		String callno=req.getParameter("callno");
		String name =req.getParameter("name");
		String auther=req.getParameter("author");
		String publisher=req.getParameter("publisher");
		String squantity=req.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		
		BookBean bean= new BookBean(callno, name, auther, publisher, quantity);
		
		int i=BookDao.save(bean);
		if(i>0){
			out.print("<h3 style='margin-left:250px'>Book Saved Successfull!!</h3>");
		}
		
			RequestDispatcher rq1= req.getRequestDispatcher("addbookform.html");
			rq1.include(req, resp);
		   out.print("</div>");
		
		
	}
	
}
