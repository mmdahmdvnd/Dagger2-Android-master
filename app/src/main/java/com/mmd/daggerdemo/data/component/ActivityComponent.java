package com.mmd.daggerdemo.data.component;

import com.mmd.daggerdemo.data.Scope.AcitvityScope;
import com.mmd.daggerdemo.data.module.ActivityModule;
import com.mmd.daggerdemo.data.ui.MainActivity;

import dagger.Component;

@AcitvityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

     void inject(MainActivity activity);

}
