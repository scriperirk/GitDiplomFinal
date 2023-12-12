package AndroidTest.tests;

import static AndroidTest.data.DataHelper.getUniqueScreenshotName;
import static AndroidTest.pages.AutorizationPage.checkLogInAndLogInIfNot;
import static AndroidTest.steps.BaseSteps.goToQuotesPageStep;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import AndroidTest.steps.BaseSteps;
import AndroidTest.steps.QuotesPageSteps;
import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;

@Epic("Тестирование страницы Цитаты")
@RunWith(AllureAndroidJUnit4.class)

public class QuotesPageTest {

  @Before
  public void setUp() {
    checkLogInAndLogInIfNot();
    goToQuotesPageStep();
  }

  @Rule
  public ActivityScenarioRule<AppActivity> myActivityScenarioRule =
      new ActivityScenarioRule<>(AppActivity.class);

  @Rule
  public ScreenshotRule screenshotRule =
      new ScreenshotRule(ScreenshotRule.Mode.FAILURE, getUniqueScreenshotName());

  @Test
  @DisplayName("Ат11 Открытие и отображение страницы Цитаты с помощью кнопки на главной странице")
  public void isItPossibleToGoToQuotesSectionWithMainPageButton() {
    QuotesPageSteps.goToQuotesPageWithPressButtonOnMainPage();
    QuotesPageSteps.isHeaderQuotesPageDisplayed();
  }

  @Test
  @DisplayName("Ат12 Проверка на разворачивание одной цитаты")
  public void testExpandQuote() {
    ViewInteraction recyclerView = QuotesPageSteps.getQuotesRecyclerViewAndScrollToFirstPosition();
    int heightBeforeClick = BaseSteps.getHeightBeforeClick(recyclerView);
    BaseSteps.clickFirstItem(recyclerView);
    int heightAfterClick = BaseSteps.getHeightAfterClick(recyclerView);
    BaseSteps.checkHeightAfterClick(heightBeforeClick, heightAfterClick);
  }

  @Test
  @DisplayName("Ат13 Проверка на сворачивание одной цитаты")
  public void testCollapseQuote() {
    ViewInteraction recyclerView = QuotesPageSteps.getQuotesRecyclerViewAndScrollToFirstPosition();
    int heightBeforeClick = BaseSteps.getHeightBeforeClick(recyclerView);
    BaseSteps.doubleClickFirstItem(recyclerView);
    int heightAfterDoubleClick = BaseSteps.getHeightAfterClick(recyclerView);
    BaseSteps.checkHeightAfterDoubleClick(heightBeforeClick, heightAfterDoubleClick);
  }
}
