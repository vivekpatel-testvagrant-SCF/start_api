
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequest;

import java.util.UUID;

public class CreateUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowUserToCreateWithInvalidEmail() {
        // 1.Arrange
        String email =  String.format("%s@aascom", UUID.randomUUID());
        String gender = "female";
        String status = "active";
        String name = "Vivek";
        CreateUserRequest createUserRequest =  new CreateUserRequest(name,gender,email,status);
        String body = "{\"name\":\"Vivek\", \"gender\":\"male\", \"email\":\"vi1v1ekk111vhpatelil.c11om\", \"status\":\"active\"}";

        //Act
      usersClient.createUser(createUserRequest)
                .then()
                .log().body()

                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
