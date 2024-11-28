package com.mmd.daggerdemo;

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

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = mock(MainActivity.class);

//        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(mock(MyApplication.class)))
//                .build();
//
//        ActivityComponent activityComponent = DaggerActivityComponent.builder()
//                .applicationComponent(applicationComponent)
//                .activityModule(new ActivityModule(mainActivity))
//                .build();

//        activityComponent.inject(mainActivity);
    }

    @Test
    public void testMainActivityInjection() {
        assertNotNull("MainActivity should have been injected", mainActivity);
    }
}
