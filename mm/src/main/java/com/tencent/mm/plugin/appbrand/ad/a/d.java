package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class d extends s {
    private static final int CTRL_INDEX = 752;
    public static final String NAME = "onSplashAdHide";
    public String source = "launch";

    public final void d(com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(44048);
        HashMap hashMap = new HashMap();
        hashMap.put("source", Util.nullAs(this.source, "launch"));
        Log.i("MicroMsg.JsApiEventOnSplashAdHide[AppBrandSplashAd]", "dispatch, source:%s", this.source);
        L(hashMap).g(sVar).bEo();
        AppMethodBeat.o(44048);
    }
}
