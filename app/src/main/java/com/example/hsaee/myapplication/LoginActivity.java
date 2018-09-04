package com.example.hsaee.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hsaee.myapplication.login.DaggerLoginComponent;
import com.example.hsaee.myapplication.login.LoginContact;
import com.example.hsaee.myapplication.login.LoginModule;

public class LoginActivity extends BaseActivity implements LoginContact.View{

    private EditText mEtLogin;
    private LoginContact.Presenter mPresenter;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEtLogin = (EditText) findViewById(R.id.et_login);
        mButton = (Button) findViewById(R.id.btn_login);

        init();


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEtLogin.getText()!=null){
                    mPresenter.requestNetWork(mEtLogin.getText().toString());
                }

            }
        });
    }

    private void init() {
        DaggerLoginComponent.builder()
                .commonComponent(getCommonComponent())
                .loginModule(new LoginModule(this))
                .build()
                .loginPresenter();

        mPresenter.start();
    }

    @Override
    public void setPresenter(LoginContact.Presenter presenter) {
        mPresenter=presenter;
    }

    @Override
    public void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void success(String message) {
        Log.d("success",message);
    }

    @Override
    public void error(String error) {
        Log.d("error",error);
    }
}
