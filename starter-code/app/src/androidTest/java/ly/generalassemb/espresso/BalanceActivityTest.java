package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by stacyzolnikov on 7/21/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mBalanceActivityTestRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);


    @Test
    public void checkBalance() throws Exception {
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }


    @Test
    public void testWithdraw () throws Exception {
        String mDescription = "Grocery";
        String mValue = "$40.00";
        String mexpected = "-$40.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(mDescription));
        onView(withId(R.id.amountEditText))
                .perform(typeText(mValue));
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(mexpected)));
    }

    @Test
    public void testDepositMoney() throws Exception{
        String mDescription = "Grocery";
        String mValue = "$40.00";
        String mexpected = "$40.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(mDescription));
        onView(withId(R.id.amountEditText))
                .perform(typeText(mValue));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(mexpected)));
    }

    @Test
    public void multipleTransactionsTest() throws Exception {
        String mDescription = "Grocery";
        String mValue = "$40.00";
        String mexpected = "$40.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(mDescription));
        onView(withId(R.id.amountEditText))
                .perform(typeText(mValue));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(mDescription));
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(mValue));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(mexpected)));
    }
}
