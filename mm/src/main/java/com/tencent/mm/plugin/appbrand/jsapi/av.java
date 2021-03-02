package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class av extends d<s> {
    public static final int CTRL_INDEX = 747;
    public static final String NAME = "batchPreloadMiniProgram";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45465);
        s sVar2 = sVar;
        Log.d("MicroMsg.Predownload.JsApiBatchPreloadMiniProgram", "JsApiBatchPreloadMiniProgram data:%s", jSONObject);
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(45465);
            return;
        }
        q qVar = (q) sVar2.getRuntime();
        if (qVar == null) {
            sVar2.i(i2, h("fail:runtime error", null));
            AppMethodBeat.o(45465);
            return;
        }
        sVar2.i(i2, h(new AppBrandBatchPreloadController().preload(jSONObject, qVar.NA()), null));
        AppMethodBeat.o(45465);
    }
}
