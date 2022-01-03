package Projet;

import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void printSeparator1() { // Print S�paration 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

	public static void printSeparator2() { // Print S�paration 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}

	public static int scanIdFor(String entity) {
		printSeparator2();
		System.out.printf("Search %s by Id:\n", entity);
		return sc.nextInt();
	}

	public static void main(String[] args) {

		DbConnection db = new DbConnection();
		db.initConnection();

		printSeparator1();
		System.out.println("\n  ~ ~ ~ Bienvenue dans le Syst�me de Gestion de la Biblioth�que ~ ~ ~");
		printSeparator1();
		System.out.println("Veuillez choisir l'option a executer : \n\n");
		System.out.println(" 1- Login\n 2- Administration\n 3- EXIT\n");

		System.out.println("Entrez votre choix : ");

		Login login = new Login(); // Appel de la m�thod login
		login.login();

	}

}
