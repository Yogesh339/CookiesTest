package flipkarttesting.pages;

import flipkarttesting.test.BaseClassFlipKart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPageFK {
    WebDriver driver;
    By actprice = By.xpath("//div[text()='₹1,88,900']");
    By ratings = By.xpath("//div[@class='XQDdHH']");

    public ResultPageFK(WebDriver driver) {
        this.driver=driver;
    }

    public void resultPage(WebDriver driver) {
        price();
        rating();
    }

    public void price() {
        WebElement actualprice = driver.findElement(actprice);
        System.out.println("Price: " + actualprice.getText());
    }

    public void rating() {
        WebElement phonerating = driver.findElement(ratings);
        System.out.println("Rating: " + phonerating.getText());
    }
}
