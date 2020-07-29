package ObjectRepository;

import org.openqa.selenium.By;

public class OR {	
	
	public static String pathUrl= "https://www.amazon.in/";
	public static By objSigninButton= By.id ("nav-link-accountList");
	public static By objCreateAccountButton= By.id ("createAccountSubmit");
	public static By objRegYourNameTextbox=By.id("ap_customer_name");
	public static By objRegMobileTextbox = By.id("ap_phone_number");
	public static By objRegEmailTextbox = By.id("ap_password");
	public static By objRegContinue = By.id("continue");
	public static By objUserID= By.name("email");
	public static By objUerIDContinue= By.id("continue");
	public static By objPassword= By.id("ap_password");
	public static By objLogin= By.id("signInSubmit");
	public static By objSearchItem= By.id("twotabsearchtextbox");
	public static By objSearch= By.xpath("//input[@type='submit']");
	public static By objSort= By.id("a-autoid-0-announce");
	public static By objLowHigh= By.id("s-result-sort-select_1");
	public static By objProduct= By.xpath("//*[contains(text(),'3T by One_Plus')]");
	public static By objAddCart= By.id("add-to-cart-button");
	public static By objCheckout= By.id("nav-cart");
	public static By objDelete= By.name("//input[(value='Delete')]");
	}
