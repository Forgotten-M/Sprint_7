package ru.praktikum.services.qa.scooter;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.Before;
import static ru.praktikum.services.qa.scooter.constants.Url.*;

public abstract class BaseTest {

    @Before
    public void setUpRestAssured() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}