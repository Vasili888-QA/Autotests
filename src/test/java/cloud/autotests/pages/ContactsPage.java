package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class ContactsPage {
    private final SelenideElement
            tabContacts = $x("//a[@href='contacts']"),
            phone = $x("//div[contains(@class,'phone')]//a"),
            email = $x("//div[contains(@class,'email')]//a");

    public void tabContacts() {
        tabContacts.shouldHave(text("Контакты"));
    }

    public void clickTabContacts() {
        tabContacts.click();
    }

    public void elementsPageContacts() {
        phone.shouldHave(text("+ 375 (29) 176-90-93"));
        email.shouldHave(text("hr@ifuture.by"));
    }
}
