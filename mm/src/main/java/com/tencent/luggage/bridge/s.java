package com.tencent.luggage.bridge;

import android.content.Context;
import android.webkit.ValueCallback;

public interface s {
    void addJavascriptInterface(Object obj, String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    Context getContext();

    String getUserAgent();
}
