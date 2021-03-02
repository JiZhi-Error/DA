package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.x;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g extends d<k> {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        ag agVar;
        h.a bUH;
        int i3;
        AppMethodBeat.i(46751);
        k kVar2 = kVar;
        try {
            q qVar = (q) kVar2.getRuntime();
            if (kVar2 instanceof ag) {
                agVar = (ag) kVar2;
            } else {
                agVar = (ag) ((s) kVar2).ax(ag.class);
            }
            String optString = jSONObject.optString("actionData");
            fcq fcq = new fcq();
            fcq.oUv = 2;
            fcq.jfi = qVar.mAppId;
            fcq.Cya = 0;
            fcq.rBX = (int) Util.nowSecond();
            fcq.Cyb = 0;
            fcq.Nyx = optString;
            fcq.LQr = qVar.bsB().leE.kNW + 1;
            fcq.Nyy = i.getNetworkType(MMApplicationContext.getContext());
            fcq.SessionId = qVar.bsC().cym;
            AppBrandStatObject appBrandStatObject = qVar.ON().cyA;
            fcq.IPh = appBrandStatObject.scene;
            fcq.Lru = appBrandStatObject.dCw;
            fcq.ecU = appBrandStatObject.ecU;
            fcq.ecV = appBrandStatObject.ecV;
            fcq.Nyz = appBrandStatObject.nHt;
            h bOz = qVar.bsD().getReporter().bOz();
            if (agVar != null) {
                bUH = bOz.s(agVar);
            } else {
                bUH = bOz.bUH();
            }
            fcq.Nyw = bUH.path;
            fcq.nIU = bUH.nII == null ? null : bUH.nII.path;
            if (bOz.aeN(bUH.path)) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            fcq.nIY = i3;
            Log.i("MicroMsg.JsApiReportRealtimeAction", "report(%s), path %s, appState %d, sessionId %s, scene %d, sceneNote %s, preScene %d, preSceneNote %s, usedState %d, referPath %s, isEntrance %d", qVar.mAppId, fcq.Nyw, Integer.valueOf(fcq.LQr), fcq.SessionId, Integer.valueOf(fcq.IPh), fcq.Lru, Integer.valueOf(fcq.ecU), fcq.ecV, Integer.valueOf(fcq.Nyz), fcq.nIU, Integer.valueOf(fcq.nIY));
            x.a.bUB().a(fcq);
            kVar2.i(i2, h("ok", null));
            AppMethodBeat.o(46751);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiReportRealtimeAction", "report by service(%s), e = %s", kVar2.getAppId(), e2);
            kVar2.i(i2, h("fail:internal error", null));
            AppMethodBeat.o(46751);
        }
    }
}
