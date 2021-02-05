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
import bean.IssueBookBean;
import dao.BookDao;
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		out.print("<!DOCTYPE>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Issue Book</title>");
		out.print("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css' />");
		out.print("</head>");
		out.print("<body>");
		
		RequestDispatcher rd=req.getRequestDispatcher("navlibrarian.html");
		rd.include(req, resp);
		
		out.print("<div class='container'>");
		
		String callno=req.getParameter("callno");
		String studentid=req.getParameter("studentid");
		String studentname=req.getParameter("studentname");
		String smobile=req.getParameter("studentmobile");
		long studentmobile=Long.parseLong(smobile);
		
		IssueBookBean bean=new IssueBookBean(callno, studentid, studentname, studentmobile);
		
		int i=BookDao.issueBook(bean);
		
		if(i>0)
		{
			out.print("<h3 style='color:green'>Book Issued Successfully !!!</h3>");
			
		}
		else{
			
			out.print("<h3> Sorry, unable to issue book.</h3><p>We may have Sortage of Book. Kindly Visit Later.</p>");
		}
		
		out.print("</div>");
		
	}
	
}
