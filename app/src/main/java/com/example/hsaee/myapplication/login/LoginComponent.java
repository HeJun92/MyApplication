package com.example.hsaee.myapplication.login;

import com.example.hsaee.myapplication.common.ActivityScope;
import com.example.hsaee.myapplication.common.CommonComponent;

import dagger.Component;

/**
 * Created by HSAEE on 2018/9/4.
 */
@ActivityScope
@Component(dependencies = CommonComponent.class,modules = LoginModule.class)
public interface LoginComponent {
    LoginPresenter loginPresenter();
}
