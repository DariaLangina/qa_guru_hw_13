package dlangina.tests;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Продукты")
@Feature("Информация о продукте")
@Story("Блок информации о продукте")
@Tag("smoke")
public class PageIntroTests extends TestBase {

  @AllureId("#6217")
  @DisplayName("Проверка компонентов информационного блока продукта R‑Vision SENSE")
  @Test
  void checkInfoBlockComponentsForSense() {
    step("Открытие страницы продукта R‑Vision SENSE", () ->
        open("https://new.rvision.ru/products/sgrc"));
    step("Проверка компонентов информационного блока", () -> {
      $(".page-intro__title")
          .shouldBe(Condition.visible)
          .shouldHave(Condition.exactText("R‑Vision SGRC"));
      $(".page-intro__desc")
          .shouldBe(Condition.visible)
          .shouldHave(Condition.exactText(
              "Автоматизация управления информационной безопасностью, рисками и соответствия требованиям"));
      $(".page-intro__content")
          .shouldHave(text("Материалы"))
          .shouldHave(text("Запросить демо"));
    });
  }

  @AllureId("6218")
  @DisplayName("Проверка перехода на блок 'Запрос на демо' по нажатию кнопки 'Запросить демо'")
  @Test
  void checkScrollingToDemoBlockByClickButton() {
    step("Открытие страницы продукта R‑Vision SENSE", () -> {
      open("https://new.rvision.ru/products/sgrc");
      $("#demomodal").shouldBe(attribute("data-animate", "false"));
    });
    step("Нажатие кнопки 'Запросить демо'", () ->
        $(".page-intro__content").$(byText("Запросить демо")).click());
    step("Проверка отображения блока 'Запросить демо'", () ->
        $("#demomodal").shouldBe(attribute("data-animate", "true")));
  }

  @AllureId("6219")
  @Tag("smoke")
  @DisplayName("Проверка перехода на блок 'Материалы' по нажатию кнопки 'Материалы'")
  @Test
  void checkScrollingToMaterialsBlockByClickButton() {
    step("Открытие страницы продукта R‑Vision SENSE", () -> {
      open("https://new.rvision.ru/products/sgrc");
      $("#productmaterials").shouldBe(attribute("data-animate", "false"));
    });
    step("Нажатие кнопки 'Материалы'", () ->
        $(".page-intro__content").$(byText("Материалы")).click());
    step("Проверка отображения блока 'Материалы'", () ->
        $("#productmaterials").shouldBe(attribute("data-animate", "true")));
  }
}