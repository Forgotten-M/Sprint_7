package ru.praktikum.services.qa.scooter;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.services.qa.scooter.model.Courier;
import ru.praktikum.services.qa.scooter.steps.CourierSteps;

public class CourierLoginTests extends BaseTest {
    private final CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Before
    public void setUp() {
        courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(10));
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        courierSteps.createCourier(courier);
    }

    @Test
    @DisplayName("Проверка стаус-кода успешного входа в систему")
    public void shouldReturnStatusCode200() {
        courierSteps
                .loginCourier(courier)
                .statusCode(200);
    }

    @Test
    @DisplayName("Проверка возврата непустого id при успешном входе")
    public void shouldReturnId() {
        courierSteps
                .loginCourier(courier)
                .body("id", Matchers.notNullValue());
    }

    @Test
    @DisplayName("Проверка статус-кода при входе под несуществующим пользователем")
    public void shouldReturnStatusCode404() {
        courier.setLogin(RandomStringUtils.randomAlphabetic(10));
        courierSteps
                .loginCourier(courier)
                .statusCode(404);
    }

    @Test
    @DisplayName("Проверка текста ошибки при входе под несуществующим пользователем")
    public void shouldReturnMessageNotFound() {
        courier.setPassword(RandomStringUtils.randomAlphabetic(10));
        courierSteps
                .loginCourier(courier)
                .body("code", Matchers.is(404), "message", Matchers.is("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Проверка статус-кода при входе без логина")
    public void shouldReturnStatusCode400() {
        courier.setLogin("");
        courierSteps
                .loginCourier(courier)
                .statusCode(400);
    }

    @Test
    @DisplayName("Проверка текста ошибки при входе без пароля")
    public void shouldReturnMessageDataNotEnough() {
        courier.setPassword("");
        courierSteps
                .loginCourier(courier)
                .body("code", Matchers.is(400), "message", Matchers.is("Недостаточно данных для входа"));
    }

    @After
    public void tearDown() {
        Integer id = courierSteps.loginCourier(courier)
                .extract().body().path("id");
        if (id != null) {
            courier.setId(id);
            courierSteps.deleteCourier(courier);
        }
    }
}