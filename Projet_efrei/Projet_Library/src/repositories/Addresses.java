package repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import abstracts.DAOImpl;
import models.Address;

public class Addresses extends DAOImpl<Address> {

	private static final Addresses instance = new Addresses();

	public static Addresses getInstance() {
		return instance;
	}

	public Addresses() {
		super("Address");
	}

	@Override
	protected Address fromResultSet(ResultSet set) throws SQLException {
		int id = set.getInt("id");
		String address = set.getString("address");
		String address2 = set.getString("address2");
		String district = set.getString("district");
		String city = set.getString("city");
		String postalCode = set.getString("postal_Code");
		String country = set.getString("country");
		return new Address(id, address, address2, district, city, postalCode, country);
	}

	@Override
	public boolean add(Address address) {
		String sql = String.format(
				"Insert into %s(address, address2, district, city, postal_Code, country) values(?,?,?,?,?,?)",
				tableName);
		try {
			PreparedStatement preparedStatement = this.DB_CONN.createPreparedStatement(sql);
			preparedStatement.setString(1, address.getAddress());
			preparedStatement.setString(2, address.getAddress2());
			preparedStatement.setString(3, address.getDistrict());
			preparedStatement.setString(4, address.getCity());
			preparedStatement.setString(5, address.getPostalCode());
			preparedStatement.setString(6, address.getCountry());
			preparedStatement.execute();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(int id, Address address) {
		String sql = String.format(
				"UPDATE %s SET Address=?, Address2=?, District=?, City=?, Postal_Code=?, Country=? ) Where Id = ?",
				tableName);
		try {
			PreparedStatement preparedStatement = this.DB_CONN.createPreparedStatement(sql);
			preparedStatement.setString(1, address.getAddress());
			preparedStatement.setString(2, address.getAddress2());
			preparedStatement.setString(3, address.getDistrict());
			preparedStatement.setString(4, address.getCity());
			preparedStatement.setString(5, address.getPostalCode());
			preparedStatement.setString(6, address.getCountry());
			preparedStatement.setInt(7, id);
			preparedStatement.execute();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

}
