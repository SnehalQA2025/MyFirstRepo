package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			 driver= new EdgeDriver();
			}
		
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();
		  return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException, InterruptedException {
		driver = initializeDriver();
		landingPage = new 	LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//read JsonFile to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//String to HashMap - JacksonDataBind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	return data;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}

}
