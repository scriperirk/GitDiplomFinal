package AndroidTest.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static AndroidTest.data.DataHelper.waitElement;
import static AndroidTest.data.DataHelper.waitUntilVisible;
import static AndroidTest.pages.AutorizationPage.loginButton;
import static AndroidTest.pages.AutorizationPage.loginField;
import static AndroidTest.pages.AutorizationPage.passwordField;
import static AndroidTest.pages.HomePage.logOutButton;

import AndroidTest.data.DataHelper;
import AndroidTest.pages.AutorizationPage;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AutorizationPageSteps {

  /* Шаги для тестирования авторизации */
  @Step("Ввод логина и пароля")
  public static void login(String login, String password) {
    Allure.step("Ввод логина " + login + " и пароля " + password);
    waitElement(AutorizationPage.idSignInButton);
    loginField.perform(replaceText(login));
    passwordField.perform(replaceText(password));
    loginButton.check(matches(isDisplayed())).perform(click());
  }

  @Step("Открытия страницы Main")
  public static void logOutIsVisible() {
    Allure.step("Открытия страницы Main и видимость кнопки выхода");
    logOutButton.check(matches(isDisplayed()));
  }

  @Step("Проверка сообщения о незаполненных логина или пароля")
  public static void loginOrPasswordDoesntBeEmpty() {
    Allure.step("Проверка сообщения о незаполненных логина или пароля");
    waitUntilVisible(DataHelper.checkToast(R.string.empty_login_or_password, true));
  }

  @Step("Проверка сообщения о неверном логине или пароле")
  public static void loginOrPasswordIsWrong() {
    Allure.step("Проверка сообщения о неверном логине или пароле");
    waitUntilVisible(DataHelper.checkToast(R.string.wrong_login_or_password, true));
  }

}
