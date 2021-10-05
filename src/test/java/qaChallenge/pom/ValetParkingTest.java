package qaChallenge.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.Locator;

public class ValetParkingTest {
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
	public void valetParkingxDayTest() throws InterruptedException {
			baseLocator.clearForm();
			baseLocator.dropDownListParkingLot("Valet Parking");
			baseLocator.inputTextValues("10/05/2021", "10/06/2021", "12:00", "12:00");
			baseLocator.setStartingTimePM();
			baseLocator.setLeavingTimePM();
			baseLocator.summitButton();
			assertEquals(baseLocator.resultValetParkingxDay,baseLocator.expectedResult());
			Thread.sleep(4000);
	}
	
	@Test
	public void valetParkingFor5hoursOrLess() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Valet Parking");
		baseLocator.inputTextValues("10/05/2021", "10/05/2021", "12:00", "03:00");
		baseLocator.setStartingTimePM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.resultValetParkingFor5orLessH,baseLocator.expectedResult());
		Thread.sleep(4000);

	}

}
