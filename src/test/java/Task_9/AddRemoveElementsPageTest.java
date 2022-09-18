package Task_9;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.AddRemoveElementsPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.ADD_REMOVE_ELEMENTS;

public class AddRemoveElementsPageTest extends BaseTest {

    @Test
    public void test(){
        new NavigationPage()
                .open()
                .navigateTo(ADD_REMOVE_ELEMENTS);
        new AddRemoveElementsPage()
                .clickAddElementBtn()
                .deleteBtnIsDisplayed()
                .clickAddElementBtn5times()
                .deleteBtn6IsDisplayed()
                .clickDeleteBtn()
                .deleteBtnIsNotDisplayed();

    }
}
