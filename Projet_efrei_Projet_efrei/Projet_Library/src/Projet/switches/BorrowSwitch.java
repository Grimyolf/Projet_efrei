package Projet.switches;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import Projet.Main;
import Projet.models.Book;
import Projet.models.Person;
import Projet.repositories.Persons;
import Projet.switches.BorrowSwitch;
import Projet.abstracts.DAOImpl;
import Projet.abstracts.DAO;
import Projet.DbConnection;
import Projet.Login;


public class BorrowSwitch {
	
	public static void printSeparator1() {  //Print S�paration 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print S�paration 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
	public void borrowSwitch() {
		
		DbConnection db = new DbConnection();
		db.initConnection();
		
		
		
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
			
		case 2:
			Login log = new Login();
			String logName = log.logName;
			
			try {
				ResultSet set = db.executeQuery("SELECT * FROM person WHERE Last_Name LIKE '%"+ logName +"%'");               
				while (set.next()) {
					int id = set.getInt("id");
					String first_name = set.getString("first_name");
					String last_Name = set.getString("last_Name");
					String password = set.getString("password");
					java.sql.Date date_Of_Birth = set.getDate("date_Of_Birth");
					int address_Id = set.getInt("address_Id");
					String phone_no = set.getString("phone_no");
					String genre = set.getString("genre");
					System.out.println (new Person(id, first_name, last_Name, password, date_Of_Birth, address_Id, phone_no, genre));
				}
			 }
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			break;
			
		case 3:
			System.out.println("Book list emprunt�");
			break;
			
		}
	}

}