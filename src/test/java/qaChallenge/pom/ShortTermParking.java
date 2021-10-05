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
	}

	@Test
	public void shorTermParkingOneHourTest() throws InterruptedException {
		baseLocator.clearForm();
		
		
	}

}
