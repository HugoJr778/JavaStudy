package requestproject.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import requestproject.entities.Client;
import requestproject.entities.Order;
import requestproject.entities.OrderItem;
import requestproject.entities.Product;
import requestproject.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter Client Data --- ");
		
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.next();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		
		System.out.println("Enter Order Data --- ");
		
		System.out.print("Status: ");
		String orderStatus = sc.next();
		System.out.print("How Many Items to this Order ? ");
		int n = sc.nextInt();
		
		Order order = new Order(date, OrderStatus.valueOf(orderStatus), new Client(nameClient, emailClient, date));
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " Item Data: ");
			System.out.print("Product Name: ");
			String nameProduct = sc.next();
			System.out.print("Product Price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			order.addOrderItem(new OrderItem(quantity, priceProduct, new Product(nameProduct, priceProduct)));
		}
		
		System.out.println("ORDER SUMMARY --- ");
		System.out.println("Order Moment: " + sdf2.format(new Date()));
		System.out.println("Client: " + order.getClient().getName() + " - " + order.getClient().getEmail());
		System.out.println("ORDER ITEMS ---");
		
		for(int posi = 0; posi < n; posi++) {
			System.out.println(order.getIndexOrderItem(posi).getProduct().getName() +
					", $" +  String.format("%.2f", order.getIndexOrderItem(posi).getPrice()) +
					", Quantity: " + order.getIndexOrderItem(posi).getQuantity() + 
					", Subtotal: " +  String.format("%.2f", order.getIndexOrderItem(posi).subTotal()));
		}
		System.out.println("Total Price: " +  String.format("%.2f", order.totalPrice()));
		sc.close();
	}
}