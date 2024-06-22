package walmartesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonBasePage {
    WebDriver driver;

    @BeforeMethod
    public void walmart() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }

    @Test
    public void walmartHome() throws InterruptedException {

        WebElement elementToHover = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).perform();
        driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();

        //Entering invalid credantials
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("+9100000000");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='a-list-item']"));
        if (!elements.isEmpty()) {
            WebElement ele = elements.get(0);
            System.out.println("Error Message: " + ele.getText());
            String actualerrormessage = ele.getText();
            String expectedmessage = "We cannot find an account with that mobile number";
            Assert.assertEquals(expectedmessage, actualerrormessage);
        }
    }
    @AfterMethod
    public void exitBrowser(){
        driver.close();
    }
}
