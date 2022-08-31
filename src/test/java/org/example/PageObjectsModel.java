package org.example;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PageObjectsModel {
    public PageObjectsModel pressButton(String nameOfButton) {
        test.browser.findElement(By.xpath("//*[contains(@class, 'XRsWPe') and text() = '"+ nameOfButton + "'] ")).click();
        return this;
    }

    public PageObjectsModel findInGoogle(String text) {
        test.browser.findElement(By.xpath("//input[contains(@title, 'Поиск')]")).sendKeys(text, Keys.ENTER);
        return this;
    }
    public PageObjectsModel result(String excepted) {
        String actual = test.browser.findElement(By.xpath("//*[contains(@class, 'qv3Wpe') and text()]")).getText();
        Assert.assertEquals("Test failed dolbojeb ", excepted, actual);
        return this;
    }





}
