package AndroidTest.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static AndroidTest.pages.HomePage.goToQuotesPage;
import static AndroidTest.pages.QuotesPage.header;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;


public class QuotesPageSteps {

  /* Шаги для тестирования страницы Цитаты */

  @Step("Получаем список цитат и обращаемся к первой")
  public static ViewInteraction getQuotesRecyclerViewAndScrollToFirstPosition() {
    Allure.step("Получаем список цитат и обращаемся к первой");
    ViewInteraction recyclerView = onView(withId(R.id.our_mission_item_list_recycler_view));
    recyclerView.perform(scrollToPosition(0));
    return recyclerView;
  }

  @Step("Проверка открытия страницы Цитаты")
  public static void goToQuotesPageWithPressButtonOnMainPage() {
    Allure.step("Проверка открытия страницы Цитаты");
    goToQuotesPage();
  }

  @Step("Проверяем, что виден заголовок раздела Цитаты")
  public static void isHeaderQuotesPageDisplayed() {
    Allure.step("Проверяем, что виден заголовок раздела Цитаты");
    header.check(matches(isDisplayed()));
  }
}
