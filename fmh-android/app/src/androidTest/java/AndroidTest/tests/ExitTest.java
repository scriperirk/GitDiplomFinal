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
import AndroidTest.steps.ExitSteps;
import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;

@Epic("Тестирование кнопки выхода")
@RunWith(AllureAndroidJUnit4.class)

public class ExitTest {

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
  @DisplayName("Ат14 Выполняем выход из учетной записи")
  public void logOutButton() {
    AutorizationPageSteps.login(correctLogin, correctPassword);
    waitElement(LogOutId);
    ExitSteps.logOutFromApp();
  }

}
