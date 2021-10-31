package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import cloud.autotests.tests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Check iFuture site")
@Feature("1 - Elements on Page")
@DisplayName("Title")
@Tag("regress")
public class MainTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Description("Check title on the main page")
    @DisplayName("iFuture.by is appeared")
    @Order(1)
    void generatedTest() {
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
    @Order(2)
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