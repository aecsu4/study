package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MailListPage {
    private final WebDriver browser;
    public By numberMails = By.xpath("//*[@class='Counters-m__total--WD+FS qa-LeftColumn-CountersTotal']");
    By writeNewMailButton = By.xpath("//*[@role= 'button' and @href = '#compose']");
    By adressInput = By.xpath("//*[@title= 'Кому']");
    By myAdressString = By.xpath("//*[@class = 'ContactsSuggestItemDesktop-Email']");
    By themeMailInput = By.xpath("//*[@id='compose-field-subject-4']");
    By mailContainerInput = By.cssSelector("[role = 'textbox']");
    By sendMailButton = By.xpath("//*[@type = 'button' and @aria-disabled='false']");
    By returnMainPage = By.xpath("//*[text()='Вернуться во \"Входящие\"']");

    public MailListPage(WebDriver browser) {
        this.browser = browser;
    }

    public MailListPage sendMail(String themeOfMail, String oldMailsNumberStr){
        //Нажатие на кнопку Написать
        browser.findElement(writeNewMailButton).click();
        //Нажатие на страницу адресации
        browser.findElement(adressInput).click();
        //Выбор строчки "Себе"
        browser.findElement(myAdressString).click();
        //Ввод темы письма
        browser.findElement(themeMailInput).sendKeys(themeOfMail, Keys.ENTER);
        //Ввод содержания письма
        browser.findElement(mailContainerInput).sendKeys("Найдено "+oldMailsNumberStr+" писем\\ьма", Keys.ENTER);
        browser.findElement(sendMailButton).click();
        browser.findElement(returnMainPage).click();
        browser.navigate().refresh();
        return this;
    }
}
