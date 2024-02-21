package com.vyasa.automation.testing;

import org.testng.annotations.Test;

import com.microsoft.edge.seleniumtools.EdgeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CrossBrowserTesting {
	public WebDriver driver;//declare browser
  @Parameters("browser")
  @BeforeClass
  public void browserLaunch(String browser)//parameters always needs data type during decleration
  {  
	  if(browser.equalsIgnoreCase("firefox"))
	  {
      System.setProperty("webdriver.gecko.driver","D:\\software testing\\Maventesting\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("firefox opened successfully"); 
	  }
  else if(browser.equalsIgnoreCase("chrome"))
  {  System.setProperty("webdriver.chrome.driver","D:\\software testing\\Maventesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("chrome opened successfully");
  }
  else if(browser.equalsIgnoreCase("edge"))
  {
	  System.setProperty("webdriver.edge.driver","D:\\software testing\\Maventesting\\Drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		System.out.println("edge opened successfully");
  }
	  driver.get("https://practice.automationtesting.in/my-account/");
	  driver.manage().window().maximize();
  }
  
  @Parameters({"username","password"})
  @Test
  public void verifUserLogon(String username,String password)
  {
	  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	 boolean actualDisplayed =driver.findElement(By.xpath(" //p[contains (text(),\"Hello \")]")).isDisplayed();
	  Assert.assertTrue(actualDisplayed);
  }

  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }

}
