package com.example.hsaee.myapplication.gate;

import com.example.hsaee.myapplication.mvp.GateContact;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HSAEE on 2018/9/4.
 */
@Module
public class GateModule {
    private final  GateContact.View mView;
    public  GateModule(GateContact.View view){
        mView=view;
    }
    @Provides
    GateContact.View provideGateContactView(){
        return mView;
    }
}
