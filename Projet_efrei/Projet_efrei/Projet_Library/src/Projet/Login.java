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
	
	public String logName;
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void printSeparator1() {  //Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
	public static String scanLastNameFor(String logName) { //Scan de nom dans la base
		printSeparator2();
		System.out.printf("Chercher %s by LastName:\n", logName);
		return sc.nextLine();
	}
	 
	public void login() {             //Connection à un profile Borrower/Clerk/Librarian/admin
			
			int login, profile = 0;
			
			Scanner x = new Scanner(System.in);
			login = x.nextInt();
			printSeparator2();
			
			DbConnection db = new DbConnection();
			db.initConnection();
			
			switch(login) {
			
				case 1: //LOGIN
					
					System.out.println("Veuillez vous authentifier :\n");
					
					System.out.println("NOM :");
					Scanner x1 = new Scanner(System.in);
					logName = x1.next();
					Scanner x2 = new Scanner(System.in);
					System.out.println("PASSWORD :");
					String UserPass = x2.next();
					
//					Repo_person repo_person = new Repo_person(db);
//					Person person = repo_person.getByLastName(logName);
//
//					if (person == null) 
//					{
//						System.out.printf("Non existing Person with LastName %s\n", logName);
//					} 
//					else 
//					{
//						System.out.println(person);
//					}
//					
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
						System.out.println("Veuillez choisir l'option à exécuter : \n\n");
						System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste de mes livres empruntés");
						printSeparator2();
						
						BorrowSwitch borrowswitch = new BorrowSwitch();  //Appel de la méthod borrowswitch
						borrowswitch.borrowSwitch();
						break;
	//----------------------------------------------------------------------------------------------------------------------------------------------					
					case 2:
						printSeparator1();
						System.out.println(" \n                   ~ ~ ~ Menu principal CLERK ~ ~ ~ ");
						printSeparator1();
						System.out.println("Veuillez choisir l'option à exécuter : \n\n");
						System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste des livres empruntés \n 4- Enregistrer l'emprunt d'un livre pour un client \n 5- Vérifier l'age d'un client \n 6- Enregistrer le retour d'un livre \n 7- Ajouter un nouveau client \n 8- Mettre à jour le profile d'un client\n");
						printSeparator2();
						
						ClerkSwitch clerkswitch = new ClerkSwitch();  //Appel de la méthod clerkswitch
						clerkswitch.clerkSwitch();
						break;
	//----------------------------------------------------------------------------------------------------------------------------------------------					
					case 3:
						printSeparator1();
						System.out.println(" \n                   ~ ~ ~ Menu principal LIBRARIAN ~ ~ ~ ");
						printSeparator1();
						System.out.println("Veuillez choisir l'option à exécuter : \n\n");
						System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste des livres empruntés \n 4- Enregistrer l'emprunt d'un livre pour un client \n 5- Vérifier l'age d'un client \n 6- Enregistrer le retour d'un livre \n 7- Ajouter un nouveau client \n 8- Mettre à jour le profile d'un client\n 9- Ajouter un nouveau livre dans la bibliothèque \n 10- Supprimer un livre de la bibliothèque \n 11- Mettre à jour les informations à propos d'un livre" );
						printSeparator2();
						
						LibSwitch libswitch = new LibSwitch();  //Appel de la méthod libswitch
						libswitch.libSwitch();
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
					System.out.println(" 1- Ajouter nouveau profile CLERK \n 2- Ajouter un nouveau profile LIBRARIAN \n 3- Voir l'historique d'emprunt des livres de la bibliothèque \n 4- Voir l'inventaire des livres de la bibliothèque");
					printSeparator2();
					
					AdminSwitch adminswitch = new AdminSwitch();
					adminswitch.adminSwitch();
				break;
				
				case 3: //EXIT
					System.exit(3);
					break;
				default: //EXIT
					System.exit(0);
					
			}
			
	
	}		
}

	
