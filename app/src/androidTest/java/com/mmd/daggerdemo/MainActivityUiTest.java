package com.mmd.daggerdemo;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.mmd.daggerdemo.data.MyApplication;
//import com.mmd.daggerdemo.data.component.DaggerActivityComponent;
import com.mmd.daggerdemo.data.module.ActivityModule;
import com.mmd.daggerdemo.data.remote.NetworkService;
import com.mmd.daggerdemo.data.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(AndroidJUnit4.class)
public class MainActivityUiTest {

    @Mock
    NetworkService mockNetworkService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock NetworkService behavior
//        Mockito.when(mockNetworkService.getDummyData()).thenReturn("Test Data");

        // Inject mocked dependencies into Dagger
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
//        scenario.onActivity(activity -> {
//            DaggerActivityComponent.builder()
//                    .applicationComponent(((MyApplication) activity.getApplication()).applicationComponent)
//                    .activityModule(new ActivityModule(activity))
//                    .build()
//                    .inject(activity);
//        });
    }

    @Test
    public void testToastMessageDisplayed() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity.class);

        // Check if the Toast message is displayed with the correct text
        onView(withText("Test Data"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }
}