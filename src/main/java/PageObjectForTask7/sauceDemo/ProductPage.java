package PageObjectForTask7.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Driver.SimpleDriver.getWebDriver;

public class ProductPage {

    public void verifyProductPageUri(){
        getWebDriver().getCurrentUrl().contains("inventory.html");
        System.out.println("Uri: " + getWebDriver().getCurrentUrl());
    }
    public WebElement getElementProduct(String productname){
        return getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productname +"']"));
    }

}
