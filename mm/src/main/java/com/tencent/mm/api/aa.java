package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.d.e;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.ui.widget.MMWebView;

public interface aa extends a {
    BaseWebViewController a(MMWebView mMWebView);

    BaseWebViewController a(MMWebView mMWebView, BaseWebViewController.c cVar, e eVar);

    boolean a(Activity activity, int i2, int i3, Intent intent);

    h b(MMWebView mMWebView);

    void c(Activity activity, String str);

    String fM(String str);
}
