package com.example.hsaee.myapplication.common.main;

import com.example.hsaee.myapplication.common.ActivityScope;
import com.example.hsaee.myapplication.common.CommonComponent;

import dagger.Component;

/**
 * Created by HSAEE on 2018/9/4.
 */
@ActivityScope
@Component(dependencies = CommonComponent.class,modules = MainModule.class)
public interface MainComponent {
    MainPresenter mainPresenter();
}
