package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;





public class PageObjectsModel {
    private final WebDriver browser;
    public PageObjectsModel(WebDriver browser) {
        this.browser = browser;
    }

    public PageObjectsModel pressButton(String nameOfButton ) {
        browser.findElement(By.xpath("//*[contains(@class, 'XRsWPe') and text() = '"+ nameOfButton  + "'] ")).click();
        return this;
    }

    public PageObjectsModel findInGooglePage(String text) {
        browser.findElement(By.xpath("//input[contains(@title, 'Поиск')]")).sendKeys(text, Keys.ENTER);
        return this;
    }

    public void assertResult(String excepted) {
        String actual = browser.findElement(By.xpath("//*[contains(@class, 'qv3Wpe') and text()]")).getText();
        Assert.assertEquals("TestCalculator failed dolbojeb ", excepted, actual);
    }

}
