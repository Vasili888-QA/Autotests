package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            mainImageIFuture = $x("//h1//img[@alt='iFuture']"),
            openedNavigationBar = $x("//div[@id='menuToggle' and @class='active']"),
            menuNavigationBar = $x("//div[@id='menuToggle']");

    public MainPage openMainPage() {
        open("https://www.ifuture.by/");
        return this;
    }

    public void mainImageIFuture() {
        mainImageIFuture.shouldBe(visible);
    }

    public void menuNavigationBar() {
        menuNavigationBar.shouldBe(visible);
    }

    public void openNavigationBarAndCheckIt() {
        menuNavigationBar.click();
        openedNavigationBar.shouldBe(visible);
    }
}