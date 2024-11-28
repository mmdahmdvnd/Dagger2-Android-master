package com.mmd.daggerdemo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import android.content.Context;

import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.component.ActivityComponent;
import com.mmd.daggerdemo.data.component.ApplicationComponent;
//import com.mmd.daggerdemo.data.component.DaggerActivityComponent;
//import com.mmd.daggerdemo.data.component.DaggerApplicationComponent;
import com.mmd.daggerdemo.data.module.ActivityModule;
import com.mmd.daggerdemo.data.module.ApplicationModule;
import com.mmd.daggerdemo.data.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;

public class ActivityComponentTest {

    private ActivityComponent activityComponent;
    private ApplicationComponent applicationComponent;
    private MainActivity mockActivity;

    @Before
    public void setUp() {
        // Mock MainActivity
        mockActivity = mock(MainActivity.class);

        // Create ApplicationComponent
        MyApplication mockApplication = mock(MyApplication.class);
//        applicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(mockApplication))
//                .build();

        // Create ActivityComponent and set ApplicationComponent as a dependency
//        activityComponent = DaggerActivityComponent.builder()
//                .applicationComponent(applicationComponent) // Pass ApplicationComponent here
//                .activityModule(new ActivityModule(mockActivity))
//                .build();
    }

    @Test
    public void testInjection() {
        // Inject dependencies into MainActivity and verify
        activityComponent.inject(mockActivity);

        // Validate that the context is injected
        Context activityContext = new ActivityModule(mockActivity).provideActivityContext();
        assertNotNull("Activity context should not be null", activityContext);
    }
}