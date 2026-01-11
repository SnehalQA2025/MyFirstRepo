package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.OrderPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseTest;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrderTest extends BaseTest{
//	WebDriverManager.chromedriver().setup();
//	
//	WebDriver driver= new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.manage().window().maximize();
//	String productname = "ZARA COAT 3";
	//	LandingPage landingPage = new 	LandingPage(driver);
	//	landingPage.goTo();
//	ProductCatalogue productCatalogue = landingPage.loginApplication("sonalsonar@gmail.com", "Sonal@sonar123");
//	productCatalogue.getProductList();
//	productCatalogue.addProductToCart(productname);
//	CartPage cartPage = productCatalogue.goToCartPage();
//	boolean match=cartPage.verifyProductdisplay(productname);
//	System.out.println(match);
//    Assert.assertTrue(match);
//    CheckOutPage checkOutPage = cartPage.gotoCheckOut(); 
//    checkOutPage.selectCountry("India");
//    ConfirmationPage confirmationPage = checkOutPage.submitOrder();
//    String confirmMsg = confirmationPage.getConfirmessage();                 
//    //Assert.assertEquals(confirmMsg, "Thankyou for the order.");         
//    Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));           
//    driver.close();     
	String productname = "ZARA COAT 3";
	
	@Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrderTest(HashMap<String,String> input) throws IOException, InterruptedException {
		
	   // ProductCatalogue productCatalogue = landingPage.loginApplication("sonalsonar@gmail.com", "Sonal@sonar123");      
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		productCatalogue.getProductList();
		//productCatalogue.addProductToCart(productname);
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		//boolean match=cartPage.verifyProductdisplay(productname);
		boolean match=cartPage.verifyProductdisplay(input.get("product"));
		System.out.println(match);
	    Assert.assertTrue(match);
	    CheckOutPage checkOutPage = cartPage.gotoCheckOut(); 
	    checkOutPage.selectCountry("India");
	    ConfirmationPage confirmationPage = checkOutPage.submitOrder();
	    String confirmMsg = confirmationPage.getConfirmessage();                 
	    //Assert.assertEquals(confirmMsg, "Thankyou for the order.");         
	    Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));  
	    System.out.println("submitOrderTest passed");
	 
	}
	
	@Test(dependsOnMethods = {"submitOrderTest"})
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("sonalsonar@gmail.com", "Sonal@sonar123"); 
		OrderPage orderspage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderspage.verifyOrderdisplay(productname));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//PurchaseOrde.json");
		return new Object [][] {{data.get(0)}, {data.get(1)}};
	}

	
}




















