package generics.application;

import java.util.Scanner;

import generics.services.PrintService;

public class Program {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PrintService<Integer> ps = new PrintService<>();
		
		System.out.print("How many values ? ");
		int n = sc.nextInt();
		
		for (int index = 0; index < n; index++) {
			int value = sc.nextInt();
			ps.addValue(value);
		}
		
		ps.print();
		System.out.println("First: " + ps.first());
		
		sc.close();
	}
}