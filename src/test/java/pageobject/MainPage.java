package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    // Header
    // локатор иконки Яндекс
    @FindBy(how = How.CLASS_NAME,using = "Header_LogoYandex__3TSOI")
    private SelenideElement logoYandexIcon;
    // локатор иконки Самокат
    @FindBy(how = How.CLASS_NAME,using = "Header_LogoScooter__3lsAR")
    private SelenideElement logoScooterIcon;
    // локатор иконки Учебный тренажер
    @FindBy(how = How.CLASS_NAME,using = "Header_Disclaimer__3VEni")
    private SelenideElement trainingSimulatorIcon;
    // локатор кнопки Заказать
    @FindBy(how = How.CLASS_NAME,using = "Button_Button__ra12g")
    private SelenideElement orderButton;
    // локатор кнопки Статус Заказа
    @FindBy(how = How.CLASS_NAME,using = "Header_Link__1TAG7")
    private SelenideElement orderStatusButton;
    // локатор инпута номера заказа
    @FindBy(how = How.CLASS_NAME,using = "Input_Input__1iN_Z")
    private SelenideElement orderStatusInput;
    // локатор кнопки Go
    @FindBy(how = How.CLASS_NAME,using = "Header_Button__28dPO")
    private SelenideElement goButton;


    // FirstPart
    // локатор текста Самокат на пару дней (Header)
    @FindBy(how = How.CLASS_NAME,using = "Home_Header__iJKdX")
    private SelenideElement headerText;
    // локатор subHeader
    @FindBy(how = How.CLASS_NAME,using = "Home_SubHeader__zwi_E")
    private SelenideElement subHeaderText;

    // локатор таблицы характеристик самоката
    @FindBy(how = How.CLASS_NAME,using = "Home_Table__2kPxP")
    private SelenideElement homeTable;
    // локатор название модели самоката
    @FindBy(how = How.CLASS_NAME,using = "Home_Column__xlKDK")
    private SelenideElement modelScooter;
    // локатор пункта таблицы
    @FindBy(how = How.CLASS_NAME,using = "Home_Row__jdQW2")
    private SelenideElement tableItem;
    // локатор подпункта таблицы
    @FindBy(how = How.CLASS_NAME,using = "Home_Column__xlKDK")
    private SelenideElement tableSubItem;


    // SecondPart


    // ThirdPart
    // локатор текста Как это работает
    @FindBy(how = How.CLASS_NAME,using = "Home_SubHeader__zwi_E")
    private SelenideElement HowItWorksText;
    // локатор RoadMap
    @FindBy(how = How.CLASS_NAME,using = "Home_RoadMap__2tal_")
    private SelenideElement roadMap;
    // локатор statusCircleRoadMap
    @FindBy(how = How.CLASS_NAME,using = "Home_StatusCircle__3_aTp")
    private ElementsCollection statusCircleRoadMap;
    // локатор действие в RoadMap
    @FindBy(how = How.CLASS_NAME,using = "Home_Status__YkfmH")
    private ElementsCollection actionRoadMap;
    // локатор описание RoadMap
    @FindBy(how = How.CLASS_NAME,using = "Home_StatusDescription__3WGl5")
    private ElementsCollection statusDescriptionRoadMap;
    // локатор описание второй кнопи Заказать
    @FindBy(how = How.CLASS_NAME,using = "Button_Middle__1CSJM")
    private SelenideElement orderSecondButton;


    // FourPart
    // локатор текста Вопросы о важном
    @FindBy(how = How.CLASS_NAME,using = "Home_SubHeader__zwi_E")
    private SelenideElement questionsAboutImportantText;
    // локатор пункта аккордеона
    @FindBy(how = How.CLASS_NAME,using = "accordion__heading")
    private ElementsCollection accordionHeading;
    // локатор панели (ответа) пункта аккордеона
    @FindBy(how = How.CLASS_NAME,using = "accordion__panel")
    private ElementsCollection accordionPanel;


    // Cookies
    // локатор текста куки
    @FindBy(how = How.CLASS_NAME,using = "App_CookieText__1sbqp")
    private SelenideElement cookieText;
    // локатор кнопки куки (Да все привыкли)
    @FindBy(how = How.CLASS_NAME,using = "App_CookieButton__3cvqF")
    private SelenideElement cookieButton;


    // геттер элемента аккордеона
    public SelenideElement getAccordionHeading(int i) {
        return accordionHeading.get(i).scrollTo();
    }
    // метод нажатия на пункт аккордеона
    public void clickAccordionElement(int i) {
        accordionHeading.get(i).scrollTo().click();
    }
    // метод поиска и сравнения на соответствие искомому тексту
    public void compareText(int i, String expectedText) {
        accordionPanel.get(i).shouldBe(visible).shouldHave(exactText(expectedText));
    }

    // если куки видны, кликнуть их
    public void closeCookieMessage () {
        if (cookieButton.isDisplayed()) {
            cookieButton.click();
        }
    }

    // нажать Заказать (верхняя кнопка)
    public OrderPage clickOrderButton() {
        orderButton.click();
        // создаём экземпляр класса страницы заказа
        OrderPage orderPage = Selenide.page(OrderPage.class);
        // ожидаем загрузки страницы заказа
        orderPage.waitForLoadOrderPage();
        // возвращаем экземпляр класса главной страницы
        return orderPage;
    }
    // нажать Заказать (нижняя кнопка)
    public OrderPage clickOrderSecondButton() {
        orderSecondButton.click();
        // создаём экземпляр класса страницы заказа
        OrderPage orderPage = Selenide.page(OrderPage.class);
        // ожидаем загрузки страницы заказа
        orderPage.waitForLoadOrderPage();
        // возвращаем экземпляр класса главной страницы
        return orderPage;
    }
    // кликнуть иконку самоката
    public void clickLogoScooterIcon() {
        logoScooterIcon.click();
    }
    // кликнуть иконку яндекса
    public void clickLogoYandexIcon() {
        logoYandexIcon.click();
    }
    // кликнуть Статус заказа
    public void clickOrderStatusButton() {
        orderStatusButton.click();
    }
    // ввести номер заказа
    public void setOrderStatusInput(String expectedValue) {
        orderStatusInput.setValue(expectedValue);
    }
    // кликнуть кнопку Go
    public TrackPage clickGoButton() {
        goButton.click();
        // создаём экземпляр класса страницы заказа
        TrackPage trackPage = Selenide.page(TrackPage.class);
        // ожидаем загрузки страницы заказа
        trackPage.waitForLoadOrderPage();
        // возвращаем экземпляр класса главной страницы
        return trackPage;
    }



}
