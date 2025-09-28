package practice1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://nseindia.com/");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		File dsFile = new File("D:\\Java Automation Nov24\\Homepage.png");
		
		FileUtils.copyFile(sourceFile, dsFile);
		
		System.out.println("Screenshot is saved to" + dsFile);

	}

}
