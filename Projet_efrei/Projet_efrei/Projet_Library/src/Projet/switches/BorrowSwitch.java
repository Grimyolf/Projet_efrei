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

public class BorrowSwitch {
	
	public static void printSeparator1() {  //Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
	public void borrowSwitch() {
		
		int borrowlog = 0;
		String searchBook;
		Scanner x = new Scanner(System.in);
		
		System.out.println("Entrez votre choix : \n");
		
		borrowlog = x.nextInt();
		switch(borrowlog) {
		
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
			
		}
	}

}
