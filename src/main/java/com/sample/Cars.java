package com.sample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Cars {
	private String category;
	//private boolean hired;
	private List<Date> hiredDaysCar ;
	
	


	public List<Date> getHiredDaysCar() {
		return hiredDaysCar;
	}

	public void setHiredDaysCar(List<Date> hiredDaysCar) {
		this.hiredDaysCar = hiredDaysCar;
	}

	public Cars( String cat ) {
		this.category=cat;
		this.hiredDaysCar=  new ArrayList <Date> ();
		}

	public String getCategory() {
		return this.category;
	}
	//public boolean check (ArrayList<Date> list1, ArrayList<Date> list2) {
	public boolean check (List<Date> list1, List <Date>list2) {
		
		if ( list1.size() ==0  || list2.size()==0 ) return true;
			
		 
		 for (int i = 0; i < list1.size(); i++) { 
				for(int j=0; j<list2.size(); j++) {
					
					if  ( list1.get(i).equals(list2.get(j)) ) {
						
						return false;
						
					}
					
					
				}
				}
		
		
		return true;
		
	}
	public static List<Date> add2list ( List<Date> list1, List <Date>list2) {
		
		List<Date> newlist = new ArrayList <Date> ();
		newlist.addAll(list1);
		newlist.addAll(list2);
		return newlist;
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
	
		

		
		
		
		
	}
