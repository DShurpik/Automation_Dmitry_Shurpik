package Task_14.PUT;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class put_test {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void put_test1(){
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).put("/users/2");
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "zion resident");
    }
}
