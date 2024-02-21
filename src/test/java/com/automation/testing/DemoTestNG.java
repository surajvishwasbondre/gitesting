package com.vyasa.automation.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG {
 

@Test(alwaysRun=true,priority=1,description="test case verify the title page")
  //it will execute always
  public void TestCase1()
  {
	  System.out.println("TestCase1 Executed");
	  Assert.assertTrue(false);
  }
  
  @Test(enabled=false,priority=4,description="verify alignment of page")
//it will not execute 
  public void TestCase2()
  {
	  System.out.println("TestCase2 Executed");
  }
  
  @Test(groups="sanity",priority=7)
  public void TestCase3()
  {
	  System.out.println("TestCase3 Executed");
  }
  
  @Test(groups="regression",priority=8)
  public void TestCase4()
  {
	  System.out.println("TestCase4 Executed");
  }
  
  @Test(groups="regression,sanity",priority=2)
  public void TestCase5()
  {
	  System.out.println("TestCase5 Executed");
  }
  
  @Test(dependsOnGroups="regression",priority=6)
  
  public void TestCase6()
  {
	  System.out.println("TestCase6 Executed");
  }
  
  @Test(priority=9,dependsOnMethods={"TestCase4"})
  public void TestCase7()
  {
	  System.out.println("TestCase7 Executed");
  }
  
  @Test(dependsOnMethods="TestCase6",priority=10)
  public void TestCase8()
  {
	  System.out.println("TestCase8 Executed");
  }
  
  @Test(invocationCount=3,invocationTimeOut=500,priority=11)
  //give time out in mili seconds not in seconds like waits and threads
  public void TestCase9()
  {
	  System.out.println("TestCase9 Executed");
  }
  
  @Test(priority=12)
  public void TestCase10()
  {
	  System.out.println("TestCase10 Executed");
  }
  
  @Test(priority=5)
  public void TestCase11()
  {
	  System.out.println("TestCase11 Executed");
  }
  
  @Test(priority=3)
  public void TestCase12()
  {
	  System.out.println("TestCase12 Executed");
  }
}
