package dlangina.tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Поиск по сайту")
@Feature("Отображение блока контактов")
@Story("Страница результатов поиска")
@Tag("regress")
public class SearchPageTests extends TestBase {

  @AllureId("6215")
  @Tag("contacts")
  @DisplayName("Проверка блока контактов на странице c результатами поиска - найдено больше 0")
  @Test
  void checkContactsBlockOnSearchResultPage() {
    step("Открытие главной страницы", () ->
        open("https://new.rvision.ru/"));
    step("Нажатие иконки поиска", () ->
        $(".t-header-search__btn").shouldBe(visible).click());
    step("Поиск по запросу 'R-Vision'", () -> {
      $(".t-header-search__input").setValue("R-Vision").pressEnter();
      $(".contacts-block").shouldBe(visible);
    });
    step("Проверка блока контактов", () -> {
      $(".contacts-block__head").shouldHave(
          exactText("Не нашли то, что искали? Обратитесь по указанным контактам"));
      $(".contacts-block ")
          .shouldHave(text("Телефон"))
          .shouldHave(text("+7 (499) 322-80-40"))
          .shouldHave(text("email"))
          .shouldHave(text("rvision@rvision.pro"));
    });
  }

  @AllureId("6216")
  @Tag("contacts")
  @DisplayName("Проверка блока контактов на странице c результатами поиска- найдено 0 результатов")
  @Test
  void checkContactsBlockOnSearchResultPageNoResults() {
    step("Открытие главной страницы", () ->
        open("https://new.rvision.ru/"));
    step("Нажатие иконки поиска", () ->
        $(".t-header-search__btn").shouldBe(visible).click());
    step("Поиск по запросу 'R-Vision'", () -> {
      $(".t-header-search__input").setValue("noResults").pressEnter();
      $(".contacts-block").shouldBe(visible);
    });
    step("Проверка блока контактов", () -> {
      $(".contacts-block__head").shouldHave(
          exactText("Не нашли то, что искали? Обратитесь по указанным контактам"));
      $(".contacts-block ")
          .shouldHave(text("Телефон"))
          .shouldHave(text("+7 (499) 322-80-40"))
          .shouldHave(text("email"))
          .shouldHave(text("rvision@rvision.pro"));
    });
  }
}

