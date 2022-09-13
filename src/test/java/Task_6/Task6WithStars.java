package Task_6;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleDriver.getWebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Task6WithStars {

    @BeforeTest
    public void precondition() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
        getWebDriver().navigate().refresh();
    }

    @BeforeMethod
    public void reload() {
        getWebDriver().get("https://www.saucedemo.com/");
        getWebDriver().navigate().refresh();
    }

    @Test
    public void test1above() {
        WebElement userName = getWebDriver().findElement(By.id("user-name"));
        WebElement passUser = getWebDriver().findElement(By.name("password"));
        WebElement loginBtn = getWebDriver().findElement(By.name("login-button"));
        userName.sendKeys("standard_user");
        passUser.sendKeys("secret_sauce");
        loginBtn.click();
        WebElement product1 = getWebDriver().findElement(By.xpath("(//button[contains(text(),'A')])[3]"));
        getWebDriver().findElement(with(By.id("item_4_title_link")).above(product1)).click();
    }

    @Test
    public void test2below() {
        WebElement userName = getWebDriver().findElement(By.id("user-name"));
        WebElement passUser = getWebDriver().findElement(By.name("password"));
        WebElement loginBtn = getWebDriver().findElement(By.name("login-button"));
        userName.sendKeys("standard_user");
        passUser.sendKeys("secret_sauce");
        loginBtn.click();
        WebElement product1 = getWebDriver().findElement(By.xpath("(//button[contains(text(),'A')])[3]"));
        getWebDriver().findElement(with(By.id("item_2_title_link")).below(product1)).click();
    }

    @Test
    public void test3toLeftOf() {
        WebElement userName = getWebDriver().findElement(By.id("user-name"));
        WebElement passUser = getWebDriver().findElement(By.name("password"));
        WebElement loginBtn = getWebDriver().findElement(By.name("login-button"));
        userName.sendKeys("standard_user");
        passUser.sendKeys("secret_sauce");
        loginBtn.click();
        WebElement product1 = getWebDriver().findElement(By.xpath("(//button[contains(text(),'A')])[4]"));
        getWebDriver().findElement(with(By.id("item_1_title_link")).toLeftOf(product1)).click();

    }
    @Test
    public void test4toRightOf() {
        WebElement userName = getWebDriver().findElement(By.id("user-name"));
        WebElement passUser = getWebDriver().findElement(By.name("password"));
        WebElement loginBtn = getWebDriver().findElement(By.name("login-button"));
        userName.sendKeys("standard_user");
        passUser.sendKeys("secret_sauce");
        loginBtn.click();
        WebElement product1 = getWebDriver().findElement(By.xpath("(//button[contains(text(),'A')])[4]"));
        getWebDriver().findElement(with(By.id("item_1_title_link")).toLeftOf(product1)).click();

    }
    @Test
    public void test5near() {
        WebElement userName = getWebDriver().findElement(By.id("user-name"));
        getWebDriver().findElement(with(By.id("password")).near(userName)).sendKeys("secret_sauce");
        WebElement loginBtn = getWebDriver().findElement(By.name("login-button"));
        userName.sendKeys("standard_user");
        loginBtn.click();
    }
}
