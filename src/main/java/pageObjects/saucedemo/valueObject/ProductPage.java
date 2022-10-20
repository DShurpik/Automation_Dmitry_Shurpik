package pageObjects.saucedemo.valueObject;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j

public class ProductPage extends BasePage {

    private final By title = By.xpath("//span[@class='title']");

    public ProductPage verifyPageTitle() {
        Assert.assertEquals(getText(title), "PRODUCTS");
        log.debug("Title is displayed");
        return this;
    }

}
