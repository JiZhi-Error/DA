package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class a extends d<s> {
    public static final int CTRL_INDEX = 585;
    public static final String NAME = "hideSplashScreen";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(130533);
        s sVar2 = sVar;
        Log.i("MicroMsg.JsApiHideSplashScreen", "hideSplashScreen jsApi");
        if (!Me()) {
            sVar2.i(i2, h("ok", null));
            Mf();
            AppMethodBeat.o(130533);
        } else if (sVar2.getRuntime() != null) {
            sVar2.getRuntime().brr();
            Mf();
            sVar2.i(i2, h("ok", null));
            AppMethodBeat.o(130533);
        } else {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(130533);
        }
    }

    /* access modifiers changed from: protected */
    public boolean Me() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void Mf() {
    }
}
