package pageObjects.saucedemo.valueObject;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class ProductPage extends BasePage {

    private final By title = By.xpath("//span[@class='title']");

    public ProductPage verifyPageTitle() {
        Assert.assertEquals(getText(title), "PRODUCTS");
        System.out.println("title is displayed");
        return this;
    }

}
