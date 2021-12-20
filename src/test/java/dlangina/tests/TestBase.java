package dlangina.tests;

import static java.lang.String.format;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import dlangina.config.SelenoidConfig;
import dlangina.helpers.Attach;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

@ExtendWith({AllureJunit5.class})
public class TestBase {

  @BeforeAll
  public static void config() {
    SelenoidConfig selenoid = ConfigFactory.create(SelenoidConfig.class);
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    Configuration.startMaximized = true;
//    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    Configuration.remote = format("https://%s:%s@%s", selenoid.login(),
                                  selenoid.password(), System.getProperty("selenoidUrl")
                                 );

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;
  }

  @AfterEach
  public void tearDown() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }
}

