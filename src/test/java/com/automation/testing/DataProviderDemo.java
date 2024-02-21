package com.vyasa.automation.testing;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DataProviderDemo {
	 WebDriver driver;//declare browser
	  @BeforeClass
	  public void browserSetup() {
		System.setProperty("webdriver.chrome.driver","D:\\software testing\\Maventesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://practice.automationtesting.in/my-account/");
		driver.manage().window().maximize();
	  }
	
	@Test(dataProvider = "LoginData")
	public void verifUserLogon(String tcName,String username,String password)
	  {
		 WebElement userEle= driver.findElement(By.xpath("//input[@name=\"username\"]"));
		 userEle.clear();
		 userEle.sendKeys(username);
		 
		 WebElement passEle=driver.findElement(By.xpath("//input[@id=\"password\"]"));
		 passEle.clear();
		 passEle.sendKeys(password);
		 
		  driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		  
		  //Validation
		if(tcName.equalsIgnoreCase("blank"))
		{
              String errormsg= driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
               Assert.assertEquals(errormsg,"Error: Username is required.");
		}else if(tcName.equalsIgnoreCase("blankpass"))
		{
			String errormsg= driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
            Assert.assertEquals(errormsg,"Error: Password is required.");
		}else if(tcName.equalsIgnoreCase("wrongcredentials"))
		{
			String errormsg= driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).getText();
            Assert.assertEquals(errormsg,"Error: A user could not be found with this email address.");
		}else if(tcName.equalsIgnoreCase("succlogin"))
		{
		boolean display= driver.findElement(By.xpath("//p[contains( text(),\"Hello\")]")).isDisplayed();
            Assert.assertEquals(display, true);
		}
  }

  @DataProvider
  public Object[][] LoginData() //4 testcase with three input/elements
  { //data provider is always strore in object type
    return new Object[][] {{"blank","",""},{"blankpass","vyasainstitute2022@gmail.com",""},
    	{"wrongcredentials","vyasainstitut2022@gmail.com","admin123"},{"succlogin","vyasainstitute2022@gmail.com","Vyasa@12345"}};
   
  }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
