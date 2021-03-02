package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CookieManager extends z {
    public static String LOGTAG = "CookieManager";

    /* renamed from: d  reason: collision with root package name */
    private static CookieManager f1662d;

    /* renamed from: a  reason: collision with root package name */
    CopyOnWriteArrayList<b> f1663a;

    /* renamed from: b  reason: collision with root package name */
    String f1664b;

    /* renamed from: c  reason: collision with root package name */
    a f1665c = a.MODE_NONE;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1666e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1667f = false;

    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL;

        public static a valueOf(String str) {
            AppMethodBeat.i(54535);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(54535);
            return aVar;
        }

        static {
            AppMethodBeat.i(54536);
            AppMethodBeat.o(54536);
        }
    }

    /* access modifiers changed from: package-private */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f1672a;

        /* renamed from: b  reason: collision with root package name */
        String f1673b;

        /* renamed from: c  reason: collision with root package name */
        String f1674c;

        /* renamed from: d  reason: collision with root package name */
        ValueCallback<Boolean> f1675d;

        b() {
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        AppMethodBeat.i(54874);
        if (f1662d == null) {
            synchronized (CookieManager.class) {
                try {
                    if (f1662d == null) {
                        f1662d = new CookieManager();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(54874);
                    throw th;
                }
            }
        }
        CookieManager cookieManager = f1662d;
        AppMethodBeat.o(54874);
        return cookieManager;
    }

    public void removeSessionCookie() {
        AppMethodBeat.i(54875);
        if (isX5Core()) {
            getCookieManagerImpl().removeSessionCookie();
            AppMethodBeat.o(54875);
            return;
        }
        android.webkit.CookieManager.getInstance().removeSessionCookie();
        AppMethodBeat.o(54875);
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(54876);
        if (isX5Core()) {
            getCookieManagerImpl().removeSessionCookies(valueCallback);
            AppMethodBeat.o(54876);
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54876);
        } else {
            k.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.o(54876);
        }
    }

    public void removeAllCookie() {
        AppMethodBeat.i(54877);
        if (this.f1663a != null) {
            this.f1663a.clear();
        }
        if (isX5Core()) {
            getCookieManagerImpl().removeAllCookie();
            AppMethodBeat.o(54877);
            return;
        }
        android.webkit.CookieManager.getInstance().removeAllCookie();
        AppMethodBeat.o(54877);
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(54878);
        if (this.f1663a != null) {
            this.f1663a.clear();
        }
        if (isX5Core()) {
            getCookieManagerImpl().removeAllCookies(valueCallback);
            AppMethodBeat.o(54878);
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54878);
        } else {
            k.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.o(54878);
        }
    }

    public void flush() {
        AppMethodBeat.i(54879);
        if (isX5Core()) {
            getCookieManagerImpl().flush();
            AppMethodBeat.o(54879);
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54879);
        } else {
            k.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
            AppMethodBeat.o(54879);
        }
    }

    public void removeExpiredCookie() {
        AppMethodBeat.i(54880);
        if (isX5Core()) {
            getCookieManagerImpl().removeExpiredCookie();
            AppMethodBeat.o(54880);
            return;
        }
        android.webkit.CookieManager.getInstance().removeExpiredCookie();
        AppMethodBeat.o(54880);
    }

    public synchronized void setAcceptCookie(boolean z) {
        AppMethodBeat.i(54881);
        if (isX5Core()) {
            getCookieManagerImpl().setAcceptCookie(z);
            AppMethodBeat.o(54881);
        } else {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
                AppMethodBeat.o(54881);
            } catch (Throwable th) {
                AppMethodBeat.o(54881);
            }
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        AppMethodBeat.i(54882);
        if (isX5Core()) {
            getCookieManagerImpl().setAcceptThirdPartyCookies(webView.getView(), z);
            AppMethodBeat.o(54882);
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54882);
        } else {
            k.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            AppMethodBeat.o(54882);
        }
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(54883);
            if (isX5Core()) {
                z = getCookieManagerImpl().acceptThirdPartyCookies(webView.getView());
                AppMethodBeat.o(54883);
            } else if (Build.VERSION.SDK_INT < 21) {
                AppMethodBeat.o(54883);
            } else {
                Object a2 = k.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
                if (a2 != null) {
                    z = ((Boolean) a2).booleanValue();
                    AppMethodBeat.o(54883);
                } else {
                    AppMethodBeat.o(54883);
                    z = false;
                }
            }
        }
        return z;
    }

    public synchronized void setCookie(String str, String str2) {
        AppMethodBeat.i(54884);
        setCookie(str, str2, false);
        AppMethodBeat.o(54884);
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        AppMethodBeat.i(54885);
        if (isX5Core()) {
            getCookieManagerImpl().setCookie(str, str2);
            AppMethodBeat.o(54885);
        } else {
            new StringBuilder("setSysCookie,reallySet:").append(this.f1667f);
            if (this.f1667f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!x.a().d()) {
                b bVar = new b();
                bVar.f1672a = 2;
                bVar.f1673b = str;
                bVar.f1674c = str2;
                bVar.f1675d = null;
                if (this.f1663a == null) {
                    this.f1663a = new CopyOnWriteArrayList<>();
                }
                this.f1663a.add(bVar);
            }
            AppMethodBeat.o(54885);
        }
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(54886);
        if (isX5Core()) {
            getCookieManagerImpl().setCookie(str, str2, valueCallback);
            AppMethodBeat.o(54886);
        } else {
            if (!x.a().d()) {
                b bVar = new b();
                bVar.f1672a = 1;
                bVar.f1673b = str;
                bVar.f1674c = str2;
                bVar.f1675d = valueCallback;
                if (this.f1663a == null) {
                    this.f1663a = new CopyOnWriteArrayList<>();
                }
                this.f1663a.add(bVar);
            }
            if (this.f1667f) {
                if (Build.VERSION.SDK_INT < 21) {
                    AppMethodBeat.o(54886);
                } else {
                    k.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
                }
            }
            AppMethodBeat.o(54886);
        }
    }

    public boolean hasCookies() {
        AppMethodBeat.i(54887);
        if (isX5Core()) {
            boolean hasCookies = getCookieManagerImpl().hasCookies();
            AppMethodBeat.o(54887);
            return hasCookies;
        }
        boolean hasCookies2 = android.webkit.CookieManager.getInstance().hasCookies();
        AppMethodBeat.o(54887);
        return hasCookies2;
    }

    public boolean acceptCookie() {
        AppMethodBeat.i(54888);
        if (isX5Core()) {
            boolean acceptCookie = getCookieManagerImpl().acceptCookie();
            AppMethodBeat.o(54888);
            return acceptCookie;
        }
        boolean acceptCookie2 = android.webkit.CookieManager.getInstance().acceptCookie();
        AppMethodBeat.o(54888);
        return acceptCookie2;
    }

    public String getCookie(String str) {
        AppMethodBeat.i(54889);
        if (isX5Core()) {
            String cookie = getCookieManagerImpl().getCookie(str);
            AppMethodBeat.o(54889);
            return cookie;
        }
        String str2 = null;
        try {
            str2 = android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(54889);
        return str2;
    }

    public void setCookies(Map<String, String[]> map) {
        AppMethodBeat.i(54890);
        if (!(isX5Core() ? getCookieManagerImpl().setCookies(map) : false)) {
            for (String str : map.keySet()) {
                for (String str2 : map.get(str)) {
                    setCookie(str, str2);
                }
            }
        }
        AppMethodBeat.o(54890);
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        AppMethodBeat.i(54891);
        this.f1667f = true;
        if (this.f1663a == null || this.f1663a.size() == 0) {
            AppMethodBeat.o(54891);
        } else {
            x a2 = x.a();
            if (a2 != null && a2.b()) {
                Iterator<b> it = this.f1663a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    switch (next.f1672a) {
                        case 1:
                            setCookie(next.f1673b, next.f1674c, next.f1675d);
                            break;
                        case 2:
                            setCookie(next.f1673b, next.f1674c);
                            break;
                    }
                }
            } else {
                Iterator<b> it2 = this.f1663a.iterator();
                while (it2.hasNext()) {
                    b next2 = it2.next();
                    switch (next2.f1672a) {
                        case 1:
                            if (Build.VERSION.SDK_INT < 21) {
                                break;
                            } else {
                                k.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, next2.f1673b, next2.f1674c, next2.f1675d);
                                break;
                            }
                        case 2:
                            android.webkit.CookieManager.getInstance().setCookie(next2.f1673b, next2.f1674c);
                            break;
                    }
                }
            }
            this.f1663a.clear();
            AppMethodBeat.o(54891);
        }
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        AppMethodBeat.i(54892);
        long currentTimeMillis = System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            AppMethodBeat.o(54892);
            return false;
        }
        this.f1665c = aVar;
        if (str != null) {
            this.f1664b = str;
        }
        if (this.f1665c != a.MODE_NONE && z && !x.a().d()) {
            x.a().a(context, null);
        }
        new StringBuilder("setKeyCookies,timeused:").append(System.currentTimeMillis() - currentTimeMillis).append(", cookieCompatiableMode:").append(this.f1665c.ordinal());
        AppMethodBeat.o(54892);
        return true;
    }

    /* access modifiers changed from: protected */
    public synchronized void a(Context context, boolean z, boolean z2) {
        int i2;
        int i3;
        boolean z3 = true;
        synchronized (this) {
            AppMethodBeat.i(54893);
            if (this.f1665c == a.MODE_NONE || context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME) || this.f1666e) {
                StringBuilder sb = new StringBuilder("compatiableCookieDatabaseIfNeed noneedCompatiable,context is null:");
                if (context != null) {
                    z3 = false;
                }
                sb.append(z3).append("= or canUseFunction is false,isCompatiableed:").append(this.f1666e);
                AppMethodBeat.o(54893);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = 0;
                TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
                if (z || QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.f1702a) {
                    if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.f1702a) {
                        z2 = false;
                    }
                    boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.USEX5_FILE_NAME);
                    TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
                    TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
                    if (canUseFunction == z2) {
                        AppMethodBeat.o(54893);
                    } else {
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                        if (TextUtils.isEmpty(this.f1664b)) {
                            tbsLogInfo.setErrorCode(701);
                            i2 = 0;
                            i3 = 0;
                        } else if (q.a().j(context) <= 0 || q.a().j(context) >= 36001) {
                            if (canUseFunction) {
                                i3 = l.d(context);
                                if (i3 > 0) {
                                    i2 = getROMCookieDBVersion(context);
                                    if (i2 > 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = false;
                                i2 = 0;
                            } else {
                                i3 = l.d(context);
                                if (i3 > 0) {
                                    String d2 = q.a().d(context, "cookies_database_version");
                                    if (!TextUtils.isEmpty(d2)) {
                                        try {
                                            i2 = Integer.parseInt(d2);
                                            z3 = false;
                                        } catch (Exception e2) {
                                            new StringBuilder("cannot cast toVersion:0,e:").append(e2.toString());
                                        }
                                    }
                                }
                                z3 = false;
                                i2 = 0;
                            }
                            if (!z3 && (i3 <= 0 || i2 <= 0)) {
                                tbsLogInfo.setErrorCode(702);
                            } else if (i2 >= i3) {
                                new StringBuilder("INFO_COOKIE_SWITCH_NONEED, from :").append(i3).append(",to:").append(i2);
                                tbsLogInfo.setErrorCode(703);
                            } else {
                                l.a(context, this.f1665c, this.f1664b, z3, z2);
                                tbsLogInfo.setErrorCode(704);
                                j2 = System.currentTimeMillis() - currentTimeMillis;
                            }
                        } else {
                            AppMethodBeat.o(54893);
                        }
                        tbsLogInfo.setFailDetail("x5->sys:" + canUseFunction + " from:" + i3 + " to:" + i2 + ",timeused:" + j2);
                        TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
                        AppMethodBeat.o(54893);
                    }
                } else {
                    x.a().a(context, null);
                    AppMethodBeat.o(54893);
                }
            }
        }
    }

    public static int getROMCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences;
        AppMethodBeat.i(54894);
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        int i2 = sharedPreferences.getInt("db_version", -1);
        AppMethodBeat.o(54894);
        return i2;
    }

    public static void setROMCookieDBVersion(Context context, int i2) {
        SharedPreferences sharedPreferences;
        AppMethodBeat.i(54895);
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("cookiedb_info", 0);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("db_version", i2);
        edit.commit();
        AppMethodBeat.o(54895);
    }
}
