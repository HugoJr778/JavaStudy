package priceTag_project.entities;

public class Product {
		
	private String nameProduct;
	private Double priceProduct;
	
	public Product() {
	}

	public Product(String nameProduct, Double priceProduct) {
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
	}
	
	public String priceTag() {
		return getNameProduct() + " $ " + String.format("%.2f", getPriceProduct());
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}
}