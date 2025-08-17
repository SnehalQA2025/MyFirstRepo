package assignments;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
//		ChromeOptions options = new ChromeOptions();
//
//		// Disable notifications and password manager features
//		options.addArguments("--disable-notifications");
//		options.addArguments("--disable-popup-blocking");
//
//		// Disable password manager
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("credentials_enable_service", false);
//		prefs.put("profile.password_manager_enabled", false);
//		prefs.put("profile.password_manager_leak_detection", false);
//
//		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new ChromeDriver();
		
		//WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement drpOptions = driver.findElement(By.xpath("//select[@class='form-control']"));
		
		Select dropdown = new Select(drpOptions);
		
		dropdown.selectByValue("consult");
		
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());

//        Alert alert = driver.switchTo().alert();
//        //assertEquals("Sample Alert", alert.getText());
//        alert.accept();
		
		Alert alert = driver.switchTo().alert();
	        //assertEquals("Are you sure?", alert.getText());
	        alert.dismiss();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		
		for(WebElement product : products) {
			product.click();
		}
		
		driver.findElement(By.partialLinkText("Checkout")).click();
		
		
		
		
		

	}

}
