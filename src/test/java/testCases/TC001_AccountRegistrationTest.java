package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("*****starting TC001_AccountRegistrationTest****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		
		
		hp.clickRegister();
		logger.info("clicked on register ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("providing customer details ");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("validating expected message ");
		  
	String confmsg=regpage.getConfirmationMsg();
	if(confmsg.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("test failed");
		logger.debug("debug logs..");
		Assert.assertTrue(false);
	}
		
	//Assert.assertEquals(confmsg,"Your Account Has Been Created!!!");
	}
	catch(Exception e)
		{
		 logger.error("test failed..");
		 logger.debug("debug logs..");
		 Assert.fail();
		}
	
	logger.info("***Finished TC001_AccountRegistrationTest ***");
	}
}
