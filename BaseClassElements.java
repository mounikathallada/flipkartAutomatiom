package com.company.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseClassElements {
	// Table value 1 to 8 columns
	public static final String CSS_TBL_CURR_ASS_VALUE_START = "#current_assignee  tr > td:nth-child(";
	public static final String CSS_TBL_CURR_ASS_VALUE_END = ")";
	
	

	//image of the flipkart in home page
	public static final String img_flpcar="//img[@title='Flipkart']";
	//elements for login
	public static final String login_button="//a[contains(@class,'_2k0') and contains(@href,'/account/login?')]";
	public static String username_login="//input[@class='_2zrpKA']";
	public static final String password_login="//input[contains(@class,'_2zrpKA') and @type='password']";
	public static final String login_submit_button="//button[contains(@class,'_3zLR') and @type='submit']";
	public static final String homepage_advertise_image="//div[@class='aqWyJi']/div[1]/a";
	public static final String search_bar="//div[@class='O8ZS_U']/input[@class='LM6RPg']";
	public static final String search_button="//button[@class='vh79eN']";
	public static final String username_mousehover_afterlogin="//a[@href='/account/?rd=0&link=home_account' and contains(@class,'_1A')]";
	public static final String wishlist_item_moushover_username="//a[@href='/wishlist?link=home_wishlist']";
	public static final String sort_in_wishlist="//select[contains(@onchange,'FKART.Wishlist.chan')]";
	public static final String
	
	
	
	
	
	public WebElement findElemByXpath(String element){
		WebElement elem=TestLoginPage.driver.findElement(By.xpath(element));
		return elem;
		
	}
	public void threadsleep(){
		try {
		Thread.sleep(400);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
	
}