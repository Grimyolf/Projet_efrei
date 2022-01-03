package request;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;

public class RequestStaff {

	DbConnection db = new DbConnection();

	public void addStaff() {

		try {
			db.initConnection();

			Scanner x2 = new Scanner(System.in);

			String sql = ("INSERT INTO staff(id, type, salary, desk_no, office_no) values(?,?,?,?,?)");
			PreparedStatement ps = db.createPreparedStatement(sql);
			System.out.println("\nEntrez l'id personne du nouveau collaborateur:");
			ps.setString(1, x2.nextLine());
			System.out.println("\nEntrez le statut du collaborateur (CLERK ou LIBRARIAN ou ADMIN):");
			ps.setString(2, x2.nextLine());
			System.out.println("\nEntrez le salaire:");
			ps.setString(3, x2.nextLine());
			System.out.println("\nEntrez le numero de poste:");
			ps.setString(4, x2.nextLine());
			System.out.println("\nEntrez le numero de bureau:");
			ps.setString(5, x2.nextLine());
			ps.execute();
			// System.out.println("");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addBorrow() {

		try {
			db.initConnection();

			Scanner x2 = new Scanner(System.in);

			String sql = ("INSERT INTO borrower (id) values(?)");
			PreparedStatement ps = db.createPreparedStatement(sql);
			System.out.println("\nEntrez l'id (Personne) du nouveau Borrower:");
			ps.setString(1, x2.nextLine());
			ps.execute();
			System.out.println("~ ~ ~ Borrower ajouté avec succès uwU ~ ~ ~");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
