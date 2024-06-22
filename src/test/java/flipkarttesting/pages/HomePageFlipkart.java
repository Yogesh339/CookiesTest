package flipkarttesting.pages;

import flipkarttesting.test.BaseClassFlipKart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageFlipkart {
    WebDriver driver;
    By searchele = By.xpath("//div[@class='_2SmNnR']/input[@type='text']");
    String value = "Iphone 15 Pro max 1TB";

    public HomePageFlipkart(WebDriver driver) {
        this.driver = driver;
    }

    public void homePageSearch() {
        entervalue(searchele, value);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }

    public void entervalue(By sendkeys, String values) {
        WebElement searchBox = this.driver.findElement(searchele);
        searchBox.sendKeys(value);
    }
}
