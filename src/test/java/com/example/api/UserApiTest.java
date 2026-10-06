package com.example.api;

import com.example.framework.config.Config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Test
public class UserApiTest {
    public void shouldGetUserById() {
        given()
                .baseUri(Config.get("api.base.url"))
        .when()
                .get("/users/2")
        .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"));
    }
}
