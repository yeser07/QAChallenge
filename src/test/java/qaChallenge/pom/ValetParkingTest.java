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
		driver.manage().window().maximize();
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
	
	@Test 
	public void valetParkingLeavingDateBeforeStartingDate() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Valet Parking");
		baseLocator.inputTextValues("10/04/2021","10/03/2021","12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.errorLeavingDateBeforeStartingDate,baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test 
	public void emptyDateFields() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Valet Parking");
		baseLocator.inputTextValues("","10/03/2021","12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.emtyField,baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test 
	public void emptyHoursFields() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Valet Parking");
		baseLocator.inputTextValues("10/03/2021","10/03/2021","", "");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.emtyField,baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	@Test
	public void formatDate() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Valet Parking");
		baseLocator.inputTextValues("asdasdasdasd","asdasdasfgasfa","", "");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.formatDateError,baseLocator.expectedResult());
		Thread.sleep(4000);
	}

}
