package com.mmd.daggerdemo;

import android.content.Context;
import com.mmd.daggerdemo.data.module.ActivityModule;
import com.mmd.daggerdemo.data.qualifiers.ActivityContextQualifier;
import com.mmd.daggerdemo.data.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class ActivityModuleTest {

    private ActivityModule activityModule;

    @Before
    public void setUp() {
        MainActivity mockActivity = mock(MainActivity.class);
        activityModule = new ActivityModule(mockActivity);
    }

    @Test
    public void testProvideActivityContext() {
        @ActivityContextQualifier
        Context context = activityModule.provideActivityContext();
        assertNotNull("Activity context should not be null", context);
    }
}
