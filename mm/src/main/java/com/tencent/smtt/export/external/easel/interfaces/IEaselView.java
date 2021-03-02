package com.tencent.smtt.export.external.easel.interfaces;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;

public interface IEaselView {
    void addJavascriptInterface(Object obj, String str);

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback, String str2);

    void loadDataWithBaseURL(String str, String str2);

    void loadUrl(String str);

    void pause();

    void removeJavascriptInterface(String str);

    void resume();

    void setEaselViewClient(IEaselViewClient iEaselViewClient);

    void takeScreenshot(ValueCallback<Bitmap> valueCallback);
}
