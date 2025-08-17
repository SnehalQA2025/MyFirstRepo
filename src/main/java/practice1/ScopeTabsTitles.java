package practice1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeTabsTitles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());     //scope to footer only
		
		WebElement columDriver = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
		System.out.println(columDriver.findElements(By.tagName("a")).size());     //scope to colum in footer
		
		//Opening links in seperate tabs in a colum and checcking if the pages are opening
		
		for(int i=1; i<columDriver.findElements(By.tagName("a")).size();i++) {
			
			String clickonLinkTab= Keys.chord(Keys.CONTROL, Keys.ENTER);
			columDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
		}                                                                           //Open all tabs
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it= windows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
			
			
			
		
		
		
		
		
		
	}

}
