package com.example.hsaee.myapplication.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HSAEE on 2018/9/4.
 */
@Module
public class LoginModule {
    private final LoginContact.View mView;

    public LoginModule(LoginContact.View view){
        mView=view;
    }

    @Provides
    LoginContact.View provideLoginContactView(){
        return mView;
    }
}
