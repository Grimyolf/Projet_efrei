package switches;

import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import repositories.Staffs;
import request.RequestAddress;
import request.RequestPerson;
import request.RequestStaff;
import models.*;
import Projet.DbConnection;

public class AdminSwitch {

	public static void printSeparator1() { // Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

	public static void printSeparator2() { // Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}

	public void adminSwitch() {

		DbConnection db = new DbConnection();
		db.initConnection();

		int id = 0, adminlog = 0;
		String searchBook;
		String type = "CLERK";
		Double salary;
		int desk_no, office_no;
		Scanner x = new Scanner(System.in);

		System.out.println("Entrez votre choix : ");
		adminlog = x.nextInt();

		Staffs staffs1 = new Staffs();

		switch (adminlog) {

		case 1:

			RequestAddress addaddress = new RequestAddress(); // Ajout d'une colonne Address
			addaddress.addAddress();

			RequestPerson addperson = new RequestPerson(); // Ajout d'une colonne Person
			addperson.addPerson();

			RequestStaff addstaff = new RequestStaff(); // Ajout d'une colonne Staff
			addstaff.addStaff();

			System.out.println("\n~ ~ ~  Profil ajouté avec succès  ~ ~ ~");
			// AJOUT CLERK + LIBRARIAN + ADMIN
			break;

		case 2:
			System.out.println("\nHistorique d'emprunt de la bibliothèque :\n");
			try {
				ResultSet set = db.executeQuery("SELECT * FROM loan");
				while (set.next()) {
					int loan_id = set.getInt("id");
					int borrower_id = set.getInt("borrower_id");
					int book_id = set.getInt("book_id");
					int issuer_id = set.getInt("issuer_id");
					Date issued_date = set.getDate("issued_date");
					int receiver_id = set.getInt("receiver_id");
					Date return_date = set.getDate("return_date");
					System.out.println(
							new Loan(loan_id, borrower_id, book_id, issuer_id, issued_date, receiver_id, return_date));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case 3:

			System.out.println("\nInventaire des livres de la bibliothèque :\n");
			try {
				ResultSet set = db.executeQuery("SELECT * FROM book");
				while (set.next()) {
					int book_id = set.getInt("id");
					String title = set.getString("title");
					String author = set.getString("author");
					String synopsis = set.getString("synopsis");
					String genre = set.getString("genre");
					int is_issued = set.getInt("is_issued");
					System.out.println(new Book(book_id, title, author, synopsis, genre, is_issued));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

}
