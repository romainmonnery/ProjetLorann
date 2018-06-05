
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>The Class MapDAO.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public abstract class MapDAO extends AbstractDAO {

	//attribute corresponding to the SQL request in a String
	private static String procedure="{CALL GetMapbyId(?)};";

	/**
     * The getMapById method.
     *
     *Method which return the content of a field in the database in function of the ID given in parameters
     * @param final int id
     * @throws SQLException 
     * @return stringmap
     */
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
