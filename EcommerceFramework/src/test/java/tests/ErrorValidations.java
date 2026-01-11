package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductCatalogue;
import testComponents.BaseTest;

public class ErrorValidations extends BaseTest{
	
	  
		@Test
	    public void submitOrderErrorTest() throws IOException, InterruptedException {
           System.out.println("submitOrderErrorTest passed");
		}
		
		@Test
	    public void LoginErrorTest() throws IOException, InterruptedException {
			String productname = "ZARA COAT 3";
		    ProductCatalogue productCatalogue = landingPage.loginApplication("sonalsonar@gmail.com", "Sonali@sonar123");
		    Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		    System.out.println("LoginErrorTest passed");
		}
		
		
}
