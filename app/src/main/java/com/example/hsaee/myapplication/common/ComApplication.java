package com.example.hsaee.myapplication.common;

import android.app.Application;

import com.example.hsaee.myapplication.utils.CommonPreferences;

import javax.inject.Inject;

/**
 * Created by HSAEE on 2018/9/4.
 */

public class ComApplication extends Application{

    private ComApplication app;
    private CommonComponent component;
    @Inject
    CommonPreferences commonPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        init();
    }

    private void init() {
        component = DaggerCommonComponent.builder()
                .commonModule(new CommonModule(this))
                .build();
        component.inject(this);
    }

    public CommonComponent getCommonComponent(){
        return component;
    }
}
