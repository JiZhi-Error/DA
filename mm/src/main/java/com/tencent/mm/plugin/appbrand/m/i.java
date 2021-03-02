package com.tencent.mm.plugin.appbrand.m;

import android.webkit.ValueCallback;
import java.net.URL;

public interface i extends o {
    <T extends j> T R(Class<T> cls);

    void a(URL url, String str, ValueCallback<String> valueCallback);

    void a(URL url, String str, String str2, int i2, String str3, ValueCallback<String> valueCallback);

    void addJavascriptInterface(Object obj, String str);

    void destroy();

    void setJsExceptionHandler(h hVar);
}
