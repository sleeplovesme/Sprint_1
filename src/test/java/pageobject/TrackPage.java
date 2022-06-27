package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class TrackPage {

    // локатор "Такого заказа нет"
    @FindBy(how = How.CLASS_NAME,using = "Track_NotFound__6oaoY")
    private SelenideElement trackNotFoundIcon;

    // проверить что картинка "Такого заказа нет" видна
    public void isVisibleTrackNotFoundIcon() {
        trackNotFoundIcon.shouldBe(visible);
    }

    // метод ожидания загрузки страницы
    public void waitForLoadOrderPage(){
        $(byClassName("Track_NotFound__6oaoY")).shouldBe(visible);
    }
}

