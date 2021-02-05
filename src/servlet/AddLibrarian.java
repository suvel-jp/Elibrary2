package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LibrarianBean;
import dao.LibrarianDao;


@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Librarian</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		
		RequestDispatcher rd=req.getRequestDispatcher("navadmin.html");
		rd.include(req, resp);
		
		
		String name = req.getParameter("name");
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		String smobile=req.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		LibrarianBean bean = new LibrarianBean(name, password, email, mobile);
		LibrarianDao.save(bean);
		
		out.print("<h4 style='color:green'>Librarian Added Successfully!!</h4>");
		
		RequestDispatcher rd1= req.getRequestDispatcher("addlibrarianform.html");
		rd1.include(req, resp);
		
		out.print("</div>");
		
		
		
		
		
		
	}
	
}
