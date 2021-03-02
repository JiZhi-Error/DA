package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class b extends k<ac, f> {
    public static final int CTRL_INDEX = 139;
    public static final String NAME = "disableScrollBounce";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d, org.json.JSONObject, int, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.k
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2, f fVar) {
        AppMethodBeat.i(138215);
        ac acVar2 = acVar;
        f fVar2 = fVar;
        if (jSONObject.has("disable")) {
            if (jSONObject.optBoolean("disable", false)) {
                fVar2.ij(false);
            } else {
                b.d pageConfig = acVar2.getPageConfig();
                if (pageConfig == null) {
                    fVar2.ij(false);
                } else {
                    fVar2.ij(pageConfig.lcy);
                }
            }
        }
        acVar2.i(i2, h("ok", null));
        AppMethodBeat.o(138215);
    }

    public b() {
        super(f.class);
    }
}
