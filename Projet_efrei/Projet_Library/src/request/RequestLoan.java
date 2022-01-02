package request;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;

public class RequestLoan {
	
	DbConnection db = new DbConnection();

	public void addLoan() {
		
		try {
			db.initConnection();	
			
			Scanner x2 = new Scanner(System.in);
		    
		    String sql = ("INSERT INTO Loan (borrower_Id, book_Id, issuer_Id, issued_Date, receiver_Id, return_Date) values(?,?,?,?,?,?)");
		    PreparedStatement ps = db.createPreparedStatement(sql);
		    System.out.println("\nEntrez l'id du Borrower qui emprunte le livre:");
		    ps.setString(1, x2.nextLine());
		    System.out.println("\nEntrez l'id du livre emprunté:");
		    ps.setString(2, x2.nextLine());
		    System.out.println("\nEntrez l'id du bibliothécaire qui enregistre l'emprunt:");
		    ps.setString(3, x2.nextLine());
		    System.out.println("\nEntrez la date d'emprunt (format: AAAA-MM-DD ):");
		    ps.setString(4, x2.nextLine());
		    System.out.println("\nEntrez l'id du bibliothécaire qui enregistre le retour du livre:");
		    ps.setString(5, x2.nextLine());
		    System.out.println("\nEntrez la date de Retour d'emprunt (format: AAAA-MM-DD ):");
		    ps.setString(6, x2.nextLine());
		    ps.execute();
		    System.out.println("Emprunt ajouté avec succès");
		}
			catch (SQLException e)
			{
		    e.printStackTrace();
		    }
		
	}
	
	public void deleteLoan() {
		
		db.initConnection();
		int retourChoice=0;
		Scanner x2 = new Scanner(System.in);
		System.out.println("Entrez l'id du livre à retourner:");
		String idRetour = x2.nextLine();
		System.out.println("\nEtes vous sur de vouloir retourner ce livre ? --> "+ idRetour+"");
		System.out.println("\n1-  OUI\n2-  NON");
		retourChoice = x2.nextInt();
		
		switch(retourChoice) {
		
		case 1:
			try 
			{
				db.initConnection();					
				String sql = ("DELETE FROM loan WHERE book_id = '" + idRetour + "'");
			    PreparedStatement ps = db.createPreparedStatement(sql);
			    ps.execute();
			    System.out.println("Livre avec l'ID  " + idRetour + "  à été retourné avec succès");
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
	
}
