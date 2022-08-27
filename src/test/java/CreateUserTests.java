
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import javax.jws.soap.SOAPBinding;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {


    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreateMaleUser() {



        String email =  String.format("%s@gmail.com",UUID.randomUUID());
        String body = String.format("{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"%s\", \"status\":\"active\"}",email);

        //Act
        usersClient.createUser(body)
                .then()
                //Assert
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());


    }

    @Test
    public void shouldCreateFemaleUser() {
        //Arrange
        String email =  String.format("%s@gmail.com",UUID.randomUUID());
        String body = String.format("{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"%s\", \"status\":\"active\"}",email);

        //Act
       usersClient.createUser(body)
                .then()
                .log().body()

                //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());

    }




}
