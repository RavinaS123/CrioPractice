/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.awt.AWTException;
import java.net.MalformedURLException;

public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException, AWTException {
        //TestCases tests = new TestCases(); // Initialize your test class
        //AmazonSearch amazon = new AmazonSearch();
        //HyperlinkCount hyperLink = new HyperlinkCount();
        //Linkedin linkedin = new Linkedin();
        //BookMyShow bms = new BookMyShow();
        //NestedFrames nf = new NestedFrames();
        IMDB imdb = new IMDB();

        //Todo: call your test case functions one after other here

        //tests.testCase01();
        //amazon.testCase01();
        //hyperLink.testCase01();
        //linkedin.testCase01();
        //bms.testCase01();
        //nf.testcase01();
        imdb.testCase01();

        //END Tests
        //End your test by clearning connections and closing browser

        //tests.endTest(); 
        //amazon.endTest();
        //hyperLink.endTest();
        //linkedin.endTest();
        //bms.endTest();
        //nf.endTest();
        imdb.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException, AWTException {
        new App().getGreeting();
    }
}
