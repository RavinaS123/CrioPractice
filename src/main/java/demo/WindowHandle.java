package demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle
{   
    ChromeDriver driver;
    public WindowHandle()
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

    public void takeScreenshot(WebDriver driver, String screenshotType, String description) {
        try {
            // Create a directory if it doesn't exist
            File theDir = new File("screenshots");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
    
            // Generate a timestamp for the filename
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = now.format(formatter);
    
            // Create the screenshot filename
            String fileName = String.format("screenshot_%s_%s_%s.png", timestamp, screenshotType, description);
    
            // Take the screenshot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    
            // Define the destination file
            File destFile = new File("screenshots", fileName);
    
            // Copy the screenshot file to the destination
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            // Handle any exceptions that may occur during screenshot capture or file copy
            e.printStackTrace();
        }
    }

    public void testCase01()
    {
        //Enter URL  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        try
        {
            WebElement iframe = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
            driver.switchTo().frame(iframe);
            //Click on Try it button Using Locator "XPath" //button[text()='Try it']
            driver.findElement(By.xpath("//body/button[text()='Try it']")).click();
            
            //Get window handles and store it in a set  driver.getWindowHandles()
            Set<String> handles = driver.getWindowHandles();

            //Switch to the opened window  switchTo().window
            driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
            Thread.sleep(3000);

            //Get the page URL getCurrentUrl()
            System.out.println("Current URL : "+driver.getCurrentUrl());

            //Get the page title getTitle()
            System.out.println("Title : "+driver.getTitle());

            //Take the screenshot  
            takeScreenshot(driver, "Window Handle", "screenshot1");

            //Close the current window  switchTo().window().close()
            driver.close();

            //Switch to the main window  switchTo().window
            driver.switchTo().window(handles.toArray(new String[handles.size()])[0]);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}