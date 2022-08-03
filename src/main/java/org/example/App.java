package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class App
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\павел\\IdeaProjects\\SDETtest\\lib\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath(pageObjectsModel.search)).sendKeys("Калькулятор", Keys.ENTER);
        driver.findElement(By.xpath(pageObjectsModel.openBracket)).click();
        driver.findElement(By.xpath(pageObjectsModel.one)).click();
        driver.findElement(By.xpath(pageObjectsModel.plus)).click();
        driver.findElement(By.xpath(pageObjectsModel.two)).click();
        driver.findElement(By.xpath(pageObjectsModel.closeBracket)).click();
        driver.findElement(By.xpath(pageObjectsModel.multiplication)).click();
        driver.findElement(By.xpath(pageObjectsModel.three)).click();
        driver.findElement(By.xpath(pageObjectsModel.minus)).click();
        driver.findElement(By.xpath(pageObjectsModel.four)).click();
        driver.findElement(By.xpath(pageObjectsModel.zero)).click();
        driver.findElement(By.xpath(pageObjectsModel.division)).click();
        driver.findElement(By.xpath(pageObjectsModel.five)).click();
        driver.findElement(By.xpath(pageObjectsModel.equal)).click();
        String result =  driver.findElement(By.xpath(pageObjectsModel.result)).getText();
        String msg1 = "Result: ";
        System.out.println(msg1+result);
        if (new String(result).equals("1") ){
            String msg = "Test uspeshno zavershen";
            System.out.println(msg);
            driver.close();
        }
        else{
            String msg = "Test provalen";
            System.out.println(msg);
        }

    }
}
