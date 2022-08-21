package Lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lecture4_3HomeWorkGoogleBy {
    @Test
    public void test1(){

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.by/");
        WebElement search = chromeDriver.findElement(By.xpath("//input[@name='q']"));
        search.click();
        search.sendKeys("Привет, мир");
        search.sendKeys(Keys.ENTER);
        Assert.assertTrue(search.isDisplayed());
    }
}
