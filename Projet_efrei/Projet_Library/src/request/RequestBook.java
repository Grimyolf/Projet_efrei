package request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;
import models.Address;
import models.Book;

public class RequestBook {

	DbConnection db = new DbConnection();

	public void addBook() {

		try {
			db.initConnection();

			Scanner x2 = new Scanner(System.in);

			String sql = ("INSERT INTO book(title, author, synopsis, genre, is_issued) values(?,?,?,?,?)");
			PreparedStatement pstate = db.createPreparedStatement(sql);
			System.out.println("\nEntrez le Titre du livre:");
			pstate.setString(1, x2.nextLine());
			System.out.println("\nEntrez l'auteur:");
			pstate.setString(2, x2.nextLine());
			System.out.println("\nEntrez le synopsis:");
			pstate.setString(3, x2.nextLine());
			System.out.println(
					"\nEntrez le genre: (FANTASY, FICTION, HISTORICAL, HORROR, KIDS, MYSTERY, ROMANCE, SCIFI, THRILLER, WESTERN)");
			pstate.setString(4, x2.next());
			System.out.println("\nEntrez le statut d'emprunt (par défaut : 0):");
			pstate.setInt(5, x2.nextInt());
			pstate.execute();
			System.out.println("Livre ajouté avec succès");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//--------------------------------------------------------------------------------------------------------------------------------------------------------
	public void delBook() {

		int delChoice = 0;
		Scanner x2 = new Scanner(System.in);
		System.out.println("Entrez le titre du livre à supprimer de la base de donnée:");
		String delTitre = x2.nextLine();
		System.out.println("\nEtes vous sur de vouloir supprimer ce livre ? --> " + delTitre + "");
		System.out.println("\n1-  OUI\n2-  NON");
		delChoice = x2.nextInt();

		switch (delChoice) {

		case 1:
			try {
				db.initConnection();
				String sql = ("DELETE FROM book WHERE title = '" + delTitre + "'");
				PreparedStatement ps = db.createPreparedStatement(sql);
				ps.execute();
				System.out.println("Livre  " + delTitre + "  supprimé avec succès");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case 2:
			System.exit(0);
			break;

		default:
			System.exit(0);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			db.initConnection();
			Scanner x2 = new Scanner(System.in);

			String sql = ("UPDATE book SET Title=?, Author=?, Synopsis=?, Genre=?, Is_issued=? WHERE Id = ?");
			PreparedStatement pstate = db.createPreparedStatement(sql);
			System.out.println("\n\nEntrez le Nouveau titre du livre:");
			pstate.setString(1, x2.nextLine());
			System.out.println("\nEntrez le nouvel auteur:");
			pstate.setString(2, x2.nextLine());
			System.out.println("\nEntrez le nouveau synopsis:");
			pstate.setString(3, x2.nextLine());
			System.out.println(
					"\nEntrez le nouveau genre: (Format = FANTASY, FICTION, HISTORICAL, HORROR, KIDS, MYSTERY, ROMANCE, SCIFI, THRILLER, WESTERN)");
			pstate.setString(4, x2.nextLine());
			System.out.println("\nEntrez le statut d'emprunt // par défaut = 0 (disponible):");
			pstate.setInt(5, x2.nextInt());
			System.out.println("\nEntrez l'iD du livre à modifier:");
			pstate.setInt(6, x2.nextInt());
			pstate.execute();
			System.out.println("\nLivre modifié avec succès");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void findBook() {

		db.initConnection();
		String searchBook;
		System.out.println("Entrez le Titre, Auteur ou Genre que vous recherchez :\n");
		Scanner x1 = new Scanner(System.in);
		searchBook = x1.nextLine();

		try {
			ResultSet set = db.executeQuery("SELECT * FROM book WHERE Title LIKE '%" + searchBook
					+ "%' OR Author LIKE '%" + searchBook + "%' OR Genre LIKE '%" + searchBook + "%'");
			while (set.next()) {
				int id = set.getInt("id");
				String title = set.getString("title");
				String author = set.getString("author");
				String synopsis = set.getString("synopsis");
				String genre = set.getString("genre");
				int is_issued = set.getInt("is_issued");
				System.out.println(new Book(id, title, author, synopsis, genre, is_issued));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBookIssued() {

		db.initConnection();

		try {
			db.initConnection();
			Scanner x2 = new Scanner(System.in);

			String sql = ("UPDATE book SET Is_issued=? WHERE Id=? ");
			PreparedStatement pstate = db.createPreparedStatement(sql);
			System.out.println("\nEntrez le statut d'emprunt (0 = disponible // 1 = Emprunté) :");
			pstate.setInt(1, x2.nextInt());
			System.out.println("\nEntrez l'iD du livre à modifier:");
			pstate.setInt(2, x2.nextInt());
			pstate.execute();
			System.out.println("\n~ ~ ~ Livre modifié avec succès ~ ~ ~");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
