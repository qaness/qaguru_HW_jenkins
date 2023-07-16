package demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.pages.RegistrationPage;
import demoqa.utils.TestsRandomData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakeDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestsRandomData randomValue = new TestsRandomData();

    @Test
    @Tag("remote")
    public void successfulRegistrationTest() {

        String picture = "example.png";

        registrationPage.openPage()
                //Input fields
                .setFirstName(randomValue.firstName)
                .setLastName(randomValue.lastName)
                .setUserEmail(randomValue.userEmail)
                .setUserNumber(randomValue.userNumber)
                .setCurrentAddress(randomValue.currentAddress)

                //Radio & checkbox
                .setGender(randomValue.gender)
                .setHobbies(randomValue.hobbies)

                // Date & drop-down
                .setBirthDay(randomValue.birthdayDay, randomValue.birthdayMonth, randomValue.birthdayYear)
                .setSubjects(randomValue.subject)
                .setStateAndCity(randomValue.state, randomValue.city)

                //Upload Image field
                .uploadPicture(picture)

                //submit
                .submitForm()

                // assertions
                .checkResultFormAppeared()
                .validateItemsInForm("Student Name", randomValue.firstName + " " + randomValue.lastName)
                .validateItemsInForm("Student Email", randomValue.userEmail)
                .validateItemsInForm("Gender", randomValue.gender)
                .validateItemsInForm("Mobile", randomValue.userNumber)
                .validateItemsInForm("Date of Birth", randomValue.birthdayDay +
                                    " " + randomValue.birthdayMonth +
                                    "," + randomValue.birthdayYear)
                .validateItemsInForm("Subjects", randomValue.subject)
                .validateItemsInForm("Hobbies", randomValue.hobbies)
                .validateItemsInForm("Picture", picture )
                .validateItemsInForm("Address", randomValue.currentAddress)
                .validateItemsInForm("State and City", randomValue.state + " " + randomValue.city);
    }

}
