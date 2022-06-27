package tests.additionaltestcases;

import pageobject.MainPage;
import pageobject.TrackPage;

import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

// 4) Проверить: если ввести неправильный номер заказа,
// попадёшь на страницу статуса заказа.
// На ней должно быть написано, что такого заказа нет.

public class IncorrectOrderNumberTests {

    private final String ORDER_NUMBER = "123";
    MainPage mainPage;
    TrackPage trackPage;
    final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void openMainPage() {
        Configuration.startMaximized = true;
        mainPage = open(URL, MainPage.class);
    }

    @Test
    public void checkIncorrectOrderNumber () {
        mainPage.clickOrderStatusButton();
        mainPage.setOrderStatusInput(ORDER_NUMBER);
        trackPage = mainPage.clickGoButton();
        trackPage.isVisibleTrackNotFoundIcon();
    }
}
