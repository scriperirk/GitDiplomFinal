package AndroidTest.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static AndroidTest.pages.AboutPage.versionInfo;
import static AndroidTest.pages.AboutPage.versionText;
import static AndroidTest.pages.AboutPage.webPageExistence;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;

public class AboutPageSteps {

  /* Шаги для тестирования страницы О приложении */
  @Step("Проверяем информацию о версии приложения")
  public static void isAppVersion() {
    Allure.step("Проверяем информацию о версии приложения");
    versionText.check(matches(allOf(isDisplayed(), withText(Matchers.not("")))));
    versionInfo.check(matches(allOf(isDisplayed(), withText(Matchers.not("")))));
  }

  @Step("Проверяем ссылкe Политики конфедециальности")
  public static void isWebPagePrivacyPolicy() {
    Allure.step("Проверяем ссылкe Политики конфедециальности");
    webPageExistence("https://vhospice.org/#/privacy-policy/");
  }

  @Step("Проверяем ссылку Правила использования")
  public static void isWebPageRulesOfUse() {
    Allure.step("Проверяем ссылку Правила использования");
    webPageExistence("https://vhospice.org/#/terms-of-use");
  }
}
