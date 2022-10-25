package Task_10;

import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pageObjects.herokuapp.NavigationItems.SORTABLE_DATA_TABLES;
@Log4j

public class EmailTest extends BaseTest {

    @Test
    public void test() {
        new NavigationPage()
                .open()
                .navigateTo(SORTABLE_DATA_TABLES);

        Map<String, List<String>> mapTableData = new SortableDataTablesPage().clickTableColumn("Email").getTableData();
        List<List<String>> tableData = new SortableDataTablesPage().getTableRowsData();
        List<String> actaualEmail = mapTableData.get("Email");
        log.debug("actual email = " + actaualEmail);

        List<String> emailData = actaualEmail.stream().map(email -> {
            if (email.contains("@yahoo.com")) {
                return email.replace("@yahoo.com", "@gmail.com");
            } else if(email.contains("@hotmail.com")){
                return email.replace("@hotmail.com", "@gmail.com");
            } else if(email.contains("@earthlink.net")){
                return email.replace("@earthlink.net", "@gmail.com");
            }
            return email;
        }).sorted().collect(Collectors.toList());
        log.debug("after add @gmail.com and sorted " + emailData);

        List<String> expectedEmail = new ArrayList<>() {{
            add("fbach@gmail.com");
            add("jdoe@gmail.com");
            add("jsmith@gmail.com");
            add("tconway@gmail.com");
        }};
        log.debug("expected email " + expectedEmail);

        Assert.assertEquals(emailData, expectedEmail);
    }


    @Test
    public void test1() {
        new NavigationPage()
                .open()
                .navigateTo(SORTABLE_DATA_TABLES);

        Map<String, List<String>> mapTableData = new SortableDataTablesPage()
                .clickTableColumn("Email")
                .getTableData();

        List<List<String>> tableData = new SortableDataTablesPage()
                .getTableRowsData();

        List<String> actaualEmail = mapTableData.get("Email");
        log.debug("actual email = " + actaualEmail);

        List<String> emailData = actaualEmail.stream()
                .map(email -> {
            if (email.contains("@yahoo.com")) {
                return email.replace("@yahoo.com", "@gmail.com");
            } else if(email.contains("@hotmail.com")){
                return email.replace("@hotmail.com", "@gmail.com");
            } else if(email.contains("@earthlink.net")){
                return email.replace("@earthlink.net", "@gmail.com");
            }
            return email;
        })
                .sorted()
                .collect(Collectors.toList());
        log.debug("after add @gmail.com and sorted " + emailData);

        List<String> expectedEmail = new ArrayList<>() {{
            add("fbach@gmail.com");
            add("jdoe@gmail.com");
            add("jsmith@gmail.com");
            add("tconway@gmail.com");
        }};
        log.debug("expected email " + expectedEmail);

        Assert.assertEquals(emailData, expectedEmail);
    }

    @Test
    public void test2(){
        new NavigationPage()
                .open()
                .navigateTo(SORTABLE_DATA_TABLES);

        Map<String, List<String>> mapTableData = new SortableDataTablesPage()
                .clickTableColumn("Email")
                .getTableData();

        List<String> gmailData = mapTableData.get("Email")
                .stream().map(data -> data.split("@")[0] + "@gmail.com")
                .sorted()
                .collect(Collectors.toList());

        List<String> expectedEmail = new ArrayList<>() {{
            add("fbach@gmail.com");
            add("jdoe@gmail.com");
            add("jsmith@gmail.com");
            add("tconway@gmail.com");
        }};
        log.debug("expected email " + expectedEmail);

        Assert.assertEquals(gmailData, expectedEmail);
    }
}