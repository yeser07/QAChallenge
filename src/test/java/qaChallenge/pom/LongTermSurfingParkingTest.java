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
		//driver.quit();
	}

	@Test
	public void longTermSurfaceParkingxHourTest() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Surface Parking");
		baseLocator.inputTextValues("10/06/2021", "10/06/2021", "12:00","01:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermSurfaceParking(0, 1),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermSurfaceParkingxDayliMaximumTest() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Surface Parking");
		baseLocator.inputTextValues("10/06/2021", "10/06/2021", "12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermSurfaceParking(0,24),baseLocator.expectedResult());
		Thread.sleep(4000);
		
	}
	
	@Test
	public void longTermSurfaceParkingxWeekTest() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Surface Parking");
		baseLocator.inputTextValues("10/04/2021","10/11/2021", "12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermSurfaceParking(7,0),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermSurfaceMoreThanOneDayTest() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Surface Parking");
		baseLocator.inputTextValues("10/05/2021","10/07/2021" ,"12:00","1:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermSurfaceParking(2,13),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test
	public void longTermSurfaceMoreThanAWeekTest() throws InterruptedException {
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Surface Parking");
		baseLocator.inputTextValues("10/04/2021","10/20/2021","12:00", "08:00");
		baseLocator.setStartingTimePM();
		baseLocator.setLeavingTimePM();
		baseLocator.summitButton();
		assertEquals(baseLocator.longTermSurfaceParking(16,8),baseLocator.expectedResult());
		Thread.sleep(4000);
	}
	
	@Test 
	public void longTermSurfaceParkingLeavingDateBeforeStartingDate() throws InterruptedException{
		baseLocator.clearForm();
		baseLocator.dropDownListParkingLot("Long-Term Surface Parking");
		baseLocator.inputTextValues("10/04/2021","10/03/2021","12:00", "12:00");
		baseLocator.setStartingTimeAM();
		baseLocator.setLeavingTimeAM();
		baseLocator.summitButton();
		assertEquals(baseLocator.errorLeavingDateBeforeStartingDate,baseLocator.expectedResult());
		Thread.sleep(4000);
	}

}
