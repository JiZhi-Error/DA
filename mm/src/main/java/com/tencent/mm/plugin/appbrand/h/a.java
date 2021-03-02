package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class a {
    public static void a(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(139373);
        c(jSONObject, "useXWebVideo", Boolean.valueOf(z));
        c(jSONObject, "XWebVideoMinVersion", 300);
        AppMethodBeat.o(139373);
    }

    public static void b(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(139374);
        c(jSONObject, "useXWebMap", Boolean.valueOf(z));
        AppMethodBeat.o(139374);
    }

    public static void c(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(139376);
        c(jSONObject, "useXWebTextarea", Boolean.valueOf(z));
        AppMethodBeat.o(139376);
    }

    public static void d(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(139377);
        c(jSONObject, "supportXWebTextarea", Boolean.valueOf(z));
        AppMethodBeat.o(139377);
    }

    public static void e(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(139378);
        c(jSONObject, "supportXWebTouch", Boolean.valueOf(z));
        AppMethodBeat.o(139378);
    }

    public static void f(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(139379);
        c(jSONObject, "useXWebLive", Boolean.valueOf(z));
        AppMethodBeat.o(139379);
    }

    public static void g(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(139380);
        c(jSONObject, "useXWebCamera", Boolean.valueOf(z));
        AppMethodBeat.o(139380);
    }

    public static void h(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(215761);
        c(jSONObject, "abtestXWebCameraEnable", Boolean.valueOf(z));
        AppMethodBeat.o(215761);
    }

    public static void i(boolean z, JSONObject jSONObject) {
        AppMethodBeat.i(215762);
        c(jSONObject, "useXWebVoipRoom", Boolean.valueOf(z));
        AppMethodBeat.o(215762);
    }

    private static void c(JSONObject jSONObject, String str, Object obj) {
        AppMethodBeat.i(139381);
        try {
            jSONObject.put(str, obj);
            AppMethodBeat.o(139381);
        } catch (Exception e2) {
            Log.e("MicroMsg.SameLayer.AppBrandExtendPluginUtil", "build json object fail", e2);
            AppMethodBeat.o(139381);
        }
    }
}
