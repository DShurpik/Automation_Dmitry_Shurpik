package Lecture8;

import PageObjectForTask7.BaseObject.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.herokuapp.ContextMenuPage;
import pageObjects.herokuapp.DynamicLoadingPage;
import pageObjects.herokuapp.FramesPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.*;

public class Lecture8_2 extends BaseTest {

    @BeforeTest
    public void precondition(){
        new NavigationPage()
                .open();
    }

    @Test(enabled = false)
    public void dynamicLoading__Test(){
        new NavigationPage()
                .open()
                .navigateTo(DYNAMIC_LOADING);
        new DynamicLoadingPage()
                .clickOnExample("Example 1")
                .clickOnStart()
                .pageIsLoaded();
    }
    @Test(enabled = false)
    public void scroolPage_Test(){
        new NavigationPage()
                .navigateTo(INFINITE_SCROLL);
    }

    @Test(enabled = false)
    public void contexMenu_Test(){
        new NavigationPage()
                .navigateTo(CONTEXT_MENU);
        new ContextMenuPage().clickContext().verifyAlert("You selected a context menu");
    }
    @Test
    public void frame_Test(){
        new NavigationPage()
                .navigateTo(FRAMES);
        new FramesPage()
                .clickFrameLink("iFrame")
                .switchFrame()
                .enterText("Hello World!")
                .unSwitchFrame()
                .clickBoldTxt();
    }

}
