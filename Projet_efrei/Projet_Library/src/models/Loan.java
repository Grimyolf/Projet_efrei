package models;

import java.sql.Date;

public class Loan {
	private int id;
	private int borrower_id;
	private int book_id;
	private int issuer_id;
	private java.util.Date issued_date;
	private int receiver_id;
	private java.util.Date return_date;

	public Loan(int borrower_id, int book_id, int issuer_id, java.util.Date issued_date, int receiver_id, java.util.Date return_date) {
		this.setBorrower_id(borrower_id);
		this.setBook_id(book_id);
		this.setIssuer_id(issuer_id);
		this.setIssued_date(issued_date);
		this.setReceiver_id(receiver_id);
		this.setReturn_date(return_date);
	}

	public Loan(int id, int borrower_id, int book_id, int issuer_id, java.util.Date issued_date, int receiver_id, java.util.Date return_date) {
		this(borrower_id, book_id, issuer_id, issued_date, receiver_id, return_date);
		this.setLoanId(id);
	}

	
	////////////////////
	public int getLoanId() {
		return id;
	}

	public void setLoanId(int id) {
		this.id = id;
	}
	
	
	public int getBorrower_id() {
		return borrower_id;
	}

	public void setBorrower_id(int borrower_id) {
		this.borrower_id = borrower_id;
	}
	
	
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	
	public int getIssuer_id() {
		return issuer_id;
	}

	public void setIssuer_id(int issuer_id) {
		this.issuer_id = issuer_id;
	}
	
	
	public java.util.Date getIssued_date() {
		return issued_date;
	}

	public void setIssued_date(java.util.Date issued_date) {
		this.issued_date = issued_date;
	}
	
	
	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	
	
	public java.util.Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(java.util.Date return_date) {
		this.return_date = return_date;
	}


	@Override
	public String toString() {
		return "Loan [ID= " + id + ", borrower ID= " + borrower_id + ", book ID= " + book_id + ", issuer ID= " + issuer_id + ", date de retour= "+ return_date + "]";
	}

}
