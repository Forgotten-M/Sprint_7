package ru.praktikum.services.qa.scooter;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.services.qa.scooter.model.Order;
import ru.praktikum.services.qa.scooter.steps.OrderSteps;


@RunWith(Parameterized.class)
public class OrderCreateParameterizedTests extends BaseTest{
    private final String firstColour;
    private final String secondColour;

    @Parameterized.Parameters
    public static Object[][] colour() {
        return new Object[][]{
                {null, null},
                {"BLACK", null},
                {null, "GREY"},
                {"BLACK", "GREY"}
        };
    }

    public OrderCreateParameterizedTests(String firstColour, String secondColour) {
        this.firstColour = firstColour;
        this.secondColour = secondColour;
    }

    @Test
    @DisplayName("Проверка создания заказа с разными выборами цветов самоката")
    public void shouldCreateOrder() {
        OrderSteps orderSteps = new OrderSteps();
        String[] testColor = {firstColour, secondColour};
        Order order = new Order("Имя",
                "Фамилия",
                "Адрес, дом 123",
                5,
                "89996661415",
                2,
                "2024-07-21",
                "Поскорее!",
                testColor);

        orderSteps
                .createOrder(order)
                .statusCode(201)
                .body("track", Matchers.notNullValue());

    }
}