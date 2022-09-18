package Task_9;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DragAndDropPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItems.DRAG_AND_DROP;

public class DragAndDropPageTest extends BaseTest {

    @Test
    public void test(){
        NavigationPage navigationPage = new NavigationPage();
        navigationPage.open();
        navigationPage.navigateTo(DRAG_AND_DROP);
        new DragAndDropPage()
                .moveElement();
    }
}
