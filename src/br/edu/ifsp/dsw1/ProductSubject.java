package br.edu.ifsp.dsw1;

public interface ProductSubject {

	void attach(ProductObserver observer);
	
	void detach(ProductObserver observer);
	
	void notifyObservers();

}
