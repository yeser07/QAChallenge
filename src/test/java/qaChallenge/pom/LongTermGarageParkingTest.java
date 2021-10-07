package qaChallenge.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LongTermGarageParkingTest {

	private WebDriver driver;
	baseLocatorsFuntions baseLocator;

	@Before
	public void setUp() throws Exception {
		baseLocator = new baseLocatorsFuntions(driver);
		driver = baseLocator.chromeConnection();
		baseLocator.URL("https://www.shino.de/parkcalc/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void longTermGarageParkingxHour() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/04/2021","12:00", "05:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(0,5),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermGarageParkingDailyMaximum() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/04/2021","12:00", "01:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(0,13),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermGarageParkingbyDay()throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/05/2021","12:00", "12:00");
		baseLocator.setStartingTimePM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(1,0),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermGarageParkingByDayAndLess5Hours()throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/05/2021","12:00", "05:00");
		baseLocator.setStartingTimePM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(1,5),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermGarageParkingbyDayAndDailyMaximum()throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/05/2021","12:00", "01:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(1,13),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermGarageParkingxWeek()throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/11/2021","12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(7,0),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermGarageParkingWeekAndHours()throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/11/2021","12:00", "5:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(7,5),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermGarageParkingMoreThanOneWeek() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/19/2021","12:00", "01:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(15,13),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	@Test 
	public void longTermGarageParkingLeavingDateBeforeStartingDate() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/03/2021","12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.errorLeavingDateBeforeStartingDate,baseLocator.expectedResult());
		Thread.sleep(4000);
	}

}
