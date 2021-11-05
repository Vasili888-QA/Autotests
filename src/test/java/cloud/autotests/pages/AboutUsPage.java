package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AboutUsPage {
    private final SelenideElement
            tabAboutUs = $x("//a[@href='about']"),
            carouselAdvantages = $x("//section[@class='advantages']//div[@id='carousel-advantages']"),
            sectionAdvantages = $x("//section[@class='advantages']//div[@class='container']//h3");

    public void tabAboutUs() {
        tabAboutUs.shouldHave(text("О Нас"));
    }

    public void clickTabAboutUs() {
        tabAboutUs.click();
    }

    public void elementsPageAboutUs() {
        sectionAdvantages.shouldHave(text("Наши преимущества"));
        carouselAdvantages.shouldBe(visible);
    }
}
