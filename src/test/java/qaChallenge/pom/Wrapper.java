package qaChallenge.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrapper {

	private WebDriver driver;	
	
	public Wrapper(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebDriver chromeConnection () {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
		
	}
	
	public WebElement findElement(By Locator) {
		return driver.findElement(Locator);
	}
	
	public List<WebElement> findElements(By Locator){
		return driver.findElements(Locator);
	}
	
	public String getText(By Locator) {
		return driver.findElement(Locator).getText();
	}
	
	public void type(By Locator, String inputText) {
		driver.findElement(Locator).sendKeys(inputText);
	}
	
	public void click (By Locator) {
		driver.findElement(Locator).click();
	}
	
	public Boolean isDisplayed(By Locator) {
		try {
			return driver.findElement(Locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e){
			return false;
		}
	}
	
	public void select(By Locator, String visibleText ) {
		Select select = new Select(driver.findElement(Locator));
		select.selectByVisibleText(visibleText);
	}
	
	public void URL(String url) {
		driver.get(url);
	}
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}
}
