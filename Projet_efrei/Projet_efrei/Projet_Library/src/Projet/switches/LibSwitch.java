package Projet.switches;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import Projet.Main;
import Projet.models.Person;
import Projet.repositories.Repo_person;
import Projet.switches.BorrowSwitch;
import Projet.abstracts.DAOImpl;
import Projet.abstracts.DAO;
import Projet.DbConnection;

public class LibSwitch {
	
	public static void printSeparator1() {  //Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
	public void libSwitch() {
		
		int liblog = 0;
		String searchBook;
		Scanner x = new Scanner(System.in);
		
		System.out.println("Entrez votre choix : \n");
		
		liblog = x.nextInt();
		switch(liblog) {
		
		case 1:
			System.out.println("\n Entrez le Titre, Auteur ou Genre que vous recherchez :");
			Scanner x1 = new Scanner(System.in);
			searchBook = x1.nextLine();
			break;
			
		case 2:
			System.out.println("Profile check");
			break;
			
		case 3:
			System.out.println("Book list emprunté");
			break;
			
		case 4:
			System.out.println("Enregistrer emprunt livre client");
			break;
			
		case 5:
			System.out.println("Entrez le nom du client à vérifier :");
			break;
			
		case 6:
			System.out.println("Entrez le titre du livre rendu : ");
			break;
			
		case 7:
			System.out.println("Ajouter un nouveau Client");
			break;
			
		case 8:
			System.out.println("Quel est le nom du Client à modifier ?");
			break;
			
		case 9:
			System.out.println("Add book");
			break;
			
		case 10:
			System.out.println("Delete book");
			break;
		
		case 11:
			System.out.println("Update book");
			break;
			
			
		}
	}



}
