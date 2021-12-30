package Projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import Projet.Main;
import Projet.models.Person;
import Projet.repositories.Persons;
import Projet.switches.AdminSwitch;
import Projet.switches.BorrowSwitch;
import Projet.switches.ClerkSwitch;
import Projet.switches.LibSwitch;
import Projet.abstracts.DAOImpl;
import Projet.abstracts.DAO;
import Projet.DbConnection;

public class Login {

	static String logName1;

	public void setName(String logName1) {
		this.logName1 = logName1;
	}

	public static String getLogName() {
		return logName1;
	}

	private static Scanner sc = new Scanner(System.in);

	public static void printSeparator1() { // Print S�paration 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

	public static void printSeparator2() { // Print S�paration 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}

	public void login() { // Connection � un profile Borrower/Clerk/Librarian/admin

		int login, profile, triggerconn = 0;

		Scanner x = new Scanner(System.in);
		login = x.nextInt();
		printSeparator2();

		DbConnection db = new DbConnection();
		db.initConnection();

		switch (login) {

		case 1: // LOGIN

			System.out.println("Veuillez vous authentifier :\n");

			System.out.println("NOM :");
			Scanner x1 = new Scanner(System.in);
			logName1 = x1.next();

			System.out.println("PASSWORD :");
			Scanner x2 = new Scanner(System.in);
			String UserPass = x2.nextLine();

			try {
				ResultSet set = db.executeQuery(
						"SELECT * FROM person WHERE Last_Name = '" + logName1 + "' AND password = '" + UserPass + "'");
				while (set.next()) 
				{
					System.out.println("\nBienvenue Mr ou Mme " + logName1 + "");
					triggerconn = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(" //!\\   Utilisateur inconnu   //!\\ ");
			}

			if (triggerconn == 0) {
				System.out.printf("Nom d'utilisateur ou Mot de Passe incorrect !");
				System.exit(login);
			} else {

			}

			printSeparator2();
//----------------------------------------------------------------------------------------------------------------------------------------------
			System.out.println("Veuillez choisir votre profile d'utilisateur : \n\n");
			System.out.println(" 1- BORROWER\n 2- CLERK\n 3- LIBRARIAN\n");

			System.out.println("Entrez votre choix : ");

			profile = x.nextInt();

			switch (profile) {
			case 1:
				printSeparator1();
				System.out.println(" \n                   ~ ~ ~ Menu principal BORROWER ~ ~ ~ ");
				printSeparator1();
				System.out.println("Veuillez choisir l'option �executer : \n\n");
				System.out.println(
						" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Acc�der �mes informations personnelles \n 3- Afficher la liste de mes livres emprunt�s");
				printSeparator2();

				BorrowSwitch borrowswitch = new BorrowSwitch(); // Appel de la m�thod borrowswitch
				borrowswitch.borrowSwitch();
				break;
//----------------------------------------------------------------------------------------------------------------------------------------------
			case 2:
				printSeparator1();
				System.out.println(" \n                   ~ ~ ~ Menu principal CLERK ~ ~ ~ ");
				printSeparator1();
				System.out.println("Veuillez choisir l'option �executer : \n\n");
				System.out.println(
						" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Acc�der � mes informations personnelles \n 3- Afficher la liste des livres emprunt�s \n 4- Enregistrer l'emprunt d'un livre pour un client \n 5- V�rifier l'age d'un client \n 6- Enregistrer le retour d'un livre \n 7- Ajouter un nouveau client \n 8- Mettre � jour le profile d'un client\n");
				printSeparator2();

				ClerkSwitch clerkswitch = new ClerkSwitch(); // Appel de la m�thod clerkswitch
				clerkswitch.clerkSwitch();
				break;
//----------------------------------------------------------------------------------------------------------------------------------------------
			case 3:
				printSeparator1();
				System.out.println(" \n                   ~ ~ ~ Menu principal LIBRARIAN ~ ~ ~ ");
				printSeparator1();
				System.out.println("Veuillez choisir l'option �executer : \n\n");
				System.out.println(
						" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Acc�der �mes informations personnelles \n 3- Afficher la liste des livres emprunt�s \n 4- Enregistrer l'emprunt d'un livre pour un client \n 5- V�rifier l'age d'un client \n 6- Enregistrer le retour d'un livre \n 7- Ajouter un nouveau client \n 8- Mettre � jour le profile d'un client\n 9- Ajouter un nouveau livre dans la biblioth�que \n 10- Supprimer un livre de la biblioth�que \n 11- Mettre � jour les informations � propos d'un livre");
				printSeparator2();

				LibSwitch libswitch = new LibSwitch(); // Appel de la m�thod libswitch
				libswitch.libSwitch();
				break;
			}
			break;
//----------------------------------------------------------------------------------------------------------------------------------------------
		case 2: // ADMIN
			System.out.println("Veuillez vous authentifier :\n");
			System.out.println("PASSWORD :");
			Scanner x3 = new Scanner(System.in);
			String AuthPass = x3.nextLine();

			try {
				ResultSet set = db.executeQuery("SELECT password FROM person WHERE password = '" + AuthPass + "'");																																																												
				while (set.next()) {

					System.out.println("\nConnection r�ussie !");
					triggerconn = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (triggerconn == 0) {
				System.out.printf("Mot de Passe incorrect !");
				System.exit(login);
			} else {

			}

			printSeparator1();
			System.out.println(" \n                   ~ ~ ~ Menu principal ADMIN ~ ~ ~ ");
			printSeparator1();
			System.out.println("Veuillez choisir l'option �executer : \n\n");
			System.out.println(
					" 1- Ajouter un nouveau profil CLERK ou LIBRARIAN \n 2- Voir l'historique d'emprunt des livres de la biblioth�que \n 3- Voir l'inventaire des livres de la biblioth�que");
			printSeparator2();

			AdminSwitch adminswitch = new AdminSwitch();
			adminswitch.adminSwitch();

			break;

		case 3: // EXIT
			System.exit(3);
			break;
		default: // EXIT
			System.exit(0);

		}

	}

}
