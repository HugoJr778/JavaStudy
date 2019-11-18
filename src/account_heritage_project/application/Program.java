package account_heritage_project.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import account_heritage_project.entities.Account;
import account_heritage_project.entities.BusinessAccount;
import account_heritage_project.entities.SavingsAccount;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Account> list = new ArrayList<>();
		list.add(new SavingsAccount(1001, "Alex", 500.0, 0.01));
		list.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0));
		list.add(new SavingsAccount(1003, "Bob", 300.0, 0.01));
		list.add(new BusinessAccount(1005, "Ana", 500.0, 500.0));
		
		double sum = 0.0;
		for (Account account : list) {
			sum += account.getBalance();
		}
		System.out.printf("Total Balance: %.2f%n", sum);
		
		for (Account account : list) {
			account.deposit(10.0);
		}
		
		for (Account account : list) {
			System.out.printf("Update Balance for Account %d: %.2f%n", account.getNumber() ,account.getBalance());
		}
		
	}
}