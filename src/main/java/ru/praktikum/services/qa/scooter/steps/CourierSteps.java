package ru.praktikum.services.qa.scooter.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.praktikum.services.qa.scooter.model.Courier;
import static ru.praktikum.services.qa.scooter.constants.Url.*;
import static io.restassured.RestAssured.*;


public class CourierSteps {

    @Step("Шаг создания курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return given()
                .body(courier)
                .when()
                .post(CREATE_ENDPOINT)
                .then();
    }

    @Step("Шаг логина курьера в систему")
    public ValidatableResponse loginCourier(Courier courier) {
        return given()
                .body(courier)
                .when()
                .post(LOGIN_ENDPOINT)
                .then();
    }

    @Step("Шаг удаления курьера")
    public ValidatableResponse deleteCourier(Courier courier) {
        return given()
                .pathParam("id", courier.getId())
                .when()
                .delete(DELETE_ENDPOINT)
                .then();
    }
}