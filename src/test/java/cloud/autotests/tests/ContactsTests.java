package cloud.autotests.tests;

import cloud.autotests.pages.ContactsPage;
import cloud.autotests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("Check iFuture site")
@Feature("4 - Contacts")
@DisplayName("Contacts Page Elements")
@Tag("regress")
public class ContactsTests extends TestBase {
    MainPage mainPage = new MainPage();
    ContactsPage contactsPage = new ContactsPage();

    @Test
    @Description("Check Elements on the Contacts Page")
    @DisplayName("All main elements are appeared")
    void elementsTest() {
        step("Open iFuture.by", () ->
                mainPage.openMainPage());

        step("Main image is appeared 'iFuture'", () ->
                mainPage.mainImageIFuture());

        step("Open Menu navigation bar", () ->
                mainPage.openNavigationBarAndCheckIt());

        step("Tab Contacts is appeared", () ->
                contactsPage.tabContacts());

        step("Click on Contacts", () ->
                contactsPage.clickTabContacts());

        step("Phone and Email are appeared", () ->
                contactsPage.elementsPageContacts());
    }
}