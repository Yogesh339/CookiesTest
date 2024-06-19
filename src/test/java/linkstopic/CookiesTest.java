package linkstopic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class CookiesTest {
    WebDriver driver;

    @Test
    public void countries() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        Thread.sleep(1000);
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Cookie Name: " + cookie.getName());
            System.out.println("Cookie Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Is Secure: " + cookie.isSecure());
            System.out.println("Is HttpOnly: " + cookie.isHttpOnly());
            System.out.println("---------------------------");
        }
    }

    @AfterMethod
    public void exitBrowser() {
        driver.close();
    }
}
