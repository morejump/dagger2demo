package com.example.dagger2demo.components;

import com.example.dagger2demo.MainActivity;
import com.example.dagger2demo.modules.SharedPrefModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(MainActivity mainActivity);
}
