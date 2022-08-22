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
    public void test1(){  // проверка что после поиска в гугл.бай в строке поиска остается текст "Привет, мир"
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.by/");
        WebElement search = chromeDriver.findElement(By.xpath("//input[@name='q']"));
        search.click();
        search.sendKeys("Привет, мир");
        search.sendKeys(Keys.ENTER);
        WebElement searchResult = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]/input"));
        searchResult.isDisplayed();
        String s = searchResult.getAttribute("value");
        System.out.println(s);
    }
}
