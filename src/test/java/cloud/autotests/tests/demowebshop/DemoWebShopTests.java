package cloud.autotests.tests.demowebshop;

import cloud.autotests.config.demowebshop.App;
import cloud.autotests.helpers.AllureRestAssuredFilter;
import cloud.autotests.helpers.allureAnnotations.Layer;
import cloud.autotests.helpers.allureAnnotations.Microservice;
import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Microservice("Shop")
@Epic("DemoWebShop")
@Feature("All Tests on Demo Web Shop site")
@DisplayName("All Tests on DemoWebShop site")
@Tag("regress")
public class DemoWebShopTests extends TestBase {

    @BeforeAll
    static void configureBaseUrl() {
        RestAssured.baseURI = App.config.apiUrl();
        Configuration.baseUrl = App.config.webUrl();
    }

    @Layer("WEB")
    @Order(1)
    @Test
    @AllureId("5997")
    @Tag("demowebshop")
//    @Disabled("Example")
    @DisplayName("Successful authorization on DemoWebShop (UI)")
    void loginTest() {
        step("Open login page", () ->
                open("/login"));

        step("Fill login form", () -> {
            $("#Email").setValue(App.config.userLogin());
            $("#Password").setValue(App.config.userPassword())
                    .pressEnter();
        });

        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(App.config.userLogin())));
    }

    @Layer("API")
    @Order(2)
    @Test
    @AllureId("5996")
    @Tag("demowebshop")
    @DisplayName("Successful authorization on DemoWebShop (API + UI)")
    void loginWithCookieTest() {
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

        step("Open main page", () ->
                open(""));

        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(App.config.userLogin())));
    }

    @Test
    @Layer("API")
    @Order(3)
    @AllureId("5995")
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

        step("Add product to Wishlist by API", () -> {
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
