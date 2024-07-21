package ru.praktikum.services.qa.scooter;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import ru.praktikum.services.qa.scooter.steps.OrderSteps;


public class OrdersListTests extends BaseTest{
    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    @DisplayName("Проверка, что возвращаемый список заказов не пустой")
    public void shouldReturnNotEmptyOrdersList() {
        orderSteps
                .getOrdersList()
                .statusCode(200)
                .body("orders", Matchers.not(Matchers.empty()));
    }
}
