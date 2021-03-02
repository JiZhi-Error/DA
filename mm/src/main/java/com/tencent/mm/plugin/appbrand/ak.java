package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.c;

public interface ak {
    void A(AppBrandRuntime appBrandRuntime);

    void a(AppBrandRuntime appBrandRuntime, AppBrandInitConfig appBrandInitConfig);

    void a(AppBrandRuntime appBrandRuntime, Object obj);

    AppBrandRuntime getActiveRuntime();

    Context getContext();

    int getStackSize();

    c getWindowAndroid();

    AppBrandRuntime u(AppBrandRuntime appBrandRuntime);

    boolean v(AppBrandRuntime appBrandRuntime);

    void w(AppBrandRuntime appBrandRuntime);
}
