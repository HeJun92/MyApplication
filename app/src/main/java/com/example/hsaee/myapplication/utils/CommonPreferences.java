package com.example.hsaee.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.inject.Inject;

/**
 * Created by HSAEE on 2018/9/4.
 */

public class CommonPreferences {

    private final SharedPreferences defaultSharedPreferences;

    @Inject
    public CommonPreferences(Context context) {
        defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    public void test(){
        Log.d("CommonPreferences","我是test");
    }
    public <T> void setCommon(String key, T value) {
        SharedPreferences.Editor editor = defaultSharedPreferences.edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        }
        editor.apply();
    }
    public String getString(String key) {
        return defaultSharedPreferences.getString(key, "");
    }

    public boolean getBoolean(String key) {
        return defaultSharedPreferences.getBoolean(key, false);
    }

    public int getInt(String key) {
        return defaultSharedPreferences.getInt(key, 0);
    }

    public long getLong(String key) {
        return defaultSharedPreferences.getLong(key, 0);
    }
    public <T> void setModel(T entity) {
        SharedPreferences.Editor editor = defaultSharedPreferences.edit();
        try {
            ByteArrayOutputStream toByte = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(toByte);
            oos.writeObject(entity);
            // 对byte[]进行Base64编码
            String obj64 = new String(Base64.encode(toByte.toByteArray(), Base64.DEFAULT));
            editor.putString(entity.getClass().getSimpleName(), obj64);
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
