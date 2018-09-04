package com.example.hsaee.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.example.hsaee.myapplication.gate.DaggerGateCompenont;
import com.example.hsaee.myapplication.gate.GateModule;
import com.example.hsaee.myapplication.mvp.GateContact;
import com.example.hsaee.myapplication.utils.CommonPreferences;

import javax.inject.Inject;

public class GateActivity extends BaseActivity implements GateContact.View{

    private GateContact.Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate);
        init();
    }

    private void init() {
        DaggerGateCompenont.builder()
                .commonComponent(getCommonComponent())
                .gateModule(new GateModule(this))
                .build()
                .gatePresenter();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.start();
            }
        },1000);

    }


    @Override
    public void setPresenter(GateContact.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void gotoWel() {
        Intent intent = new Intent(this, WelActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
