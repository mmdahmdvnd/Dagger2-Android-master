package com.mmd.daggerdemo;

import com.mmd.daggerdemo.data.remote.NetworkService;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class NetworkServiceTest {

    private NetworkService networkService;

    @Before
    public void setUp() {
        networkService = new NetworkService("fakeApiKey");
    }

    @Test
    public void testNetworkServiceCreation() {
        assertNotNull("NetworkService should not be null", networkService);
    }

    @Test
    public void testFetchData() {
        // Mock or simulate a response for fetchData
        String response = networkService.fetchData();
        assertNotNull("Response should not be null", response);
    }
}
