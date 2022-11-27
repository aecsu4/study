package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private final WebDriver browser;
    //Записываю xpath и css селекторы в строку
    By entranceToMailButton = By.xpath("//*[@type = 'button' and @weight = '500']");
    By loginInput = By.xpath("//*[@id='passp-field-login']");
    By passInput = By.xpath("//*[@id='passp-field-passwd']");
    By loginWithMailSelector = By.xpath("//*[@type = 'button'][1]");
    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public LoginPage loginToYandex(String login, String pass){
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        browser.findElement(entranceToMailButton).click();
        browser.findElement(loginWithMailSelector).click();
        browser.findElement(loginInput).sendKeys(login, Keys.ENTER);
        browser.findElement(passInput).sendKeys(pass, Keys.ENTER);
        return this;
    }
}
