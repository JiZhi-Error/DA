package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import android.webkit.ValueCallback;
import java.net.URL;
import java.util.List;
import java.util.Map;

public interface IX5CoreCookieManager {
    boolean acceptCookie();

    boolean acceptThirdPartyCookies(Object obj);

    void appendDomain(URL url);

    void flush();

    String getCookie(String str);

    String getCookie(String str, boolean z);

    String getQCookie(String str);

    boolean hasCookies();

    void removeAllCookie();

    void removeAllCookies(ValueCallback<Boolean> valueCallback);

    void removeExpiredCookie();

    void removeSessionCookie();

    void removeSessionCookies(ValueCallback<Boolean> valueCallback);

    void setAcceptCookie(boolean z);

    void setAcceptThirdPartyCookies(Object obj, boolean z);

    void setCookie(String str, String str2);

    void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback);

    void setCookie(URL url, Map<String, List<String>> map);

    boolean setCookies(Map<String, String[]> map);

    void setQCookie(String str, String str2);

    void syncImmediately();

    @Deprecated
    void syncManagerCreateInstance(Context context);

    @Deprecated
    void syncManagerStartSync();

    @Deprecated
    void syncManagerStopSync();

    @Deprecated
    void syncManagerSync();
}
