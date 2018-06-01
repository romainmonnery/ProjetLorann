package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class MapDAO extends AbstractDAO {

	
	private static String procedure="{CALL GetMapbyId(?)};";

	public static String getMapById(final int id) throws SQLException {

		final CallableStatement callStatement = prepareCall(procedure);
		String stringmap = null;
		callStatement.setInt(1, id);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				stringmap = result.getString(1);
			}
			result.close();
		}
		return stringmap;
	}
}
	

