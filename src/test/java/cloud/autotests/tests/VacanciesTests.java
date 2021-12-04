package cloud.autotests.tests;

import cloud.autotests.helpers.Layer;
import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.VacanciesPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Layer("WEB")
@Epic("Check iFuture site")
@Feature("3 - Vacancies")
@DisplayName("Vacancies Page Elements")
@Tag("regress")
public class VacanciesTests extends TestBase {
    MainPage mainPage = new MainPage();
    VacanciesPage vacanciesPage = new VacanciesPage();

    @Test
    @Description("Check Elements on the Vacancies Page")
    @DisplayName("All main elements on page Vacancies are appeared")
    void elementsTest() {
        step("Open iFuture.by", () ->
                mainPage.openMainPage());

        step("Main image is appeared 'iFuture'", () ->
                mainPage.mainImageIFuture());

        step("Open Menu navigation bar", () ->
                mainPage.openNavigationBarAndCheckIt());

        step("Tab Vacancies is appeared", () ->
                vacanciesPage.tabVacancies());

        step("Click on Vacancies", () ->
                vacanciesPage.clickTabVacancies());

        step("All Elements are appeared", () ->
                vacanciesPage.elementsPageVacancies());
    }
}
