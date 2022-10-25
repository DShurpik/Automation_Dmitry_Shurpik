package pageObjects.baseObjects;

import driver.UIElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static driver.DriverManager.getWebDriver;
import static propertyHelper.PropertyReader.getProperties;
@Log4j

public abstract class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;

    protected Properties properties;

    protected BasePage() {
        driver = getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        actions = new Actions(driver);
        properties = getProperties();
    }

    protected FluentWait<WebDriver> fluentWait(long timeout, long pollingEvery) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    protected void load(){
        log.debug("Open page: " + properties.getProperty("url"));
        driver.get(properties.getProperty("url"));
    }

    protected void load(String url){
        log.debug("Open page: " + url);
        driver.get(url);
    }

    protected void enter(WebElement webElement, String enterData) {
        log.debug("I'm enter :: " + enterData + ", by web element :: " + webElement);
        webElement.clear();
        webElement.sendKeys(enterData);
    }

    protected void enter(By locator, CharSequence... enterData) {
        log.debug("I'm enter :: " + enterData + ", by locator :: " + locator);
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        driver.findElement(locator).sendKeys(enterData);
    }

    protected void click(By locator) {
        log.debug("I'm click by :: " + locator);
        driver.findElement(locator).click();
    }

    protected void click(WebElement webElement) {
        log.debug("I'm click by :: " + webElement);
        new UIElement(driver, wait, webElement).click();
        // работат клика из класса обертки
    }

    protected void isDisplayed(By locator) {
        log.debug("WebElement is enable: " + locator);
        driver.findElement(locator).isDisplayed();
    }
    protected void isDisplayed(WebElement webElement) {
        log.debug("WebElement is enable: " + webElement);
        webElement.isDisplayed();
    }
    protected void isDisable(By locator) {
        log.debug("WebElement is enable: " + locator);
        driver.findElement(locator).isEnabled();
    }
    protected void isDisable(WebElement webElement) {
        log.debug("WebElement is enable: " + webElement);
        webElement.isEnabled();
    }


    protected String getText(By locator) {
        log.debug("I'm get text by  :: " + locator);
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement webElement) {
        log.debug("I'm get text by  :: " + webElement);
        return webElement.getText();
    }

    protected List<String> getTexts(By locator) { // получение текстов из элементов
        log.debug("I'm get text by  :: " + locator);
        List<String> data = new ArrayList<>();
        for (WebElement webElement : driver.findElements(locator)){
            data.add(webElement.getText());
        }
        return driver.findElements(locator).stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
    }

    protected String getElementAttribute(By by, String attribute){
        log.debug("Get element " + by + " attribute " + attribute);
        return driver.findElement(by).getAttribute(attribute);
    }

    public Boolean elementNotExist(By by){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        for (int counter = 0; counter < 20; counter++){
            log.debug("wait element not exist count = " + counter);
            if(driver.findElements(by).size() == 0){
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return true;
            }
            pause(1);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return false;
    }

    protected void pause(int second){
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void waitVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void verifyElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}