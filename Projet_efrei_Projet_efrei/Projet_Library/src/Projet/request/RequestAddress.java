package Projet.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.DbConnection;
import Projet.models.Address;

public class RequestAddress {
	
	DbConnection db = new DbConnection();
	
	public void addAddress() {
	
	
		try {
		db.initConnection();	
		
		Scanner x2 = new Scanner(System.in);
	    
	    String sql = ("INSERT INTO address (address, address2, district, city, postal_Code, country) values(?,?,?,?,?,?)");
	    PreparedStatement ps = db.createPreparedStatement(sql);
	    System.out.println("\nEntrez le numero de rue de l'adresse:");
	    ps.setString(1, x2.nextLine());
	    System.out.println("\nEntrez le nom de la voie de l'adresse:");
	    ps.setString(2, x2.nextLine());
	    System.out.println("\nEntrez la region:");
	    ps.setString(3, x2.nextLine());
	    System.out.println("\nEntrez la ville:");
	    ps.setString(4, x2.nextLine());
	    System.out.println("\nEntrez le code postal:");
	    ps.setString(5, x2.nextLine());
	    System.out.println("\nEntrez le pays:");
	    ps.setString(6, x2.nextLine());
	    ps.execute();
	    //System.out.println();
	}
		catch (SQLException e)
		{
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
		 }
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
