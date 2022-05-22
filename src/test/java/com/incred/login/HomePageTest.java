package com.incred.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {
	
@Test
public void launchbrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver	driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		WebElement pass = driver.findElement(By.name("user_password"));
		WebElement user=driver.findElement(RelativeLocator.with(By.tagName("input")).above(pass));
        user.sendKeys("admin");
        pass.sendKeys("manager");
        WebElement button=driver.findElement(RelativeLocator.with(By.tagName("input")).below(pass));
        button.click();
        
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.xpath("//img[@title=\"Create Lead...\"]")).click();
        WebElement save=driver.findElement(RelativeLocator.with(By.xpath("//b[text()='Description Information']")).below(By.xpath("//input[@title=\"Save [Alt+S]\"]")));
        save.click();
        
        Thread.sleep(10000);
        driver.quit();
}}
