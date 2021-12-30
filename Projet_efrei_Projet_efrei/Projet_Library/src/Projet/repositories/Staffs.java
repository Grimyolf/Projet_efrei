package Projet.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Projet.DbConnection;
import Projet.abstracts.DAOImpl;
import Projet.models.Person;
import Projet.models.Staff;

public class Staffs extends DAOImpl<Staff> {
	
	private static final Staffs instance = new Staffs();

	public static Staffs getInstance() {
		return instance;
	}
		
		public Staffs () 
		{
			super("Staff");
		}

					@Override
					protected Staff fromResultSet(ResultSet set) throws SQLException {
						int id = set.getInt("id");
						String type = set.getString("type");
						Double salary = set.getDouble("salary");
						int desk_no = set.getInt("desk_no");
						int office_no = set.getInt("office_no");
						
						return new Staff(id, type, salary, desk_no, office_no);
					}

					@Override
					public boolean add(Staff Staff) {
						String sql = String.format("INSERT INTO staff(type, salary, desk_no, office_no) values(?,?,?,?)");
						try {
							PreparedStatement preparedStatement = this.DB_CONN.createPreparedStatement(sql);
							preparedStatement.setString(1, Staff.getType());
							preparedStatement.setDouble(2, Staff.getSalary());
							preparedStatement.setInt(3, Staff.getDesk_no());
							preparedStatement.setInt(4, Staff.getOffice_no());
							preparedStatement.execute();
							return true;
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						return false;
					}

					@Override
					public boolean update(int id, Staff Staff) {
						String sql = String.format("UPDATE %s SET Address=?, Address2=?, District=?, City=?) Where Id = ?", tableName);
						try {
							PreparedStatement preparedStatement = this.DB_CONN.createPreparedStatement(sql);
							preparedStatement.setString(1, Staff.getType());
							preparedStatement.setDouble(2, Staff.getSalary());
							preparedStatement.setInt(3, Staff.getDesk_no());
							preparedStatement.setInt(4, Staff.getOffice_no());
							preparedStatement.setInt(5, id);
							preparedStatement.execute();
							return true;
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						return false;
					}

}

