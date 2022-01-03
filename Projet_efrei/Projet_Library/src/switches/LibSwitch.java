package switches;

import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import models.Book;
import models.Loan;
import models.Person;
import request.RequestAddress;
import request.RequestBook;
import request.RequestLoan;
import request.RequestPerson;
import request.RequestStaff;
import Projet.DbConnection;
import Projet.Login;

public class LibSwitch {

	public static void printSeparator1() { // Print Séparation 1
		System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

	public static void printSeparator2() { // Print Séparation 2
		System.out.printf("\n------------------------------------------------------------------------\n");
	}

	public void libSwitch() {

		DbConnection db = new DbConnection();
		db.initConnection();

		int liblog = 0;
		String searchBook;
		Scanner x = new Scanner(System.in);

		System.out.println("Entrez votre choix : \n");

		liblog = x.nextInt();
		switch (liblog) {

		case 1:
			System.out.println("Entrez le Titre, Auteur ou Genre que vous recherchez :\n");
			Scanner x1 = new Scanner(System.in);
			searchBook = x1.nextLine();

			try {
				ResultSet set = db.executeQuery("SELECT * FROM book WHERE Title LIKE '%" + searchBook
						+ "%' OR Author LIKE '%" + searchBook + "%' OR Genre LIKE '%" + searchBook + "%'");
				while (set.next()) {
					int id = set.getInt("id");
					String title = set.getString("title");
					String author = set.getString("author");
					String synopsis = set.getString("synopsis");
					String genre = set.getString("genre");
					int is_issued = set.getInt("is_issued");
					System.out.println(new Book(id, title, author, synopsis, genre, is_issued));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 2:
			Login logName = new Login();
			String logName1 = Login.getLogName();

			try {
				ResultSet set = db.executeQuery("SELECT * FROM person WHERE Last_Name = '" + logName1 + "'");
				while (set.next()) {
					int id = set.getInt("id");
					String first_name = set.getString("first_name");
					String last_Name = set.getString("last_Name");
					String password = set.getString("password");
					java.sql.Date date_Of_Birth = set.getDate("date_Of_Birth");
					int address_id = set.getInt("address_id");
					String phone_no = set.getString("phone_no");
					System.out.println(
							new Person(id, first_name, last_Name, password, date_Of_Birth, address_id, phone_no));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 3:
			Login logName2 = new Login();
			String getName = Login.getLogName();

			try {
				ResultSet set = db
						.executeQuery("SELECT * FROM loan WHERE EXISTS (SELECT id FROM person WHERE Last_Name = '"
								+ getName + "' AND loan.borrower_id = person.id)");
				while (set.next()) {
					int id = set.getInt("id");
					int borrower_id = set.getInt("borrower_id");
					int book_id = set.getInt("book_id");
					int issuer_id = set.getInt("issuer_id");
					Date issued_date = set.getDate("issued_date");
					int receiver_id = set.getInt("receiver_id");
					Date return_date = set.getDate("return_date");
					System.out.println(
							new Loan(id, borrower_id, book_id, issuer_id, issued_date, receiver_id, return_date));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 4:
			RequestBook findbook = new RequestBook();
			findbook.findBook();

			RequestLoan addloan = new RequestLoan();
			addloan.addLoan();

			RequestBook deleteissuedbook = new RequestBook();
			deleteissuedbook.updateBookIssued();

			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 5:
			System.out.println(" W.I.P :");
			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 6:

			RequestBook findbook2 = new RequestBook();
			findbook2.findBook();

			RequestLoan deleteloan = new RequestLoan();
			deleteloan.deleteLoan();

			RequestBook deleteissuedbook2 = new RequestBook();
			deleteissuedbook2.updateBookIssued();

			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 7:
			RequestAddress addaddress = new RequestAddress();
			addaddress.addAddress();

			RequestPerson addperson = new RequestPerson();
			addperson.addPerson();

			RequestStaff addborrow = new RequestStaff();
			addborrow.addBorrow();

			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 8:
			RequestPerson updateperson = new RequestPerson();
			updateperson.updatePerson();
			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 9:
			RequestBook addbook = new RequestBook();
			addbook.addBook();
			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		case 10:
			RequestBook delbook = new RequestBook();
			delbook.delBook();
			break;
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		case 11:
			RequestBook updatebook = new RequestBook();
			updatebook.updateBook();
			break;

		}
	}

}
