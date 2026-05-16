package Tests;

import org.testng.annotations.Test;

import Pages.CheckoutPage;
import Utilities.BaseClass;

public class CheckoutTest extends BaseClass{

	@Test
	public void checkout() {
		login();
	 CheckoutPage cp=new CheckoutPage(driver);
     cp.checkout("siva", "M", "637204");
	}
}
