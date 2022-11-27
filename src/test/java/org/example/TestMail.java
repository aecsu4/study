package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMail {
    public static WebDriver browser;
    public static LoginPage LoginPage;
    public static MailListPage MailListPage;
    public String expectedMailsNumber;
    By numberMails = MailListPage.numberMails;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        browser = new ChromeDriver();
        LoginPage = new LoginPage(browser);
        MailListPage = new MailListPage(browser);
    }

    @Test
    public void test(){
        browser.get("https://yandex.ru/mail");
        LoginPage.loginToYandex("todayna228","64242011qqQ");
        String oldMailsNumberStr = browser.findElement(numberMails).getText();
        String expectedMailsNumber = Integer.toString(Integer.parseInt(oldMailsNumberStr)+1);
        this.expectedMailsNumber = expectedMailsNumber;
        MailListPage.sendMail("Simbir soft", expectedMailsNumber);
    }

    @After
    public void after(){
        String actual = browser.findElement(numberMails).getText();
        Assert.assertEquals("Test is failed. Actual mail number is wrong ", actual, expectedMailsNumber);
        browser.close();
    }
}
