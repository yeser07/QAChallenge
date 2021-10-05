package qaChallenge.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ShortTermParking {
	private WebDriver driver;
	baseLocatorsFuntions baseLocator;

	@Before
	public void setUp() throws Exception {
		baseLocator = new baseLocatorsFuntions(driver);
		driver = baseLocator.chromeConnection();
		baseLocator.URL("https://www.shino.de/parkcalc/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void shorTermParkingOneHourTest() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Short-Term Parking");
		baseLocator.inputTextValues("10/05/2021", "10/05/2021", "12:00", "01:00");
		baseLocator.setStartingTimePM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.resultShortTimeParkingHour,baseLocator.expectedResult());
		Thread.sleep(4000);

	}
	
	@Test
	public void shortTermParkingHourHalfTest() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Short-Term Parking");
		baseLocator.inputTextValues("10/05/2021","10/05/2021","12:00", "1:30");
		baseLocator.setStartingTimePM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.resultShortTimeParkingHourHalf,baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void shortTermParkingDailyMaximun() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Short-Term Parking");
		baseLocator.inputTextValues("10/04/2021","10/05/2021","12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.shortTermDailyMax(0,13.5),baseLocator.expectedResult());
		Thread.sleep(4000);
		
	}
	

}
