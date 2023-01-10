package org.example;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestMail {
    public static WebDriver browser;
    public static YandexMailLoginPage yandexMailLoginPage;
    public static YandexMailListPage yandexMailListPage;
    public Properties property;

    @Before
    public void before() throws IOException {
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        yandexMailLoginPage = new YandexMailLoginPage(browser);
        yandexMailListPage = new YandexMailListPage(browser);
        Properties property = new Properties();
        property.load(new FileInputStream("src/test/java/org/example/config.properties"));
        this.property = property;
    }

    @Test
    public void test() {
        browser.get("https://yandex.ru/mail");
        yandexMailLoginPage.entrance(property.getProperty("mail.login"), property.getProperty("mail.password"));
        int oldMailNumber = yandexMailListPage.getMailsNumber();
        String text = "Найдено " + (oldMailNumber + 1) + " писем\\ьма";
        yandexMailListPage.sendMail("Simbir soft", text);
        browser.navigate().refresh();
        int newMailNumber = yandexMailListPage.getMailsNumber();
        Assert.assertEquals("Test is failed. Actual mail number is wrong ", oldMailNumber + 1, newMailNumber);
    }

    @After
    public void after() {
        browser.close();
    }
}
