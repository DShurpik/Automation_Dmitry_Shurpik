package pageFactory.SauceDemo;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    public ProductPage(){
        PageFactory.initElements(driver, this);
    }

    public ProductPage titleIsDisplayed(){ // на новой странице не вызывается (
        Assert.assertTrue(title.isDisplayed());
        log.debug("Title is displayed");
        return this;
    }
}