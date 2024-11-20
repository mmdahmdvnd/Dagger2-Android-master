package com.mmd.daggerdemo.data.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mmd.daggerdemo.R;
import com.mmd.daggerdemo.data.MyApplication;
import com.mmd.daggerdemo.data.component.DaggerActivityComponent;
import com.mmd.daggerdemo.data.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAcivityComponent();

        Toast.makeText(this, ""+viewModel.getSomeData(), Toast.LENGTH_SHORT).show();
    }

    void getAcivityComponent(){
       DaggerActivityComponent.builder()
                .applicationComponent(((MyApplication) getApplication()).applicationComponent)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

}
