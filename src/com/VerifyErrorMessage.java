package com;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyErrorMessage {
	
	@Test
     public void VerifyErrMessage() throws InterruptedException
     {
		//System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		WebDriver dr=new FirefoxDriver();
		dr.manage().window().maximize();
		dr.get("https://www.google.com/gmail/about/");
		dr.findElement(By.xpath("html/body/nav/div/a[2]")).click();
		dr.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(2000);
		//String actual_err=dr.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).getText();
		String actual_err=dr.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).getAttribute("innerHTML");
		String Expec_err="Enter an email or phone number";
		//Type1
		Assert.assertEquals(actual_err, Expec_err);
		//Type2
		Assert.assertTrue(actual_err.contains("Enter an email"));
     }
}

