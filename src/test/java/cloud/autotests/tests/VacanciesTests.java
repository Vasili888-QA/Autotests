package cloud.autotests.tests;

import cloud.autotests.tests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

@Epic("Check iFuture site")
@Feature("3 - Vacancies")
@DisplayName("Vacancies Page Elements")
@Tag("regress")
public class VacanciesTests extends TestBase{
    MainPage mainPage = new MainPage();

    @Test
    @Description("Check Elements on the Vacancies Page")
    @DisplayName("All main elements are appeared")
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

        step("Tab Vacancies is appeared", () -> {
            $x("//a[@href='vacancies']").shouldHave(text("Вакансии"));
        });

        step("Click on Vacancies", () ->
                $x("//a[@href='vacancies']").click());

        step("All Elements are appeared", () -> {
            $x("//div[@class='vacancies']//div[@class='container']//h3").shouldBe(exist);
            $x("//div[@class='vacancies']//div[@id='carousel-vacancies']").shouldBe(visible);
            $x("//div[@class='vacancies']//div[@id='carousel-vacancies']//h4").shouldHave(text("Senior Java Developer"));
        });
    }
}
