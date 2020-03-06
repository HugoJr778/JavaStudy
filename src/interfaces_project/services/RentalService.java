package interfaces_project.services;

import interfaces_project.entities.CarRental;
import interfaces_project.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHour;
	private TaxService taxService;
	
	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		double hours = (double) (carRental.getFinish().getTime() - carRental.getStart().getTime()) / 1000 / 60 / 60;
		double basicPayment = (hours <= 12.0) ? Math.ceil(hours) * pricePerHour : Math.ceil(hours / 24) * pricePerDay;
		double tax = taxService.tax((hours <= 12.0) ? Math.ceil(hours) * pricePerHour : Math.ceil(hours / 24) * pricePerDay);
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}