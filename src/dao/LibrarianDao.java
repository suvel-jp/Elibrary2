package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.net.ssl.SSLEngineResult.Status;
import javax.rmi.CORBA.Stub;

import bean.LibrarianBean;

public class LibrarianDao {

	
	public static int save(LibrarianBean bean){
		int status=0;
		
		
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_librarian(name,email,password,mobile) values(?,?,?,?)");
	        ps.setString(1, bean.getName());
            ps.setString(2, bean.getEmail());
            ps.setString(3, bean.getPassword());
            ps.setLong(4, bean.getMobile());
            
            status=ps.executeUpdate();
            
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
		
		
	}
	
	public static int  update(LibrarianBean bean){
		
		int status = 0;
		
		
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update e_librarian set name=?, email=?, password=?, mobile=?  where id=?");
		  
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setLong(4, bean.getMobile());
			ps.setInt(5, bean.getId());
			status=ps.executeUpdate();
			
		
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
		
		
	}
	
	public static List<LibrarianBean> view(){
		
	   List<LibrarianBean> list = new ArrayList<LibrarianBean>();
	
	   
	   
	   try {
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from e_librarian");
	    ResultSet rs=ps.executeQuery();
	      
	    while(rs.next()){
	    	LibrarianBean bean= new LibrarianBean();
	    	bean.setId(rs.getInt("id"));
	    	bean.setName(rs.getString("name"));
	    	bean.setEmail(rs.getString("email"));
	    	bean.setPassword(rs.getString("password"));
	    	bean.setMobile(rs.getLong("mobile"));
	    	list.add(bean);
	    }
	     
		
	   }
	   catch (SQLException e) {
		
		e.printStackTrace();
	}

	return list;
	
	}
	
   public static LibrarianBean viewById(int id){
	   LibrarianBean bean= new LibrarianBean();
	   
	   Connection con = DB.getCon();
	   try {
		PreparedStatement ps=con.prepareStatement("select * from e_librarian where id=?");
	    
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setMobile(rs.getLong(5));
		}
	   
	   } 
	   catch (SQLException e) {
		
		e.printStackTrace();
	}
	   
	   
	   return bean;
	  
   }
	
   public static int delete(int id){
	   int status=0;
	   
	  
	   try {
		   Connection con=DB.getCon();
		  PreparedStatement ps=con.prepareStatement("delete from e_librarian where id=?");
	       ps.setInt(1, id);
	       status=ps.executeUpdate();
	   
	   } 
	   catch (SQLException e) {
		
		e.printStackTrace();
	}
	   
	   return status;
	   
   }
   
   public static boolean authenticate(String email,String password){
	   
	 boolean status=false;
	   
	try {
		  Connection con = DB.getCon();
		   PreparedStatement ps;
		ps = con.prepareStatement("select * from e_librarian where email=? and password=?");
        
		  ps.setString(1, email);
	      ps.setString(2, password);
	      ResultSet rs=ps.executeQuery();
	      while(rs.next()){
	    	  status=true;
	    	  
	      }
	      
	      
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
	   
	   return status;
	   
	   
   }
   
   
	
}
