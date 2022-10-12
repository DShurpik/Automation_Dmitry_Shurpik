package Task_8;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControlsPage;
import pageObjects.herokuapp.FileUploadPage;
import pageObjects.herokuapp.NavigationPage;

import static driver.SimpleDriver.getWebDriver;
import static pageObjects.herokuapp.NavigationItems.DYNAMIC_CONTROLS;
import static pageObjects.herokuapp.NavigationItems.FILE_UPLOAD;


public class Task8 extends BaseTest {




    @Test
    public void dynamicControls_test() {
        new NavigationPage()
                .open()
                .navigateTo(DYNAMIC_CONTROLS);
        new DynamicControlsPage()
                .clickCheckBox()
                .isEnableCheckBox()
                .clickRemoveBtn()
                .inscriptionIsEnable()
                .inputDisable()
                .clickEnableBtn()
                .inputTextEnable()
                .sendTextInInput("инпут enabled");
    }

    public String fileLink = System.getProperty("user.dir") + "src\\test\\java\\resources\\testFileForUpload.txt";

    @Test
    public void FileUploadTest() {
        new NavigationPage()
                .open().
                navigateTo(FILE_UPLOAD);
        new FileUploadPage()
                .clickUploadBtn()
                .selectUploadFile(fileLink)
                .clickSubmitBtn()
                .fileUploadedIsDisplayed();
    }
}
