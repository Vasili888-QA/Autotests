package cloud.autotests.tests;

import cloud.autotests.tests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Epic("Check iFuture site")
@Feature("2 - About Us")
@DisplayName("About Us Page Elements")
@Tag("regress")
public class AboutUsTests extends TestBase{
    MainPage mainPage = new MainPage();

    @Test
    @Description("Check Elements on the About Us Page")
    @DisplayName("All main elements are appeared")
    @Order(4)
    void elementsTest() {
        step("Open iFuture.by", () ->
                mainPage.openMainPage());

        step("Main image is appeared 'iFuture'", () -> {
            $x("//h1//img[@alt='iFuture']").shouldBe(visible);
        });

        step("Open Menu navigation bar", () -> {
            $x("//div[@id='menuToggle']").click();
            $x("//div[@id='menuToggle' and @class='active']").shouldBe(visible);
        });

        step("Tab About Us is appeared", () -> {
            $x("//a[@href='about']").shouldHave(text("О Нас"));
        });

        step("Click on About Us", () ->
            $x("//a[@href='about']").click());

        step("All Elements are appeared", () -> {
            $x("//section[@class='advantages']//div[@class='container']//h3").shouldHave(text("Наши преимущества"));
            $x("//section[@class='advantages']//div[@id='carousel-advantages']").shouldBe(visible);
        });
    }
}
