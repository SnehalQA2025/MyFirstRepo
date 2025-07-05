package practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class May12 {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.drover", "D:\\Application exe s");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(4000);
		
		//parent to child and Sibling travel
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		//child to parent travel
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent:: div/button[2]")).getText());
	}

}
