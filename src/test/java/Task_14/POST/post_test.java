package Task_14.POST;

import Lecture20.entity.request.User_request;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class post_test {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void post_test1(){

        User_request user_request = new User_request(){{
            setName("morpheus");
            setJob("leader");
        }};
        Response response = given().header("Content-Type", "application/json").body(user_request).post("/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "leader");
    }

    @Test
    public void post_test2(){
        String body = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).post("/register");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("id"), "4");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test
    public void post_test3(){
        String body = "{\n" +
                "    \"email\": \"sydney@fife\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).post("/register");
        response.then().assertThat().statusCode(400);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("error"), "Missing password");
    }

}
