package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BookBean;
import bean.IssueBookBean;

public class BookDao {

	
	
	public static int save(BookBean bean){
		
		int status=0;
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_book values(?,?,?,?,?,?)");
		    ps.setString(1, bean.getCallno());
		    ps.setString(2, bean.getName());
		    ps.setString(3, bean.getAuther());
		    ps.setString(4, bean.getPublisher());
            ps.setInt(5, bean.getQuantity());
            ps.setInt(6, 0);
            
            status=ps.executeUpdate();
            con.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public static List<BookBean> view(){
		List<BookBean> list= new ArrayList<BookBean>();
		
		
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_book");
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()){
		    	BookBean bean= new BookBean();
		    	bean.setCallno(rs.getString("callno"));
		    	bean.setName(rs.getString("name"));
		    	bean.setAuther(rs.getString("author"));
		    	bean.setPublisher(rs.getString("publisher"));
		    	bean.setQuantity(rs.getInt("quantity"));
		    	bean.setIssued(rs.getInt("issued"));
		    	
		    	list.add(bean);
		    	
		    }
		 
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static int delete(String callon){
		int status=0;
		
		try {
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from e_book where callno=?");
		    ps.setString(1, callon);
		    status=ps.executeUpdate();
		
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int getIssued(String callno){
		int issued=0;
		
		
		try {
			Connection con=DB.getCon(); 
			PreparedStatement ps =con.prepareStatement("select * from e_book where callno=?");
		    ResultSet rs=ps.executeQuery(); 
		
		    if(rs.next()){
		    	
		    	issued=rs.getInt("issued");
		    }
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return issued;
		
	}
	
	
	public static boolean checkIssued(String callno){
		boolean status=false;
		
		try {
			Connection con=DB.getCon();
			PreparedStatement ps =con.prepareStatement("select * from e_book where callno=? and quantity>issued");
		    ps.setString(1, callno);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()){
		    	status=true;
		    }
		    
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static int issueBook(IssueBookBean bean){
		String callno=bean.getCallno();
		boolean checkstatus=checkIssued(callno);
		System.out.println("Check Status : "+checkstatus);
		
		if(checkstatus){
			int status=0;
			
			try {
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("insert into e_issuebook values(?,?,?,?,?,?)");
			    ps.setString(1, bean.getCallno());
			    ps.setString(2, bean.getStudentid());
			    ps.setString(3, bean.getStudentname());
			    ps.setLong(4, bean.getStudentmobile());
			     Date currentdate= new Date(System.currentTimeMillis());
			     ps.setDate(5, currentdate);
			     ps.setString(6, "no");
			     
			     status=ps.executeUpdate();
			     
			     if(status>0){
			    	 PreparedStatement ps2=con.prepareStatement("update e_book set issued=? where callno=?");
			          ps2.setInt(1, getIssued(callno)+1);
			          ps2.setString(2, callno);
			          status=ps2.executeUpdate();
			          
			     }
			  
			}  
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return status;
			
			
		}else{
			return 0;
		}
		
		
	}
	
	public static int returnbook(String callno,String studentid){
		int status=0;
		
		try {Connection con=DB.getCon();
		PreparedStatement ps= con.prepareStatement("updeate e_issuebook set returnstate='YES' where callno=? and studentid=?");
		ps.setString(1, callno);
		ps.setString(2, studentid);
		
		status=ps.executeUpdate();
		
		if(status>0){
			PreparedStatement ps2=con.prepareStatement("update e_book set issued=? where callno=?");
			ps2.setInt(1, getIssued(callno)-1);
			ps2.setString(2, callno);
			status=ps2.executeUpdate();
			
			
		}
		con.close();
		
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public static List<IssueBookBean> viewIssuedBook(){
		List<IssueBookBean> list= new ArrayList<IssueBookBean>();
		
		
		try {
			Connection con= DB.getCon();
			PreparedStatement ps;
			ps = con.prepareStatement("select * from e_issuebook order by issueddate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			IssueBookBean bean = new IssueBookBean();
			bean.setCallno(rs.getString("callno"));
			bean.setStudentid(rs.getString("studentid"));
			bean.setStudentname(rs.getString("studentname"));
			bean.setStudentmobile(rs.getLong("studentmobile"));
			bean.setIssueddate(rs.getDate("issueddate"));
			bean.setReturnstatus(rs.getString("returnstatus"));
			list.add(bean);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	return list;
		
	}
	
}
