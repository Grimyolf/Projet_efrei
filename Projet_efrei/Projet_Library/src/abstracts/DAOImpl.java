package abstracts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Projet.Main;
import models.Person;
import abstracts.DAO;
import abstracts.DAOImpl;
import Projet.DbConnection;

public abstract class DAOImpl<TEntity> implements DAO<TEntity> {
	protected static DbConnection DB_CONN;
	protected final String tableName;

	public DAOImpl(String tableName) {
		this.tableName = tableName;
	}

	public static void setDbConnection(DbConnection conn) {
		DAOImpl.DB_CONN = conn;
	}

	protected abstract TEntity fromResultSet(ResultSet set) throws SQLException;

	public abstract boolean add(TEntity e);

	public abstract boolean update(int id, TEntity e);

	@Override
	public TEntity getById(int id) {
		try {
			ResultSet resultset = DB_CONN.executeQuery(String.format("SELECT * FROM %s WHERE ID = %d", tableName, id));
			if (resultset.next()) {
				return fromResultSet(resultset);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<TEntity> list() {
		ArrayList<TEntity> result = new ArrayList<>();

		try {
			ResultSet resultset = DB_CONN.executeQuery(String.format("SELECT * FROM %s", tableName));
			while (resultset.next()) {
				result.add(this.fromResultSet(resultset));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean remove(int id) {
		String sql = String.format("DELETE FROM %s WHERE Id=?;", tableName);
		try {
			PreparedStatement preparedStatement = DB_CONN.createPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
