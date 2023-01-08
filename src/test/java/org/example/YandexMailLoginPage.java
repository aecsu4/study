package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMailLoginPage {
    private final WebDriver browser;
    @FindBy(className = "PSHeader-NoLoginButton")
    private WebElement entryMailButton;
    @FindBy(className = "Textinput-Control")
    private WebElement loginInput;
    @FindBy(name = "passwd")
    private WebElement passInput;
    @FindBy(css = "[data-type='login']")
    private WebElement mailFormSelector;

    public YandexMailLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public YandexMailLoginPage entrance(String login, String pass){
        entryMailButton.click();
        mailFormSelector.click();
        loginInput.sendKeys(login, Keys.ENTER);
        passInput.sendKeys(pass, Keys.ENTER);
        return this;
    }
}
