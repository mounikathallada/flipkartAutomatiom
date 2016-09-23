package com.company.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestLoginPage extends BaseClassElements {
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	public static Properties prop=null;
	public String afterSearch=null;
	public String beforesearch=null;
	
	
	@BeforeTest
	public void setUp() {
		System. setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver= new ChromeDriver();
		wait=new WebDriverWait(driver,50);
		driver.manage().window().maximize();
		File file=new File("C:\\Users\\667899\\workspace\\AmazonWebsite\\src\\com\\company\\amazon\\inputFile.properties");
		FileInputStream f1=null;
		try {
			f1=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(f1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
		wait.until(ExpectedConditions.elementToBeClickable(findElemByXpath(BaseClassElements.img_flpcar)));
			
	}
	
	//home page title validation
	@Test (priority=0)
	public void homePageValidation(){
	    try
	    { 
	    //home page title validation	
	    Assert.assertEquals(driver.getTitle(), prop.getProperty("homepagetitle"));	
	    
	    System.out.println("title is correct");
	  
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	//login to the site with the user credentials
		
	@Test(priority=1)
	public void userlogIn() throws InterruptedException{
		findElemByXpath(BaseClassElements.login_button).click();
		findElemByXpath(BaseClassElements.username_login).sendKeys(prop.getProperty("username"));
		findElemByXpath(BaseClassElements.password_login).sendKeys(prop.getProperty("password"));
		findElemByXpath(BaseClassElements.login_submit_button).submit();
		wait.until(ExpectedConditions.elementToBeSelected(findElemByXpath(BaseClassElements.img_flpcar)));
			
		
	}
	//getting the web  element's particular attribute value
	public String gettingValueOfAttribute(String element){
		return findElemByXpath(element).getAttribute("title");
	}
			
	public void searchValidation(String beforesearch,String afterSearch){
		if(beforesearch==afterSearch)
			System.out.println("Page is not refreshed when search button is clicked");
		else
			System.out.println("Page got refreshed when search button is clicked");
	}
	//fetching the element before searching
	public void beforeSearchElemet(){
		beforesearch= gettingValueOfAttribute(BaseClassElements.homepage_advertise_image);
	    System.out.println("Before clicking on search button without any input  :  "+beforesearch);
		}
  //fetching the element after search
	public void afterSearchElement(){
		afterSearch= gettingValueOfAttribute(BaseClassElements.homepage_advertise_image);
		System.out.println("After clicking on search button without any input  :  "+afterSearch);
		searchValidation(beforesearch,afterSearch);
	}
	
	/**@AfterTest	
    public void closeTab(){
	
	driver.quit();
    }*/
 }		
