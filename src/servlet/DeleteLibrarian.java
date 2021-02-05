package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibrarianDao;
@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid= req.getParameter("id");
		int id =Integer.parseInt(sid);

		LibrarianDao.delete(id);
		resp.sendRedirect("ViewLibrarian");
		
		
		
		
		
	}
	
}
