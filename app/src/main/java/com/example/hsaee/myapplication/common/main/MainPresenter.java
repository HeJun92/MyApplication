package com.example.hsaee.myapplication.common.main;

import android.util.Log;

import com.example.hsaee.myapplication.utils.CommonPreferences;

import javax.inject.Inject;

/**
 * Created by HSAEE on 2018/9/4.
 */

public class MainPresenter implements MainContact.Presenter{
    private final MainContact.View mView;
    @Inject
    CommonPreferences commonPreferences;
    @Inject
    public MainPresenter(MainContact.View view){

        mView=view;
        mView.setPresenter(this);
    }
    @Override
    public void start() {
        Log.d("退出前准备","退出操作");
    }

    @Override
    public void outLogin() {
        commonPreferences.setCommon("User","");
        mView.outLogin();
    }
}
