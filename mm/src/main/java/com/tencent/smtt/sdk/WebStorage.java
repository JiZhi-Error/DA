package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class WebStorage extends z {

    /* renamed from: a  reason: collision with root package name */
    private static WebStorage f1910a;

    @Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j2);
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        AppMethodBeat.i(54325);
        if (isX5Core()) {
            getWebStorageImpl().getOrigins(valueCallback);
            AppMethodBeat.o(54325);
            return;
        }
        android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        AppMethodBeat.o(54325);
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(54326);
        if (isX5Core()) {
            getWebStorageImpl().getUsageForOrigin(str, valueCallback);
            AppMethodBeat.o(54326);
            return;
        }
        android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        AppMethodBeat.o(54326);
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(54327);
        if (isX5Core()) {
            getWebStorageImpl().getUsageForOrigin(str, valueCallback);
            AppMethodBeat.o(54327);
            return;
        }
        android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        AppMethodBeat.o(54327);
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j2) {
        AppMethodBeat.i(54328);
        if (isX5Core()) {
            getWebStorageImpl().setQuotaForOrigin(str, j2);
            AppMethodBeat.o(54328);
            return;
        }
        android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j2);
        AppMethodBeat.o(54328);
    }

    public void deleteOrigin(String str) {
        AppMethodBeat.i(54329);
        if (isX5Core()) {
            getWebStorageImpl().deleteOrigin(str);
            AppMethodBeat.o(54329);
            return;
        }
        android.webkit.WebStorage.getInstance().deleteOrigin(str);
        AppMethodBeat.o(54329);
    }

    public void deleteAllData() {
        AppMethodBeat.i(54330);
        if (isX5Core()) {
            getWebStorageImpl().deleteAllData();
            AppMethodBeat.o(54330);
            return;
        }
        android.webkit.WebStorage.getInstance().deleteAllData();
        AppMethodBeat.o(54330);
    }

    public static WebStorage getInstance() {
        AppMethodBeat.i(54331);
        WebStorage a2 = a();
        AppMethodBeat.o(54331);
        return a2;
    }

    private static synchronized WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            AppMethodBeat.i(54332);
            if (f1910a == null) {
                f1910a = new WebStorage();
            }
            webStorage = f1910a;
            AppMethodBeat.o(54332);
        }
        return webStorage;
    }
}
