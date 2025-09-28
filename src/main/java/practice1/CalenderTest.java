package practice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String monthNumber = "6";
		String year = "2027";
		String date = "15";
		String [] expectedDate = {monthNumber,date,year};
		
		driver.findElement(By.cssSelector(".react-date-picker.react-date-picker--closed.react-date-picker--enabled")).click(); //replace spaces with '.' in classname
		//driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.xpath("//button[text()= '2027']")).click();
		
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()= '15']")).click();
		
		List <WebElement> L = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		String A,E;
		for(int i=0; i<L.size();i++) {
			A = L.get(i).getAttribute("Value");
			System.out.println(A);
			E = expectedDate[i];
			System.out.println(E);
			
			Assert.assertEquals(A, E);
			
//			System.out.println(L.get(i).getAttribute("value"));
//
//			Assert.assertEquals(L.get(i).getAttribute("value"), expectedDate[i]);
			
		}
		
		//Assert.assertEquals(L, expectedDate);    find way to compare 2 lists
		
		driver.close();

	}

}
