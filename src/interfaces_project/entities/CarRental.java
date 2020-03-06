package interfaces_project.entities;

import java.util.Date;

public class CarRental {
	
	private Date start;
	private Date finish;
	private Vehicle vahicle;
	private Invoice invoice;
	
	public CarRental() {}

	public CarRental(Date start, Date finish, Vehicle vahicle) {
		this.start = start;
		this.finish = finish;
		this.vahicle = vahicle;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Vehicle getVahicle() {
		return vahicle;
	}

	public void setVahicle(Vehicle vahicle) {
		this.vahicle = vahicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}