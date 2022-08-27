import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import javax.jws.soap.SOAPBinding;

import static io.restassured.RestAssured.given;
public class GetAllUsers {

    // Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllUsers() {

        //Act

       usersClient.getAllUsers()
                .then()

               //Assert
                .body("data",Matchers.hasSize(20))
                .body("data",Matchers.hasItem(Matchers.hasEntry("","")))
                .statusCode(200)
                .log().body();

    }



}
