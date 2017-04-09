package model.dao.services;

import model.dao.daofactory.DAOFactory;
import model.dao.entity.Client;
import model.dao.entity.User;
import model.dao.interfaces.DAOAbtractUser;
import org.sql2o.Connection;

import java.sql.SQLException;

/**
 * Created by lonely on 21.06.16.
 */
public class UserService extends AbstractService implements DAOAbtractUser {
	public UserService( DAOFactory daoFactory ) {
		super( daoFactory );
	}

	public int register( User user ) {
		String sqlQuery = "INSERT INTO user (username, _hashpass, _salt)\n" +
				" VALUES (:uname, :pass, :salt)";
		int res = 0;
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			res = connection.createQuery( sqlQuery, false )
					.addParameter( "uname", user.getUserName( ) )
					.addParameter( "pass", user.getHashPassword() )
					.addParameter( "salt", user.getEncryptionSalt() )
					.executeUpdate().getResult();
		} catch ( SQLException e ) {
			e.printStackTrace();
			return res;
		}
		return res;
	}

	@Override
	public User getUserByUsername( String username ) {
		String sqlQuery = "SELECT id, username, _hashpass, _salt FROM user WHERE username = :name";
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			return (Client) connection.createQuery( sqlQuery, false )
					.addParameter( "name", username )
					.executeAndFetch( User.class );
		} catch ( SQLException e ) {
			e.printStackTrace();
			return null;
		}
	}

}
