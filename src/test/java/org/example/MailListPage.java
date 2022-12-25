package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailListPage {
    @FindBy(css = ".qa-LeftColumn-CountersTotal")
    public WebElement numberMails;
    @FindBy(css = "a[href='#compose']")
    public WebElement writeNewMailButton;
    @FindBy(css = "div[title='Кому']")
    public WebElement adressInput;
    @FindBy(className = "ContactsSuggestItemDesktop")
    public WebElement myAdressString;
    @FindBy(css = ".ComposeSubject-TextField")
    public WebElement themeMailInput;
    @FindBy(css = "[role = 'textbox']")
    public WebElement mailContainerInput;
    @FindBy(css = "button[aria-disabled]")
    public WebElement sendMailButton;
    @FindBy(css = ".ComposeDoneScreen-Link")
    public WebElement returnMainPage;

    public MailListPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
    }

    public MailListPage sendMail(String text, String oldMailsNumberStr){
        writeNewMailButton.click();
        adressInput.click();
        myAdressString.click();
        themeMailInput.sendKeys(text, Keys.ENTER);
        mailContainerInput.sendKeys("Найдено "+oldMailsNumberStr+" писем\\ьма", Keys.ENTER);
        sendMailButton.click();
        returnMainPage.click();
        return this;
    }

    public int mailNumberGet() {
        return Integer.parseInt(numberMails.getText());
    }
}
