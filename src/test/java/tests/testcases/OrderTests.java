package tests.testcases;

import models.Client;
import pageobject.MainPage;
import pageobject.OrderPage;

import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

//2) Заказ самоката. Весь флоу позитивного сценария.
// Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.

// Из чего состоит позитивный сценарий:
//  кнопку «Заказать». На странице две кнопки заказа;
// Заполнить форму заказа;
// Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.
// Нужно написать тесты с разными данными: минимум два набора. Какие именно данные использовать — на твоё усмотрение.

public class OrderTests {

    // создаем объекты с параметрами
    Client ivanIvanov = new Client("Иван", "Иванов",
            "г. Москва, ул. Ивантеевская, д. 21", "Бульвар Рокоссовского",
            "+79876543210", "16.04.2022", "привет мир!");
    Client petrPetrov = new Client("Петр", "Петров",
            "г. Москва, 9-я Парковая улица, д. 55", "Щёлковская",
            "89987654321", "17.04.2022", "привет курьер!");
    MainPage mainPage;
    OrderPage orderPage;
    final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void openMainPage() {
        Configuration.startMaximized = true;
        //открывается страница и создаётся экземпляр класса страницы
        mainPage = open(URL, MainPage.class);
        // если куки видны, кликнуть их
        mainPage.closeCookieMessage();
    }

    @Test
    public void orderScooterToIvanIvanov () {
        // кликнуть Заказать
        orderPage = mainPage.clickOrderButton();
        // Заполнить поля для ввода
        orderPage.setName(ivanIvanov.getName());
        orderPage.setSurname(ivanIvanov.getSurname());
        orderPage.setAddress(ivanIvanov.getAddress());
        orderPage.setNameMetroInput(ivanIvanov.getNameMetro());
        orderPage.clickSelectMetroInput();
        orderPage.setPhoneNumber(ivanIvanov.getPhoneNumber());
        orderPage.clickNextButton(); // кнопка Далее

        // вторая страница
        orderPage.setOrderDate(ivanIvanov.getOrderDate());
        orderPage.clickSelectedDate();
        orderPage.clickDropdownControl();
        orderPage.setAndClickDropdownElement(); // выбрать и кликнуть первый элемент дропдауна
        orderPage.clickBlackCheckBox();
        orderPage.setComment(ivanIvanov.getComment());
        orderPage.clickOrderButton(); // кнопка Заказать
        orderPage.clickYesButton(); // кнопка Да
        orderPage.compareTextOrderPlaced("Заказ оформлен"); // проверка текста в модальном окне
    }

    @Test
    public void orderScooterToPetrPetrov () {
        // кликнуть Заказать
        orderPage = mainPage.clickOrderSecondButton();
        // Заполнить поля для ввода
        orderPage.setName(petrPetrov.getName());
        orderPage.setSurname(petrPetrov.getSurname());
        orderPage.setAddress(petrPetrov.getAddress());
        orderPage.setNameMetroInput(petrPetrov.getNameMetro());
        orderPage.clickSelectMetroInput();
        orderPage.setPhoneNumber(petrPetrov.getPhoneNumber());
        orderPage.clickNextButton(); // кнопка Далее

        // вторая страница
        orderPage.setOrderDate(petrPetrov.getOrderDate());
        orderPage.clickSelectedDate();
        orderPage.clickDropdownControl();
        orderPage.setAndClickDropdownElement(); // выбрать и кликнуть первый элемент дропдауна
        orderPage.clickGreyCheckBox();
        orderPage.setComment(petrPetrov.getComment());
        orderPage.clickOrderButton(); // кнопка Заказать
        orderPage.clickYesButton(); // кнопка Да
        orderPage.compareTextOrderPlaced("Заказ оформлен"); // проверка текста в модальном окне
    }
}
