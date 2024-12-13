package example;

public class Book {
	private int no;
	private String title;
	private String author;
	private int stateCode;
	
	
	public Book(int no, String title, String author) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}


	public int getNo() {
		return no;
	}


	public String getTitle() {
		return title;
	}


	public String getAuthor() {
		return author;
	}


	public int getStateCode() {
		return stateCode;
	}


	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}


	@Override
	public String toString() {
		return "책 제목:" + title 
				+ ", 작가:" + author 
				+ ", 대여 유무:" + ((stateCode == 1) ? "재고있음" : "대여중");
	}
	
	
	
}
