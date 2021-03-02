package com.tencent.mm.plugin.appbrand.platform.window;

import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.d;

public interface g {
    boolean OD();

    boolean OG();

    d a(d.b bVar);

    e getOrientationHandler();

    float getScale();

    c.C0789c getStatusBar();

    DisplayMetrics getVDisplayMetrics();

    void setSoftOrientation(String str);
}
