package Projet.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;
import Projet.models.Address;
import Projet.models.Book;

public class RequestBook {
	
DbConnection db = new DbConnection();
	
	public void addBook() {
	
		
		try {
		db.initConnection();	
		
		Scanner x2 = new Scanner(System.in);
	    
	    String sql = ("INSERT INTO book(title, author, synopsis, genre, is_issued) values(?,?,?,?,?)");
	    PreparedStatement ps = db.createPreparedStatement(sql);
	    System.out.println("\nEntrez le Titre du livre:");
	    ps.setString(1, x2.nextLine());
	    System.out.println("\nEntrez l'auteur:");
	    ps.setString(2, x2.nextLine());
	    System.out.println("\nEntrez le synopsis:");
	    ps.setString(3, x2.nextLine());
	    System.out.println("\nEntrez le genre: (FANTASY, FICTION, HISTORICAL, HORROR, KIDS, MYSTERY, ROMANCE, SCIFI, THRILLER, WESTERN)");
	    ps.setString(4, x2.next());
	    System.out.println("\nEntrez le statut d'emprunt (par d�faut : 0):");
	    ps.setInt(5, x2.nextInt());
	    ps.execute();
	    System.out.println("Livre ajout� avec succ�s");
	}
		catch (SQLException e)
		{
	    e.printStackTrace();
	    }
		
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------
	public void delBook() {
	
		int delChoice=0;
		Scanner x2 = new Scanner(System.in);
		System.out.println("Entrez le titre du livre � supprimer de la base de donn�e:");
		String delTitre = x2.nextLine();
		System.out.println("\nEtes vous sur de vouloir supprimer ce livre ? --> "+ delTitre+"");
		System.out.println("\n1-  OUI\n2-  NON");
		delChoice = x2.nextInt();
		
		switch(delChoice) {
		
		case 1:
			try 
			{
				db.initConnection();					
				String sql = ("DELETE FROM book WHERE title = '" + delTitre + "'");
			    PreparedStatement ps = db.createPreparedStatement(sql);
			    ps.execute();
			    System.out.println("Livre  " + delTitre + "  supprim� avec succ�s");
			}
				catch (SQLException e)
			{
			    e.printStackTrace();
			}
			break;
		
		case 2:
			System.exit(0);
			break;
			
			default: System.exit(0);
	}
	}
	
	public void updateBook() {
		
		db.initConnection();	
		try {
			ResultSet set = db.executeQuery("SELECT * FROM book");               
			while (set.next()) {
				int id = set.getInt("id");
				String title = set.getString("title");
				String author = set.getString("author");
				String synopsis = set.getString("synopsis");
				String genre = set.getString("genre");
				int is_issued = set.getInt("is_issued");
				System.out.println(new Book(id, title, author, synopsis, genre, is_issued));			
			}
		 }
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		try {
			db.initConnection();	
			Scanner x2 = new Scanner(System.in);
		    
		    String sql = ("UPDATE book SET Title=?, Author=?, Synopsis=?, Genre=?, Is_issued=? WHERE Id = ?");
		    PreparedStatement ps = db.createPreparedStatement(sql);
		    System.out.println("\n\nEntrez le Nouveau titre du livre:");
		    ps.setString(1, x2.nextLine());
		    System.out.println("\nEntrez le nouvel auteur:");
		    ps.setString(2, x2.nextLine());
		    System.out.println("\nEntrez le nouveau synopsis:");
		    ps.setString(3, x2.nextLine());
		    System.out.println("\nEntrez le nouveau genre: (Format = FANTASY, FICTION, HISTORICAL, HORROR, KIDS, MYSTERY, ROMANCE, SCIFI, THRILLER, WESTERN)");
		    ps.setString(4, x2.nextLine());
		    System.out.println("\nEntrez le statut d'emprunt // par d�faut = 0 (disponible):");
		    ps.setInt(5, x2.nextInt());
		    System.out.println("\nEntrez l'iD du livre � modifier:");
		    ps.setInt(6, x2.nextInt());
		    ps.execute();
		    System.out.println("\nLivre modifi� avec succ�s");
		}
			catch (SQLException e)
			{
		    e.printStackTrace();
		    }
	}
	
}
