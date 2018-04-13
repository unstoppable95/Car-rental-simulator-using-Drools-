package com.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
		private boolean loyaltyProgramMember;
		private List<Date> hiredDaysClient = new ArrayList <Date> ();
		
		
		public List<Date> getHiredDaysClient() {
			return hiredDaysClient;
		}

		public void setHiredDaysClient(List<Date> hiredDaysCar) {
			this.hiredDaysClient = hiredDaysCar;
		}

		public Client (boolean member) {
			this.loyaltyProgramMember=member;
		}

		public boolean getLoyaltyProgramMember() {
			return this.loyaltyProgramMember;
		}


}
