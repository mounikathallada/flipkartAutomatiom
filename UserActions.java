package com.company.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserActions extends TestLoginPage 
{
	
	@Test(enabled=false)
	public void sortInWishList() throws InterruptedException{
		
		
		//using mouse hover operation selecting wishlist
		Actions act=new Actions(driver);
		act.moveToElement(findElemByXpath(BaseClassElements.username_mousehover_afterlogin)).moveToElement(findElemByXpath(BaseClassElements.wishlist_item_moushover_username)).click().perform();
		//counting the wishlist items
		/**WebElement wishitelem=driver.findElement(By.className("itm-cnt"));
		Thread.sleep(200);
		wait.until(ExpectedConditions.visibilityOf(wishitelem));
		String wishcountext=wishitelem.getText();
		int len=wishcountext.length();
		String wishcount=wishcountext.substring(0, len-1);
		System.out.println(wishcount);*/
		Thread.sleep(500);
		Select sortwishlist=new Select(findElemByXpath(BaseClassElements.sort_in_wishlist));
		sortwishlist.selectByValue("da");
	} 
//searching the page by giving the some input value	
  @Test(enabled=false)
	public void searchingWithInput(){
	  beforeSearchElemet();
	 findElemByXpath(BaseClassElements.search_bar).sendKeys("books");
	 findElemByXpath(BaseClassElements.search_bar).click(); 	
    afterSearchElement();

	}
 //searching the page without giving any input values
  @Test(priority=1)
	public void searchingWithOutInput(){
	  beforeSearchElemet();
	    findElemByXpath(BaseClassElements.search_button).click();
	    threadsleep();
	    afterSearchElement();
	}

}
