package AndroidTest.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static AndroidTest.pages.HomePage.goToNewsPageByNavigationMenu;
import static AndroidTest.pages.NewsPage.editNewsButton;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;

public class HomePageSteps {


  /* Шаги для тестирования главной страницы */

  @Step("Переходим в раздел Новости с помощью бокового меню")
  public static void goToTheNewsSectionUsingTheSideMenu() {
    Allure.step("Переходим в раздел Новости с помощью бокового меню");
    goToNewsPageByNavigationMenu();
  }

  @Step("Проверяем видимость кнопки перехода в Новости")
  public static void isButtonСheckNews() {
    Allure.step("Проверяем видимость кнопки перехода в Новости");
    editNewsButton.check(matches(isDisplayed()));
  }
}
