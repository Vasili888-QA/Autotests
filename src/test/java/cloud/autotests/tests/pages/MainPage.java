package cloud.autotests.tests.pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openMainPage() {
        open("https://www.ifuture.by/");
        return this;
    }
}
