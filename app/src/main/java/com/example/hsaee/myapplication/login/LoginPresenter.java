package com.example.hsaee.myapplication.login;

import android.util.Log;

import com.example.hsaee.myapplication.utils.CommonPreferences;

import javax.inject.Inject;

/**
 * Created by HSAEE on 2018/9/4.
 */

public class LoginPresenter implements LoginContact.Presenter {

    private LoginContact.View mView;
    @Inject
    CommonPreferences commonPreferences;

    @Inject
    public  LoginPresenter(LoginContact.View view){

        mView=view;
    }

    @Inject
    public void setupListeners(){
        mView.setPresenter(this);
    }
    @Override
    public void start() {
        Log.d("初始化","初始化成功");
    }

    @Override
    public void saveUserInfo() {

    }

    @Override
    public void requestNetWork(String info) {
        Log.d("请求开始啦",info);
        mView.gotoMain();
        mView.success("请求成功了");
        commonPreferences.setCommon("User",info);


    }
}
