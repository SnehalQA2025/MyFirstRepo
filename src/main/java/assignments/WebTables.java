package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement table=driver.findElement(By.id("product"));
		
		List<WebElement> rowList = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println("Number of rows = "+ rowList.size());
	
		List<WebElement> colList = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td"));
		System.out.println("Number of rows = "+ colList.size());
		
		
		System.out.println(colList.get(0).getText()+" "+colList.get(1).getText()+" "+colList.get(2).getText());
		
		/*WebElement table=driver.findElement(By.id("product"));



		System.out.println(table.findElements(By.tagName("tr")).size());



		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());



		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")); 
		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());
*/
		
		
		
	}

}
