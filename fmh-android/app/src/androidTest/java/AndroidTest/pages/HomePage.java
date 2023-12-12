package AndroidTest.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static AndroidTest.data.DataHelper.waitElement;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class HomePage {
  public static ViewInteraction mainMenuButton =
      onView(allOf(withId(R.id.main_menu_image_button), withContentDescription(R.string.main_menu)));
  public static int mainMenuButtonId = R.id.main_menu_image_button;

  public static ViewInteraction newsButton = onView(withText(R.string.news));
  static ViewInteraction aboutButton = onView(withText(R.string.about));

  public static ViewInteraction logOutButton = onView(allOf(withId(R.id.authorization_image_button)));
  public static int LogOutId = R.id.authorization_image_button;

  public static ViewInteraction quotesButton = onView(allOf(withId(R.id.our_mission_image_button)));
  public static int quotesButtonID = R.id.our_mission_image_button;


  public static void logOut() {
    onView(withId(LogOutId)).perform(click());
    onView(withId(android.R.id.title)).check(matches(isDisplayed()));
    onView(withId(android.R.id.title)).perform(click());
  }

  public static void goToNewsPageByNavigationMenu() {
    waitElement(mainMenuButtonId);
    mainMenuButton.perform(click());
    newsButton.check(matches(isDisplayed()));
    newsButton.perform(click());
  }

  public static void goToAboutPage() {
    waitElement(mainMenuButtonId);
    mainMenuButton.perform(click());
    aboutButton.check(matches(isDisplayed()));
    aboutButton.perform(click());
  }

  public static void goToQuotesPage() {
    waitElement(quotesButtonID);
    quotesButton.perform(click());
  }
}
