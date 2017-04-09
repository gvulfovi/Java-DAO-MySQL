package model.dao.entity;

import lombok.Data;

/**
 * Created by lonely on 21.06.16.
 */
@Data
public class Drink {
	private int id;
	private String name;
	private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


