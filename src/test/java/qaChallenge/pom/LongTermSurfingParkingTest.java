package qaChallenge.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LongTermSurfingParkingTest {

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
	public void longTermSurfaceParkingxHour() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Surface Parking");
		baseLocator.inputTextValues("10/06/2021", "10/06/2021", "12:00","01:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermSurfaceParking(0, 1),baseLocator.expectedResult());
		Thread.sleep(4000);
	}

}
