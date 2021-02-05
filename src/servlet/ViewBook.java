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

import bean.BookBean;
import dao.BookDao;


@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>View Book</title>");
		out.print("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css' />");
		out.print("</head>");
		out.print("<body>");
	    
		  RequestDispatcher rq=req.getRequestDispatcher("navhome.html");
		   rq.include(req, resp);
		   
		   out.print("<h3 align='center'>BooK's</h3>");
		out.print("<div class='container'>");
		
		List<BookBean> list=BookDao.view();
		
		out.print("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
        for(BookBean bean:list){
        	out.print("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuther()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='DeleteBook?callno="+bean.getCallno()+"'>Delete</a></td></tr>");
        }
        out.print("</table>");
        out.print("</div>");
        
	}
	
}
