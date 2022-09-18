package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class AddRemoveElementsPage extends BasePage {

    private By addElementBtn = By.xpath("//button[text()='Add Element']");

    private By deleteBtn = By.xpath("//button[text()='Delete']");

    private By deleteBtn1 = By.xpath("//button[text()='Delete'][1]");

    private By deleteBtn6 = By.xpath("//button[text()='Delete'][6]");

    public AddRemoveElementsPage clickAddElementBtn(){
        click(addElementBtn);
        return this;
    }

    public AddRemoveElementsPage clickAddElementBtn5times(){
        for (int i = 1; i < 6; i++){
            click(addElementBtn);
        }
        return this;
    }

    public AddRemoveElementsPage deleteBtnIsDisplayed() {
        System.out.println("WebElement is enable: " + deleteBtn1);
        driver.findElement(deleteBtn1).isDisplayed();
        return this;
    }

    public AddRemoveElementsPage deleteBtn6IsDisplayed(){
        System.out.println("WebElement is enable: " + deleteBtn6);
        driver.findElement(deleteBtn6).isDisplayed();
        return this;
    }

    public AddRemoveElementsPage clickDeleteBtn(){
        for (int i = 6; i > 0 ; i--){
            click(deleteBtn);
        }
        return this;
    }

    public AddRemoveElementsPage deleteBtnIsNotDisplayed(){
        if(driver.findElements(deleteBtn).size() != 0){
            System.out.println("Element is Present");
        }else{
            System.out.println("Element is Absent");
        }
        return this;
    }
}