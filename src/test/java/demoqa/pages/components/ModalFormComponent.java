package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalFormComponent {

    private SelenideElement resultTable = $(".table-responsive");

    public void verifyLabelValue(String label, String value){
        resultTable.$(byText(label)).sibling(0).shouldHave(text(value));

    }
}
