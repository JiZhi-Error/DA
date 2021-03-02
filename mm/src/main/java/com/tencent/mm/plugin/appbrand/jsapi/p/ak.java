package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class ak extends k<s, f> {
    public static final int CTRL_INDEX = 284;
    public static final String NAME = "startPullDownRefresh";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d, org.json.JSONObject, int, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.k
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2, f fVar) {
        AppMethodBeat.i(138250);
        fVar.bSe();
        sVar.i(i2, h("ok", null));
        AppMethodBeat.o(138250);
    }

    public ak() {
        super(f.class);
    }
}
