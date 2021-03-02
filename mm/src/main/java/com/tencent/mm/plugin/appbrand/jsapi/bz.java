package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class bz extends d<ac> {
    public static final int CTRL_INDEX = 0;
    public static final String NAME = "openLink";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147140);
        ac acVar2 = acVar;
        String optString = jSONObject.optString("url");
        if (Util.isNullOrNil(optString)) {
            acVar2.i(i2, h("fail", null));
            AppMethodBeat.o(147140);
            return;
        }
        ((ag) acVar2.M(ag.class)).a(acVar2.getContext(), optString, null);
        acVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147140);
    }
}
