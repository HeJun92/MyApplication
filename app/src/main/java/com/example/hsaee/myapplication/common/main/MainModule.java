package com.example.hsaee.myapplication.common.main;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HSAEE on 2018/9/4.
 */

@Module
public class MainModule {
    private final MainContact.View mView;

    public MainModule(MainContact.View view){
        mView=view;
    }
    @Provides
    MainContact.View provideMainContactView(){
        return mView;
    }
}
