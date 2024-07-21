package ru.praktikum.services.qa.scooter.steps;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import ru.praktikum.services.qa.scooter.model.Order;
import static ru.praktikum.services.qa.scooter.constants.Url.*;
import static io.restassured.RestAssured.*;

public class OrderSteps {

    @Step("Шаг запроса списка заказов")
    public ValidatableResponse getOrdersList() {
        return given()
                .when()
                .get(ORDERS_LIST_ENDPOINT)
                .then();
    }

    @Step
    @DisplayName("Шаг создания заказа")
    public ValidatableResponse createOrder(Order order) {
        return given()
                .body(order)
                .when()
                .post(CREATE_ORDER_ENDPOINT)
                .then();
    }
}