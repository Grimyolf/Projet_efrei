package Projet.request;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;

public class RequestBook {
	
DbConnection db = new DbConnection();
	
	public void addBook() {
	
	int trigger=0;
		
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
	    System.out.println("\nEntrez le statut d'emprunt (par défaut : 0):");
	    ps.setInt(5, x2.nextInt());
	    ps.execute();
	    System.out.println("Livre ajouté avec succès");
	}
		catch (SQLException e)
		{
	    e.printStackTrace();
	    }
		
	}

}
