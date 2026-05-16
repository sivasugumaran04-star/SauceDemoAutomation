package Tests;

import org.testng.annotations.Test;



import Pages.AddToCartPage;
import Pages.LoginPage;
import Utilities.BaseClass;

public class AddToCartTest  extends BaseClass{

	
	@Test
	public void addTocart() {
		LoginPage lp=new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
	AddToCartPage ap=new AddToCartPage(driver);
	ap.addproduct();
	}
	
	@Test
	public void update() {
	AddToCartPage ap=new AddToCartPage(driver);
	ap.update();
	}
	
	@Test
	public void remove() {
	AddToCartPage ap=new AddToCartPage(driver);
	ap.remove();
	}
}
