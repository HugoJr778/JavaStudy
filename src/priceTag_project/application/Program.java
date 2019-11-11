package priceTag_project.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import priceTag_project.entities.ImportedProduct;
import priceTag_project.entities.Product;
import priceTag_project.entities.UsedProduct;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> listProducts = new ArrayList<>();
		
		System.out.print("Enter the Number of Products: ");
		int quantProducts = sc.nextInt();
		
		for(int i = 1; i <= quantProducts; i++) {
			System.out.println("Product #" + i + " Data --- ");
			System.out.print("Common, Used or Imported (c/u/i) ? ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Name: ");
			String nameProduct = sc.next();
			System.out.print("Price: ");
			double priceProduct = sc.nextDouble();
			
			if(typeProduct == 'i' || typeProduct == 'I') {
				System.out.print("Customs Fee: ");
				double customsFee = sc.nextDouble();
				listProducts.add(new ImportedProduct(nameProduct, priceProduct, customsFee));
			} else if(typeProduct == 'u' || typeProduct == 'U') {
				System.out.print("Mnufacture Date (DD/MM/YYYY): ");
				String dateManufacture = sc.next();
				listProducts.add(new UsedProduct(nameProduct, priceProduct, sdf.parse(dateManufacture)));
			} else {
				listProducts.add(new Product(nameProduct, priceProduct));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS --- ");
		for(Product pdtc : listProducts) {
			System.out.println(pdtc.priceTag());
		}
		
		sc.close();
	}
}