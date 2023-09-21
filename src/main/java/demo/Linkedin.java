package demo;

//import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//import net.bytebuddy.implementation.bytecode.ShiftLeft;

import java.awt.AWTException;
/*import java.awt.Robot;
import java.awt.event.KeyEvent;*/

public class Linkedin
{
    ChromeDriver driver;
    public Linkedin()
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

    public void testCase01() throws AWTException, InterruptedException
    {
        String encodedEmail = Base64.getEncoder().encodeToString("ravinashingade95@gmail.com".getBytes());
		String encodedPwd = Base64.getEncoder().encodeToString("Ravina@LinkedIn_123".getBytes());
		
		String decodedEmail = new String(Base64.getDecoder().decode(encodedEmail.getBytes()));
        String decodedPassword = new String(Base64.getDecoder().decode(encodedPwd.getBytes()));
		
        // Launch browser with url  https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        // Locate email or phone field Using Locator "ID" session_key and enter email id
        driver.findElement(By.id("session_key")).sendKeys(decodedEmail);

        // Locate password field Using Locator "ID" session_password and enter password
        driver.findElement(By.id("session_password")).sendKeys(decodedPassword);

        // Click on sign in button Using Locator "XPath" //button[contains(text(),'Sign in')]
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

        //Confirm that user is logged in successfully  Using Locator "XPath" //a[@class='ember-view block']
        boolean status = driver.findElement(By.xpath("//a[@class='ember-view block']")).isDisplayed();
        if(status)
        {
            System.out.println("Login Successful");
        }
        else
        {
            System.out.println("Login failed");
        }

        //Locate the text 'Who's viewed your profile' and store its count in webelement Using Locator "XPath" //a[contains(@href,'profile-views')]/div/div[2]/span
        WebElement views = driver.findElement(By.xpath("//a[contains(@href,'profile-views')]/div/div[2]/span"));

        //Store the count in an integer variable count  element.size()
        String viewsCount = views.getText();
        System.out.println("Who's viewed your profile : "+viewsCount);

        // Click on image button Using Locator "ID" //span[text()='Media']
        driver.findElement(By.xpath("//span[text()='Media']")).click();
        
        // Click on upload from computer button Using Locator "XPath" //div[@class='media-editor-file-selector__upload-media-button']
        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        
        Thread.sleep(3000);
        try
        {
            //Robot robot = new Robot();
            String imagePath = "C:\\Users\\Client\\Downloads\\mondayquotes.jpg";
            upload.sendKeys(imagePath);

            /*for (char c : imagePath.toCharArray()) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_SEMICOLON);
                    robot.keyRelease(KeyEvent.VK_SEMICOLON);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                    robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                    System.out.println("Line 3");
                }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);*/

            // Click on Next button Using Locator "XPath" //span[text()='Next']
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            
            // Click on sharing with options Using Locator "XPath" //*[@id="share-to-linkedin-modal__header"]/button
            driver.findElement(By.className("share-unified-settings-entry-button__chevron-icon")).click();

            // Select Connections only option Using Locator "XPath" //button[@id='CONNECTIONS_ONLY']
            driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']")).click();

            // Click on Done button Using Locator "XPath" //span[text()='Done']
            driver.findElement(By.xpath("//span[text()='Done']")).click();

            // Click on Post button Using Locator "XPath" //span[text()='Post']
            driver.findElement(By.xpath("//span[text()='Post']")).click();
            
            // Click on profile name on left side panel Using Locator "XPath" //a[@class='ember-view block']
            /*driver.findElement(By.xpath("//a/div[2][@class='t-16 t-black t-bold']")).click();
            System.out.println("class not found");

            // Click on show all posts Using Locator "XPath" //span[text()='Show all posts']
            driver.findElement(By.xpath("//span[text()='Show all posts']")).click();*/

            // Check if post is displayed Using Locator "XPath" //div[@class='pv0 ph5'].isDisplayed()
            status = driver.findElement(By.xpath("//img[@alt='Image preview']")).isDisplayed();
            if(status)
            {
                System.out.println("Post upload successful");
            }
            else
            {
                System.out.println("Post upload failed");
            }

            //driver.findElement(By.xpath("//span[text()='Home']")).click();

            //Locate the text Impressions of your post' and store its count in webelement Using Locator "XPath" //a[contains(@href,'shares')]/div/div[2]/span
            WebElement impressions = driver.findElement(By.xpath("//a[contains(@href,'shares')]/div/div[2]/span"));

            // Store the count in an integer variable count
            String imprCount = impressions.getText();
            System.out.println("Impressions of your post : "+imprCount);
        }
        catch (Exception e)
        {
            System.out.println(e);
        } 

        
    }
}
