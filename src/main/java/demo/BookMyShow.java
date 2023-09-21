package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BookMyShow
{
    ChromeDriver driver;
    public BookMyShow()
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
        //Launch browser with url  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        try
        {
            //Make a list of movies name displayed in first section Using Locator "Class" Name eJQlCo
        	List<WebElement> movieTitles1 = driver.findElements(By.className("eJQlCo"));
            
            //Click on right arrow Using Locator "Class" Name fQuapp
            driver.findElement(By.className("fQuapp")).click();
            Thread.sleep(1000);
            
            //Make a list of movies name displayed in second section Using Locator "Class" Name daKrZU
            List<WebElement> movieTitles2 = driver.findElements(By.className("daKrZU"));
            
            //Click on left arrow Using Locator "Class" Name emCCuK
            driver.findElement(By.className("emCCuK")).click();
            Thread.sleep(1000);
            
            //Merge both lists into a single list  
            List<WebElement> moviesTitle = new ArrayList<>();
            moviesTitle.addAll(movieTitles1);
            moviesTitle.addAll(movieTitles2);
            
            /*Iterate through the final list to get each webelement  Using Locator "XPath" //img[contains(@alt,'"+title+"')]
            Store the src attribute value in string variable  
            Print the string variable */ 
            for (int i = 0; i < moviesTitle.size(); i++)
            {
                if(i == 5)
            	{
            		driver.findElement(By.className("fQuapp")).click();
                    Thread.sleep(1000);
            	}
                WebElement movieTitleElement = moviesTitle.get(i);
                String title = movieTitleElement.getText();

                // Find the image element using alt attribute
                WebElement imgURL = driver.findElement(By.xpath("//img[contains(@alt,'" + title + "')]"));
                String imageURL = imgURL.getAttribute("src");

                System.out.println(i + " : " + imageURL);

            	/*if(i < 5)
            	{
            		String title = moviesTitle.get(i).getText();
                	WebElement imgURL = driver.findElement(By.xpath("//img[contains(@alt,'"+title+"')]"));
                	String imageURL = imgURL.getAttribute("src");
                	System.out.println(i+" : "+imageURL);
            	}
            	else
            	{
            		try
            		{
            			driver.findElement(By.className("fQuapp")).click();
                        Thread.sleep(1000);
            		}
            		catch(Exception e)
            		{
            			String title = moviesTitle.get(i).getText();
                    	WebElement imgURL = driver.findElement(By.xpath("//img[contains(@alt,'"+title+"')]"));
                    	String imageURL = imgURL.getAttribute("src");
                    	System.out.println(i+" : "+imageURL);
            		}
            	}*/
            }
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[1]/div[6]/div/div")));
            
            WebElement parent = driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[1]/div[6]/div/div"));
            //WebElement section = parent.findElement(By.xpath("//div/div/div/div[2]/div/div"));
            
            //Locate the webelement for title in premiere Using Locator "XPath" //a[contains(@class,'fHgWnO')][2]/div/div[3]/div[1]
            String title = parent.findElement(By.xpath("//a[contains(@class,'fHgWnO')][2]/div/div[3]/div[1]")).getText();
            System.out.println("Name : "+title);

            //Locate the webelement for language in premiere Using Locator "XPath" //a[contains(@class,'fHgWnO')][2]/div/div[3]/div[2]
            String language = parent.findElement(By.xpath("//a[contains(@class,'fHgWnO')][2]/div/div[3]/div[2]")).getText();
            System.out.println("Name : "+title+"  Language : "+language);
            driver.quit();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}