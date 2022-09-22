package Task_8;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControlsPage;
import pageObjects.herokuapp.NavigationPage;

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

    @Test
    public void FileUploadTest() {
        new NavigationPage()
                .navigateTo(FILE_UPLOAD);
        //new FileUploadPage()
        //.setFile()
        //.clickUploadBtn()
        //.verifyFileNames();
        //     .checkDownloadedFile(); //этот метод не работает. Он относится к последнему заданию (с зорачкай)
    }
}
