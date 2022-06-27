package tests.additionaltestcases;

import pageobject.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.Assert.assertEquals;

// 1) Проверить: если нажать на логотип «Самоката»,
// попадёшь на главную страницу «Самоката».
// 2) Проверить: если нажать на логотип Яндекса,
// в новом окне откроется главная страница Яндекса.

public class CheckUrlTests {

    MainPage mainPage;
    final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void openMainPage() {
        Configuration.startMaximized = true;
        mainPage = open(URL, MainPage.class);
    }

    @Test
    public void checkCurrentUrl () {
        mainPage.clickLogoScooterIcon();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(URL, currentUrl);
    }

    @Test
    public void checkCurrentUrlAfterSwitchTo () {
        mainPage.clickLogoYandexIcon();
        switchTo().window(1);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("https://yandex.ru/", currentUrl);
    }
}
