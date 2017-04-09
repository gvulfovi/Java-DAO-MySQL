import model.dao.daofactory.DAOFactory;
import model.dao.entity.Admin;
import model.dao.entity.Drink;
import model.dao.entity.Ingredient;
import model.dao.entity.User;
import model.dao.services.AdminService;
import model.dao.services.OrderService;
import model.dao.services.UserService;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

/**
 * Created by lonely on 24.06.16.
 */
public class TestService {

	// Instantiation of adminService, orderService, userService
	AdminService adminService = DAOFactory.getDAOFactory().getAdminDAO();
	OrderService orderService = DAOFactory.getDAOFactory().getOrderDAO();
	UserService userService = DAOFactory.getDAOFactory().getUserDAO();

	@Test
	public void testSaveRecord( ) throws Exception {
		Drink drink = new Drink();
		drink.setName( "Coffee" );
		drink.setPrice( 34.50 );
		adminService.addDrink( drink );
	}

	@Test
	public void testReadQuery( ) throws Exception {
		List<Drink> drinkList = adminService.getDrinks();
		for ( Drink drink : drinkList ) {
			System.out.print( drink.getId() + "\n" + drink.getName() + "\n\n" );
		}
	}

	@Test
	public void testSave1Query( ) throws Exception {
		Ingredient ingredient = new Ingredient();
		ingredient.setName( "Sugar" );
		ingredient.setPrice( 34.50 );
		adminService.addIngredient( ingredient );
	}

	@Test
	public void testRead2Query( ) throws Exception {
		List<Ingredient> ingredients = userService.getIngredients();
		for ( Ingredient ingredient : ingredients ) {
			System.out.print( ingredient.getId() + "\n" + ingredient.getName() + "\n\n" );
		}
	}
	@Test
	public void testRegister() throws Exception {
		User user = new Admin();
		String salt = BCrypt.gensalt();
		user.setUserName( "Vova" );
		user.setEncryptionSalt( salt );
		user.setHashPassword( BCrypt.hashpw( "password", salt ) );
		adminService.register( user );

		User user1 = new Admin();
		String salt1 = BCrypt.gensalt();
		user1.setUserName( "Vova" );
		user1.setEncryptionSalt( salt1 );
		user1.setHashPassword( BCrypt.hashpw( "password", salt1 ) );

		userService.register( user1 );
	}
}
