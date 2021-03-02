package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

public interface ah extends b {
    void a(Activity activity, AppBrandInitConfig appBrandInitConfig);

    void a(AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, Runnable runnable);

    void a(AppBrandRuntime appBrandRuntime, Runnable runnable, AppBrandRuntime appBrandRuntime2);

    void m(Activity activity);
}
