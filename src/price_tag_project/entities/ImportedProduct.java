package price_tag_project.entities;

public class ImportedProduct extends Product {
	
	private Double customsFee;

	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String nameProduct, Double priceProduct, Double customsFee) {
		super(nameProduct, priceProduct);
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return getNameProduct() + " $ " + String.format("%.2f", totalPrice()) + " (Customs Fee: $ " + getCustomsFree() + ")";
	}
	
	public double totalPrice() {
		return getPriceProduct() + customsFee;
	}

	public Double getCustomsFree() {
		return customsFee;
	}

	public void setCustomsFree(Double customsFree) {
		this.customsFee = customsFree;
	}
}