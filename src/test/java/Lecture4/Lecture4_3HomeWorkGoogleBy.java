package Lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lecture4_3HomeWorkGoogleBy {

    WebDriver driver;
    WebElement search;
    WebElement searchResult;
    String expectedResult = "Привет, мир";
    String actualResult;

    @Test
    public void test1(){  // проверка что после поиска в гугл.бай в строке поиска остается текст "Привет, мир"
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.by/");
        search = driver.findElement(By.xpath("//input[@name='q']"));
        search.click();
        search.sendKeys("Привет, мир");
        search.sendKeys(Keys.ENTER);
        searchResult = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]/input"));
        searchResult.isDisplayed();
        actualResult = searchResult.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    @Test
    public void test2(){ // проверить что в ссылках после поиска отображается текст  “Привет, мир”
        driver = new ChromeDriver();
        driver.get("https://www.google.by/");
        search = driver.findElement(By.xpath("//input[@name='q']"));
        search.click();
        search.sendKeys("Привет, мир");
        search.sendKeys(Keys.ENTER);
        searchResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a/h3"));
        actualResult = searchResult.getAttribute("outerText");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    @Test
    public void test3(){
        driver = new ChromeDriver();
        driver.get("https://www.google.by/");
        search = driver.findElement(By.xpath("//input[@name='q']"));
        search.click();
        search.sendKeys("Привет, мир");
        search.sendKeys(Keys.ENTER);
        searchResult = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div/div/div[1]/div/a/h3"));
        actualResult = searchResult.getAttribute("outerText");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }
}
