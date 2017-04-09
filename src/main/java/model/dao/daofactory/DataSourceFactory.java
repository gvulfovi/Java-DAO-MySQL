package model.dao.daofactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import model.dao.services.AdminService;
import model.dao.services.OrderService;
import model.dao.services.UserService;
import org.sql2o.Sql2o;

import java.sql.SQLException;

/**
 * Created by lonely on 21.06.16.
 */
public class DataSourceFactory extends DAOFactory{
	private  static DataSourceFactory ds;

	private static Sql2o dataSourceSQL2O = null;

	private DataSourceFactory( ) {

	}

	public static DataSourceFactory getInstance( ) {
		return ds = ( ds == null ) ? new DataSourceFactory() : ds;
	}


	public Sql2o getDataBaseDriver( ) throws SQLException {
		HikariConfig config = new HikariConfig(  );
		// SQLLite connection setup
		/*config.setPoolName("SQLiteConnectionPool");
		//config.setDriverClassName("org.sqlite.JDBC");
		//config.setDataSourceClassName("org.sqlite.JDBC");
		//config.setDataSourceClassName("org.sqlite.SQLiteDataSource");
		config.setJdbcUrl("jdbc:sqlite:C:\\Users\\Gabriel\\Documents\\Dropbox\\Programming\\Curso Mobile\\Tema 03 - Base de Datos\\JavaAccess.db");
		config.setConnectionTestQuery("SELECT 1");
		config.setMaxLifetime(60000); // 60 Sec
		config.setIdleTimeout(45000); // 45 Sec
		config.setMaximumPoolSize(50); // 50 Connections (including idle connections)
		*/

		// MySql connection setup
		config.setDataSourceClassName( "com.mysql.jdbc.jdbc2.optional.MysqlDataSource" );
		config.addDataSourceProperty("serverName","127.0.0.1");
		config.addDataSourceProperty("port", 3306);
		config.addDataSourceProperty("databaseName", "starenky");
		config.addDataSourceProperty("user", "root");
		config.addDataSourceProperty("password", "root");
		config.setMaximumPoolSize( 5 );
		
		HikariDataSource dataSource = new HikariDataSource( config );

		return dataSourceSQL2O = (dataSourceSQL2O == null) ? new Sql2o( dataSource ) : dataSourceSQL2O;
	}

	public UserService getUserDAO( ) {
		return new UserService(this);
	}

	public AdminService getAdminDAO( ) {
		return new AdminService(this);
	}

	@Override
	public OrderService getOrderDAO( ) {
		return new OrderService( this );
	}
}
