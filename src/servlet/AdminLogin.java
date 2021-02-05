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


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet{

	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		   PrintWriter out=resp.getWriter();
		   
		   out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.println("<head>");
			out.println("<title>Admin Section</title>");
			out.println("<link rel='stylesheet' href='css/bootstrap.min.css' type='text/css'/>");
			out.println("</head>");
			out.println("<body>");
		   
			
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			if(email.equals("admin@1234")&& password.equals("pass123")){
				
				HttpSession session= req.getSession();
				session.setAttribute("admin", "true");
				
				RequestDispatcher rd =req.getRequestDispatcher("navadmin.html");
				rd.include(req, resp);
			   			   	
				
			}
			
			else{
				RequestDispatcher rd=req.getRequestDispatcher("navhome.html");
				rd.include(req, resp);
				
				out.print("<div class='container'>");
              	out.print("<h3 style='color:red'>Invaliad Username or Password</h3>");
              	 RequestDispatcher rd2=req.getRequestDispatcher("adminLoginInfo.html");
              	 rd2.include(req, resp);
              	out.print("</div>");
				
				
			}
			
		   
	}
	
	
}
