package Projet.repositories;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Projet.DbConnection;
import Projet.abstracts.DAOImpl;
import Projet.models.Person;

public class Persons extends DAOImpl<Person>{

	
	public Persons(DbConnection conn) {
			super(conn, "person");
		}

		
		@Override
		protected Person fromResultSet(ResultSet set) throws SQLException {
			int id = set.getInt("id");
			String first_name = set.getString("first_name");
			String last_Name = set.getString("last_Name");
			String password = set.getString("password");
			Date date_Of_Birth = set.getDate("date_Of_Birth");
			int address_Id = set.getInt("address_Id");
			String phone_no = set.getString("phone_no");
			String genre = set.getString("genre");
			return new Person(id, first_name, last_Name, password, date_Of_Birth, address_Id, phone_no, genre);
		}

		@Override
		public boolean add(Person person) {
			String sql = String.format("Insert into %s(Name, LastName, Password, DateOfBirth, AdressId, Phone, Genre) values(?,?,?,?,?,?,?)", tableName);
			try {
				PreparedStatement preparedStatement = this.conn.createPreparedStatement(sql);
				preparedStatement.setString(1, person.getName());
				preparedStatement.setString(2, person.getLastName());
				preparedStatement.setString(3, person.getPassword());
				preparedStatement.setDate(4, person.getDateOfBirth());
				preparedStatement.setInt(5, person.getAdressId());
				preparedStatement.setString(6, person.getPhone());
				preparedStatement.setString(7, person.getGenre());
				preparedStatement.execute();
				return true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean update(int id, Person person) {
			String sql = String.format("UPDATE %s SET Name = ?, LastName = ? Where Id = ?", tableName);
			try {
				PreparedStatement preparedStatement = this.conn.createPreparedStatement(sql);
				preparedStatement.setString(1, person.getName());
				preparedStatement.setString(2, person.getLastName());
				preparedStatement.setString(3, person.getPassword());
				preparedStatement.setDate(4, person.getDateOfBirth());
				preparedStatement.setInt(5, person.getAdressId());
				preparedStatement.setString(6, person.getPhone());
				preparedStatement.setString(7, person.getGenre());
				preparedStatement.setInt(3, id);
				preparedStatement.execute();
				return true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		
	}


		@Override
		public boolean find(int id, Person person, String logName) {
			String sql = String.format("SELECT * FROM person WHERE LAST_NAME LIKE '%s'", logName);
		try {
			PreparedStatement preparedStatement = this.conn.createPreparedStatement(sql);
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setString(3, person.getPassword());
			preparedStatement.setDate(4, person.getDateOfBirth());
			preparedStatement.setInt(5, person.getAdressId());
			preparedStatement.setString(6, person.getPhone());
			preparedStatement.setString(7, person.getGenre());
			preparedStatement.setInt(3, id);
			preparedStatement.execute();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;              
			
		}
}

