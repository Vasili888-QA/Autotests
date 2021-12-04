package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import cloud.autotests.helpers.allureAnnotations.Layer;
import cloud.autotests.helpers.allureAnnotations.Microservice;
import cloud.autotests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Layer("WEB")
@Microservice("Management")
@Owner("Vasili")
@Epic("Check iFuture site")
@Feature("1 - Elements on Page")
@DisplayName("Title")
@Tag("regress")
public class MainTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Description("Check title on the main page")
    @DisplayName("iFuture.by is appeared")
    void generalTest() {
        step("Open iFuture.by", () ->
                mainPage.openMainPage());

        step("Page title should have text 'iFuture.by'", () -> {
            String expectedTitle = "iFuture.by";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Check console logs")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open iFuture.by", () ->
                mainPage.openMainPage());

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}