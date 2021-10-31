package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Check iFuture site")
@Feature("Elements on Page")
@DisplayName("Title")
@Tag("regress")
public class GeneratedTests extends TestBase {
    @Test
    @Description("Check title on the main page")
    @DisplayName("iFuture.by is appeared")
    void generatedTest() {
        step("Open iFuture.by", () ->
                open("https://www.ifuture.by/"));

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
                open("https://www.ifuture.by/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}