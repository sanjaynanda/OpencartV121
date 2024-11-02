package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

@Test(groups={"Sanity","Master"})
public void verify_login()
{
	logger.info("*****Starting TC_002_LOGIN TEST***");
	
	try {
	HomePage hp= new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	//My Account
	
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	Assert.assertTrue(targetPage);
	
	macc.clickLogout();
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("*****finished TC_002_LOGIN TEST***");
}

}