package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

public abstract class i implements ComponentCallbacks2 {
    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }
}
