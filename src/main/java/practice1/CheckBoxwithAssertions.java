package practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxwithAssertions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input[type='checkbox']")).click(); 
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());//gives 1st match out of 3
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());//gives list of all of matches
		
		Assert.assertEquals(5, driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
