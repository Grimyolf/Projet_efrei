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
		
		Staffs staffs1 = new Staffs();
		
		switch(adminlog) {
		
			case 1: 
				
				Staffs staffs = Staffs.getInstance();
				
//				System.out.println("Entrez le salaire :");
//				Scanner x1 = new Scanner(System.in);
//				salary = x1.nextDouble();
//				System.out.println("Entrez le numero de Poste :");
//				Scanner x2 = new Scanner(System.in);
//				desk_no = x2.nextInt();
//				System.out.println("Entrez le numero de Bureau :");
//				Scanner x3 = new Scanner(System.in);
//				office_no = x3.nextInt();
				
				Staff newStaff = new Staff("Clerck",(double) 40000,8,16);
			
				if(staffs.add(newStaff)) 
				{
					System.out.println("Clerk added successfully");
		     	}
			
				try {
					ResultSet set = db.executeQuery("SELECT * FROM staff");               
					while (set.next()) {
						
						//System.out.println (new Staff(id,type,salary,desk_no,office_no));
					}
				 }
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				//AJOUT CLERK
				break;
			
			case 2: 
				System.out.println("ajout lib");
				break;
				
			case 3:
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
						System.out.println (new Loan(loan_id, borrower_id, book_id, issuer_id, issued_date, receiver_id, return_date));
					}
				 }
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
				break;
				
			case 4:
				
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
						System.out.println (new Book(book_id, title, author, synopsis, genre, is_issued));
					}
				 }
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
				break;
				
		
			
		}
	}

}
