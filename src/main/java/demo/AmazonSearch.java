package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch
{
    ChromeDriver driver;
    public AmazonSearch()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01()
    {
        //Enter URL  www.google.com
        driver.get("https://www.google.com");

        //Locate search bar Using Locator "ID" APjFqb | sendkeys("amazon")
        driver.findElement(By.id("APjFqb")).sendKeys("amazon");

        //Click on google search button Using Locator "Name" btnK
        driver.findElement(By.name("btnK")).click();

        //Find the link amazon.in or amazon.com Using Locator "XPath" href='http://www.amazon.in/'
        boolean status = driver.findElement(By.xpath("//a[contains(@href,'amazon.in') or contains(@href,'amazon.com')]")).isDisplayed();

        //Return true if the link element is found  
        if(status)
        {
            System.out.println("Either amazon.in or amazon.com is displayed? "+status);
        } 
    }
}