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
				String logName = x1.next();
				System.out.println("PASSWORD :");
				Scanner x2 = new Scanner(System.in);
				String UserPass = x2.next();
				
			break;
			case 2:
				System.out.println("Veuillez vous authentifier :\n");
				System.out.println("PASSWORD :");
				Scanner x3 = new Scanner(System.in);
				String AuthPass = x3.next();
				
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
	
	public static String scanLastNameFor(String entity) {
		printSeparator1();
		System.out.printf("Search %s by LastName:\n", entity);
		return sc.next();
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
		
		
		printSeparator1();
		
		Persons persons = new Persons(db);
		String logName = scanLastNameFor("LAST_NAME");
		 Person person = persons.getByLastName(logName);

		if ( person == null) {
			System.out.printf("Non existing User with LastName %s\n", logName);
		} else {
			System.out.println(logName);
		}

		printSeparator1();
		
		try {
			ResultSet resset = db.executeQuery("SELECT * FROM person");               
			while (resset.next()) {
				int personId = resset.getInt("Id");
				String firstName = resset.getString("first_name");
				String lastName = resset.getString("last_Name");
				String password = resset.getString("password");
				Date dateOfBirth = resset.getDate("date_Of_Birth");
				int adressId = resset.getInt("address_Id");
				String phone = resset.getString("phone_no");
				String genre = resset.getString("genre");
				System.out.println (new Person(personId, firstName, lastName, password, dateOfBirth, adressId, phone, genre));
			}
		 }
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
}
	
}

