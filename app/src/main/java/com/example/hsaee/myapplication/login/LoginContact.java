package com.example.hsaee.myapplication.login;

import com.example.hsaee.myapplication.mvp.BasePreseneter;
import com.example.hsaee.myapplication.mvp.BaseView;

/**
 * Created by HSAEE on 2018/9/4.
 */

public interface LoginContact {

    public interface  View extends BaseView<Presenter>{
        void gotoMain();
        void success(String message);
        void error(String error);
    }
    public interface Presenter extends BasePreseneter{

        void saveUserInfo();
        void requestNetWork(String info);

    }
}
