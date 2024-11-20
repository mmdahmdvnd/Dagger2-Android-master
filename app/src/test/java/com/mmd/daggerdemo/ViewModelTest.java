package com.mmd.daggerdemo;

import com.mmd.daggerdemo.data.remote.NetworkService;
import com.mmd.daggerdemo.data.ui.ViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewModelTest {

    private ViewModel viewModel;
    private NetworkService mockNetworkService;

    @Before
    public void setUp() {
        // ایجاد mock برای NetworkService
        mockNetworkService = mock(NetworkService.class);

        // تزریق mock به ViewModel
        viewModel = new ViewModel(mockNetworkService);
    }

    @Test
    public void testGetSomeData() {
        // مقدار بازگشتی متد mock را مشخص می‌کنیم
        String expectedData = "Dummy Data";
        when(mockNetworkService.getDummyData()).thenReturn(expectedData);

        // فراخوانی متد getSomeData و بررسی مقدار بازگشتی
        String actualData = viewModel.getSomeData();
        assertEquals(expectedData, actualData);
    }
}
