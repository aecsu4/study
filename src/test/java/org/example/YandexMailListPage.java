package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMailListPage {
    @FindBy(className = "qa-LeftColumn-CountersTotal")
    public WebElement numberMails;
    @FindBy(css = "[href='#compose']")
    public WebElement writeNewMailButton;
    @FindBy(className = "composeYabbles")
    public WebElement adressInput;
    @FindBy(className = "ContactsSuggestItemDesktop")
    public WebElement myAdressString;
    @FindBy(className = "ComposeSubject-TextField")
    public WebElement themeMailInput;
    @FindBy(className = "cke_contents_ltr")
    public WebElement mailContainerInput;
    @FindBy(className = "ComposeSendButton")
    public WebElement sendMailButton;
    @FindBy(className = "ComposeDoneScreen-Link")
    public WebElement returnMainPage;

    public YandexMailListPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
    }

    public YandexMailListPage sendMail(String theme, String text) {
        writeNewMailButton.click();
        adressInput.click();
        myAdressString.click();
        themeMailInput.sendKeys(theme, Keys.ENTER);
        mailContainerInput.sendKeys(text, Keys.ENTER);
        sendMailButton.click();
        returnMainPage.click();
        return this;
    }

    public int getMailsNumber() {
        return Integer.parseInt(numberMails.getText());
    }
}
