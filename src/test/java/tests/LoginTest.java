package Tests;

import org.testng.annotations.Test;

import Utilities.BaseClass;

import Pages.LoginPage;

public class LoginTest  extends BaseClass{


	@Test
	public void login() throws Exception{
		
			LoginPage lp=new LoginPage(driver);
			lp.login("standard_user", "secret_sauce");
		}
}

