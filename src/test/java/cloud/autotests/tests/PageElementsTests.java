package cloud.autotests.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("Check iFuture site")
@Feature("Elements on Page")
@DisplayName("Page Elements")
@Tag("regress")
public class PageElementsTests extends TestBase {
    @Test
    @Description("Check Elements on the main page")
    @DisplayName("All main elements are appeared")
    @Order(3)
    void elementsTest() {
        step("Open iFuture.by", () ->
                open("https://www.ifuture.by/"));

        step("Main image is appeared 'iFuture'", () -> {
            $x("//h1//img[@alt='iFuture']").shouldBe(visible);
        });

        step("Menu navigation bar is appeared", () -> {
            $x("//div[@id='menuToggle']").shouldBe(visible);
        });
    }
}
