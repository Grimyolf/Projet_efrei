package Projet;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.Login;
import Projet.DbConnection;
import Projet.models.*;
import Projet.repositories.*;
import Projet.repositories.Repo_person.Persons;
import Projet.abstracts.DAO;
import Projet.abstracts.DAOImpl;


public class Main {
	private static Scanner sc = new Scanner(System.in);
	

	public static void printSeparator1() {
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	
public static boolean login() {             //Connection à un profile Borrower/Clerk/Librarian
		
		int login = 0;
		Scanner x = new Scanner(System.in);
		login = x.nextInt();
			
		switch(login) {
		
			case 1:
				
				System.out.println("Veuillez vous authentifier :\n");
				System.out.println("NOM :");
				Scanner x1 = new Scanner(System.in);
				String ID = x1.next();
				System.out.println("PASSWORD :");
				Scanner x2 = new Scanner(System.in);
				String PWD2 = x2.next();
				
				
//				try {
//					
//					String sql = String.format("Insert into %s(Name, LastName, Password, DateOfBirth, AdressId, Phone, Genre) values(?,?,?,?,?,?,?)", tableName);
//					
//						PreparedStatement preparedStatement = this.conn.createPreparedStatement(sql);
//						preparedStatement.setString(2, person.getLastName());
//						preparedStatement.setString(3, person.getPassword());	
//				} 
//				catch (SQLException e) {
//					e.printStackTrace();
//				}
				
			break;
			case 2:
				System.out.println("Veuillez vous authentifier :\n");
				System.out.println("PASSWORD :");
				Scanner x3 = new Scanner(System.in);
				String PWD3 = x3.next();
				
			break;
			case 3:
				System.exit(3);
				break;
			default:
				System.exit(0);
				
		}
		return false;

}
		
	public static int scanIdFor(String entity) {
		printSeparator1();
		System.out.printf("Search %s by Id:\n", entity);
		return sc.nextInt();
	}

	public static void main(String[] args) {
		
		DbConnection db = new DbConnection();
		db.initConnection();
		
		printSeparator1();
		System.out.println("\n  ~ ~ ~ Bienvenue dans le Système de Gestion de la Bibliothèque ~ ~ ~");
		printSeparator1();
		System.out.println("Veuillez choisir l'option à exécuter : \n\n");
		System.out.println(" 1- Login\n 2- Administration\n 3- EXIT");
		printSeparator2();
		System.out.println("Entrez votre choix : ");
		
		login();
		

		
		try {
			ResultSet set = db.executeQuery("SELECT * FROM person");               
			while (set.next()) {
				int personId = set.getInt("Id");
				String firstName = set.getString("first_name");
				String lastName = set.getString("last_Name");
				String password = set.getString("password");
				Date dateOfBirth = set.getDate("date_Of_Birth");
				int adressId = set.getInt("address_Id");
				String phone = set.getString("phone_no");
				String genre = set.getString("genre");
				System.out.println (new Person(personId, firstName, lastName, password, dateOfBirth, adressId, phone, genre));
				
//				int id = set.getInt("Id");
//				String title = set.getString("title");
//				String author = set.getString("author");
//				String synopsis = set.getString("synopsis");
//				String genre = set.getString("genre");
//				String is_issued = set.getString("is_issued");
//				System.out.println(new Book(id, title, author, synopsis, genre, is_issued));
			}
		 }
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		}
	
}

