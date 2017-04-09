package model.dao.interfaces;

import model.dao.entity.Drink;
import model.dao.entity.Ingredient;

import java.util.List;

/**
 * Created by lonely on 21.06.16.
 */
public interface DAOAbstractService {
	List<Drink> getDrinks( );

	List<Ingredient> getIngredients( );

}
