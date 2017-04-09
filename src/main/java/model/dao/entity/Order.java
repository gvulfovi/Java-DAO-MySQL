package model.dao.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by lonely on 21.06.16.
 */
@Data
@RequiredArgsConstructor
public class Order {
	private int id;
	private int userId;
	private int drinkId;
	private int ingId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}

	public int getIngId() {
		return ingId;
	}

	public void setIngId(int ingId) {
		this.ingId = ingId;
	}
}
