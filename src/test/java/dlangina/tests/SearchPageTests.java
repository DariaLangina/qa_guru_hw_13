package dlangina.tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchPageTests extends TestBase {

  @Tag("regress")
  @DisplayName("Проверка блока контактов на странице c результатами поиска - найдено больше 0")
  @Test
  void checkContactsBlockOnSearchResultPage() {
    step("Открытие главной страницы", () ->
        open("https://new.rvision.ru/"));
    step("Закрытие модального окна 'Мы используем Cookie'", () ->
        $(".t-modal__close-cookie").click());
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
}

