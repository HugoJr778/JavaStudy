package price_tag_project.entities;

import java.util.Date;

public class UsedProduct extends Product {

	private Date manufactureDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String nameProduct, Double priceProduct, Date manufactureDate) {
		super(nameProduct, priceProduct);
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return getNameProduct() + " (Used) $ " + String.format("%.2f", getPriceProduct()) + " (Manufacture Date: " + manufactureDate + ")";
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
}