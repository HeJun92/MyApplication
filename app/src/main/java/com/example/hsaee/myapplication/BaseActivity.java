package com.example.hsaee.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hsaee.myapplication.common.ComApplication;
import com.example.hsaee.myapplication.common.CommonComponent;
import com.example.hsaee.myapplication.common.CommonModule;
import com.example.hsaee.myapplication.common.DaggerCommonComponent;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public CommonComponent getCommonComponent(){
        CommonComponent build = DaggerCommonComponent.builder().commonModule(new CommonModule(this))
                .build();
        return  build;
    }

    protected CommonComponent component() {
        return ((ComApplication) getApplication()).getCommonComponent();
    }

}
