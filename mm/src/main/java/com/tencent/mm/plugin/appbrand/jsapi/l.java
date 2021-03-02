package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import kotlin.g.b.p;
import org.json.JSONObject;

public abstract class l extends g implements k {
    private final String TAG = "AppBrandComponentWxaSharedKT";

    public abstract boolean bsW();

    public abstract boolean bsX();

    public static /* synthetic */ void a(l lVar, JSONObject jSONObject) {
        p.h(jSONObject, "__wxConfig");
        lVar.getJsRuntime().evaluateJavascript("var __wxConfig = ".concat(String.valueOf(jSONObject)), null);
    }

    public JSONObject bte() {
        JSONObject jSONObject = new JSONObject();
        d(jSONObject);
        c(jSONObject, "preload", Boolean.TRUE);
        return jSONObject;
    }

    public void d(JSONObject jSONObject) {
        p.h(jSONObject, "config");
        c(jSONObject, TPDownloadProxyEnum.USER_PLATFORM, "android");
        c(jSONObject, "system", "Android " + Build.VERSION.RELEASE);
        c(jSONObject, "brand", Build.BRAND);
        c(jSONObject, "model", Build.MODEL);
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        c(jSONObject, "pixelRatio", Float.valueOf(resources.getDisplayMetrics().density));
    }

    public final void c(JSONObject jSONObject, String str, Object obj) {
        p.h(jSONObject, "obj");
        p.h(str, "key");
        try {
            jSONObject.put(str, obj);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "put with key(" + str + ')', new Object[0]);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final void P(Runnable runnable) {
        if (runnable != null) {
            AppBrandRuntime runtime = getRuntime();
            if (runtime != null) {
                runtime.P(runnable);
                return;
            }
            l lVar = this;
            if (lVar.bsX() || lVar.bsW()) {
                MMHandlerThread.postToMainThread(runnable);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final void i(Runnable runnable, long j2) {
        if (runnable != null) {
            AppBrandRuntime runtime = getRuntime();
            if (runtime != null) {
                runtime.i(runnable, j2);
                return;
            }
            l lVar = this;
            if (lVar.bsX() || lVar.bsW()) {
                MMHandlerThread.postToMainThreadDelayed(runnable, j2);
            }
        }
    }

    public final p Ze(String str) {
        p.h(str, "apiName");
        return this.lxp.get(str);
    }
}
