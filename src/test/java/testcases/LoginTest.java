package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.Annotations;


public class LoginTest extends Annotations {
	
	@Test(dataProvider="fetchData",priority=0)
	public void loginTest(String userName, String passWord, String expResult) throws Exception {
		new LoginPage()
		.login(userName, passWord, expResult);
	}

}
