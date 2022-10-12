package pageObjects.herokuapp;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class FileUploadPage extends BasePage {

    private By selectFileForUpload = By.id("drag-drop-upload");

    private By uploadBtn = By.id("file-submit");

    private By inputForFile = By.xpath("//input[@type='file']");

    private By titlePageSuccesfulDwnld = By.xpath("//h3[text()='File Uploaded!']");

    //public String fileLink = "D:\\code\\Automation_Dmitry_Shurpik\\src\\test\\java\\resources\\testFileForUpload.txt";
    public String fileLink = System.getProperty("user.dir") + "src\\test\\java\\resources\\testFileForUpload.txt";

    public FileUploadPage clickUploadBtn(){
        click(selectFileForUpload);
        System.out.println("click upload btn");
        return this;
    }

    public FileUploadPage selectUploadFile(String fileLink){
        getWebDriver().findElement(inputForFile).sendKeys(fileLink);
        System.out.println("file for upload was selected");

        return this;
    }

    public FileUploadPage clickSubmitBtn(){
        getWebDriver().findElement(uploadBtn).click();
        System.out.println("click submit btn");
        return this;
    }

    public FileUploadPage fileUploadedIsDisplayed(){
        getWebDriver().findElement(titlePageSuccesfulDwnld).isDisplayed();
        System.out.println("File Uploaded! is displayed");
        return this;
    }
}
