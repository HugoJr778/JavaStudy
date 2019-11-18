package arithmetic_forms_project.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import arithmetic_forms_project.entities.Circle;
import arithmetic_forms_project.entities.Rectangle;
import arithmetic_forms_project.entities.Shape;
import arithmetic_forms_project.entities.enums.Color;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Shape> list = new ArrayList<>();
		
		System.out.print("Enter the Number of Shapes: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Shape #" + i + " Data ---");
			System.out.print("Rectangle or Circle (r/c) ? ");
			char ch = sc.next().charAt(0);
			System.out.println("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			
			if(ch == 'r' || ch == 'R') {
				System.out.println("Width: ");
				double width = sc.nextDouble();
				System.out.println("Heigth: ");
				double heigth = sc.nextDouble();
				list.add(new Rectangle(color, width, heigth));
			} else {
				System.out.println("Radius: ");
				double radius = sc.nextDouble();
				list.add(new Circle(color, radius));
			}
		}
		
		System.out.println("\nSHAPE AREAS --- ");
		for (Shape shape : list) {
			System.out.println(String.format("%.2f", shape.area()));
		}
		
		sc.close();
	}
}