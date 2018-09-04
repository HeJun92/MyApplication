package com.example.hsaee.myapplication.common;

import android.content.Context;

import com.example.hsaee.myapplication.utils.CommonPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HSAEE on 2018/9/4.
 */

@Module
public class CommonModule {

    private final Context context;

    public CommonModule(Context context){
        this.context=context;
    }
    //提供实例
    @Provides
    @Singleton
    //单一实例
    Context provideApplication(){
        return context;
    }
    @Provides
    CommonPreferences provideCommonPreferences(){
        return  new CommonPreferences(context);
    }


}
