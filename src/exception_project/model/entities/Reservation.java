package exception_project.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exception_project.model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn))
			throw new DomainException("Check-Out date must be after Check-In date");
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) 
			throw new DomainException("Reservation dates for Update Must be Future dates");
		if (!checkOut.after(checkIn))
			throw new DomainException("Check-Out date must be after Check-In date"); 
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString() {
		return  "Room " + 
				roomNumber + 
				", check-in: " +
				sdf.format(checkIn) +
				", check-out: " + 
				sdf.format(checkOut) + 
				", " + 
				duration() + 
				" nigths";
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
}