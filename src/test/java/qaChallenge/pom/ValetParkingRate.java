package qaChallenge.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValetParkingRate extends Wrapper {
	By title = By.linkText("PARKING COST CALCULATOR");
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
	By result = By.tagName("b");
	
	String resultValetParkingxDay ="$ 18:00";
	
	
	
	public ValetParkingRate(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void valetParkingxDay() throws InterruptedException {
			clearEverything();
			select(parkingLot,"Valet Parking");
			type(startingDate,"10/5/2021");
			type(leavingDate,"10/6/2021");
			type(startingTime, "12:00");
			type(leavingTime, "12:00");
			click(startingTimePM);
			click(leavingTimePM);
			click(calculateButton);		
	}
	
	public void clearEverything() {
		clear(startingDate);
		clear(leavingDate);
		clear(startingTime);
		clear(leavingTime);
	}
	
	

}
