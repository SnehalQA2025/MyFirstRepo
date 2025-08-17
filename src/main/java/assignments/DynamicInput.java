package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicInput {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("http://qaclickacademy.com/practice.php");
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText());
		
		String SelOpt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		
		Select s =new Select(dropDown);
		s.selectByVisibleText(SelOpt);
		
		driver.findElement(By.name("enter-name")).sendKeys(SelOpt);
		driver.findElement(By.id("alertbtn")).click();
		
		String text = driver.switchTo().alert().getText();
		
		if(text.contains(SelOpt)) {
			System.out.println("Alert message success");
		}
		else
			System.out.println("Something went wrong");
		
		System.out.println(text);

	}

}
