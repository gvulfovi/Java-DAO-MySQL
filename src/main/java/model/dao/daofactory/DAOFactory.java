package model.dao.daofactory;

import model.dao.services.AdminService;
import model.dao.services.OrderService;
import model.dao.services.UserService;
import org.sql2o.Sql2o;

import java.sql.SQLException;

/**
 * Created by lonely on 21.06.16.
 */
public abstract class DAOFactory {

	public static DAOFactory getDAOFactory( ) {
		return DataSourceFactory.getInstance();
	}

	public abstract Sql2o getDataBaseDriver() throws SQLException;

	public abstract UserService getUserDAO( );

	public abstract AdminService getAdminDAO( );

	public abstract OrderService getOrderDAO( );

}
