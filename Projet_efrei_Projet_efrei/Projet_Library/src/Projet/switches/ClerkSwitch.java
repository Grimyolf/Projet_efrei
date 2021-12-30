package Projet.switches;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import Projet.Main;
import Projet.models.Book;
import Projet.models.Loan;
import Projet.models.Person;
import Projet.repositories.Persons;
import Projet.switches.BorrowSwitch;
import Projet.abstracts.DAOImpl;
import Projet.abstracts.DAO;
import Projet.DbConnection;
import Projet.Login;

public class ClerkSwitch {

	
		public static void printSeparator1() {  //Print Séparation 1
			System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
		
		public static void printSeparator2() {  //Print Séparation 2
			System.out.printf("\n------------------------------------------------------------------------\n");
		}
		
		public void clerkSwitch() {
			
			DbConnection db = new DbConnection();
			db.initConnection();
			
			int clerklog = 0;
			String searchBook;
			Scanner x = new Scanner(System.in);
			
			System.out.println("Entrez votre choix : \n");
			
			clerklog = x.nextInt();
			switch(clerklog) {
			
			case 1:
				System.out.println("Entrez le Titre, Auteur ou Genre que vous recherchez :\n");
				Scanner x1 = new Scanner(System.in);
				searchBook = x1.nextLine();
				
				try {
					ResultSet set = db.executeQuery("SELECT * FROM book WHERE Title LIKE '%"+ searchBook +"%' OR Author LIKE '%"+ searchBook +"%' OR Genre LIKE '%"+ searchBook +"%'");               
					while (set.next()) {
						int id = set.getInt("id");
						String title = set.getString("title");
						String author = set.getString("author");
						String synopsis = set.getString("synopsis");
						String genre = set.getString("genre");
						int is_issued = set.getInt("is_issued");
						System.out.println (new Book(id, title, author, synopsis, genre, is_issued));
					}
				 }
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------				
			case 2:
				Login logName = new Login();
				String logName1 = Login.getLogName();
				
				try {
					ResultSet set = db.executeQuery("SELECT * FROM person WHERE Last_Name = '"+ logName1 +"'");               
					while (set.next()) {
						int id = set.getInt("id");
						String first_name = set.getString("first_name");
						String last_Name = set.getString("last_Name");
						String password = set.getString("password");
						java.sql.Date date_Of_Birth = set.getDate("date_Of_Birth");
						int address_id = set.getInt("address_id");
						String phone_no = set.getString("phone_no");
						String genre = set.getString("genre");
						System.out.println (new Person(id, first_name, last_Name, password, date_Of_Birth, address_id, phone_no, genre));
					}
				 }
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------				
			case 3:
				Login logName2 = new Login();
				String getName = Login.getLogName();
				
				try {
					ResultSet set = db.executeQuery("SELECT * FROM loan WHERE EXISTS (SELECT id FROM person WHERE Last_Name = '"+ getName +"' AND loan.borrower_id = person.id)");               
					while (set.next()) {
						int id = set.getInt("id");
						int borrower_id = set.getInt("borrower_id");
						int book_id = set.getInt("book_id");
						int issuer_id = set.getInt("issuer_id");
						Date issued_date = set.getDate("issued_date");
						int receiver_id = set.getInt("receiver_id");
						Date return_date = set.getDate("return_date");
						System.out.println (new Loan(id, borrower_id, book_id, issuer_id, issued_date, receiver_id, return_date));
					}
				 }
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------				
			case 4:
				System.out.println("Enregistrer emprunt livre client");
				break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------				
			case 5:
				System.out.println("Entrez le nom du client à vérifier :");
				break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------				
			case 6:
				System.out.println("Entrez le titre du livre rendu : ");
				break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case 7:
				System.out.println("Ajouter un nouveau Client");
				break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			case 8:
				System.out.println("Quel est le nom du Client à modifier ?");
				break;
			}
		}

	
}
