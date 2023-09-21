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
        try
        {
        	List<WebElement> movieTitles1 = driver.findElements(By.className("eJQlCo"));
            
            //right arrow
            driver.findElement(By.className("fQuapp")).click();
            Thread.sleep(1000);
            
            List<WebElement> movieTitles2 = driver.findElements(By.className("daKrZU"));
            
            //left arrow
            driver.findElement(By.className("emCCuK")).click();
            Thread.sleep(1000);
            
            int size = movieTitles1.size() + movieTitles2.size();
            
            List<WebElement> moviesTitle = new ArrayList<>();
            for(WebElement webElement : movieTitles1)
            {
    			moviesTitle.add(webElement);
    		}
            for(WebElement webElement : movieTitles2)
            {
    			moviesTitle.add(webElement);
    		}
            
            for (int i = 0; i < moviesTitle.size(); i++)
            {
            	if(i < 5)
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
            	}
            }
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[1]/div[6]/div/div")));
            
            WebElement parent = driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[1]/div[6]/div/div"));
            //WebElement section = parent.findElement(By.xpath("//div/div/div/div[2]/div/div"));
            
            String title = parent.findElement(By.xpath("//a[contains(@class,'fHgWnO')][2]/div/div[3]/div[1]")).getText();
            System.out.println("Name : "+title);
            String language = parent.findElement(By.xpath("//a[contains(@class,'fHgWnO')][2]/div/div[3]/div[2]")).getText();
            System.out.println("Name : "+title+"  Language : "+language);
            driver.quit();
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
    }
}