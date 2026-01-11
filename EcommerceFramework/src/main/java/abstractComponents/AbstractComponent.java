package abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
		
	public AbstractComponent(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		//wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisAppear(By findBy) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCartPage() {
		// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage() {
		// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
}
}

