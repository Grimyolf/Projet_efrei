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

public class ClerkSwitch {

	
		public static void printSeparator1() {  //Print S�paration 1
			System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
		
		public static void printSeparator2() {  //Print S�paration 2
			System.out.printf("\n------------------------------------------------------------------------\n");
		}
		
		public void clerkSwitch() {
			
			int clerklog = 0;
			String searchBook;
			Scanner x = new Scanner(System.in);
			
			System.out.println("Entrez votre choix : \n");
			
			clerklog = x.nextInt();
			switch(clerklog) {
			
			case 1:
				System.out.println("\n Entrez le Titre, Auteur ou Genre que vous recherchez :");
				Scanner x1 = new Scanner(System.in);
				searchBook = x1.nextLine();
				break;
				
			case 2:
				System.out.println("Profile check");
				break;
				
			case 3:
				System.out.println("Book list emprunt�");
				break;
				
			case 4:
				System.out.println("Enregistrer emprunt livre client");
				break;
				
			case 5:
				System.out.println("Entrez le nom du client � v�rifier :");
				break;
				
			case 6:
				System.out.println("Entrez le titre du livre rendu : ");
				break;
				
			case 7:
				System.out.println("Ajouter un nouveau Client");
				break;
				
			case 8:
				System.out.println("Quel est le nom du Client � modifier ?");
				break;
			}
		}

	
}
