package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import java.util.HashMap;
import java.util.Map;

public interface a {
    void a(Context context, String str, ValueCallback<Boolean> valueCallback);

    void a(h hVar);

    boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback);

    boolean canOpenWebPlus(Context context);

    void closeFileReader(Context context);

    void disableAutoCreateX5Webview();

    void forceSysWebView();

    String getMiniQBVersion(Context context);

    boolean getTBSInstalling();

    int getTbsVersion(Context context);

    void initTbsSettings(Map<String, Object> map);

    void reset(Context context);

    void setNewDnsHostList(String str);

    void setUploadCode(Context context, int i2);

    void setWebContentsDebuggingEnabled(boolean z);

    int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback);
}
