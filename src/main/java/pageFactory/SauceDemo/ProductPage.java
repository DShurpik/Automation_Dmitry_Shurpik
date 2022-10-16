package pageFactory.SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    public ProductPage(){
        PageFactory.initElements(driver, this);
    }

    public ProductPage titleIsDisplayed(){ // на новой странице не вызывается (
        Assert.assertTrue(title.isDisplayed());
        System.out.println("title is displayed");
        return this;
    }
}