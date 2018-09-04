package com.example.hsaee.myapplication.mvp;

/**
 * Created by HSAEE on 2018/9/4.
 */

public interface GateContact {

    public interface View extends  BaseView<Presenter>{
        void gotoWel();
        void gotoLogin();
        void gotoMain();
    }

    public  interface  Presenter extends BasePreseneter{

    }
}
