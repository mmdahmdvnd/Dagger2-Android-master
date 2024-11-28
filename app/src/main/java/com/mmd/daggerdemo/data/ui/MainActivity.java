package com.mmd.daggerdemo.data.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mmd.daggerdemo.R;
import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.component.ActivityComponent;
import com.mmd.daggerdemo.data.component.ApplicationComponent;
import com.mmd.daggerdemo.data.module.ActivityModule;
import com.mmd.daggerdemo.data.ui.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MainViewModel mainViewModel;
    private ActivityComponent activityComponent; // تعریف ActivityComponent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // دریافت ApplicationComponent از MyApplication
        ApplicationComponent appComponent = ((MyApplication) getApplication()).getApplicationComponent();

        // ساخت ActivityComponent
        activityComponent = appComponent.activityComponentBuilder()
                .activityModule(new ActivityModule(this))
                .build();

        // تزریق وابستگی‌ها با استفاده از ActivityComponent
        activityComponent.inject(this);

        // مقداردهی ViewModel
        mainViewModel = new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class);

        // استفاده از ViewModel
        mainViewModel.getUser(1).subscribe(user -> {
            Toast.makeText(this, "Name: " + user.getName(), Toast.LENGTH_SHORT).show();
        }, throwable -> {
            Toast.makeText(this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}