package com.sample;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;





public class Reservation {
	
	private Cars car;
	private Client client;
	private String preferedCategory;
	private Date rentalDate;
	private Date returnDate;
	private boolean trunk;
	private boolean babySeat;
	private float expectedPrice;
	private int expectedDays;
	private List<Date> expectedHiredDays = new ArrayList <Date> ();
		
	

	public Reservation ( Client c , String cat , String rental , String ret , boolean trunk1, boolean seat) {
		
		this.car=null;
		this.client=c;
		if (cat==null) 
			this.preferedCategory="A";
		else this.preferedCategory=cat;
		SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		this.rentalDate=newDate.parse(rental);
		this.returnDate=newDate.parse(ret);
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}
		this.trunk=trunk1;
		this.babySeat=seat;
		
		long days= this.returnDate.getTime()-this.rentalDate.getTime();
		this.expectedDays=(int) (days/ (1000 * 60 * 60 * 24))+1;
		
		this.setExpectedHiredDays(getDaysBetweenDates(this.rentalDate,this.returnDate));
	}
	
	public static List<Date> getDaysBetweenDates(Date startdate, Date enddate)
	{	
		Date tomorrow = new Date(enddate.getTime() + (1000 * 60 * 60 * 24));
	    List<Date> dates = new ArrayList<Date>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(startdate);

	    while (calendar.getTime().before(tomorrow))
	    {
	        Date result = calendar.getTime();
	        dates.add(result);
	        calendar.add(Calendar.DATE, 1);
	    }
	    return dates;
	}
	public Cars getCar() {
		return this.car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPreferedCategory() {
		return preferedCategory;
	}

	public void setPreferedCategory(String preferedCategory) {
		this.preferedCategory = preferedCategory;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isTrunk() {
		return trunk;
	}

	public void setTrunk(boolean trunk) {
		this.trunk = trunk;
	}

	public boolean isBabySeat() {
		return babySeat;
	}

	public void setBabySeat(boolean babySeat) {
		this.babySeat = babySeat;
	}

	public float getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(float expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public int getExpectedDays() {
		return this.expectedDays;
	}

	public void setExpectedDays(int expectedDays) {
		this.expectedDays = expectedDays;
	}

	public List<Date> getExpectedHiredDays() {
		return expectedHiredDays;
	}

	public void setExpectedHiredDays(List<Date> expectedHiredDays) {
		this.expectedHiredDays = expectedHiredDays;
	}
	

}
