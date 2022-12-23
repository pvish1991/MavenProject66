package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	SoftAssert softAssert = new SoftAssert();
	
	
  @Test (priority = 1 , groups = "smoke ")//create new User test@test.com and  priority is for setting up the priority to run the code to the accordingly  
  //If we want to execute the according need to use priority one other wise it will execute the result randomly.
  public void createUser() {
	  System.out.println("I'm in home test");
	  System.out.println("Before assertion");
	  Assert.assertTrue(2>3, "Verifying Element");//we use regular assert in industry 
	  System.out.println("After assertion");
	  Assert.assertEquals("abc", "abc");
  }
  
  @Test (priority = 2, dependsOnMethods = "createUser" ) // Edit User test@test.com
  public void editUser() {
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element");//we use regular assert in industry 
	  System.out.println("After assertion");
	  softAssert.assertAll();// Similar as error collector in Junit and whenever we use soft assert need to this syntax.
  }
  
  @Test (priority = 2, dependsOnMethods = "editUser" ) //Delete User test@test.com and
  public void deleteUser() {
	  System.out.println("I'm in end test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element");//we use regular assert in industry 
	  System.out.println("After assertion");
	  softAssert.assertEquals("abc", "abc1");
	  System.out.println("After second assertion");
	  softAssert.assertAll();
  }
}
