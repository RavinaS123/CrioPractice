package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames
{
    ChromeDriver driver;
    public NestedFrames()
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

    public void testcase01()
    {
        //Launch browser with URL  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        try
        {
            //Switch to top frame Using Locator "Name" frame-top
            WebElement topFrame = driver.findElement(By.name("frame-top"));
            driver.switchTo().frame(topFrame);

            //Switch to left frame Using Locator "Name" frame-left
            WebElement leftFrame = driver.findElement(By.name("frame-left"));
            driver.switchTo().frame(leftFrame);

            //Locate the text(left)  Using Locator "Tag Name" body | sysout
            String text = driver.findElement(By.tagName("body")).getText();
            System.out.println("Text in left frame : "+text);

            //Switch to parent frame(top)  driver.switchTo.parentFrame
            driver.switchTo().defaultContent();
            driver.switchTo().frame(topFrame);

            //Switch to middle frame Using Locator "Name" frame-middle
            WebElement middleFrame = driver.findElement(By.name("frame-middle"));
            driver.switchTo().frame(middleFrame);

            //Locate the text(middle)  Using Locator "Tag Name" body | sysout
            text = driver.findElement(By.tagName("body")).getText();
            System.out.println("Text in middle frame : "+text);

            //Switch to parent frame(top)  driver.switchTo.parentFrame
            driver.switchTo().defaultContent();
            driver.switchTo().frame(topFrame);

            //Switch to right frame Using Locator "Name" frame-right
            WebElement rightFrame = driver.findElement(By.name("frame-right"));
            driver.switchTo().frame(rightFrame);

            //Locate the text(right)  Using Locator "Tag Name" body | sysout
            text = driver.findElement(By.tagName("body")).getText();
            System.out.println("Text in right frame : "+text);

            //Switch to default content  using switchTo.defaultContent()
            driver.switchTo().defaultContent();

            //Switch to bottom frame Using Locator "Name" frame-bottom
            WebElement bottomFrame = driver.findElement(By.name("frame-bottom"));
            driver.switchTo().frame(bottomFrame);

            //Locate the text(bottom)  Using Locator "Tag Name" body | sysout
            text = driver.findElement(By.tagName("body")).getText();
            System.out.println("Text in bottom frame : "+text);

            //Switch to default content
            driver.switchTo().defaultContent();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }  
    }
}