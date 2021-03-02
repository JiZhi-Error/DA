package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import java.util.Map;

public interface IX5CoreEntry {
    boolean canLoadX5(Context context);

    boolean canUseX5();

    IX5WebViewBase createX5WebView(Context context, boolean z);

    int getCoreVersion();

    IX5CoreCacheManager getX5CoreCacheManager();

    IX5CoreCookieManager getX5CoreCookieManager();

    IX5CoreGeolocationPermissions getX5CoreGeolocationPermissions();

    IX5CoreJsCore getX5CoreJsCore();

    IX5CoreMessy getX5CoreMessy();

    IX5CoreNetwork getX5CoreNetwork();

    IX5CoreOptimizedBitmap getX5CoreOptimizedBitmap();

    IX5CoreUrlUtil getX5CoreUrlUtil();

    IX5CoreWebIconDB getX5CoreWebIconDB();

    IX5CoreWebStorage getX5CoreWebStorage();

    IX5CoreWebViewDB getX5CoreWebViewDB();

    void initRuntimeEnvironment();

    void initSettings(Map map);

    void setQua1(String str);

    void setQua2_v3(String str, String str2, String str3, String str4, String str5, boolean z);

    void setSdkVersionCode(int i2);

    void setSdkVersionName(String str);
}
