package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class b extends s {
    private static final int CTRL_INDEX = 760;
    public static final String NAME = "onSplashAdButtonClicked";
    public String source = "launch";
    public String type = "close";

    public final void d(com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(160554);
        HashMap hashMap = new HashMap();
        hashMap.put("source", Util.nullAs(this.source, "launch"));
        hashMap.put("buttonType", Util.nullAs(this.type, "close"));
        Log.i("MicroMsg.JsApiEventOnSplashAdButtonClicked[AppBrandSplashAd]", "dispatch, source:%s, buttonType:%s", this.source, this.type);
        L(hashMap).g(sVar).bEo();
        AppMethodBeat.o(160554);
    }
}
