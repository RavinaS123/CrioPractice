package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB
{
    ChromeDriver driver;
    public IMDB()
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
        //Launch browser with URL  https://www.imdb.com/chart/top/
        driver.get("https://www.imdb.com/chart/top/");

        //Locate all the movies list and store in list Using Locator "XPath" //li[contains(@class,'cli-parent')]
        List<WebElement> moviesCount = new ArrayList<>();
        moviesCount.addAll(driver.findElements(By.xpath("//li[contains(@class,'cli-parent')]")));

        //Print the count  count+" movies are included in the table."
        System.out.println(moviesCount.size()+" movies are included in the table.");

        //Locate the sort by option and click on it Using Locator "Tag Name" select.click()
        driver.findElement(By.tagName("select")).click();

        //Select Ranking option  Using Locator "XPath" //option[text()='Ranking']
        driver.findElement(By.xpath("//option[text()='Ranking']")).click();

        //Get the text of the 1st movie in the list Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3
        String title = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();

        //Print the text  title+" is the highest rated movie on IMDb"
        System.out.println(title+" is the highest rated movie on IMDb.");

        //Click on sort by option Using Locator "Tag Name" select.click()
        driver.findElement(By.tagName("select")).click();

        //Select Release Date option  Using Locator "XPath" //option[text()='Release date']
        driver.findElement(By.xpath("//option[text()='Release date']")).click();

        //Click on asc desc sort button Using Locator "ID" swap-sort-order-button
        driver.findElement(By.id("swap-sort-order-button")).click();

        //Get the text of the 1st movie in the list Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3
        title = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();

        //Print the text  title+" is the oldest movie on the list"
        System.out.println(title+" is the oldest movie on the list.");

        //Click on asc desc sort button Using Locator "ID" swap-sort-order-button
        driver.findElement(By.id("swap-sort-order-button")).click();

        //Get the text of the 1st movie in the list Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3
        title = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();

        //Print the text  title+" is the most recent movie on the list"
        System.out.println(title+" is the most recent movie on the list.");
    }
}