package qaChallenge.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators extends Wrapper {
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
	
	
	
	public Locators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
}
