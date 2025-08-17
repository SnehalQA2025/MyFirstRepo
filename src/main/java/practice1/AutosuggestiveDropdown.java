package practice1;

import java.time.Duration;
import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(3000);                                            //CSS Parent to child

		List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));


		for(WebElement option :options)

		{

		if(option.getText().equalsIgnoreCase("India"))

		{

		option.click();

		break;


		}

		}

















		}



		}



	


