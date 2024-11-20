package com.mmd.daggerdemo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import android.content.Context;

import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.component.ApplicationComponent;
import com.mmd.daggerdemo.data.component.DaggerApplicationComponent;
import com.mmd.daggerdemo.data.module.ApplicationModule;
import com.mmd.daggerdemo.data.remote.NetworkService;

import org.junit.Before;
import org.junit.Test;

public class ApplicationComponentTest {

    private ApplicationComponent applicationComponent;
    private MyApplication mockApplication;

    @Before
    public void setUp() {
        // Mock Application
        mockApplication = mock(MyApplication.class);

        // Create ApplicationComponent with a custom module
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(mockApplication))
                .build();
    }

    @Test
    public void testInjection() {
        // Check if the dependencies are injected correctly
        Context appContext = applicationComponent.getAppContext();
        assertNotNull("AppContext should not be null", appContext);

        NetworkService networkService = applicationComponent.getNetworkService();
        assertNotNull("NetworkService should not be null", networkService);
    }
}
