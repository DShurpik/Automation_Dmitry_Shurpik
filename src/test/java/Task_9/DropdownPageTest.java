package Task_9;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DropdownListPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.DROPDOWN;

public class DropdownPageTest extends BaseTest {

    @Test
    public void select1IndexTest(){
        new NavigationPage()
                .open()
                .navigateTo(DROPDOWN);
        new DropdownListPage()
                .isDisplayedPage()
                .selectOptions(1)
                .select1IsDisplayed();
    }

    @Test
    public void select2IndexTest(){
        new NavigationPage()
                .open()
                .navigateTo(DROPDOWN);
        new DropdownListPage()
                .isDisplayedPage()
                .selectOptions(2)
                .select2IsDisplayed();
    }

    @Test
    public void select1ValueTest(){
        new NavigationPage()
                .open()
                .navigateTo(DROPDOWN);
        new DropdownListPage()
                .isDisplayedPage()
                .selectOptions("Option 1")
                .select1ValueIsDisplayed();
    }

    @Test
    public void select2ValueTest(){
        new NavigationPage()
                .open()
                .navigateTo(DROPDOWN);
        new DropdownListPage()
                .isDisplayedPage()
                .selectOptions("Option 2")
                .select2ValueIsDisplayed();
    }
}
