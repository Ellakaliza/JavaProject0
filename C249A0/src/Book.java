
public class Book {
	private String title;
	private String author;
	private long isbn;
	private double price;
	private static int counter=0;
	Book (String title, String author, long isbn, double price){
		this.author=author;
		this.isbn=isbn;
		this.price=price;
		this.title=title;
		counter++;
	}
	Book(){
		this("","",0,0);
		counter++;
	}
	public static int findNumberOfCreatedBooks() {
		return counter;
	}
	public String gettitle() {
		return this.title;
	}
	public String getauthor() {
		return this.author;
	}
	public long getisbn() {
		return this.isbn;
	}
	public double getprice() {
		return this.price;
	}
	public void settitle(String title) {
		this.title=title;
	}
	public void setauthor(String author) {
		this.author=author;
	}
	public void setisbn(long isbn) {
		this.isbn= isbn;
	}
	public void setprice(double price) {
		this.price=price;
	}
	public String toString() {
		return "Author: "+author+"\n"+"Title: "+title+"\n"+"ISBN: "+isbn+"\n"+"Price: $"+price;
	}
	public boolean equals(Book book) {
		if(this.isbn==book.isbn&&this.price==book.price)
			return true;
		else
			return false;
	}
}
