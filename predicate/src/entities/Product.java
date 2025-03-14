package entities;

public class Product {

	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// testa o atributo atribuido como parametro
	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100.00;
	}
	
	// testa o atributo da propria classe
	public boolean nonStaticProductPredicate() {
		return price >= 100.00;
	}

	@Override
	public String toString() {
		return getName() + ", " + String.format("%.2f", getPrice());
	}
	
}
