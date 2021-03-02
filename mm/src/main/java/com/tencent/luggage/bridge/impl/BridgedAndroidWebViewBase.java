package com.tencent.luggage.bridge.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.luggage.bridge.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.a.a;

public class BridgedAndroidWebViewBase extends WebView implements s {
    private static boolean csU = false;

    public BridgedAndroidWebViewBase(Context context) {
        this(context, null);
    }

    public BridgedAndroidWebViewBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BridgedAndroidWebViewBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(140354);
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        AppMethodBeat.o(140354);
    }

    @Override // com.tencent.luggage.bridge.s
    public String getUserAgent() {
        AppMethodBeat.i(221175);
        String userAgentString = getSettings().getUserAgentString();
        AppMethodBeat.o(221175);
        return userAgentString;
    }

    @Override // com.tencent.luggage.bridge.s
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(140355);
        if (Build.VERSION.SDK_INT < 17) {
            AppMethodBeat.o(140355);
            return;
        }
        addJavascriptInterface(obj, str);
        AppMethodBeat.o(140355);
    }

    @Override // com.tencent.luggage.bridge.s, android.webkit.WebView
    public void evaluateJavascript(final String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(221176);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            cP(str);
            AppMethodBeat.o(221176);
            return;
        }
        post(new Runnable() {
            /* class com.tencent.luggage.bridge.impl.BridgedAndroidWebViewBase.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(140353);
                BridgedAndroidWebViewBase.this.cP(str);
                AppMethodBeat.o(140353);
            }
        });
        AppMethodBeat.o(221176);
    }

    public final void cP(String str) {
        AppMethodBeat.i(140357);
        if (TextUtils.isEmpty(str)) {
            Log.e("BridgedAndroidWebViewBase", "Empty script");
            AppMethodBeat.o(140357);
        } else if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
            AppMethodBeat.o(140357);
        } else {
            if (csU) {
                if (!cQ(str)) {
                    csU = false;
                } else {
                    AppMethodBeat.o(140357);
                    return;
                }
            }
            try {
                super.loadUrl("javascript:".concat(String.valueOf(str)));
                AppMethodBeat.o(140357);
            } catch (Exception e2) {
                Log.i("BridgedAndroidWebViewBase", "evaluateJavascript failed : %s", e2);
                AppMethodBeat.o(140357);
            }
        }
    }

    private boolean cQ(String str) {
        AppMethodBeat.i(140358);
        try {
            Object obj = a.gG(a.gG(this).bvr("mProvider").object).bvr("mWebViewCore").object;
            Message obtain = Message.obtain(null, 194, str);
            a.gG(obj).u("sendMessage", obtain);
            AppMethodBeat.o(140358);
            return true;
        } catch (Exception e2) {
            Log.e(getClass().getName(), "reflectEvalJS, exception = %s", e2);
            AppMethodBeat.o(140358);
            return false;
        }
    }
}
