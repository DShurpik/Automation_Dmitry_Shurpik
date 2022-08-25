package Lecture6;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Driver.SimpleDriver.getWebDriver;

public class Lecture_6 {

    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
    }
    @BeforeMethod
    public void reload() {
        getWebDriver().navigate().refresh();
    }
    @Test
    public void test1(){
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.id("login-button")).click();

        elementExist(By.linkText("Facebook"));
        elementExist(By.partialLinkText("Twi"));
        elementExist(By.className("app_logo"));


    }
    private void elementExist(By by){
        Assert.assertEquals(getWebDriver().findElements(by).size(), 1); // Проверка через количество элементов листа элементов

    }
}
