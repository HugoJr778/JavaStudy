package exception_project.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exception_project.model.entities.Reservation;
import exception_project.model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-In Date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("RESERVATION: " + reservation);
			
			System.out.println("Enter Data to Update the Reservation: ");
			System.out.print("Check-In Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("RESERVATION: " + reservation);
			
		} catch (ParseException e) {
			System.out.println("Invalid Date Format: " + e.getMessage());
		} catch (DomainException e) {
			System.out.println("Error in Reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected Error: " + e.getMessage());
		}
		sc.close();
	}
}