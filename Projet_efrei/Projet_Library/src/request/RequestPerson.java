package request;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;
import models.Address;
import models.Book;
import models.Person;

public class RequestPerson {

	DbConnection db = new DbConnection();

	public void addPerson() {

		try {
			db.initConnection();

			Scanner x2 = new Scanner(System.in);

			String sql = ("Insert into person (First_Name, Last_Name, Password, Date_Of_Birth, Address_Id, Phone_no) values(?,?,?,?,?,?)");
			PreparedStatement ps = db.createPreparedStatement(sql);
			System.out.println("\nEntrez le Nom de famille:");
			ps.setString(1, x2.nextLine());
			System.out.println("\nEntrez le prénom:");
			ps.setString(2, x2.nextLine());
			System.out.println("\nEntrez le mot de passe par défaut:");
			ps.setString(3, x2.nextLine());
			System.out.println("\nEntrez la date de naissance (format: AAAA-MM-DD ):");
			ps.setString(4, x2.nextLine());
			System.out.println("\nEntrez l'id de l'adresse correspondant à ce profil:");
			ps.setString(5, x2.nextLine());
			System.out.println("\nEntrez le numero de telephone:");
			ps.setString(6, x2.nextLine());
			ps.execute();
			// System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ResultSet set = db.executeQuery("SELECT * FROM person");
			while (set.next()) {
				int id = set.getInt("id");
				String first_name = set.getString("first_name");
				String last_Name = set.getString("last_Name");
				String password = set.getString("password");
				Date date_Of_Birth = set.getDate("date_Of_Birth");
				int address_Id = set.getInt("address_Id");
				String phone_no = set.getString("phone_no");
				System.out
						.println(new Person(id, first_name, last_Name, password, date_Of_Birth, address_Id, phone_no));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePerson() {

		db.initConnection();
		try {
			ResultSet set = db.executeQuery("SELECT * FROM person");
			while (set.next()) {
				int id = set.getInt("id");
				String first_name = set.getString("first_name");
				String last_Name = set.getString("last_Name");
				String password = set.getString("password");
				Date date_Of_Birth = set.getDate("date_Of_Birth");
				int address_Id = set.getInt("address_Id");
				String phone_no = set.getString("phone_no");
				System.out
						.println(new Person(id, first_name, last_Name, password, date_Of_Birth, address_Id, phone_no));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestAddress updateaddress = new RequestAddress();
		updateaddress.updateAddress();

		try {
			db.initConnection();
			Scanner x2 = new Scanner(System.in);

			String sql = ("UPDATE person SET first_Name=?, Last_Name=?, password=?, Phone_no=? WHERE Id = ?");
			PreparedStatement ps = db.createPreparedStatement(sql);
			System.out.println("\n\nEntrez le nouveau Prénom de la personne:");
			ps.setString(1, x2.nextLine());
			System.out.println("\nEntrez le nouveau Nom de famille:");
			ps.setString(2, x2.nextLine());
			System.out.println("\nEntrez le nouveau mot de passe:");
			ps.setString(3, x2.nextLine());
			System.out.println("\nEntrez le nouveau numero de telephone:");
			ps.setString(4, x2.nextLine());
			System.out.println("\nEntrez l'iD de la personne à modifier:");
			ps.setInt(5, x2.nextInt());
			ps.execute();
			System.out.println("\nProfil modifié avec succès");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}