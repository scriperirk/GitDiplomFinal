package AndroidTest.steps;

import static AndroidTest.pages.HomePage.logOut;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;


public class ExitSteps {

  /* Шаги для тестирования кнопки выхода */
  @Step("Проверка выполнения выхода из учетной записи")
  public static void logOutFromApp() {
    Allure.step("Проверка выполнения выхода из учетной записи");
    logOut();
  }
}
