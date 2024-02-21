package com.vyasa.automation.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenBrowers{
	//create driver as global driver(i.e declare browser with ref variable)
	WebDriver driver;
  @BeforeClass
  public void openBrower(){
	  System.setProperty("webdriver.chrome.driver","D:\\software testing\\Maventesting\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
       driver.get("https://www.amazon.in/");
       driver.manage().window().maximize();
       
  }
  @Test
  public void verifyHomePageLoaded()
  {
	  //locate element
	  String expectedURL="https://www.amazon.in/";
	  String actualURL=driver.getCurrentUrl();
	  System.out.println(actualURL);
	  Assert.assertEquals(actualURL, expectedURL);//Hard assert
	  
  }
  @Test
  public void verifyCartDisplayed()
  {
	  WebElement cartEle=driver.findElement(By.xpath("//*[@id=\"nav-cart\"]"));
	 boolean actualValue=cartEle.isDisplayed();
	 System.out.println(actualValue);
	 Assert.assertTrue(actualValue);
  }
  @AfterClass
  public void closeBrower()
  {
	  driver.close();
  }
  
}
