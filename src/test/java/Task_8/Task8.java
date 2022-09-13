package Task_8;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControlsPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.DYNAMIC_CONTROLS;


public class Task8 extends BaseTest {



    @Test
    public void dynamicControls_test(){
        new NavigationPage()
                .open()
                .navigateTo(DYNAMIC_CONTROLS);
        new DynamicControlsPage()
                .clickCheckBox()
                .isEnableCheckBox()
                .clickRemoveBtn()
                .inscriptionIsEnable();

    }
}
