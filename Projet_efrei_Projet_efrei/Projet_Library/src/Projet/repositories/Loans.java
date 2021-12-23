package Projet.repositories;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Projet.DbConnection;
import Projet.abstracts.DAOImpl;
import Projet.models.Loan;
import Projet.models.Person;


		public class Loans extends DAOImpl<Loan> {

			private static final Loans instance = new Loans();

			public static Loans getInstance() {
				return instance;
			}
			
				public Loans() {
					super("Loan");
				}

				@Override
				protected Loan fromResultSet(ResultSet set) throws SQLException {
					int id = set.getInt("loan_id");
					int borrower_id = set.getInt("borrower_id");
					int book_id = set.getInt("book_id");
					int issuer_id = set.getInt("issuer_id");
					Date issued_date = set.getDate("issued_date");
					int receiver_id = set.getInt("receiver_id");
					Date return_date = set.getDate("return_date");
					return new Loan(id, borrower_id, book_id, issuer_id, issued_date, receiver_id, return_date);
				}

				@Override
				public boolean add(Loan Loan) {
					String sql = String.format("Insert into %s(borrowerId, bookId, issuerId, issuedDate, receiverId, returnDate) values(?,?,?,?,?,?)", tableName);
					try {
						PreparedStatement preparedStatement = this.DB_CONN.createPreparedStatement(sql);
						preparedStatement.setInt(1, Loan.getBorrower_id());
						preparedStatement.setInt(2, Loan.getBook_id());
						preparedStatement.setInt(3, Loan.getIssuer_id());
						preparedStatement.setDate(4, Loan.getIssued_date());
						preparedStatement.setInt(5, Loan.getReceiver_id());
						preparedStatement.setDate(6, Loan.getReturn_date());
						preparedStatement.execute();
						return true;
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return false;
				}

				@Override
				public boolean update(int id, Loan Loan) {
					String sql = String.format("UPDATE %s SET Address=?, Address2=?, District=?, City=?) Where Id = ?", tableName);
					try {
						PreparedStatement preparedStatement = this.DB_CONN.createPreparedStatement(sql);
						preparedStatement.setInt(1, Loan.getBorrower_id());
						preparedStatement.setInt(2, Loan.getBook_id());
						preparedStatement.setInt(3, Loan.getIssuer_id());
						preparedStatement.setDate(4, Loan.getIssued_date());
						preparedStatement.setInt(5, Loan.getReceiver_id());
						preparedStatement.setDate(6, Loan.getReturn_date());
						preparedStatement.setInt(7, id);
						preparedStatement.execute();
						return true;
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return false;
				}

				@Override
				public boolean find(int id, Person person, String logName) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean find(int id, Loan e, String logName) {
					// TODO Auto-generated method stub
					return false;
				}

}
