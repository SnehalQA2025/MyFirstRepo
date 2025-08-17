package practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.className("a-button-text")).click();
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//CApital text search
		
		//a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
  //select entered text
		
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		
		//a.moveToElement(move).build().perform();     //mouseover
		
		a.moveToElement(move).contextClick().build().perform(); //right click
		
		    
		    
		  
		  
		
		

	}

}
