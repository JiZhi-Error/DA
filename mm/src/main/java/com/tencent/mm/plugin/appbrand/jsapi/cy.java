package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class cy {
    public static void a(i iVar, String str, String str2) {
        AppMethodBeat.i(147149);
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        Log.d("MicroMsg.JsScriptEvaluatorWC", "hy: dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), 0);
        iVar.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler('%s', %s)", str, str2), new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.cy.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(147148);
                Log.i("MicroMsg.JsScriptEvaluatorWC", "hy: value ret: %s", str);
                AppMethodBeat.o(147148);
            }
        });
        AppMethodBeat.o(147149);
    }
}
