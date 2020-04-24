package generics_delimited.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import generics_delimited.entities.Product;
import generics_delimited.services.CalculationService;

public class Program {
	
	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		String path = "file_folders_example\\in.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			System.out.println("Most Expensive: " + CalculationService.max(list));
		} catch (IOException e) {
			System.out.println(e.getMessage() + e);
		}
		
	}
}