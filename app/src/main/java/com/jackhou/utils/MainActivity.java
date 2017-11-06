package com.jackhou.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jackhou.utilslibrary.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.i("zx");
    }
}
