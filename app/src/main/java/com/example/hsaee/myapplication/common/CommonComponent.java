package com.example.hsaee.myapplication.common;

import android.content.Context;

import com.example.hsaee.myapplication.GateActivity;
import com.example.hsaee.myapplication.utils.CommonPreferences;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HSAEE on 2018/9/4.
 */
@Singleton
@Component(
        modules = {
                CommonModule.class
        })
public interface CommonComponent {

    void inject(ComApplication comApplication);

    CommonPreferences commonPreferences();

}
