package Projet.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Projet.DbConnection;
import Projet.abstracts.DAOImpl;
import Projet.models.Book;
import Projet.models.Person;
import Projet.repositories.Books;
	

	public class Books extends DAOImpl<Book> {
		
		private static final Books instance = new Books();

		public static Books getInstance() {
			return instance;
		}
		DbConnection db = new DbConnection();
		
		private Books() {
			super("Books");
		}

		@Override
		protected Book fromResultSet(ResultSet set) throws SQLException {
			int id = set.getInt("id");
			String title = set.getString("title");
			String author = set.getString("author");
			String synopsis = set.getString("synopsis");
			String genre = set.getString("genre");
			int is_issued = set.getInt("is_issued");
			return new Book(id, title, author, synopsis, genre, is_issued);
		}

		@Override
		public boolean add(Book book) {
			String sql = String.format("Insert into book(title, author, synopsis, genre, is_issued) values(?,?,?,?,?)");
			try {
				PreparedStatement preparedStatement = db.createPreparedStatement(sql);
				preparedStatement.setString(1, book.getTitle());
				preparedStatement.setString(2, book.getAuthor());
				preparedStatement.setString(3, book.getSynopsis());
				preparedStatement.setString(4, book.getGenre());
				preparedStatement.setInt(5, book.getIs_issued());
				preparedStatement.execute();
				return true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean update(int id, Book book) {
			String sql = String.format("UPDATE %s SET Title=?, Author=?, Synopsis=?, Genre=?, Is_issued=?) Where Id = ?", tableName);
			try {
				PreparedStatement preparedStatement = this.DB_CONN.createPreparedStatement(sql);
				preparedStatement.setString(1, book.getTitle());
				preparedStatement.setString(2, book.getAuthor());
				preparedStatement.setString(3, book.getSynopsis());
				preparedStatement.setString(4, book.getGenre());
				preparedStatement.setInt(5, book.getIs_issued());
				preparedStatement.setInt(6, id);
				preparedStatement.execute();
				return true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}

}
