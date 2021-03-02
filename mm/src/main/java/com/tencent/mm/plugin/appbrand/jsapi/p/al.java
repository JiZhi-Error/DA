package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class al extends k<s, f> {
    public static final int CTRL_INDEX = 12;
    public static final String NAME = "stopPullDownRefresh";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d, org.json.JSONObject, int, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.k
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2, f fVar) {
        AppMethodBeat.i(138251);
        fVar.bSf();
        sVar.i(i2, h("ok", null));
        AppMethodBeat.o(138251);
    }

    public al() {
        super(f.class);
    }
}
