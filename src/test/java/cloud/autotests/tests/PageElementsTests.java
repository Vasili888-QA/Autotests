package cloud.autotests.tests;

import cloud.autotests.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Epic("Check iFuture site")
@Feature("1 - Elements on Page")
@DisplayName("Page Elements")
@Tag("regress")
public class PageElementsTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Description("Check Elements on the main page")
    @DisplayName("All main elements on header are appeared")
    void elementsTest() {
        step("Open iFuture.by", () ->
                mainPage.openMainPage());

        step("Main image is appeared 'iFuture'", () ->
                mainPage.mainImageIFuture());

        step("Menu navigation bar is appeared", () ->
                mainPage.menuNavigationBar());
    }
}
