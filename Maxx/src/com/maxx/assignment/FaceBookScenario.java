package com.maxx.assignment;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass;

public class FaceBookScenario {

	public static void main(String[] args)  
	{
		//launch chrome browser
		WebDriver driver = new ChromeDriver();
		//maximaize the window
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//implicitly wait till 5 secs to load the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//trigger the facebook url
		driver.get("https://www.facebook.com/login.php/");
		//store the locator of emaild id textfield 
		WebElement un = driver.findElement(By.id("email"));
		//giving input and copy that 
		un.sendKeys("axzyte.ben08@gmail.com"+Keys.CONTROL+"AC");
		//paste it in password texfield 
		driver.findElement(By.id("pass")).sendKeys(Keys.CONTROL+"V");
		//clearing the username textfield
		un.clear();
		//finding the locator of loginbutton
		WebElement button = driver.findElement(By.id("loginbutton"));
		//getting the color of login button
		String color = button.getCssValue("background-color");
		//getting the size of the login button
		String fontSize = button.getCssValue("font-size");
		//getting the tag name of the log in button
		String tagName = button.getTagName();
		//getting the text of login button
		String tagText = button.getText();
		//storing in locator of the sign up facebook link
		WebElement toolTip = driver.findElement(By.xpath("//a[@title='Sign up for Facebook']"));
		//getting the attribute title of tool tip
		String tipText = toolTip.getAttribute("title");
		//printing the cssvalues
		System.out.println("The color of create new account button is : "+color);
		System.out.println("The fontsize of create new account button is : "+fontSize);
		System.out.println("The tagName of create new account button is : "+tagName);
		System.out.println("The tag text of create new account button is : "+tagText);
		System.out.println("The text present in tool tip is : "+tipText);
		//check whether button is enabled or not
		boolean buttonEnorDis = button.isEnabled();
		System.out.println("\"whether log in button is enables or not \"" +buttonEnorDis);
		//clicking the signup link
		toolTip.click();
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		 int day_Y_axis = day.getLocation().getY();
		 int month_Y_axis = month.getLocation().getY();
		 int year_Y_axis = year.getLocation().getY();
		int dayWidth = day.getSize().getWidth();
		int dayHeight = day.getSize().getHeight();
		int monthWidth = month.getSize().getWidth();
		int monthHeight = month.getSize().getHeight();
		int yearWidth = year.getSize().getWidth();
		int yearHeight = year.getSize().getHeight();
		if(dayHeight == monthHeight && monthHeight == yearHeight && dayWidth == monthWidth && monthWidth == yearWidth)
		{
			System.out.println("all the dimension are same");
		}
		if(day_Y_axis == month_Y_axis && month_Y_axis == year_Y_axis)
		{
			System.out.println("alinments are correct ");
		}
		WebElement sign_up = driver.findElement(By.name("websubmit"));
		boolean signUpDisOrNot = sign_up.isDisplayed();
		System.out.println("\"sign up displayed or not : \""+signUpDisOrNot);
		wait.until(ExpectedConditions.attributeContains(sign_up, "type", "submit"));
		sign_up.submit();//it is not working 
//		sign_up.click();// it is working
		driver.quit();
	}

}
