package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import org.json.JSONObject;

public final class cx {
    public static void a(o oVar, String str, String str2, int i2) {
        n nVar;
        AppMethodBeat.i(221221);
        if (!(oVar instanceof i) || (nVar = (n) ((i) oVar).R(n.class)) == null) {
            oVar.evaluateJavascript(z(str, str2, i2), null);
            AppMethodBeat.o(221221);
            return;
        }
        nVar.subscribeHandler(str, str2, i2, ayR());
        AppMethodBeat.o(221221);
    }

    public static String z(String str, String str2, int i2) {
        AppMethodBeat.i(140649);
        if (Util.isNullOrNil(str2)) {
            str2 = "{}";
        }
        try {
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = i2 == 0 ? "undefined" : String.valueOf(i2);
            objArr[3] = ayR();
            String format = String.format(locale, "WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)", objArr);
            AppMethodBeat.o(140649);
            return format;
        } catch (OutOfMemoryError e2) {
            String format2 = String.format(Locale.ENGLISH, "oom:%s, event:%s, data.size:%d", e2.getMessage(), str, Integer.valueOf(Util.nullAsNil(str2).length()));
            Log.e("MicroMsg.JsScriptEvaluator", "message:%s", format2);
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError(format2);
            AppMethodBeat.o(140649);
            throw outOfMemoryError;
        }
    }

    public static String ayR() {
        AppMethodBeat.i(140650);
        try {
            String jSONObject = new JSONObject().put("nativeTime", System.currentTimeMillis()).toString();
            AppMethodBeat.o(140650);
            return jSONObject;
        } catch (Exception e2) {
            Log.e("MicroMsg.JsScriptEvaluator", "makeExtStatJson e = %s", e2);
            AppMethodBeat.o(140650);
            return "{}";
        }
    }
}
