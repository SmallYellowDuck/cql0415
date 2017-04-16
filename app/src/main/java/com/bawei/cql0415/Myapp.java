package com.bawei.cql0415;

import android.app.Application;

import org.xutils.x;

/**
 * 作者:程千浪
 * .时间：2017/4/15 10:14
 * 类用途：
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
