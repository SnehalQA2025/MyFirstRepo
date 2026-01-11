package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	//List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));   //By.xPath("//*[@class='cartSection']/h3")
    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> productNames;
    
    @FindBy(css=".totalRow button")
    WebElement checkOutEle;
	
	
	//Boolean match =  cartProducts.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase("ZARA COAT 3"));
    public boolean verifyOrderdisplay(String productName) {
    	Boolean match =  productNames.stream().anyMatch(cartp->cartp.getText().equalsIgnoreCase(productName));
    	return match;
    }
    
    public CheckOutPage gotoCheckOut() {
    	checkOutEle.click();
    	return new CheckOutPage(driver);
    }
    
}
