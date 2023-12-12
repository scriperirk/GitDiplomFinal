package AndroidTest.tests;

import static AndroidTest.pages.AutorizationPage.checkLogInAndLogInIfNot;
import static AndroidTest.data.DataHelper.getUniqueScreenshotName;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import AndroidTest.steps.HomePageSteps;
import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;

@Epic("Тестирование главной страницы")
@RunWith(AllureAndroidJUnit4.class)

public class HomePageTest {

  @Before
  public void setUp() {
    checkLogInAndLogInIfNot();
  }

  @Rule
  public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
      new ActivityScenarioRule<>(AppActivity.class);

  @Rule
  public ScreenshotRule screenshotRule =
      new ScreenshotRule(ScreenshotRule.Mode.FAILURE, getUniqueScreenshotName());

  @Test
  @DisplayName("Ат10 Переходим в раздел Новости с помощью бокового меню")
  public void goToNewsInTheSideMenu() {
    HomePageSteps.goToTheNewsSectionUsingTheSideMenu();
    HomePageSteps.isButtonСheckNews();
  }
}
