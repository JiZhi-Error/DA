package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.util.Map;

public interface bb extends i, bz {
    void MM();

    boolean MN();

    boolean MO();

    void aG(Context context);

    @Override // com.tencent.mm.plugin.appbrand.m.i
    void destroy();

    int getContentHeight();

    View getContentView();

    d getFullscreenImpl();

    int getHeight();

    String getUserAgentString();

    int getWebScrollX();

    int getWebScrollY();

    int getWidth();

    View getWrapperView();

    void i(Runnable runnable);

    void onBackground();

    void onForeground();

    void s(int i2, long j2);

    void setAppBrandInfo(Map<String, String> map);

    void setBackgroundColor(int i2);

    void setFullscreenImpl(d dVar);

    void setOnScrollChangedListener(as asVar);

    void setOnTrimListener(aq aqVar);

    void setVerticalScrollBarEnabled(boolean z);

    void setWebViewLayoutListener(ap apVar);

    void setXWebKeyboardImpl(au auVar);

    void x(String str, String str2);
}
