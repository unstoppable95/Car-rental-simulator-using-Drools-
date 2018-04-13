package com.sample;

import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Returns {

	private int realAdditionalDays;
	private int distanceInKilometres;
	private int lostCaps;
	private boolean lostInsurance;
	private boolean lostRegistrationDocument;
	private float additionalPrice;
	private Reservation reservation;
	private List<Date> additionalCarDays = new ArrayList <Date> ();
	
	public Returns (Reservation x, String retDate, int dist , int lostC , boolean lostI , boolean lostReg )
	{
		this.reservation=x;
		//this.realReturnDate=retDate;
		SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			long differenceDays=newDate.parse(retDate).getTime()- x.getReturnDate().getTime() ;
			this.realAdditionalDays=(int) (differenceDays/ (1000 * 60 * 60 * 24));
			this.setAdditionalCarDays(getDaysBetweenDates(x.getReturnDate(),newDate.parse(retDate)));
			}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		this.distanceInKilometres=dist;
		this.lostCaps=lostC;
		this.lostInsurance=lostI;
		this.lostRegistrationDocument=lostReg;
		this.additionalPrice=0;
	
		}
	
	public static List<Date> getDaysBetweenDates(Date startdate, Date enddate)
	{	
		Date tomorrow = new Date(enddate.getTime() + (1000 * 60 * 60 * 24));
		Date tomorrow1 = new Date(startdate.getTime() + (1000 * 60 * 60 * 24));
	    List<Date> dates = new ArrayList<Date>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(tomorrow1);

	    while (calendar.getTime().before(tomorrow))
	    {
	        Date result = calendar.getTime();
	        dates.add(result);
	        calendar.add(Calendar.DATE, 1);
	    }
	    return dates;
	}
	
	public float getAdditionalPrice() {
		return additionalPrice;
	}

	public void setAdditionalPrice(float additionalPrice) {
		this.additionalPrice = additionalPrice;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public int getRealAdditionalDays() {
		return realAdditionalDays;
	}

	public int getDistanceInKilometres() {
		return this.distanceInKilometres;
	}

	public int getLostCaps() {
		return this.lostCaps;
	}

	public boolean getLostInsurance() {
		return this.lostInsurance;
	}

	public boolean getLostRegistrationDocument() {
		return this.lostRegistrationDocument;
	}

	public List<Date> getAdditionalCarDays() {
		return additionalCarDays;
	}

	public void setAdditionalCarDays(List<Date> additionalCarDays) {
		this.additionalCarDays = additionalCarDays;
	}

	
	
	
}
