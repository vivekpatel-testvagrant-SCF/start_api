import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateMaleUser() {
        //Arrange
        String body = "{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"vi1v1ekk11vhpatel@gmail.com\", \"status\":\"active\"}";

        //Act
        createUser(body)
                .then()
                //Assert
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());


    }

    @Test
    public void shouldCreateFemaleUser() {
        //Arrange
        String body = "{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"vi1v1ekk111vhpatel@gmail.com\", \"status\":\"active\"}";

        //Act
        createUser(body)
                .then()
                .log().body()

                //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());

    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 3f19f08e5ec0a3ee893e574b47b5111dc93665012b526172e1f584b2d034eae6")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }



}
