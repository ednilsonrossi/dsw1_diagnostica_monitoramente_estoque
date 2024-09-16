package br.edu.ifsp.dsw1;

import java.util.LinkedList;
import java.util.List;

public class Product implements ProductSubject {

	private String name;
	private int quantity;
	private double price;
	private List<ProductObserver> observers;

	private Product() {
		observers = new LinkedList<ProductObserver>();
	}

	public Product(String name, int quantity, double price) {
		this();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public void attach(ProductObserver observer) {
		if (observer != null) {
			observers.add(observer);
		}

	}

	@Override
	public void detach(ProductObserver observer) {
		if (observer != null) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for(var observer : observers) {
			observer.update(this);
		}
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

	public int getQuantity() {
		return quantity;
	}

	public boolean reduceStock(int quantity) {
		if (quantity >= 0 && this.quantity >= quantity) {
			this.quantity -= quantity;
			notifyObservers();
			return true;
		}

		return false;
	}

	public void increaseStock(int quantity) {
		if (quantity >= 0) {
			this.quantity += quantity;
			notifyObservers();
		}
	}

}
