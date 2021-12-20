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

@Epic("Контакты")
@Feature("Страница 'Контакты")
@Story("Информация")
@Tag("smoke")
public class ContactPageTests extends TestBase {

  @AllureId("6248")
  @DisplayName("Проверка информации в блоке 'Консультация по продуктам'")
  @Test
  void checkInfoOnContactPage() {
    step("Открытие страницы 'Контакты'", () ->
        open("https://rvision.pro/kontakty/"));
    step("Проверка компонентов информационного блока", () -> {
      $(".vc_section", 0)
          .shouldBe(visible)
          .shouldHave(text("Консультация по продуктам"))
          .shouldHave(text(
              "Чтобы получить консультацию по продукту или коммерческое предложение, отправьте запрос по адресу:"));
    });
  }
}
