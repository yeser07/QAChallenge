package qaChallenge.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class baseLocatorsFuntions extends Wrapper {
	
	By pageTitle = By.linkText("PARKING COST CALCULATOR");
	By  parkingLot = By.id("ParkingLot");
	By startingDate = By.id("StartingDate");
	By leavingDate = By.id("LeavingDate");
	By startingTime = By.id("StartingTime");
	By leavingTime= By.id("LeavingTime");
	By startingTimeAM = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input[3]");
	By startingTimePM = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input[4]");
	By leavingTimeAM =By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[3]");
	By leavingTimePM =By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[4]");
	By calculateButton = By.name("Submit");
	By answerResultMessage = By.tagName("b");
	
	String resultValetParkingxDay ="$ 18.00";
	String resultValetParkingFor5orLessH ="$ 12.00";
	String resultShortTimeParkingHour ="$ 2.00";
	String resultShortTimeParkingHourHalf ="$ 3.00";
	String errorLeavingDateBeforeStartingDate = "ERROR! YOUR LEAVING DATE OR TIME IS BEFORE YOUR STARTING DATE OR TIME";
	String emtyField = "THIS FIELD CAN NOT BE EMPTY";
	String formatDateError= "THIS FORMAT IS NOT CORRECT";
	public baseLocatorsFuntions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void clearForm() {
		clear(startingDate);
		clear(leavingDate);
		clear(startingTime);
		clear(leavingTime);
	}
	
	public void inputTextValues(String starting_Date, String leaving_Date,String starting_Time, String leaving_Time) {
		type(startingDate,starting_Date);
		type(leavingDate,leaving_Date);
		type(startingTime, starting_Time);
		type(leavingTime, leaving_Time);
	}
	
	public void setStartingTimePM() {
		click(startingTimePM);
	}
	public void setLeavingTimePM() {
		click(leavingTimePM);
	}
	
	public void setStartingTimeAM() {
		click(startingTimeAM);
	}
	public void setLeavingTimeAM() {
		click(leavingTimeAM);
	}
	
	public void summitButton() {
		click(calculateButton);
	}
	
	public Boolean titleDisplay() {
		if(isDisplayed(pageTitle)==true){
			System.out.println("Title Displayed");
		}
		return false;		
	}
	
	public void dropDownListParkingLot(String parking_Lot) {
		select(parkingLot,parking_Lot);
	}
	
	public String expectedResult() {
		String expectec_result = getText(answerResultMessage);
		return expectec_result;
	}
	
	public String shortTermDailyMax(int days, double hours) {
		String currency ="$ ";
		int hourxDay =24;
		hours = hours*2;
		String result;
		double total;
		if(days ==0 && hours >24) {
			total = 24;
			return result = currency + Double.toString(total)+"0";
		}
		
		if(days>0 &&(hours*2>24)) {
			days = days*hourxDay;
			hours = 24;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}
			days = days*hourxDay;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
	}

	public String longTermGarageParking(int days, double hours) {
		String currency ="$ ";
		double total;
		String result;
		int weeks;
		int valuexDay =12;
		
		if(days==0 && (hours*2 >12)) {
			total = 12;
			return result = currency + Double.toString(total)+"0";
		}else if(days==1 && hours==0 || days==0 && (hours*2 >12)) {
			total = 12;
			return result = currency + Double.toString(total)+"0";
		}else if(days>=1 && days<7 && (hours*2<12)) {
			days = days*valuexDay;
			hours = hours*2;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days>=1 && days<7 && (hours*2>12)) {
			days = days*valuexDay;
			hours = 12;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days==7 && hours==0) {
			days = 72;
			//hours = 0;
			total = days;
			return result = currency + Double.toString(total)+"0";
		}else if(days==7 && (hours*2<12)) {
			days = 72;
			hours = hours*2;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days > 7 && hours*2<12) {
			hours = hours*2;
			weeks = days/7;
			days = (((days*24)-(weeks*168))/24);
			
			int weeksValue = weeks*72;
			int daysValue = days*12;
			total = weeksValue+daysValue+hours;
			
			return result = currency + Double.toString(total)+"0";
		}else if(days > 7 && hours*2>12) {
			hours = 12;
			weeks = days/7;
			days = (((days*24)-(weeks*168))/24);
			
			int weeksValue = weeks*72;
			int daysValue = days*12;
			total = weeksValue+daysValue+hours;
			
			return result = currency + Double.toString(total)+"0";
		}
		hours = hours*2;
		return result = currency + Double.toString(hours)+"0";
		
		
	}
	
	
	public String longTermSurfaceParking(int days, double hours) {
		String currency ="$ ";
		double total;
		String result;
		int weeks;
		int valuexDay =10;
		
		if(days==0 && (hours*2 >10)) {
			total = 10;
			return result = currency + Double.toString(total)+"0";
		}else if(days==1 && hours==0 || days==0 && (hours*2 >10)) {
			total = 10;
			return result = currency + Double.toString(total)+"0";
		}else if(days>=1 && days<7 && (hours*2<10)) {
			days = days*valuexDay;
			hours = hours*2;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days>=1 && days<7 && (hours*2>10)) {
			days = days*valuexDay;
			hours = 10;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days==7 && hours==0) {
			days = 60;
			total = days;
			return result = currency + Double.toString(total)+"0";
		}else if(days==7 && (hours*2<10)) {
			days = 60;
			hours = hours*2;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days > 7 && hours*2<10) {
			hours = hours*2;
			weeks = days/7;
			days = (((days*24)-(weeks*168))/24);
			
			int weeksValue = weeks*60;
			int daysValue = days*10;
			total = weeksValue+daysValue+hours;
			
			return result = currency + Double.toString(total)+"0";
		}else if(days > 7 && hours*2>10) {
			hours = 10;
			weeks = days/7;
			days = (((days*24)-(weeks*168))/24);
			
			int weeksValue = weeks*60;
			int daysValue = days*10;
			total = weeksValue+daysValue+hours;
			
			return result = currency + Double.toString(total)+"0";
		}
		hours = hours*2;
		return result = currency + Double.toString(hours)+"0";		
	}
	
	public String economyParking(int days, double hours) {
		String currency ="$ ";
		double total;
		String result;
		int weeks;
		int valuexDay =9;
		
		if(days==0 && (hours*2 >9)) {
			total = 9;
			return result = currency + Double.toString(total)+"0";
		}else if(days==1 && hours==0 || days==0 && (hours*2 >9)) {
			total = 9;
			return result = currency + Double.toString(total)+"0";
		}else if(days>=1 && days<7 && (hours*2<9)) {
			days = days*valuexDay;
			hours = hours*2;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days>=1 && days<7 && (hours*2>9)) {
			days = days*valuexDay;
			hours = 9;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days==7 && hours==0) {
			days = 54;
			total = days;
			return result = currency + Double.toString(total)+"0";
		}else if(days==7 && (hours*2<9)) {
			days = 54;
			hours = hours*2;
			total = days + hours;
			return result = currency + Double.toString(total)+"0";
		}else if(days > 7 && hours*2<9) {
			hours = hours*2;
			weeks = days/7;
			days = (((days*24)-(weeks*168))/24);
			
			int weeksValue = weeks*54;
			int daysValue = days*9;
			total = weeksValue+daysValue+hours;
			
			return result = currency + Double.toString(total)+"0";
		}else if(days > 7 && hours*2>9) {
			hours = 9;
			weeks = days/7;
			days = (((days*24)-(weeks*168))/24);
			
			int weeksValue = weeks*54;
			int daysValue = days*9;
			total = weeksValue+daysValue+hours;
			
			return result = currency + Double.toString(total)+"0";
		}
		hours = hours*2;
		return result = currency + Double.toString(hours)+"0";		
	}
	
	
	
	
	
	

}
