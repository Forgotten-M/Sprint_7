## Финальный проект 7 спринта

Протестирован API учебного сервиса [Яндекс.Самокат](https://qa-scooter.praktikum-services.ru/). Его документация: qa-scooter.praktikum-services.ru/docs/

* `POST /api/v1/courier` - Создание курьера
* `POST /api/v1/courier/login` - Логин курьера в системе
* `POST /api/v1/orders` - Создание заказа
* `GET /api/v1/orders` - Получение списка заказов

#### В проекте используются:
Java 11
Maven 3.8.1
JUnit 4.13.2
Rest Assured 5.2.0
Allure 2.28.0
Maven Surefire Plugin 2.22.2

#### Запуск:
`mvn clean test` - запуск тестов
`mvn allure:serve` - отчёты Allure


