import java.awt.HeadlessException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.OR;


public class AmazonAccount {
	WebDriver driver;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver","C://Program Files (x86)//eclipse//Library//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(OR.pathUrl);
		driver.manage().window().maximize();
	}
	
	@Test(enabled=false)
	public void RegisterToAmazon(){
		driver.findElement(OR.objSigninButton).click();
		driver.findElement(OR.objCreateAccountButton).click();
		driver.findElement(OR.objRegYourNameTextbox).sendKeys("AutomationTesting123");
		driver.findElement(OR.objRegMobileTextbox).sendKeys("9588437134");
		driver.findElement(OR.objRegEmailTextbox).sendKeys("AT@1234");
		driver.findElement(OR.objRegContinue).click();
		//next autentication requires manual intervenstion where we have to enter OTP and guess the characters
		String verifyTitle= driver.getTitle();
		Assert.assertEquals(verifyTitle, "yourstore","Logged in successfully");
	}
	
	@Test(priority=1)
	public void Login(){
		driver.findElement(OR.objSigninButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(OR.objUserID).sendKeys("9588437134");
		driver.findElement(OR.objUerIDContinue).click();
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(OR.objPassword)));
		driver.findElement(OR.objPassword).click();
		driver.findElement(OR.objPassword).sendKeys("AT@1234");
		driver.findElement(OR.objLogin).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String verifyTitle= driver.getTitle();
		Assert.assertEquals(verifyTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Logged in successfully");
	}
	
	@Test(priority=2)
	public void searchItemAndSort(){
		driver.findElement(OR.objSearchItem).sendKeys("one plus");
		driver.findElement(OR.objSearch).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(OR.objSort).click();
		driver.findElement(OR.objLowHigh).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,250)");
		driver.findElement(OR.objProduct).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ParentWindow= driver.getWindowHandle();
		Set<String> Window= driver.getWindowHandles();
		Iterator<String> itr= Window.iterator();
		while(itr.hasNext()){
	         String childwindow = itr.next();
	         if(!childwindow.equalsIgnoreCase(ParentWindow)){
	            driver.switchTo().window(childwindow);
	            driver.findElement(OR.objAddCart).click();
	            driver.close();
	         }
		}
		driver.switchTo().window(ParentWindow);
	}
	
	@Test(priority= 3)
	public void checkOutandClose(){
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		driver.findElement(OR.objCheckout).click();
		driver.findElement(OR.objDelete).click();
	}
	@AfterTest()
	public void teardown(){
		driver.close();
	}
}
