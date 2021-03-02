package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class c extends d<s> {
    public static final int CTRL_INDEX = 395;
    public static final String NAME = "setDeviceOrientation";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(130535);
        final s sVar2 = sVar;
        if (jSONObject == null) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(130535);
            return;
        }
        try {
            e orientationHandler = sVar2.kEb.getOrientationHandler();
            if (orientationHandler == null) {
                NullPointerException nullPointerException = new NullPointerException();
                AppMethodBeat.o(130535);
                throw nullPointerException;
            }
            e.b aeE = e.b.aeE(jSONObject.optString("value", null));
            if (aeE == null) {
                sVar2.i(i2, h("fail:invalid data", null));
                AppMethodBeat.o(130535);
            } else if (sVar2.getRuntime() == null || AndroidContextUtil.castActivityOrNull(sVar2.getRuntime().mContext) == null) {
                sVar2.i(i2, h("fail", null));
                AppMethodBeat.o(130535);
            } else {
                orientationHandler.a(aeE, new e.a() {
                    /* class com.tencent.luggage.game.d.c.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
                    public final void a(e.b bVar, boolean z) {
                        String str;
                        AppMethodBeat.i(177432);
                        s sVar = sVar2;
                        int i2 = i2;
                        c cVar = c.this;
                        if (z) {
                            str = "ok";
                        } else {
                            str = "fail";
                        }
                        sVar.i(i2, cVar.h(str, null));
                        AppMethodBeat.o(177432);
                    }
                });
                AppMethodBeat.o(130535);
            }
        } catch (NullPointerException e2) {
            Log.printErrStackTrace("MicroMsg.JsApiSetDeviceOrientation", e2, "require WindowOrientationHandler NPE", new Object[0]);
            sVar2.i(i2, h("fail:internal error", null));
            AppMethodBeat.o(130535);
        }
    }
}
