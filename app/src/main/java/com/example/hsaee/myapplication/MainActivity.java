package com.example.hsaee.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hsaee.myapplication.common.main.DaggerMainComponent;
import com.example.hsaee.myapplication.common.main.MainContact;
import com.example.hsaee.myapplication.common.main.MainModule;

public class MainActivity extends BaseActivity implements MainContact.View{

    private Button mBtnOutLogin;
    private MainContact.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mBtnOutLogin = (Button) findViewById(R.id.btn_out_login);
        mBtnOutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.outLogin();
            }
        });
    }

    private void init() {
        DaggerMainComponent.builder()
                .commonComponent(getCommonComponent())
                .mainModule(new MainModule(this))
                .build()
                .mainPresenter();

        mPresenter.start();
    }

    @Override
    public void setPresenter(MainContact.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void outLogin() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
