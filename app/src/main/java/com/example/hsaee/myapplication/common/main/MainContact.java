package com.example.hsaee.myapplication.common.main;

import com.example.hsaee.myapplication.mvp.BasePreseneter;
import com.example.hsaee.myapplication.mvp.BaseView;

/**
 * Created by HSAEE on 2018/9/4.
 */

public interface MainContact {
    public interface View extends BaseView<Presenter>{
        void outLogin();
    }
    public interface Presenter extends BasePreseneter{
        void  outLogin();
    }
}
