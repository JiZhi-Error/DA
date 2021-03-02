package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.x;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class m {
    private static final m nJt = new m(true, h.nIG);
    public String appId;
    public int dCv;
    public String dCw;
    public String dCx;
    public int ecU;
    public String ecV;
    public int nHt;
    private final boolean nIR;
    public String nIU;
    public int nIY;
    private final h nay;
    public int scene;
    public String sessionId;

    private m(boolean z, h hVar) {
        this.nIR = z;
        this.nay = hVar;
    }

    static {
        AppMethodBeat.i(48155);
        AppMethodBeat.o(48155);
    }

    public static m bUN() {
        return nJt;
    }

    public static m b(q qVar, String str, h hVar) {
        AppMethodBeat.i(48150);
        m mVar = new m(false, hVar);
        try {
            mVar.sessionId = str;
            mVar.appId = qVar.mAppId;
            AppBrandStatObject appBrandStatObject = qVar.ON().cyA;
            mVar.scene = appBrandStatObject.scene;
            mVar.dCw = appBrandStatObject.dCw;
            mVar.ecU = appBrandStatObject.ecU;
            mVar.ecV = appBrandStatObject.ecV;
            mVar.nHt = appBrandStatObject.nHt;
            mVar.dCv = qVar.bsC().eix + 1;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", e2, "Kv_14004 protect the npe", new Object[0]);
        }
        AppMethodBeat.o(48150);
        return mVar;
    }

    private void report() {
        AppMethodBeat.i(48152);
        if (this.nIR) {
            AppMethodBeat.o(48152);
            return;
        }
        this.dCx = aeR(this.dCx);
        this.nIU = aeR(this.nIU);
        fcq fcq = new fcq();
        fcq.oUv = 1;
        fcq.jfi = this.appId;
        fcq.Nyw = this.dCx;
        fcq.Cya = 0;
        fcq.rBX = (int) Util.nowSecond();
        fcq.Cyb = 1;
        fcq.Nyx = "";
        fcq.LQr = this.dCv;
        fcq.SessionId = this.sessionId;
        fcq.Nyy = i.getNetworkType(MMApplicationContext.getContext());
        fcq.IPh = this.scene;
        fcq.Nyz = this.nHt;
        fcq.Lru = this.dCw;
        fcq.nIU = this.nIU;
        fcq.ecU = this.ecU;
        fcq.ecV = this.ecV;
        fcq.nIY = this.nIY;
        x.a.bUB().a(fcq);
        Log.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
        AppMethodBeat.o(48152);
    }

    private static String aeR(String str) {
        AppMethodBeat.i(48153);
        if (Util.nullAsNil(str).length() > 1024) {
            str = str.substring(0, 1024);
        }
        AppMethodBeat.o(48153);
        return str;
    }

    public final String toString() {
        AppMethodBeat.i(48154);
        String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.sessionId + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", pagePath='" + this.dCx + '\'' + ", usedState=" + this.nHt + ", appState=" + this.dCv + ", referPagePath='" + this.nIU + '\'' + ", isEntrance=" + this.nIY + '}';
        AppMethodBeat.o(48154);
        return str;
    }

    public final void x(ag agVar) {
        AppMethodBeat.i(48151);
        this.dCx = agVar.nna;
        h.a s = this.nay.s(agVar);
        this.nIU = (s == null || s.nII == null) ? null : s.nII.path;
        this.nIY = this.nay.aeN(this.dCx) ? 1 : 0;
        report();
        AppMethodBeat.o(48151);
    }
}
