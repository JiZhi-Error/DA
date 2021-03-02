package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.a.f;
import org.json.JSONObject;

public final class u extends k<d, f> {
    public static final int CTRL_INDEX = 453;
    public static final String NAME = "setBackgroundColor";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d, org.json.JSONObject, int, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.k
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2, f fVar) {
        AppMethodBeat.i(138226);
        try {
            fVar.a(f.a.IGNORE, g.afE(jSONObject.optString("backgroundColor", "")));
            dVar.i(i2, h("ok", null));
            AppMethodBeat.o(138226);
        } catch (Exception e2) {
            dVar.i(i2, h("fail:invalid color", null));
            AppMethodBeat.o(138226);
        }
    }

    public u() {
        super(f.class);
    }
}
