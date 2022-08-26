import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class SampleTest {

    @Test
    public void shouldGetAllUsers() {
        // Arrange
        //Act
        //Assert
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users/3")
                .then()
                .statusCode(200)
                .log().body();

    }

    @Test
    public void shouldCreateNewUser() {

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer ACCESS-TOKEN")
                .body("{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.ramakrishna@15ce.com\", \"status\":\"active\"}")
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .log().body();
    }
}
