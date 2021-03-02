package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class cc extends d<s> {
    public static final int CTRL_INDEX = 201;
    public static final String NAME = "openUrl";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        Context context;
        AppMethodBeat.i(147141);
        s sVar2 = sVar;
        String optString = jSONObject.optString("url");
        if (Util.isNullOrNil(optString) || (context = sVar2.getContext()) == null) {
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(147141);
            return;
        }
        ((ag) sVar2.M(ag.class)).a(context, optString, null);
        sVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147141);
    }
}
