package com.jackhou.utilslibrary.app;

import android.app.Application;
import android.content.Context;

/**
 * Author: JackHou
 * Date: 2017/10/13.
 */

public class JackApplication extends Application {

    private static JackApplication instance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static JackApplication getInstance(){
        return instance;
    }
}
