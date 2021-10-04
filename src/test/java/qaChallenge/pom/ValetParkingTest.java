package qaChallenge.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.Locator;

public class ValetParkingTest {
	private WebDriver driver;
	Locators locator;
	ValetParkingRate valet_parking_rate;

	@Before
	public void setUp() throws Exception {
		valet_parking_rate = new ValetParkingRate(driver);
		driver = valet_parking_rate.chromeConnection();
		valet_parking_rate.URL("https://www.shino.de/parkcalc/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void valetParkingxDayTest() throws InterruptedException {
		valet_parking_rate.valetParkingxDay();
		//assertEquals(locator.resultValetParkingxDay,locator.result);
	}

}
