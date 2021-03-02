package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class b extends a {
    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(211033);
        JSONObject jSONObject = nVar.ISf;
        if (jSONObject == null) {
            AppMethodBeat.o(211033);
            return false;
        }
        String preload = ((IAppBrandBatchPreloadController) g.af(IAppBrandBatchPreloadController.class)).preload(jSONObject, true);
        if (!Util.isNullOrNil(preload)) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":" + preload, null);
        } else {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":error", null);
        }
        AppMethodBeat.o(211033);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return 366;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return av.NAME;
    }
}
