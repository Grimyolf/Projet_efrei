package Projet;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import Projet.Main;
import Projet.models.Person;
import Projet.abstracts.DAOImpl;
import Projet.abstracts.DAO;
import Projet.DbConnection;

public class Login {
	
	 public boolean login(Person person) {             //Connection à un profile Borrower/Clerk/Librarian
		
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
				String PWD = x2.next();
				
				DbConnection db = new DbConnection();
				db.initConnection();
		
				try {
					
					String sql = String.format("Insert into %s(Name, LastName, Password, DateOfBirth, AdressId, Phone, Genre) values(?,?,?,?,?,?,?)", tableName);
					
						PreparedStatement preparedStatement = this.conn.createPreparedStatement(sql);
						preparedStatement.setString(2, person.getLastName());
						preparedStatement.setString(3, person.getPassword());
						
						
					
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			break;
			case 2:
				System.out.println("admin");
			break;
			case 3:
				System.out.println("exit");
				break;
			default:
				System.out.println("exit");
		}
		return false;

}
	}
