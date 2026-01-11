package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);    //initializing all Webelements   Whenever object is created, all webelements gets initialized
	}
	
	   //Using PageFactory annotations
	
	@FindBy(id="userEmail")
	WebElement userEmail;                 //WebElement UserEmail=driver.findElement(By.id("userEmail")); //.sendKeys("sonalsonar@gmail.com");
	
	 @FindBy(id="userPassword")
	 WebElement userpassword;            //driver.findElement(By.id("userPassword")).sendKeys("Sonal@sonar123");
	 
	 @FindBy(id="login")
	 WebElement submit;                  //driver.findElement(By.id("login")).click();
	 
//	 @FindBy(css="div[aria-label='Incorrect email or password.']")
//	 WebElement errorMessage;
	 
	 By errorMessage = By.cssSelector("div[aria-label='Incorrect email or password.']");
	 
	public ProductCatalogue loginApplication(String email, String password) {
		
		userEmail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public void goTo() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/client/");
		Thread.sleep(4);
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return driver.findElement(errorMessage).getText();
		//return errorMessage.getText();
	}

}
