package dlangina.tests;

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

@Epic("Продукты")
@Feature("Информация о продукте")
@Story("Блок информации о продукте")
@Tag("smoke")
public class PageIntroTestsNew extends TestBase {

  @AllureId("6247")
  @DisplayName("Проверка компонентов информационного блока продукта R‑Vision SENSE")
  @Test
  void checkInfoBlockComponentsForSense() {
    step("Открытие страницы продукта R‑Vision SENSE", () ->
        open("https://rvision.pro/sense/"));
    step("Проверка компонентов информационного блока", () -> {
      $(".beautiful-title-container")
          .shouldBe(visible)
          .shouldHave(text("R-Vision SENSE"))
          .shouldHave(text("Аналитическая платформа кибербезопасности"));
    });
  }
}
