package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {


	WebDriver driver;
	public   CheckoutPage(WebDriver driver) {

		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	
	 @FindBy(id="checkout")
	 private WebElement checkout;
	 @FindBy(name="firstName")
	 private WebElement firstName;
	 @FindBy(id="last-name")
	 private WebElement lastname;
	 @FindBy(id="postal-code")
	 private WebElement pincode;
	 @FindBy(xpath="//input[@value='Continue']")
	 private WebElement cbtn;
	 @FindBy (id="finish")
	 private WebElement fbtn;
	 @FindBy(xpath="//h2[text()='Thank you for your order!']")
	 private WebElement text;
	 
	 public void checkout(String firstname,String lastname,String pincode ) {

		  this.firstName.sendKeys(firstname);
		  this.lastname.sendKeys(lastname);
		  this.pincode.sendKeys(pincode);
		  cbtn.click();
		  fbtn.click();
		  String ep="Thank you for your order!";
		  String at = text.getText();
		  Assert.assertEquals(ep,at,"Product Ordered Successfully");
	 }
}
