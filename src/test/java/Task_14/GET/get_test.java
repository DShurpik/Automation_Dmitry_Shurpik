package Task_14.GET;

import Lecture20.entity.responce.User_responce;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class get_test {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void get_test_list_users(){
        Response response = given().get("/users?page=2");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("page"), 2);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("per_page"), 6);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("total"), 12);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("total_pages"), 2);
    }

    @Test
    public void get_test_single_user(){
        Data_request data_request = new Data_request(){{
            setId(2);
            setEmail("janet.weaver@reqres.in");
            setFirstName("Janet");
            setLastName("Weaver");
        }};
        Response response = given().header("Content-Type", "application/json").body(getJson("single_user")).get("/users/2");
        response.then().assertThat().statusCode(200);
        Data_responce data_responce = response.as(Data_responce.class);
        Assert.assertEquals(data_responce.getId(), data_request.getId());
        Assert.assertEquals(data_responce.getEmail(), data_request.getEmail());
        Assert.assertEquals(data_responce.getFirstName(), data_request.getFirstName());
        Assert.assertEquals(data_responce.getLastName(), data_request.getLastName());
    }

    @Test
    public void get_test_single_user_not_found(){
        Response response = given().get("/users/23");
        response.then().assertThat().statusCode(404);
    }

    public String getJson(String fileName){
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Task_14/json/" + fileName + ".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
