package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebViewDatabase extends z {

    /* renamed from: a  reason: collision with root package name */
    private static WebViewDatabase f1940a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1941b;

    protected WebViewDatabase(Context context) {
        this.f1941b = context;
    }

    public static WebViewDatabase getInstance(Context context) {
        AppMethodBeat.i(54354);
        WebViewDatabase a2 = a(context);
        AppMethodBeat.o(54354);
        return a2;
    }

    private static synchronized WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            AppMethodBeat.i(54355);
            if (f1940a == null) {
                f1940a = new WebViewDatabase(context);
            }
            webViewDatabase = f1940a;
            AppMethodBeat.o(54355);
        }
        return webViewDatabase;
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        AppMethodBeat.i(54356);
        if (isX5Core()) {
            boolean hasUsernamePassword = getWebViewDBImpl().hasUsernamePassword(this.f1941b);
            AppMethodBeat.o(54356);
            return hasUsernamePassword;
        }
        boolean hasUsernamePassword2 = android.webkit.WebViewDatabase.getInstance(this.f1941b).hasUsernamePassword();
        AppMethodBeat.o(54356);
        return hasUsernamePassword2;
    }

    @Deprecated
    public void clearUsernamePassword() {
        AppMethodBeat.i(54357);
        if (isX5Core()) {
            getWebViewDBImpl().clearUsernamePassword(this.f1941b);
            AppMethodBeat.o(54357);
            return;
        }
        android.webkit.WebViewDatabase.getInstance(this.f1941b).clearUsernamePassword();
        AppMethodBeat.o(54357);
    }

    public boolean hasHttpAuthUsernamePassword() {
        AppMethodBeat.i(54358);
        if (isX5Core()) {
            boolean hasHttpAuthUsernamePassword = getWebViewDBImpl().hasHttpAuthUsernamePassword(this.f1941b);
            AppMethodBeat.o(54358);
            return hasHttpAuthUsernamePassword;
        }
        boolean hasHttpAuthUsernamePassword2 = android.webkit.WebViewDatabase.getInstance(this.f1941b).hasHttpAuthUsernamePassword();
        AppMethodBeat.o(54358);
        return hasHttpAuthUsernamePassword2;
    }

    public void clearHttpAuthUsernamePassword() {
        AppMethodBeat.i(54359);
        if (isX5Core()) {
            getWebViewDBImpl().clearHttpAuthUsernamePassword(this.f1941b);
            AppMethodBeat.o(54359);
            return;
        }
        android.webkit.WebViewDatabase.getInstance(this.f1941b).clearHttpAuthUsernamePassword();
        AppMethodBeat.o(54359);
    }

    public boolean hasFormData() {
        AppMethodBeat.i(54360);
        if (isX5Core()) {
            boolean hasFormData = getWebViewDBImpl().hasFormData(this.f1941b);
            AppMethodBeat.o(54360);
            return hasFormData;
        }
        boolean hasFormData2 = android.webkit.WebViewDatabase.getInstance(this.f1941b).hasFormData();
        AppMethodBeat.o(54360);
        return hasFormData2;
    }

    public void clearFormData() {
        AppMethodBeat.i(54361);
        if (isX5Core()) {
            getWebViewDBImpl().clearFormData(this.f1941b);
            AppMethodBeat.o(54361);
            return;
        }
        android.webkit.WebViewDatabase.getInstance(this.f1941b).clearFormData();
        AppMethodBeat.o(54361);
    }
}
