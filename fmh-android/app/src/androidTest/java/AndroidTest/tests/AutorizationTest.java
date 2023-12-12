package AndroidTest.tests;

import static AndroidTest.data.Data.correctLogin;
import static AndroidTest.data.Data.correctPassword;
import static AndroidTest.data.DataHelper.getUniqueScreenshotName;
import static AndroidTest.data.DataHelper.waitElement;
import static AndroidTest.pages.AutorizationPage.checkLogOutAndLogOutIfNot;
import static AndroidTest.pages.HomePage.LogOutId;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import AndroidTest.steps.AutorizationPageSteps;
import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;


@Epic("Тестирование авторизации")
@RunWith(AllureAndroidJUnit4.class)

public class AutorizationTest {

  @Before
  public void setUp() {
    checkLogOutAndLogOutIfNot();
  }

  @Rule
  public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
      new ActivityScenarioRule<>(AppActivity.class);

  @Rule
  public ScreenshotRule screenshotRule =
      new ScreenshotRule(ScreenshotRule.Mode.FAILURE, getUniqueScreenshotName());

  @Test
  @DisplayName("Ат1 Авторизация с валидным логином и паролем")
  public void correctLoginAndPasswordAuthorizationTest() {
    AutorizationPageSteps.login(correctLogin, correctPassword);
    waitElement(LogOutId);
    AutorizationPageSteps.logOutIsVisible();
  }

  @Test
  @DisplayName("Ат2 Авторизация с не валидным логином и паролем")
  public void wrongLoginAndPasswordAuthorizationTest() {
    AutorizationPageSteps.login("login", "password");
    AutorizationPageSteps.loginOrPasswordIsWrong();
  }

  @Test
  @DisplayName("Ат3 Авторизация с использованием спецсимвола в логине или пароле")
  public void wrongLoginAndCorrectPasswordAuthorizationTest() {
    AutorizationPageSteps.login("login!", correctPassword);
    AutorizationPageSteps.loginOrPasswordIsWrong();
  }

  @Test
  @DisplayName("Ат4 Авторизация с пустым значением в логине или пароле")
  public void emptyLoginAndEmptyPasswordAuthorizationTest() {
    AutorizationPageSteps.login("", "");
    AutorizationPageSteps.loginOrPasswordDoesntBeEmpty();
  }

  @Test
  @DisplayName("Ат5 Авторизация со значением разного регистра в логине или пароле")
  public void differentLoginAndCorrectPasswordAuthorizationTest() {
    AutorizationPageSteps.login("LogIN", correctPassword);
    AutorizationPageSteps.loginOrPasswordIsWrong();
  }

  @Test
  @DisplayName("Ат6 Авторизация с использованием пробелов в логине или пароле")
  public void spaceAtTheEndLoginAndCorrectPasswordAuthorizationTest() {
    AutorizationPageSteps.login("login2 ", correctPassword);
    AutorizationPageSteps.loginOrPasswordIsWrong();
  }
}
