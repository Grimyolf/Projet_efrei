package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Projet.DbConnection;

public class Book {
	private int id;
	private String title;
	private String author;
	private String synopsis;
	private String genre;
	private int is_issued;

	public Book(String title, String author, String synopsis, String genre, int is_issued) {
		this.setTitle(title);
		this.setAuthor(author);
		this.setSynopsis(synopsis);
		this.setGenre(genre);
		this.setIs_issued(is_issued);
	}

	public Book(int id, String title, String author, String synopsis, String genre, int is_issued) {
		this(title, author, synopsis, genre, is_issued);
		this.setId(id);
	}

	public Book(int id, int is_issued) {
		this.setIs_issued(is_issued);
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getIs_issued() {
		return is_issued;
	}

	public void setIs_issued(int is_issued) {
		this.is_issued = is_issued;
	}

	@Override
	public String toString() {
		return "Livre: [Book_id= " + id + ", Titre= " + title + ", Autheur= " + author + ", Synopsis= " + synopsis
				+ ", Genre= " + genre + ", Disponible= " + is_issued + "]";
	}

}
