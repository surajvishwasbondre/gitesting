package com.vyasa.automation.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomePageAutomation {
  WebDriver driver;//declare browser
  @BeforeClass
  public void browserSetup() {
	System.setProperty("webdriver.chrome.driver","D:\\software testing\\Maventesting\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://practice.automationtesting.in/");
	driver.manage().window().maximize();
  }
  @Test(description="verify homepage is loaded",priority=1)
  public void verifyHomePageLoaded() {
	String actualtitle=driver.getTitle();
	Assert.assertEquals(actualtitle,"Automation Practice Site");
  }
  
  @Test(description="verifyNewArrivalsDisplayed",priority=2)
  public void verifyNewArrivalsDisplayed() {
	 boolean actualValue=driver.findElement(By.tagName("h2")).isDisplayed();
	Assert.assertTrue(actualValue);
  }
  
  @Test(description="verify HomePage With Three Sliders",priority=3)
  public void verifyHomePageWithThreeSliders() {
	int slidersCount=driver.findElements(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div")).size();
	System.out.println(slidersCount);
	Assert.assertEquals(slidersCount, 3);
  }
  @Test(description="verify HomePage With Three Arrivals",priority=4)
  public void verifyHomePageWithThreeArrivals() {
	int arrivalCount=driver.findElements(By.xpath("//img[@class=\"attachment-shop_catalog size-shop_catalog wp-post-image\"]")).size();
	System.out.println(arrivalCount);
	Assert.assertEquals(arrivalCount, 3);
  }

  @Test(description="verify HomePage With Three Arrivals Navigation",priority=5)
  public void verifyHomePageWithThreeArrivalsNavigation() {
	List<WebElement> listImgBooks=driver.findElements(By.xpath("//img[@loading=\"lazy\"]"));
	for (WebElement booksEle : listImgBooks) {
		if(booksEle.getAttribute("title").equalsIgnoreCase("Selenium Ruby"))
		{
			booksEle.click();
		String actualBookTitle=driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualBookTitle,"Selenium Ruby");	
		}
		else if(booksEle.getAttribute("title").equalsIgnoreCase("Thinking in HTML"))
		{
			booksEle.click();
		String actualBookTitle=driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(actualBookTitle, "Thinking in HTML");
		}
		else 
		{
			booksEle.click();
		String actualBookTitle=driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(actualBookTitle, "Mastering JavaScript");
		}
		driver.navigate().back();
	}
  }
  
  @AfterClass
  public void browserClose() {
	  driver.close();
  }
  }


