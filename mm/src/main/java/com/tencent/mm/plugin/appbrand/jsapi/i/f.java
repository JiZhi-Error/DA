package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class f extends g {
    private static final int CTRL_INDEX = 587;
    private static final String NAME = "disableLocationUpdate";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.g, com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.i.e
    public final /* bridge */ /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46376);
        a(sVar, jSONObject, i2);
        AppMethodBeat.o(46376);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.g
    public final void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46375);
        super.a(sVar, jSONObject, i2);
        if (this.lXb != null && this.lXb.lXu) {
            AppBrandBackgroundRunningMonitor.a(sVar, 2, c.kYp.beL);
        }
        AppMethodBeat.o(46375);
    }
}
