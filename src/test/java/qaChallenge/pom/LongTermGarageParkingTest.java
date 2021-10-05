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
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void longTermGarageParkingxHour() throws Exception {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Garage Parking");
		baseLocator.inputTextValues("10/04/2021","10/18/2021","12:00", "01:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermGarageParking(14,13),baseLocator.expectedResult());
		Thread.sleep(4000);
	}

}
