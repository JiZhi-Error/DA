package com.tencent.mapsdk.rastercore.core;

import android.content.Context;

public class MapContext {
    private static volatile Context context;

    public static void setContext(Context context2) {
        context = context2;
    }

    public static Context getContext() {
        return context;
    }
}
