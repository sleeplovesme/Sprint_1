package tests.testcases;

import pageobject.MainPage;

import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

//1) Выпадающий список в разделе «Вопросы о важном».
// Тебе нужно проверить: когда нажимаешь на стрелочку,
// открывается соответствующий текст.
// Важно написать отдельный тест на каждый вопрос.

public class FAQTests {

    // порядковый номер локатора (элемента) аккордеона
    private final int FIRST_ELEMENT_OF_ACCORDION  = 0;
    private final int SECOND_ELEMENT_OF_ACCORDION  = 1;
    private final int THIRD_ELEMENT_OF_ACCORDION  = 2;
    private final int FOURTH_ELEMENT_OF_ACCORDION  = 3;
    private final int FIFTH_ELEMENT_OF_ACCORDION  = 4;
    private final int SIXTH_ELEMENT_OF_ACCORDION  = 5;
    private final int SEVENTH_ELEMENT_OF_ACCORDION  = 6;
    private final int EIGHTH_ELEMENT_OF_ACCORDION  = 7;
    // ожидаемый текст (для сравнения)
    private final String FIRST_EXPECTED_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String SECOND_EXPECTED_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String THIRD_EXPECTED_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String FOURTH_EXPECTED_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String FIFTH_EXPECTED_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String SIXTH_EXPECTED_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String SEVENTH_EXPECTED_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String EIGHTH_EXPECTED_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    MainPage mainPage;
    final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void openMainPage() {
        Configuration.startMaximized = true;
        mainPage = open(URL, MainPage.class);
        // если куки видны, кликнуть их
        mainPage.closeCookieMessage();
        }

    @Test
    public void checkTextInFirstAccordionElement () {
        // проверить: когда нажимаешь на стрелочку, открывается соответствующий текст
        mainPage.clickAccordionElement(FIRST_ELEMENT_OF_ACCORDION);
        mainPage.compareText(FIRST_ELEMENT_OF_ACCORDION, FIRST_EXPECTED_TEXT);
    }

    @Test
    public void checkTextInSecondAccordionElement () {
        mainPage.clickAccordionElement(SECOND_ELEMENT_OF_ACCORDION);
        mainPage.compareText(SECOND_ELEMENT_OF_ACCORDION, SECOND_EXPECTED_TEXT);
    }

    @Test
    public void checkTextInThirdAccordionElement () {
        mainPage.clickAccordionElement(THIRD_ELEMENT_OF_ACCORDION);
        mainPage.compareText(THIRD_ELEMENT_OF_ACCORDION, THIRD_EXPECTED_TEXT);
    }

    @Test
    public void checkTextInFourthAccordionElement () {
        mainPage.clickAccordionElement(FOURTH_ELEMENT_OF_ACCORDION);
        mainPage.compareText(FOURTH_ELEMENT_OF_ACCORDION, FOURTH_EXPECTED_TEXT);
    }

    @Test
    public void checkTextInFifthAccordionElement () {
        mainPage.clickAccordionElement(FIFTH_ELEMENT_OF_ACCORDION);
        mainPage.compareText(FIFTH_ELEMENT_OF_ACCORDION, FIFTH_EXPECTED_TEXT);
    }

    @Test
    public void checkTextInSixthAccordionElement () {
        mainPage.clickAccordionElement(SIXTH_ELEMENT_OF_ACCORDION);
        mainPage.compareText(SIXTH_ELEMENT_OF_ACCORDION, SIXTH_EXPECTED_TEXT);
    }

    @Test
    public void checkTextInSeventhAccordionElement () {
        mainPage.clickAccordionElement(SEVENTH_ELEMENT_OF_ACCORDION);
        mainPage.compareText(SEVENTH_ELEMENT_OF_ACCORDION, SEVENTH_EXPECTED_TEXT);
    }

    @Test
    public void checkTextInEighthAccordionElement () {
        mainPage.clickAccordionElement(EIGHTH_ELEMENT_OF_ACCORDION);
        mainPage.compareText(EIGHTH_ELEMENT_OF_ACCORDION, EIGHTH_EXPECTED_TEXT);
    }
}
