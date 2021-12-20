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

import Projet.abstracts.DAO;
import Projet.abstracts.DAOImpl;


public class Main {
	private static Scanner sc = new Scanner(System.in);
	

	public static void printSeparator1() {  //Print S�paration 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public static void printSeparator2() {  //Print S�paration 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}
	

		
	public static int scanIdFor(String entity) {  //Scan d'ID dans la base
		printSeparator2();
		System.out.printf("Search %s by Id:\n", entity);
		return sc.nextInt();
	}
	
	public static String scanLastNameFor(String logName) { //Scan de nom dans la base
		printSeparator2();
		System.out.printf("Chercher %s by LastName:\n", logName);
		return sc.nextLine();
	}

	
	
	public static void main(String[] args) {
		
		DbConnection db = new DbConnection();
		db.initConnection();
		
		printSeparator1();
		System.out.println("\n  ~ ~ ~ Bienvenue dans le Syst�me de Gestion de la Biblioth�que ~ ~ ~");
		printSeparator1();
		System.out.println("Veuillez choisir l'option � ex�cuter : \n\n");
		System.out.println(" 1- Login\n 2- Administration\n 3- EXIT\n");
		
		System.out.println("Entrez votre choix : ");
		
		Login login = new Login();  //Appel de la m�thod login
		login.login();
		
		
		
		
		
//		Repo_person persons = new Repo_person(db);
//		String logName = scanLastNameFor("LAST_NAME");
//		 Person person = persons.getByLastName(logName);
//
//		if ( person == null) {
//			System.out.printf("Non existing User with LastName %s\n", logName);
//		} else {
//			System.out.println("OUI");
//		}
//
//		printSeparator1();
		
//		try {
//			ResultSet resset = db.executeQuery("SELECT * FROM person");               
//			while (resset.next()) {
//				int personId = resset.getInt("Id");
//				String firstName = resset.getString("first_name");
//				String lastName = resset.getString("last_Name");
//				String password = resset.getString("password");
//				Date dateOfBirth = resset.getDate("date_Of_Birth");
//				int adressId = resset.getInt("address_Id");
//				String phone = resset.getString("phone_no");
//				String genre = resset.getString("genre");
//				System.out.println (new Person(personId, firstName, lastName, password, dateOfBirth, adressId, phone, genre));
//			}
//		 }
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
		
}
	
}

