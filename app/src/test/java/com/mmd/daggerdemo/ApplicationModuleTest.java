package com.mmd.daggerdemo;

import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.module.ApplicationModule;
import com.mmd.daggerdemo.data.qualifiers.AppContextQualifier;
import com.mmd.daggerdemo.data.qualifiers.DatabaseQualifier;
import com.mmd.daggerdemo.data.qualifiers.NetworkQualifier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApplicationModuleTest {

    private ApplicationModule applicationModule;

    @Before
    public void setUp() {
        MyApplication mockApplication = new MyApplication();
        applicationModule = new ApplicationModule(mockApplication);
    }

    @Test
    public void testProvideContext() {
        @AppContextQualifier
        Object context = applicationModule.provideContext();
        assertNotNull("Context should not be null", context);
    }

    @Test
    public void testProvideDatabaseName() {
        @DatabaseQualifier
        String dbName = applicationModule.provideDatabaseName();
        assertEquals("dbName", dbName);
    }

    @Test
    public void testProvideNetworkKey() {
        @NetworkQualifier
        String networkKey = applicationModule.provideNetworkKey();
        assertEquals("dbName", networkKey);
    }

    @Test
    public void testProvideDatabaseVersion() {
        @DatabaseQualifier
        int dbVersion = applicationModule.provideDataBaseVersion();
        assertEquals(1, dbVersion);
    }
}
