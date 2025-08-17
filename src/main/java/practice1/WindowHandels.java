package practice1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandels {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles(); //[parentId, ChildId]
		Iterator <String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String text =driver.findElement(By.cssSelector(".im-para.red")).getText();
		
		String email = text.split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		
		

	}

}
