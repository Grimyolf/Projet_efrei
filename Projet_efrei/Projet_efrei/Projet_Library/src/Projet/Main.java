package Projet;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.Login;
import Projet.DbConnection;
import Projet.models.*;
import Projet.repositories.*;
import Projet.repositories.Repo_person.Persons;
import Projet.abstracts.DAO;
import Projet.abstracts.DAOImpl;


public class Main {
	private static Scanner sc = new Scanner(System.in);
	

	public static void printSeparator1() {  //Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
public static boolean login() {             //Connection à un profile Borrower/Clerk/Librarian/admin
		
		int login, adminlog, borrowlog, clerklog, liblog, profile = 0;
		Scanner x = new Scanner(System.in);
		login = x.nextInt();
		printSeparator2();	
		switch(login) {
		
			case 1: //LOGIN
				
				System.out.println("Veuillez vous authentifier :\n");
				System.out.println("NOM :");
				Scanner x1 = new Scanner(System.in);
				String logName = x1.nextLine();
				System.out.println("PASSWORD :");
				Scanner x2 = new Scanner(System.in);
				String UserPass = x2.nextLine();
				printSeparator2();
//----------------------------------------------------------------------------------------------------------------------------------------------				
				System.out.println("Veuillez choisir votre profile d'utilisateur : \n\n");
				System.out.println(" 1- BORROWER\n 2- CLERK\n 3- LIBRARIAN\n");
				
				System.out.println("Entrez votre choix : ");
				Scanner x8 = new Scanner(System.in);
				profile = x8.nextInt();
				
				
				switch (profile) {
				case 1:
					printSeparator1();
					System.out.println(" \n                   ~ ~ ~ Menu principal BORROWER ~ ~ ~ ");
					printSeparator1();
					System.out.println("Veuillez choisir l'option à exécuter : \n\n");
					System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste de mes livres emprunté");
					printSeparator2();
					System.out.println("Entrez votre choix : ");
					
					Scanner x5 = new Scanner(System.in);
					borrowlog = x5.nextInt();
					break;
//----------------------------------------------------------------------------------------------------------------------------------------------					
				case 2:
					printSeparator1();
					System.out.println(" \n                   ~ ~ ~ Menu principal CLERK ~ ~ ~ ");
					printSeparator1();
					System.out.println("Veuillez choisir l'option à exécuter : \n\n");
					System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste des livres emprunté");
					printSeparator2();
					System.out.println("Entrez votre choix : ");
					
					Scanner x6 = new Scanner(System.in);
					clerklog = x6.nextInt();
					break;
//----------------------------------------------------------------------------------------------------------------------------------------------					
				case 3:
					printSeparator1();
					System.out.println(" \n                   ~ ~ ~ Menu principal LIBRARIAN ~ ~ ~ ");
					printSeparator1();
					System.out.println("Veuillez choisir l'option à exécuter : \n\n");
					System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste des livres emprunté");
					printSeparator2();
					System.out.println("Entrez votre choix : ");
					
					Scanner x7 = new Scanner(System.in);
					liblog = x7.nextInt();
					break;
				}
				break;
//----------------------------------------------------------------------------------------------------------------------------------------------				
			case 2: //ADMIN
				System.out.println("Veuillez vous authentifier :\n");
				System.out.println("PASSWORD :");
				Scanner x3 = new Scanner(System.in);
				String AuthPass = x3.nextLine();
				printSeparator1();
				System.out.println(" \n                   ~ ~ ~ Menu principal ADMIN ~ ~ ~ ");
				printSeparator1();
				System.out.println("Veuillez choisir l'option à exécuter : \n\n");
				System.out.println(" 1- Ajouter nouveau profile CLERK \n 2- Ajouter un nouveau profile LIBRARIAN \n 3- Voir l'historique d'emprunt de la bibliothèque \n 4- Voir l'inventaire des livres de la bibliothèque");
				printSeparator2();
				System.out.println("Entrez votre choix : ");
				
				Scanner x4 = new Scanner(System.in);
				adminlog = x4.nextInt();
				
				switch(adminlog) {
				
					case 1: 
						System.out.println("clerc");
						break;
					
					case 2: 
						System.out.println("lib");
						break;
						
					case 3:
						System.out.println("issue");
						break;
						
					case 4:
						System.out.println("inventory");
						break;
						
				}
			break;
			case 3: //EXIT
				System.exit(3);
				break;
			default: //EXIT
				System.exit(0);
				
		}
		return false;

}
		
	public static int scanIdFor(String entity) {  //Scan d'ID dans la base
		printSeparator2();
		System.out.printf("Search %s by Id:\n", entity);
		return sc.nextInt();
	}
	
	public static String scanLastNameFor(String logName) { //Scan de nom dans la base
		printSeparator2();
		System.out.printf("Chercher %s by LastName:\n", logName);
		return sc.nextLine();
	}

	
	
	public static void main(String[] args) {
		
		DbConnection db = new DbConnection();
		db.initConnection();
		
		printSeparator1();
		System.out.println("\n  ~ ~ ~ Bienvenue dans le Système de Gestion de la Bibliothèque ~ ~ ~");
		printSeparator1();
		System.out.println("Veuillez choisir l'option à exécuter : \n\n");
		System.out.println(" 1- Login\n 2- Administration\n 3- EXIT\n");
		
		System.out.println("Entrez votre choix : ");
		
		login(); //Appel de la méthod login (cf: plus haut)
		
		
//		Repo_person persons = new Repo_person(db);
//		String logName = scanLastNameFor("LAST_NAME");
//		 Person person = persons.getByLastName(logName);
//
//		if ( person == null) {
//			System.out.printf("Non existing User with LastName %s\n", logName);
//		} else {
//			System.out.println("OUI");
//		}
//
//		printSeparator1();
		
//		try {
//			ResultSet resset = db.executeQuery("SELECT * FROM person");               
//			while (resset.next()) {
//				int personId = resset.getInt("Id");
//				String firstName = resset.getString("first_name");
//				String lastName = resset.getString("last_Name");
//				String password = resset.getString("password");
//				Date dateOfBirth = resset.getDate("date_Of_Birth");
//				int adressId = resset.getInt("address_Id");
//				String phone = resset.getString("phone_no");
//				String genre = resset.getString("genre");
//				System.out.println (new Person(personId, firstName, lastName, password, dateOfBirth, adressId, phone, genre));
//			}
//		 }
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
		
}
	
}

