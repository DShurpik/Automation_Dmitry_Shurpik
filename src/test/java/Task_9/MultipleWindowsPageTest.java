package Task_9;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.NewWindow;
import pageObjects.herokuapp.OpeningANewWindowPage;

import static pageObjects.herokuapp.NavigationItems.MULTIPLE_WINDOWS;

public class MultipleWindowsPageTest extends BaseTest {



    @Test
    public void MultipleWindowsTest(){

        new NavigationPage()
                .open()
                .navigateTo(MULTIPLE_WINDOWS);

        new OpeningANewWindowPage()
                .verifyPageOpen()
                .click()
                .openTab();

        new NewWindow()
                .verifyOpenNewWindow()
                .closeTabNewWindow();
    }
}
