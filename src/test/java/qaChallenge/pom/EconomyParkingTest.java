package qaChallenge.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class EconomyParkingTest {

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
	public void economyParkingxHour() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Economy Parking");
		baseLocator.inputTextValues("10/06/2021", "10/06/2021", "12:00", "01:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.economyParking(0, 1),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void economyParkingDailyMaximun() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Economy Parking");
		baseLocator.inputTextValues("10/06/2021", "10/07/2021", "12:00","12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.economyParking(0, 24),baseLocator.expectedResult());
		Thread.sleep(4000);	
	}
	
	@Test
	public void economyParkingxWeek() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Economy Parking");
		baseLocator.inputTextValues("10/04/2021", "10/11/2021", "12:00","12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.economyParking(7, 0),baseLocator.expectedResult());
		Thread.sleep(4000);	
	}
	
	@Test
	public void economyParkingMoreThanOneDay() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Economy Parking");
		baseLocator.inputTextValues("10/04/2021", "10/07/2021", "12:00","05:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.economyParking(3, 5),baseLocator.expectedResult());
		Thread.sleep(4000);	
	}
	
	@Test
	public void economyParkingMoreThanAWeek() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Economy Parking");
		baseLocator.inputTextValues("10/04/2021", "10/20/2021", "12:00","05:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.economyParking(16, 5),baseLocator.expectedResult());
		Thread.sleep(4000);	
	}
	
	@Test 
	public void economyParkingLeavingDateBeforeStartingDate() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Economy Parking");
		baseLocator.inputTextValues("10/04/2021","10/03/2021","12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.errorLeavingDateBeforeStartingDate,baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	

}
