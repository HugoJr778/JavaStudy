package withdraw_exception_project.application;

import java.util.Locale;
import java.util.Scanner;

import withdraw_exception_project.model.entities.Account;
import withdraw_exception_project.model.exception.DomainAccountException;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account Data ---");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		sc.next();
		System.out.print("Initial Balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, balance, withdrawLimit);
				
		try {
			System.out.print("\nEnter Amout for Withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));
		} catch (DomainAccountException e) {
			System.out.println("Withdraw Error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected Error: " + e.getMessage());
		}
		
		sc.close();
	}
}