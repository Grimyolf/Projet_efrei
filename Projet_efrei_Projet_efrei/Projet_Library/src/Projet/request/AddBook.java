package Projet.request;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.models.*;

import Projet.DbConnection;

public class AddBook {
	
DbConnection db = new DbConnection();
	
	public void addBook(String title, String author, String synopsis, String genre, int is_issued) {
	try {
		Scanner x2 = new Scanner(System.in);
	    db.initConnection();
	    System.out.println("Entrez le Titre du livre:\n");
	    title = x2.next();
	    System.out.println("Entrez l'autheur:\n");
	    author = x2.next();
	    System.out.println("Entrez le synopsis:\n");
	    synopsis = x2.next();
	    System.out.println("Entrez le genre:\n");
	    genre = x2.next();
	    System.out.println("Entrez le statut d'emprunt (par défaut : 0):\n");
	    is_issued = x2.nextInt();
	    String sql = ("INSERT INTO book(title, author, synopsis, genre, is_issued) values(?,?,?,?,?)");
	    PreparedStatement ps = db.createPreparedStatement(sql);
	    ps.setString(1, title());
	    ps.setString(2, author());
	    ps.setString(3, synopsis());
	    ps.setString(4, genre());
	    ps.setInt(5, is_issued());
	    ps.execute();
	}catch (SQLException e){
	    e.printStackTrace();
	}

	}

	private String genre() {
		// TODO Auto-generated method stub
		return null;
	}

	private int is_issued() {
		// TODO Auto-generated method stub
		return 0;
	}

}
