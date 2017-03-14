package com.wdz.mvpdemo;

import android.app.Application;

/**
 * Created by cd on 17/3/14.
 * 联系作者:413526086@QQ.COM
 */

public class App extends Application {

    private  static App INSTANCE;

    public static App getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE =this;
    }
}
