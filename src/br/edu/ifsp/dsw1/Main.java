package br.edu.ifsp.dsw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Marketing marketing = new Marketing();
		Purchasing purchasing = new Purchasing();
		List<Product> products = new ArrayList<Product>(3);
		int opcao;
		
		do {
			System.out.println("1. Novo produto");
			System.out.println("2. Vender produto");
			System.out.println("3. Comprar produto");
			System.out.println("0. Sair");
			System.out.print("Escolha: ");
			opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
				case 1:
					var p = insertProduct();
					p.attach(purchasing);
					p.attach(marketing);
					products.add(p);
					break;

				case 2:
					sell(products);
					break;
					
				case 3:
					buy(products);
					break;
			}
			
		} while (opcao != 0);
		scanner.close();
	}

	private static Product insertProduct() {
		System.out.println("Nome.......: ");
		var nome = scanner.nextLine();
		System.out.println("Quantidade.: ");
		var qtd = scanner.nextInt();
		System.out.println("Preço......: ");
		var preco = scanner.nextDouble();
		
		return new Product(nome, qtd, preco);
	}
	
	private static void sell(List<Product> products) {
		int id = 1, qtd;
		for (var p : products) {
			System.out.println(id + " - " + p.getName());
			id++;
		}
		System.out.println("ID do produto: ");
		id = scanner.nextInt();
		id--;
		System.out.println("Quantidade...: ");
		qtd = scanner.nextInt();
		
		if (id >= 0 && id < products.size()) {
			if (products.get(id).reduceStock(qtd)) {
				System.out.println("Venda realizada com sucesso.");
			} else {
				System.out.println("Quantidade indisponível para venda.");
			}
		} else {
			System.out.println("Produto não encontrado.");
		}
		
	}
	
	private static void buy(List<Product> products) {
		int id = 1, qtd;
		for (var p : products) {
			System.out.println(id + " - " + p.getName());
			id++;
		}
		System.out.println("ID do produto: ");
		id = scanner.nextInt();
		id--;
		System.out.println("Quantidade...: ");
		qtd = scanner.nextInt();
		
		if (id >= 0 && id < products.size()) {
			products.get(id).increaseStock(qtd);
			System.out.println("Compra realizada com sucesso.");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}
}
