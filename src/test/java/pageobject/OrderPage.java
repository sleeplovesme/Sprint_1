package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.startsWith;

public class OrderPage {

    // локатор поля для ввода (кроме метро)
    @FindBy(how = How.CLASS_NAME,using = "Input_Responsible__1jDKN")
    private ElementsCollection nameInput;
    // локатор поля для ввода станции метро
    @FindBy(how = How.CLASS_NAME,using = "select-search__input")
    private SelenideElement nameMetroInput;
    // локатор поля для выбора станции метро
    @FindBy(how = How.CLASS_NAME,using = "select-search__row")
    private SelenideElement selectMetroInput;
    // локатор кнопок (Далее, Заказать, Да)
    @FindBy(how = How.CLASS_NAME,using = "Button_Middle__1CSJM")
    private ElementsCollection nextButton;
    // локатор инпутов на 2ой странице заказа
    @FindBy(how = How.CLASS_NAME,using = "Input_Responsible__1jDKN")
    private ElementsCollection nameInputSecondPage;
    // локатор выбранного дня
    @FindBy(how = How.CLASS_NAME,using = "react-datepicker__day--selected")
    private SelenideElement selectedDate;
    // локатор дропдауна (кликнуть на сам дропдаун)
    @FindBy(how = How.CLASS_NAME,using = "Dropdown-control")
    private SelenideElement dropdownControl;
    // локатор дропдауна (выбрать из списка)
    @FindBy(how = How.CLASS_NAME,using = "Dropdown-option")
    private ElementsCollection dropdownOption;
    // локатор чекбокса Черный
    @FindBy(how = How.ID,using = "black")
    private SelenideElement blackCheckBox;
    // локатор чекбокса Черный
    @FindBy(how = How.ID,using = "grey")
    private SelenideElement greyCheckBox;
    // локатор успешного заказа
    @FindBy(how = How.CLASS_NAME,using = "Order_ModalHeader__3FDaJ")
    private SelenideElement orderPlaced;
    // локатор текста об ошибке
    @FindBy(how = How.CLASS_NAME,using = "Input_Visible___syz6")
    private ElementsCollection errorMessage;
    // локатор текста об ошибке поля метро
    @FindBy(how = How.CLASS_NAME,using = "Order_MetroError__1BtZb")
    private SelenideElement errorMessageMetro;

    // метод для ввода Имени
    public void setName(String inputName) {
        nameInput.get(0).setValue(inputName);
    }
    // метод для ввода Фамилии
    public void setSurname(String inputSurname) {
        nameInput.get(1).setValue(inputSurname);
    }
    // метод для ввода Адреса
    public void setAddress(String inputAddress) {
        nameInput.get(2).setValue(inputAddress);
    }
    // метод для ввода Адреса
    public void setPhoneNumber(String inputPhoneNumber) {
        nameInput.get(3).setValue(inputPhoneNumber);
    }
    // ввести название станции
    public void setNameMetroInput(String nameMetroStation) {
        nameMetroInput.setValue(nameMetroStation);
    }
    // Выбрать пункт из выпадайки
    public void clickSelectMetroInput() {
        selectMetroInput.click();
    }
    // кликнуть Далее
    public void clickNextButton() {
        nextButton.get(0).click();
    }
    // кликнуть Заказать
    public void clickOrderButton() {
        nextButton.get(1).click();
    }
    // кликнуть Да
    public void clickYesButton() {
        nextButton.get(3).click();
    }

    // метод для ввода даты заказа
    public void setOrderDate(String inputNameSecondPage) {
        nameInputSecondPage.get(0).setValue(inputNameSecondPage);
    }
    // метод для ввода комментария
    public void setComment(String inputNameSecondPage) {
        nameInputSecondPage.get(1).setValue(inputNameSecondPage);
    }
    // кликнуть на выбранной дате
    public void clickSelectedDate() {
        selectedDate.click();
    }
    // кликнуть на дропдауне
    public void clickDropdownControl() {
        dropdownControl.click();
    }
    // метод выбора дропдауна (колв-во суток)
    public void setAndClickDropdownElement() {
        dropdownOption.get(0).click();
    }
    // кликнуть на чекбоксе (черный)
    public void clickBlackCheckBox() {
        blackCheckBox.click();
    }
    // кликнуть на чекбоксе (серый)
    public void clickGreyCheckBox() {
        greyCheckBox.click();
    }
    // сравнить текст (Успешный заказ)
    public void compareTextOrderPlaced(String foundText) {
        MatcherAssert.assertThat(orderPlaced.getText(), startsWith(foundText));
    }
    // отображается ли ошибка "Введите корректное имя"
    public void isVisibleErrorTextName() {
        errorMessage.get(0).shouldBe(visible);
    }
    // отображается ли ошибка "Введите корректную фамилию"
    public void isVisibleErrorTextSurname() {
        errorMessage.get(1).shouldBe(visible);
    }
    // отображается ли ошибка "Введите корректный адрес"
    public void isVisibleErrorTextAddress() {
        errorMessage.get(2).shouldBe(visible);
    }
    // отображается ли ошибка "Введите корректный номер"
    public void isVisibleErrorTextPhoneNumber() {
        errorMessage.get(3).shouldBe(visible);
    }
    // отображается ли ошибка "Выберите станцию"
    public void isVisibleErrorMessageMetro() {
        errorMessageMetro.shouldBe(visible);
    }

    // метод ожидания загрузки страницы
    public void waitForLoadOrderPage(){
        $(byClassName("Order_Content__bmtHS")).shouldBe(visible);
    }
}
