package br.edu.ifsp.dsw1;

public class Marketing implements ProductObserver {

	@Override
	public void update(Product product) {
		readjust(product);
	}

	private void readjust(Product product) {
		if (product.getQuantity() > 100) {
			product.setPrice(product.getPrice() * 0.9);
			System.out.println("PROMOÇÃO");
			System.out.println(product.getName() + "R$ " + product.getPrice());
		} else if (product.getQuantity() < 50) {
			product.setPrice(product.getPrice() * 1.18);
			System.out.println("Reajuste do " + product.getName() + " para R$ " + product.getPrice());
		}
	}
}
