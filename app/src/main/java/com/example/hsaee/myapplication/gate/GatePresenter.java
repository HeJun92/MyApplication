package com.example.hsaee.myapplication.gate;

import android.util.Log;

import com.example.hsaee.myapplication.mvp.GateContact;
import com.example.hsaee.myapplication.utils.CommonPreferences;

import javax.inject.Inject;

/**
 * Created by HSAEE on 2018/9/4.
 */

public class GatePresenter implements GateContact.Presenter {
    private final GateContact.View mView;

    @Inject
    CommonPreferences commonPreferences;

    @Inject
    public GatePresenter(GateContact.View view) {
        mView = view;
    }

    @Inject
    public void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        String user = commonPreferences.getString("User");
        if (user.isEmpty()) {
            mView.gotoLogin();
        } else {
            mView.gotoMain();
        }
        Log.d("GatePresenter", "GatePresenter");
    }
}
