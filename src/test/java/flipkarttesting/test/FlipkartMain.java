package flipkarttesting.test;

import flipkarttesting.pages.HomePageFlipkart;
import flipkarttesting.pages.ResultPageFK;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FlipkartMain extends BaseClassFlipKart {
    @Test
    public void flipkart(){
        HomePageFlipkart home = new HomePageFlipkart(driver);
        home.homePageSearch();

        ResultPageFK result = new ResultPageFK(driver);
        result.resultPage(driver);
    }
}
