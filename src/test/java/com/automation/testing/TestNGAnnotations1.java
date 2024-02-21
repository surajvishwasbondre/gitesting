package com.vyasa.automation.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations1 {
  @BeforeSuite
  public void beforeSuiteMethod() {
	  System.out.println("beforeSuiteMethod");
  }
  @BeforeTest
  public void beforeTestMethod()
  {
	  System.out.println("beforeTestMethod");
  }
  @BeforeGroups
  void beforeGroupsMethod()
  {
		System.out.println("beforeGroupsMethod");  
  }
  @BeforeClass
  public void beforeClassMethod()
  {
	  System.out.println("beforeClassMethod");
  }
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("beforeMethod");
  }
  @Test
  void testMethod() {
		System.out.println("TestMethod");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("AfterMethod");
  }
  @AfterClass
  void afterClassMethod()
  {
		System.out.println("afterClassMethod");  
  }
  @AfterGroups
  void afterGroupsMethod()
  {
		System.out.println("afterGroupsMethod");  
  }
  @AfterTest
  void afterTest()
  {
		System.out.println("afterTest");  
  }
  @AfterSuite
  void afterSuiteMethod()
  {
		System.out.println("afterSuiteMethod");  
  }
}

  

