package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestMail {
    public static WebDriver browser;
    public static LoginPage loginPage;
    public static MailListPage mailListPage;
    public String yandexMailLogin = LogPassData.yandexMailLogin;
    public String yandexMailPass = LogPassData.yandexMailPass;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(browser);
        mailListPage = new MailListPage(browser);
    }

    @Test
    public void test(){
        browser.get("https://yandex.ru/mail");
        loginPage.loginToYandex(yandexMailLogin,yandexMailPass);
        int oldMailNumber = mailListPage.mailNumberGet();
        mailListPage.sendMail("Simbir soft", Integer.toString(oldMailNumber+1));
        int newMailNumber = mailListPage.mailNumberGet();
        Assert.assertEquals("Test is failed. Actual mail number is wrong ", oldMailNumber+1, newMailNumber);
    }

    @After
    public void after(){
        browser.close();
    }
}
