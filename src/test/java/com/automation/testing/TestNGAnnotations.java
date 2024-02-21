package com.vyasa.automation.testing;

import org.testng.annotations.Test;
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


	public class TestNGAnnotations {
		  
		@Test
	  void testMethod() {
			System.out.println("TestMethod");
	  }
	   @BeforeSuite
	   void beforeSuiteMethod()
	   {
			System.out.println("beforeSuiteMethod");  
	   }
	   @AfterSuite
	   void afterSuiteMethod()
	   {
			System.out.println("afterSuiteMethod");  
	   }
	   @BeforeTest
	   void beforeTest()
	   {
			System.out.println("beforeTest");  
	   }
	   @AfterTest
	   void afterTest()
	   {
			System.out.println("afterTest");  
	   }
	   @BeforeMethod
	   void beforeMethod()
	   {
			System.out.println("beforeMethod");  
	   }
	   @AfterMethod
	   public void afterMethod() {
	 	  System.out.println("AfterMethod");
	   }
	   @BeforeClass
	   void beforeClassMethod()
	   {
			System.out.println("beforeClassMethod");  
	   }
	   @AfterClass
	   void afterClassMethod()
	   {
			System.out.println("afterClassMethod");  
	   }
	   @BeforeGroups
	   void beforeGroupsMethod()
	   {
			System.out.println("beforeGroupsMethod");  
	   }
	   @AfterGroups
	   void afterGroupsMethod()
	   {
			System.out.println("afterGroupsMethod");  
	   }
	}

  

