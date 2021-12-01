package cloud.autotests.tests.demowebshop;

import cloud.autotests.config.demowebshop.App;
import cloud.autotests.helpers.AllureRestAssuredFilter;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("DemoWebShop")
@Feature("Wishlist Tests")
@DisplayName("Wishlist Tests")
@Tag("regress")
public class WishlistTests {
    @Test
    @Story("Add product to Wishlist")
    @Tag("demowebshop")
    @DisplayName("Add product to Wishlist (API + UI)")
    void addProductToWishlistTest() {
        step("Get cookie by api and set it to browser", () -> {
            String authorizationCookie =
                    given()
                            .filter(AllureRestAssuredFilter.withCustomTemplates())
                            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                            .formParam("Email", App.config.userLogin())
                            .formParam("Password", App.config.userPassword())
                            .when()
                            .post("/login")
                            .then()
                            .statusCode(302)
                            .extract()
                            .cookie("NOPCOMMERCE.AUTH");

            step("Open minimal content, because cookie can be set when site is opened", () ->
                    open("/Themes/DefaultClean/Content/images/logo.png"));

            step("Set cookie to to browser", () ->
                    getWebDriver().manage().addCookie(
                            new Cookie("NOPCOMMERCE.AUTH", authorizationCookie)));
        });

        step("Add product to Wishlist", () -> {
            given()
                    .filter(AllureRestAssuredFilter.withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .formParam("EnteredQuantity", 1)
                    .when()
                    .post("/addproducttocart/details/14/2")
                    .then()
                    .statusCode(200)
                    .body("success", is(true),
                            "updatetopwishlistsectionhtml", is("(1)"));});

        step("Open Wishlist page", () ->{
            given()
                    .get("/wishlist")
                    .then()
                    .statusCode(200);});

        open("/wishlist");
        Selenide.$x("//span[@class='wishlist-qty']").shouldHave(text("(1)"));
    }
}
