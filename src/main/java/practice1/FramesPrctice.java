package practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesPrctice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(0);
		
		Actions a=new Actions(driver);
		
		WebElement sourceId= driver.findElement(By.id("draggable"));
		WebElement targetId= driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(sourceId, targetId).build().perform();
		
		driver.switchTo().defaultContent();
		
		

	}

}
