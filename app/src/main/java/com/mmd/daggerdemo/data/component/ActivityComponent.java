package com.mmd.daggerdemo.data.component;

import com.mmd.daggerdemo.data.Scope.ActivityScope;
import com.mmd.daggerdemo.data.module.ActivityModule;
import com.mmd.daggerdemo.data.ui.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

     void inject(MainActivity mainActivity);

     @Subcomponent.Builder
     interface Builder {
          Builder activityModule(ActivityModule activityModule);

          ActivityComponent build();
     }
}
