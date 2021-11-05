package cloud.autotests.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openMainPage() {
        open("https://www.ifuture.by/");
        return this;
    }

    public void mainImageIFuture() {
        $x("//h1//img[@alt='iFuture']").shouldBe(visible);
    }
}
