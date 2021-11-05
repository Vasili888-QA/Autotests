package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class VacanciesPage {
    private final SelenideElement
            tabVacancies = $x("//a[@href='vacancies']"),
            carouselVacancies = $x("//div[@class='vacancies']//div[@id='carousel-vacancies']"),
            vacanciesContainer = $x("//div[@class='vacancies']//div[@class='container']//h3");

    public void tabVacancies() {
        tabVacancies.shouldHave(text("Вакансии"));
    }

    public void clickTabVacancies() {
        tabVacancies.click();
    }

    public void elementsPageVacancies() {
        vacanciesContainer.shouldBe(exist);
        carouselVacancies.shouldBe(visible);
    }
}