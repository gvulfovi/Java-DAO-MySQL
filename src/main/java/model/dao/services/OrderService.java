package model.dao.services;

import model.dao.daofactory.DAOFactory;
import model.dao.entity.Order;
import model.dao.interfaces.DAOUserService;
import org.sql2o.Connection;

import java.sql.SQLException;

/**
 * Created by lonely on 21.06.16.
 */
public class OrderService extends AbstractService implements DAOUserService {
	public OrderService( DAOFactory daoFactory ) {
		super( daoFactory );
	}

	@Override
	public void makeOrder( Order order) {
		String sqlQuery = "INSERT INTO orders (user_id, drink_id, ing_id)\n" +
				" VALUES (:userId, :drinkId, :ingId)";
		try ( Connection connection = daoFactory.getDataBaseDriver().open() ) {
			connection.createQuery( sqlQuery, false )
					.addParameter( "userId", order.getUserId() )
					.addParameter( "drinkId", order.getDrinkId() )
					.addParameter( "ingId", order.getIngId() )
					.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
}