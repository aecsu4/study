package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestMail {
    public static WebDriver browser;
    public static LoginPage loginPage;
    public static MailListPage mailListPage;
    public String login;
    public String password;
    FileInputStream loginPass;
    @Before
    public void before() throws IOException {
        System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(browser);
        mailListPage = new MailListPage(browser);
        Properties property = new Properties();
        loginPass = new FileInputStream("src/test/java/org/example/config.properties");
        property.load(loginPass);
        String login = property.getProperty("mail.login");
        String password = property.getProperty("mail.password");
        this.login = login;
        this.password = password;
    }

    @Test
    public void test(){
        browser.get("https://yandex.ru/mail");
        loginPage.loginToYandex(login,password);
        int oldMailNumber = mailListPage.mailNumberGet();
        mailListPage.sendMail("Simbir soft", Integer.toString(oldMailNumber+1));
        browser.navigate().refresh();
        int newMailNumber = mailListPage.mailNumberGet();
        Assert.assertEquals("Test is failed. Actual mail number is wrong ", oldMailNumber+1, newMailNumber);
    }

    @After
    public void after(){
        browser.close();
    }
}
