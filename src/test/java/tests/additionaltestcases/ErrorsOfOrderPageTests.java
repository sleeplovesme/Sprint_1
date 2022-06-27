package tests.additionaltestcases;

import pageobject.OrderPage;

import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

// 3) Проверить ошибки для всех полей формы заказа.

public class ErrorsOfOrderPageTests {

    OrderPage orderPage;
    final String URL = "https://qa-scooter.praktikum-services.ru/order";

    @Before
    public void openOrderPage() {
        Configuration.startMaximized = true;
        orderPage = open(URL, OrderPage.class);
    }

    @Test
    public void checkErrorsOfOrderPageTest () {
        // ввести невалидный адрес
        orderPage.setAddress("q");
        // кликнуть Далее
        orderPage.clickNextButton();
        // фамилия
        orderPage.isVisibleErrorTextName();
        // имя
        orderPage.isVisibleErrorTextSurname();
        // адрес
        orderPage.isVisibleErrorTextAddress();
        // метро
        orderPage.isVisibleErrorMessageMetro();
        // телефон
        orderPage.isVisibleErrorTextPhoneNumber();
    }
}
