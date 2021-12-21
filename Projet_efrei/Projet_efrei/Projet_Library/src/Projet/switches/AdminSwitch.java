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

public class AdminSwitch {
	
	public static void printSeparator1() {  //Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
	public void adminSwitch() {
		
		int adminlog = 0;
		String searchBook;
		Scanner x = new Scanner(System.in);
		
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
	}

}
