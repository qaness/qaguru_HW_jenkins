package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ModalFormComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    ModalFormComponent resultForm = new ModalFormComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            genderWrapper = $("#genterWrapper"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            subjectWrapper = $("#subjectsWrapper"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            submitButton = $("#submit"),
            modalForm = $(".modal-dialog"),
            formTitle = $("#example-modal-sizes-title-lg");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmailInput.setValue(email);
        return this;

    }

    public RegistrationPage setUserNumber(String phoneNumber) {
        userNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;

    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;

    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String fullWord) {
        subjectInput.setValue(fullWord).pressEnter();
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String pictureName) {
        pictureInput.uploadFromClasspath(pictureName);
        return this;
    }

    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    //modal component with assertions

    public RegistrationPage checkResultFormAppeared() {
        modalForm.should(appear);
        formTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public RegistrationPage validateItemsInForm(String label, String value) {
        resultForm.verifyLabelValue(label, value);
        return this;
    }
}
