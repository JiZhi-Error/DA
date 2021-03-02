package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.f.a;
import com.tencent.mm.plugin.appbrand.game.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class c extends d<com.tencent.mm.plugin.appbrand.service.c> {
    public static final int CTRL_INDEX = 688;
    public static final String NAME = "reportCanvasData";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45166);
        com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        Log.i("MicroMsg.JsApiReportCanvasData", "hy: request report canvas data");
        String optString = jSONObject.optString("eventInfo");
        int optInt = jSONObject.optInt("viewId", 0);
        if (cVar2.bsz() == null || cVar2.bsz().S(a.class) == null) {
            Log.w("MicroMsg.JsApiReportCanvasData", "hy: current is not game");
            AppMethodBeat.o(45166);
            return;
        }
        b bDj = ((a) cVar2.bsz().S(a.class)).bDj();
        if (bDj != null) {
            Log.d("MicroMsg.WAGameCanvasSecurityGuard", "hy: trigger event : %s", optString);
            bDj.lta.postToWorker(new Runnable(optInt, optString) {
                /* class com.tencent.mm.plugin.appbrand.game.f.b.AnonymousClass2 */
                final /* synthetic */ int ltd;
                final /* synthetic */ String lte;

                {
                    this.ltd = r2;
                    this.lte = r3;
                }

                /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
                /* JADX WARNING: Removed duplicated region for block: B:33:0x00b1  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 736
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.game.f.b.AnonymousClass2.run():void");
                }
            });
            AppMethodBeat.o(45166);
            return;
        }
        Log.e("MicroMsg.JsApiReportCanvasData", "hy: guard is null!");
        AppMethodBeat.o(45166);
    }
}
