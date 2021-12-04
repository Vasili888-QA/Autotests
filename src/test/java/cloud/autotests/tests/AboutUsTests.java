package cloud.autotests.tests;

import cloud.autotests.helpers.allureAnnotations.Layer;
import cloud.autotests.helpers.allureAnnotations.Microservice;
import cloud.autotests.pages.AboutUsPage;
import cloud.autotests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Layer("WEB")
@Microservice("Management")
@Epic("Check iFuture site")
@Feature("2 - About Us")
@DisplayName("About Us Page Elements")
@Tag("regress")
public class AboutUsTests extends TestBase {
    MainPage mainPage = new MainPage();
    AboutUsPage aboutUsPage = new AboutUsPage();

    @Test
    @Description("Check Elements on the About Us Page")
    @DisplayName("All main elements on page About Us are appeared")
    void elementsTest() {
        step("Open iFuture.by", () ->
                mainPage.openMainPage());

        step("Main image is appeared 'iFuture'", () ->
                mainPage.mainImageIFuture());

        step("Open Menu navigation bar", () ->
                mainPage.openNavigationBarAndCheckIt());

        step("Tab About Us is appeared", () ->
                aboutUsPage.tabAboutUs());

        step("Click on About Us", () ->
                aboutUsPage.clickTabAboutUs());

        step("All Elements are appeared", () ->
                aboutUsPage.elementsPageAboutUs());
    }
}
