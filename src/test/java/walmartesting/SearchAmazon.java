package walmartesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SearchAmazon {
    WebDriver driver;

    @Test
    public void search() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Apple 15 1TB");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        WebElement selectProduct = driver.findElement(By.xpath("//span[text()='Apple iPhone 15 Pro (1 TB) - White Titanium']"));
        selectProduct.click();
    }
}
