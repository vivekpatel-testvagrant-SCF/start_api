g
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser() {
        //Arrange
        String body = "{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"vi1v1ek1k11vhpatel@gmail.com\", \"status\":\"active\"}";

        //Act
        new UsersClient().createUser(body)
                .then()
                //Assert
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());


    }

    @Test
    public void shouldCreateFemaleUser() {
        //Arrange
        String body = "{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"vi1v1ekk111vhp1atel@gmail.com\", \"status\":\"active\"}";

        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

                //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());

    }




}
