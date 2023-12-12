package AndroidTest.tests;

import static AndroidTest.data.DataHelper.getUniqueScreenshotName;
import static AndroidTest.pages.AutorizationPage.checkLogInAndLogInIfNot;
import static AndroidTest.steps.BaseSteps.goToNewsEditingPageStep;
import static AndroidTest.steps.BaseSteps.goToNewsPageStep;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import AndroidTest.steps.BaseSteps;
import AndroidTest.steps.NewsEditingPageSteps;
import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;

@Epic("Тестирование страницы редактирования новостей")
@RunWith(AllureAndroidJUnit4.class)

public class NewsEditingPageTest {

  @Before
  public void setUp() {
    checkLogInAndLogInIfNot();
    goToNewsPageStep();
    goToNewsEditingPageStep();
  }

  @Rule
  public ActivityScenarioRule<AppActivity> myActivityScenarioRule =
      new ActivityScenarioRule<>(AppActivity.class);

  @Rule
  public ScreenshotRule screenshotRule =
      new ScreenshotRule(ScreenshotRule.Mode.FAILURE, getUniqueScreenshotName());

  @Test
  @DisplayName("Ат19 Создание новости с валидными данными")
  public void testAddingNews() {
    NewsEditingPageSteps.addingNews();
    NewsEditingPageSteps.scrollToNewsWithTittleAndClick();
    NewsEditingPageSteps.editingNews();
    NewsEditingPageSteps.checkAttributesNews();
  }

  @Test
  @DisplayName("Ат20 Изменение статуса новости")
  public void testChangeNewsStatus() {
    NewsEditingPageSteps.addingNews();
    NewsEditingPageSteps.changeStatusNewsToNotActive();
    NewsEditingPageSteps.editingNews();
    NewsEditingPageSteps.checkNotActiveStatus();
  }

  @Test
  @DisplayName("Ат21 Создание новости с пустым полем заголовка")
  public void testRefusalAddingNewsWithEmptyFieldTittle() {
    NewsEditingPageSteps.addNewsWithEmptyFieldTittle();
    NewsEditingPageSteps.neverFieldsDoesntBeEmptyMessage();
  }

  @Test
  @DisplayName("Ат22 Создание новости с пустым полем даты")
  public void testRefusalAddingNewsWithEmptyFieldDate() {
    NewsEditingPageSteps.addNewsWithEmptyFieldDate();
    NewsEditingPageSteps.neverFieldsDoesntBeEmptyMessage();
  }

  @Test
  @DisplayName("Ат23 Отмена создания новости")
  public void testCancelAddingNewsWithPressCancel() {
    NewsEditingPageSteps.fillingAllFieldsNews();
    NewsEditingPageSteps.pressCancelButton();
    NewsEditingPageSteps.confirmCancelAddingNews();
    BaseSteps.pressBack();
    int itemCount = NewsEditingPageSteps.getItemCount();
    NewsEditingPageSteps.isNewsNotCreated(itemCount);
  }

  @Test
  @DisplayName("Ат24 Выполняем удаление новости")
  public void testDeleteNews() {
    NewsEditingPageSteps.addingNews();
    NewsEditingPageSteps.deleteAddedNews();
    int itemCount = NewsEditingPageSteps.getItemCount();
    NewsEditingPageSteps.isNewsDeleted(itemCount);
  }
}
