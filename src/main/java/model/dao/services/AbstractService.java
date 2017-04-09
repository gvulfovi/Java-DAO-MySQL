package model.dao.services;

import model.dao.daofactory.DAOFactory;
import model.dao.entity.Drink;
import model.dao.entity.Ingredient;
import model.dao.interfaces.DAOAbstractService;
import org.sql2o.Connection;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lonely on 21.06.16.
 */
public class AbstractService implements DAOAbstractService {
	protected DAOFactory daoFactory;

	public AbstractService( DAOFactory daoFactory ){
		this.daoFactory = daoFactory;
	}

	public List<Drink> getDrinks( ) {
		String sqlQuery = "select * from drink";

		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			return connection.createQuery( sqlQuery, false )
					.executeAndFetch( Drink.class );
		} catch ( SQLException e ) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Ingredient> getIngredients( ) {
		String sqlQuery = "select * from ingredient";

		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			return connection.createQuery( sqlQuery, false )
					.executeAndFetch( Ingredient.class );
		} catch ( SQLException e ) {
			e.printStackTrace();
			return null;
		}
	}
}
