package request;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;
import models.Address;
import models.Person;

public class RequestAddress {

	DbConnection db = new DbConnection();

	public void addAddress() {

		try {
			db.initConnection();

			Scanner x2 = new Scanner(System.in);

			String sql = ("INSERT INTO address (address, address2, district, city, postal_Code, country) values(?,?,?,?,?,?)");
			PreparedStatement ps = db.createPreparedStatement(sql);
			System.out.println("\nEntrez le numero de rue:");
			ps.setString(1, x2.nextLine());
			System.out.println("\nEntrez le nom de voie de l'adresse:");
			ps.setString(2, x2.nextLine());
			System.out.println("\nEntrez la Region:");
			ps.setString(3, x2.nextLine());
			System.out.println("\nEntrez la Ville:");
			ps.setString(4, x2.nextLine());
			System.out.println("\nEntrez le Code Postal:");
			ps.setString(5, x2.nextLine());
			System.out.println("\nEntrez le Pays:");
			ps.setString(6, x2.nextLine());
			ps.execute();
			// System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			ResultSet set = db.executeQuery("SELECT * FROM address");
			while (set.next()) {
				int id = set.getInt("id");
				String address = set.getString("address");
				String address2 = set.getString("address2");
				String district = set.getString("district");
				String city = set.getString("city");
				String postalCode = set.getString("postal_Code");
				String country = set.getString("country");
				System.out.println(new Address(id, address, address2, district, city, postalCode, country));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAddress() {

		db.initConnection();
		try {
			ResultSet set = db.executeQuery("SELECT * FROM address");
			while (set.next()) {
				int id = set.getInt("id");
				String address = set.getString("address");
				String address2 = set.getString("address2");
				String district = set.getString("district");
				String city = set.getString("city");
				String postalCode = set.getString("postal_Code");
				String country = set.getString("country");
				System.out.println(new Address(id, address, address2, district, city, postalCode, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			db.initConnection();
			Scanner x2 = new Scanner(System.in);

			String sql = ("UPDATE address SET Address=?, Address2=?, District=?, City=?, Postal_Code=?, Country=? WHERE Id = ?");
			PreparedStatement ps = db.createPreparedStatement(sql);
			System.out.println("\n\nEntrez le Numero de voie:");
			ps.setString(1, x2.nextLine());
			System.out.println("\nEntrez le nouveau Nom de voie:");
			ps.setString(2, x2.nextLine());
			System.out.println("\nEntrez la nouvelle Region :");
			ps.setString(3, x2.nextLine());
			System.out.println("\nEntrez la nouvelle Ville:");
			ps.setString(4, x2.nextLine());
			System.out.println("\nEntrez le nouveau Code postal:");
			ps.setString(5, x2.nextLine());
			System.out.println("\nEntrez le nouveau Pays:");
			ps.setString(6, x2.nextLine());
			System.out.println("\nEntrez l'iD de l'adresse à modifier:");
			ps.setInt(7, x2.nextInt());
			ps.execute();
			System.out.println("\nAdresse modifiée avec succès");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
