package com.tencent.xweb.internal;

import android.content.Context;
import com.tencent.xweb.WebView;

public final class CookieInternal {

    public interface ICookieManagerInternal {
        void e(WebView webView);

        String getCookie(String str);

        void hsq();

        void removeAllCookie();

        void removeSessionCookie();

        void setCookie(String str, String str2);
    }

    public interface ICookieSyncManagerInternal {
        void init(Context context);

        void sync();
    }
}
