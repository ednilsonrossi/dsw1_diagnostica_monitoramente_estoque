package br.edu.ifsp.dsw1;

public class Purchasing implements ProductObserver {

	@Override
	public void update(Product product) {
		if (product.getQuantity() < 10) {
			product.increaseStock(100);
			System.out.println("Compra do produto " + product.getName() + " de 100 unidades.");
		}
	}

}
