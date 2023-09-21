package demo;

import java.util.List;
//import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperlinkCount
{
    ChromeDriver driver;
    public HyperlinkCount()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01()
    {
        //Launch browser  and Enter URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        //Locate the anchor tag and store in list Using Locator "Tag Name" <a>
        List<WebElement> hyperLinks = driver.findElements(By.tagName("a"));
                    
        //Get and store the size of list in an integer variable count  <a>
        int linkCount = hyperLinks.size();

        //Print the count  
        System.out.println("Count of hyperlinks : "+linkCount);
    }
}