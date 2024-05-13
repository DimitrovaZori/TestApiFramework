package in.reqres.tests.create;

import in.reqres.model.request.create.UserRequest;
import in.reqres.model.response.create.UserResponse;
import in.reqres.tests.ApiTestBase;
import in.reqres.utils.ApiUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CreateTests extends ApiTestBase {
    @Test
    public void testCreateUser() {
       UserRequest request = new UserRequest();
       request.setName("morpheus");
       request.setJob("leader");

       UserResponse userResponse = given()
               .spec(ApiUtils.jsonRequestSpec())
               .body(request)
               .when()
               .post("/users")
               .then()
               .statusCode(201)
               .extract().as(UserResponse.class);

       assertNotNull(userResponse.getId());
       assertEquals("morpheus",userResponse.getName());
        assertEquals("leader",userResponse.getJob());
        assertNotNull(userResponse.getCreatedAt());

    }

}
