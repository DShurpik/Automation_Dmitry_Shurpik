package pageObjects.tableHTML;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

public class Table extends BasePage {

    private WebElement tableNameField = driver.findElement(By.id("fname"));

    public Table open(){
        load();
        return this;
    }

    public Table sendText(String string){
        enter(tableNameField, string);
        return this;
    }

}
