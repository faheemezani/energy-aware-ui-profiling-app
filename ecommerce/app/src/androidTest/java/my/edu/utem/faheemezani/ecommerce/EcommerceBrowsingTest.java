package my.edu.utem.faheemezani.ecommerce;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.anything;

import android.util.Log;
import android.view.Choreographer;

@RunWith(AndroidJUnit4.class)
public class EcommerceBrowsingTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testBrowseSelectItemWorstCase() {
        long[] before = CpuUsageMonitor.readCpuTimes();
        logFrameTiming();

        // Scroll to the last item (position 49) and click on it
        onData(anything())
                .inAdapterView(withId(R.id.productList))
                .atPosition(49)
                .perform(click());

        // Verify product detail activity launched and title is correct
        onView(withId(R.id.productTitle)).check(matches(withText("Product 50")));

        logFrameTiming();

        // Perform additional action to simulate complete scenario
        onView(withId(R.id.addToCartButton)).perform(click());

        logFrameTiming();
        long[] after = CpuUsageMonitor.readCpuTimes();
        logCpuUsage(before, after);

    }

    @Test
    public void textBrowseSelectItemWorstCaseWithoutLogging() {
        long[] before = CpuUsageMonitor.readCpuTimes();
        // Scroll to the last item (position 49) and click on it
        onData(anything())
                .inAdapterView(withId(R.id.productList))
                .atPosition(49)
                .perform(click());

        // Verify product detail activity launched and title is correct
        onView(withId(R.id.productTitle)).check(matches(withText("Product 50")));

        // Perform additional action to simulate complete scenario
        onView(withId(R.id.addToCartButton)).perform(click());
        long[] after = CpuUsageMonitor.readCpuTimes();
        logCpuUsage(before, after);
    }

    @Test
    public void textBrowseSelectItemWorstCaseWithCPULogOnly() {
        // Scroll to the last item (position 49) and click on it
        onData(anything())
                .inAdapterView(withId(R.id.productList))
                .atPosition(49)
                .perform(click());

        // Verify product detail activity launched and title is correct
        onView(withId(R.id.productTitle)).check(matches(withText("Product 50")));

        // Perform additional action to simulate complete scenario
        onView(withId(R.id.addToCartButton)).perform(click());
    }


    private void logFrameTiming() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync(() ->
                Choreographer.getInstance().postFrameCallback(frameTimeNanos -> Log.d("FrameTiming", "Frame at: " + frameTimeNanos)));
    }

    private void logCpuUsage(long[] before, long[] after) {
        float usage = CpuUsageMonitor.getAppCpuUsagePercent(before, after, 1000);
        Log.d("CpuUsage", "Approximate CPU usage: " + usage + "%");
    }
}
