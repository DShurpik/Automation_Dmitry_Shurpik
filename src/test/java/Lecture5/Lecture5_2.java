package Lecture5;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static Driver.SimpleDriver.getWebDriver;

public class Lecture5_2 {

    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
    }
    @Test
    public void test1(){
        Select selectGender = new Select(getWebDriver().findElement(By.id("oSex")));
        selectGender.selectByValue("0");
        getWebDriver().findElement(By.id("oCr")).sendKeys("50");
        getWebDriver().findElement(By.id("oAge")).sendKeys("20");
        getWebDriver().findElement(By.id("oWeight")).sendKeys("50");
        getWebDriver().findElement(By.id("oHeight")).sendKeys("170");
        getWebDriver().findElement(By.xpath("//*[@id=\"Form1\"]/ul/li[6]/input[1]")).click();
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
    /**@AfterTest
    public void postconditions(){
        getWebDriver().close();
    }*/
}
