package org.example;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SomeTest {

    private WebDriver driver;

    private PageObjectsModel page;

    @Before
    public void before() {
      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\павел\\IdeaProjects\\SDETtest\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        page = new PageObjectsModel(driver);
    }

    @Test
    public void someTest2() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath(PageObjectsModel.search)).sendKeys("Калькулятор", Keys.ENTER);

        Assert.assertEquals("Эти числа не равны, еблан", "1", "2");
    }

    @Test
    public void someTest() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath(PageObjectsModel.search)).sendKeys("Калькулятор", Keys.ENTER);
        page.pressButton("3")
                .pressButton("4")
                .pressButton("5");
        driver.findElement(By.xpath(PageObjectsModel.openBracket)).click();
        driver.findElement(By.xpath(PageObjectsModel.one)).click();
        driver.findElement(By.xpath(PageObjectsModel.plus)).click();
        driver.findElement(By.xpath(PageObjectsModel.two)).click();
        driver.findElement(By.xpath(PageObjectsModel.closeBracket)).click();
        driver.findElement(By.xpath(PageObjectsModel.multiplication)).click();
        // driver.findElement(By.xpath(PageObjectsModel.three)).click();
        driver.findElement(By.xpath(PageObjectsModel.minus)).click();
        driver.findElement(By.xpath(PageObjectsModel.four)).click();
        driver.findElement(By.xpath(PageObjectsModel.zero)).click();
        driver.findElement(By.xpath(PageObjectsModel.division)).click();
        driver.findElement(By.xpath(PageObjectsModel.five)).click();
        driver.findElement(By.xpath(PageObjectsModel.equal)).click();
        String result = driver.findElement(By.xpath(PageObjectsModel.result)).getText();
        String msg1 = "Result: ";
        System.out.println(msg1 + result);
        Assert.assertEquals("1", result);
        String msg;
        if (result.equals("1")) {
            msg = "Test uspeshno zavershen";
        } else {
            msg = "Test provalen";
        }
        System.out.println(msg);
    }

    @After
    public void after() {
        driver.close();
    }
}
