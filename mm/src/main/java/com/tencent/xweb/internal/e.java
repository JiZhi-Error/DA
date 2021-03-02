package com.tencent.xweb.internal;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.o;

public interface e {
    boolean a(String str, String str2, JsResult jsResult);

    boolean a(String str, String str2, String str3, o oVar);

    boolean b(String str, String str2, JsResult jsResult);

    void onHideCustomView();

    void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback);

    void y(String str, Bitmap bitmap);
}
