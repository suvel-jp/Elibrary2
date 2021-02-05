package bean;

public class BookBean {

	private String callno,name,auther,publisher;
	private int quantity,issued;
	
	
	public BookBean(){
		
	}


	public BookBean(String callno, String name, String auther, String publisher, int quantity) {
		super();
		this.callno = callno;
		this.name = name;
		this.auther = auther;
		this.publisher = publisher;
		this.quantity = quantity;
		
	}


	public String getCallno() {
		return callno;
	}


	public void setCallno(String callno) {
		this.callno = callno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuther() {
		return auther;
	}


	public void setAuther(String auther) {
		this.auther = auther;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getIssued() {
		return issued;
	}


	public void setIssued(int issued) {
		this.issued = issued;
	}
	
	
	
	
	
	
}
