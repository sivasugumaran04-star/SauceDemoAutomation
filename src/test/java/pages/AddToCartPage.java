package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPage {


	WebDriver driver;
	public AddToCartPage(WebDriver driver) {

		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	
	 @FindBy(xpath="(//button[text()='Add to cart'])[1]")
	 private WebElement add;
	 @FindBy(xpath="//a[@class='shopping_cart_link']")
	 private WebElement icon;
	 @FindBy(xpath="[text()='Sauce Labs Backpack']")
	 private WebElement text;
	 @FindBy(xpath="//div[@class='cart_quantity']")
	 private WebElement update;
	 @FindBy(xpath="//button[text()='Remove']")
	 private WebElement remove;
	 
	 public void addproduct() {

		 add.click();
		 icon.click();
		  String ep="Sauce Labs Backpack";
		  String at = text.getText();
		  Assert.assertEquals(ep,at,"Product Added Successfully");
	 }
	 public void update() {
		 icon.click();
		 update.sendKeys("5");
		 String ep="5";
		  String at = update.getText();
		  Assert.assertEquals(ep,at,"Update Product Successfully");
		 
		 
	 }
	 
	 public void remove() {
		 
		 icon.click();
		 remove.click();
		 
		 
	 }
}
