package com.tencent.mm.toolkit.frontia.core;

import android.app.Application;
import android.content.Context;

public abstract class PluginApp extends Application {
    protected Context mContext;

    public abstract a getBehavior();

    public void setAppContext(Context context) {
        this.mContext = context;
    }
}
