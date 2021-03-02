package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.a.f;
import org.json.JSONObject;

public final class v extends k<d, f> {
    public static final int CTRL_INDEX = 454;
    public static final String NAME = "setBackgroundTextStyle";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d, org.json.JSONObject, int, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.k
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2, f fVar) {
        AppMethodBeat.i(138227);
        fVar.adV(jSONObject.optString("textStyle", f.a.IGNORE.name().toLowerCase()));
        dVar.i(i2, h("ok", null));
        AppMethodBeat.o(138227);
    }

    public v() {
        super(f.class);
    }
}
