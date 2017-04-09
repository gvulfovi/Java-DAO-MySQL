package model.dao.services;

import model.dao.daofactory.DAOFactory;
import model.dao.entity.Admin;
import model.dao.entity.Drink;
import model.dao.entity.Ingredient;
import model.dao.entity.User;
import model.dao.interfaces.DAOAbtractUser;
import model.dao.interfaces.DAOAdminService;
import org.sql2o.Connection;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lonely on 21.06.16.
 */
public class AdminService extends AbstractService implements DAOAdminService, DAOAbtractUser {
	public AdminService( DAOFactory daoFactory ) {
		super( daoFactory );
	}

	public void addDrink( Drink drink ) {
		String sqlQuery = "INSERT INTO drink (name, price)\n" +
				" VALUES ( :name, :price )";
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			connection.createQuery( sqlQuery, true )
					.addParameter( "name", drink.getName() )
					.addParameter( "price", drink.getPrice() )
					.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	public void addDrinks( List<Drink> drinkList ) {
		String sqlQuery = "INSERT INTO drink (name, price)\n" +
				" VALUES ( :name, :price)";
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			for ( Drink drink : drinkList ) {
				connection.createQuery( sqlQuery, false )
						.addParameter( "name", drink.getName() )
						.addParameter( "price", drink.getPrice() )
						.executeUpdate();
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	public void addIngredient( Ingredient ingredient ) {
		String sqlQuery = "INSERT INTO ingredient ( name, price )\n" +
				" VALUES ( :name, :price )";
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			connection.createQuery( sqlQuery, false )
					.addParameter( "name", ingredient.getName() )
					.addParameter( "price", ingredient.getPrice() )
					.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	public void addIngredients( List<Ingredient> ingredientList ) {
		String sqlQuery = "INSERT INTO ingredient ( name, price )\n" +
				" VALUES ( :name, :price )";
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {

			for ( Ingredient ingredient : ingredientList ) {
				connection.createQuery( sqlQuery, false )
						.addParameter( "name", ingredient.getName() )
						.addParameter( "pass", ingredient.getPrice() )
						.executeUpdate();
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	public int register( User user ) {
		String sqlQuery = "INSERT INTO admin (username, _hashpass, _salt)\n" +
				" VALUES (:uname, :pass, :salt)";
		int res = 0;
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			res = connection.createQuery( sqlQuery, false )
					.addParameter( "uname", user.getUserName() )
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
		String sqlQuery = "SELECT id, username, _hashpass, _salt FROM admin WHERE username = :name";
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			return (Admin) connection.createQuery( sqlQuery, false )
					.addParameter( "name", username )
					.executeAndFetch( User.class );
		} catch ( SQLException e ) {
			e.printStackTrace();
			return null;
		}
	}

}
