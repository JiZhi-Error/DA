package com.tencent.mm.plugin.box.webview;

import android.annotation.TargetApi;
import android.webkit.JavascriptInterface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class d {
    b plU;

    public d(b bVar) {
        this.plU = bVar;
    }

    @JavascriptInterface
    public void request(String str) {
        AppMethodBeat.i(76357);
        Log.i("MicroMsg.Box.BoxWebViewJSApi", "request %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.plU.ckZ().fc(jSONObject.optString("requestId", ""), jSONObject.optString("data", ""));
            AppMethodBeat.o(76357);
        } catch (Exception e2) {
            AppMethodBeat.o(76357);
        }
    }

    @JavascriptInterface
    public void webviewUIReady() {
        AppMethodBeat.i(76358);
        Log.i("MicroMsg.Box.BoxWebViewJSApi", "webviewUIReady");
        h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.box.webview.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(76355);
                AppMethodBeat.o(76355);
            }
        });
        AppMethodBeat.o(76358);
    }

    @JavascriptInterface
    public void openWeAppPage(String str) {
        AppMethodBeat.i(76359);
        Log.i("MicroMsg.Box.BoxWebViewJSApi", "openWeAppPage %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("userName", "");
            String optString2 = jSONObject.optString("relativeURL", "");
            wq wqVar = new wq();
            wqVar.ecI.userName = optString;
            wqVar.ecI.ecK = optString2;
            wqVar.ecI.scene = jSONObject.optInt("scene", 1000);
            EventCenter.instance.publish(wqVar);
            AppMethodBeat.o(76359);
        } catch (Exception e2) {
            AppMethodBeat.o(76359);
        }
    }

    @JavascriptInterface
    public void reportKV(String str) {
        AppMethodBeat.i(76360);
        Log.i("MicroMsg.Box.BoxWebViewJSApi", "reportKV %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            e.INSTANCE.kvStat(jSONObject.optInt("logid", 0), jSONObject.optString("msg", ""));
            AppMethodBeat.o(76360);
        } catch (Exception e2) {
            AppMethodBeat.o(76360);
        }
    }

    @JavascriptInterface
    public void log(String str) {
        AppMethodBeat.i(76361);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Log.i("MicroMsg.Box.BoxWebViewJSApi", "[%s][%s]", jSONObject.optString("level", ""), jSONObject.optString("msg", ""));
            AppMethodBeat.o(76361);
        } catch (Exception e2) {
            AppMethodBeat.o(76361);
        }
    }

    @JavascriptInterface
    public void closePage() {
        AppMethodBeat.i(76362);
        Log.i("MicroMsg.Box.BoxWebViewJSApi", "closePage");
        this.plU.dismiss();
        AppMethodBeat.o(76362);
    }

    public final void f(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(76363);
        Log.i("MicroMsg.Box.BoxWebViewJSApi", "onDataReady %s %s %s", str, Integer.valueOf(i2), str2);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", str);
            jSONObject.put("ret", i2);
            jSONObject.put("data", str3);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.box.webview.d.AnonymousClass2 */

                @TargetApi(7)
                public final void run() {
                    String str;
                    AppMethodBeat.i(76356);
                    String jSONObject = jSONObject.toString();
                    b bVar = d.this.plU;
                    try {
                        if (Util.isNullOrNil("requestCompleted")) {
                            AppMethodBeat.o(76356);
                            return;
                        }
                        String nullAsNil = Util.nullAsNil(jSONObject);
                        Object[] objArr = new Object[2];
                        objArr[0] = "requestCompleted";
                        if (Util.isNullOrNil(nullAsNil) || nullAsNil.length() <= 50) {
                            str = nullAsNil;
                        } else {
                            str = nullAsNil.substring(0, 50);
                        }
                        objArr[1] = str;
                        Log.i("MicroMsg.Box.BoxJsEventNotifier", "notifyJsEvent %s %s", objArr);
                        bVar.ckY().evaluateJavascript(String.format("javascript:boxJSApi['%s'] && boxJSApi.%s(%s)", "requestCompleted", "requestCompleted", nullAsNil), null);
                        AppMethodBeat.o(76356);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Box.BoxJsEventNotifier", e2, "notifyJsEvent", new Object[0]);
                        AppMethodBeat.o(76356);
                    }
                }
            });
            AppMethodBeat.o(76363);
        } catch (Exception e2) {
            AppMethodBeat.o(76363);
        }
    }
}
