package Projet.switches;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import Projet.Main;
import Projet.repositories.Persons;
import Projet.repositories.Staffs;
import Projet.switches.BorrowSwitch;
import Projet.models.*;
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
		
		Staffs staffs = new Staffs();
		
		switch(adminlog) {
		
			case 1: 
				
				System.out.println("Entrez le salaire :");
				salary = x.nextDouble();
				System.out.println("Entrez le numero de Poste :");
				desk_no = x.nextInt();
				System.out.println("Entrez le numero de Bureau :");
				office_no = x.nextInt();
				
				Staff newStaff = new Staff(id,type,salary,desk_no,office_no);
			
				if(staffs.add(newStaff)) 
				{
					System.out.println("Clerk added successfully");
		     	}
			
				
				//AJOUT CLERK
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
