package Lecture4;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Driver.SimpleDriver.getWebDriver;

import java.time.Duration;

public class Lecture4_2_2 {


    WebElement zipCode;
    WebElement continueButton;
    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");

    }
    @BeforeMethod
    public void beforeMethod(){
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void test1() {
        WebElement zipCode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue' ]"));
        zipCode.sendKeys("1111");
        continueButton.click();
        pause(1);
        WebElement updateZipCode = getWebDriver().findElement(By.xpath("//input[@value='Continue' ]"));
        Assert.assertTrue(updateZipCode.isDisplayed());
    }
    @Test
    public void test2() {
        WebElement zipCode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue' ]"));
        zipCode.clear();
        zipCode.sendKeys("11111");
        continueButton.click();
        pause(1);
        WebElement updateZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertFalse(updateZipCode.isDisplayed());
    }
    @Test
    public void test3() {
        WebElement zipCode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue' ]"));
        zipCode.clear();
        zipCode.sendKeys("111111");
        continueButton.click();
        pause(1);
        WebElement updateZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertTrue(updateZipCode.isDisplayed());
    }

    @AfterTest
    public void postconditions(){
        getWebDriver().close();
    }
    private void pause(Integer timeout){
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}