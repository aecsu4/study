package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCalculator {
    public static WebDriver browser;
    public static PageObjectsModel start;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        browser = new ChromeDriver();
        start = new PageObjectsModel(browser);
    }

    @Test

    public void test(){
        browser.get("https://yandex.ru/mail");
        start.loginToYandex("todayna228","64242011qqQ").sendMail("Simbir soft").assertResult();
    }

    @After

    public void after(){
        browser.close();
    }
}
