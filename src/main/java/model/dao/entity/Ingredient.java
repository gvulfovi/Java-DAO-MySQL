package model.dao.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by lonely on 21.06.16.
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
	private int id;
	private String name;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
