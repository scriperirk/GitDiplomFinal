package AndroidTest.tests;

import static AndroidTest.data.DataHelper.getUniqueScreenshotName;
import static AndroidTest.pages.AutorizationPage.checkLogInAndLogInIfNot;
import static AndroidTest.steps.AboutPageSteps.isAppVersion;
import static AndroidTest.steps.AboutPageSteps.isWebPagePrivacyPolicy;
import static AndroidTest.steps.AboutPageSteps.isWebPageRulesOfUse;
import static AndroidTest.steps.BaseSteps.goToAboutPageStep;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;

@Epic("Тестирование страницы О приложении")
@RunWith(AllureAndroidJUnit4.class)

public class AboutPageTest {

  @Before
  public void setUp() {
    checkLogInAndLogInIfNot();
    goToAboutPageStep();
  }

  @Rule
  public ActivityScenarioRule<AppActivity> myActivityScenarioRule =
      new ActivityScenarioRule<>(AppActivity.class);

  @Rule
  public ScreenshotRule screenshotRule =
      new ScreenshotRule(ScreenshotRule.Mode.FAILURE, getUniqueScreenshotName());

  @Test
  @DisplayName("Ат7 Проверка веб-страницы о версии приложения")
  public void testIsAppVersion() {
    isAppVersion();
  }

  @Test
  @DisplayName("Ат8 Проверка веб-страницы с политикой конфиденциальности")
  public void testWebPrivacyPolicyPage() {
    isWebPagePrivacyPolicy();
  }

  @Test
  @DisplayName("Ат9 Проверка веб-страницы с правилами использования")
  public void testWebPageRulesOfUse() {
    isWebPageRulesOfUse();
  }
}
