import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class GetAllUsers {


    @Test
    public void shouldGetAllUsers() {
        // Arrange
        //Act
        //Assert
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users/3")
                .then()
                .body("data",Matchers.hasSize(20))
                .body("data",Matchers.hasItem(Matchers.hasEntry("","")))
                .statusCode(200)
                .log().body();

    }

}
