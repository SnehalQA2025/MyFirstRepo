package practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		WebElement nameEditBox = driver.findElement(By.name("name")); // driver.findElement(By.cssSelector("[name='name']")
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());  //above
		
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for = 'dateofBirth']"));
		
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();  //Below
		
		WebElement iceCream = driver.findElement(By.xpath("//label[text() = 'Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();
		
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));



		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		
	}

}
