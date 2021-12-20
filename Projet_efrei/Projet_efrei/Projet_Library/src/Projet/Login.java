package Projet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import Projet.Main;
import Projet.models.Person;
import Projet.repositories.Repo_person;
import Projet.abstracts.DAOImpl;
import Projet.abstracts.DAO;
import Projet.DbConnection;

public class Login {
	
	
	public static void printSeparator1() {  //Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
	 
	public boolean login() {             //Connection à un profile Borrower/Clerk/Librarian/admin
			
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
					Scanner x2 = new Scanner(System.in);
					System.out.println("PASSWORD :");
					String UserPass = x2.nextLine();
				
					
					Repo_person repo_person = new Repo_person();
					repo_person.update(profile, null);
					
					
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
						System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste de mes livres emprunté");
						printSeparator2();
						System.out.println("Entrez votre choix : ");
						
						
						borrowlog = x.nextInt();
						break;
	//----------------------------------------------------------------------------------------------------------------------------------------------					
					case 2:
						printSeparator1();
						System.out.println(" \n                   ~ ~ ~ Menu principal CLERK ~ ~ ~ ");
						printSeparator1();
						System.out.println("Veuillez choisir l'option à exécuter : \n\n");
						System.out.println(" 1- Chercher un livre par Titre, Auteur ou Genre \n 2- Accéder à mes informations personnelles \n 3- Afficher la liste des livres emprunté \n 4- Valider l'emprunt d'un livre pour un client \n 4");
						printSeparator2();
						System.out.println("Entrez votre choix : ");
						
						
						clerklog = x.nextInt();
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
						
						
						liblog = x.nextInt();
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
					
					
					adminlog = x.nextInt();
					
					switch(adminlog) {
					
						case 1: 
							System.out.println("ajout clerc");
							break;
						
						case 2: 
							System.out.println("ajout lib");
							break;
							
						case 3:
							System.out.println("check issue");
							break;
							
						case 4:
							System.out.println("check inventory");
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
}


//	 public boolean login(Person person) {             //Connection à un profile Borrower/Clerk/Librarian
//		
//		int login = 0;
//		Scanner x = new Scanner(System.in);
//		login = x.nextInt();
//			
//		switch(login) {
//		
//			case 1:
//				
//				System.out.println("Veuillez vous authentifier :\n");
//				System.out.println("NOM :");
//				Scanner x1 = new Scanner(System.in);
//				String ID = x1.next();
//				System.out.println("PASSWORD :");
//				Scanner x2 = new Scanner(System.in);
//				String PWD = x2.next();
//				
//				DbConnection db = new DbConnection();
//				db.initConnection();
//		
//				try {
//					
//					String sql = String.format("Insert into %s(Name, LastName, Password, DateOfBirth, AdressId, Phone, Genre) values(?,?,?,?,?,?,?)", tableName);
//					
//						PreparedStatement preparedStatement = this.conn.createPreparedStatement(sql);
//						preparedStatement.setString(2, person.getLastName());
//						preparedStatement.setString(3, person.getPassword());
//						
//						
//					
//				} 
//				catch (SQLException e) {
//					e.printStackTrace();
//				}
//				
//			break;
//			case 2:
//				System.out.println("admin");
//			break;
//			case 3:
//				System.out.println("exit");
//				break;
//			default:
//				System.out.println("exit");
//		}
//		return false;
//}
	
