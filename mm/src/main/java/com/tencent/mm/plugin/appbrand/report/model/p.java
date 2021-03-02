package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.af.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class p {
    private static final p nJZ = new p(true);
    public String appId;
    public int appVersion;
    public int apptype;
    public int dCv;
    public String dCw;
    public String dCx;
    public int ecU;
    public String ecV;
    public q kBw;
    public long mRS;
    public int nHt;
    private final boolean nIR;
    boolean nIT = false;
    public String nIU;
    public int nIV;
    public String nIW;
    public int nIX;
    public int nIY;
    public String nIZ;
    private String nKa = "";
    public final LinkedList<String> nKb = new LinkedList<>();
    public String nKc;
    public boolean nKd = true;
    public String networkType;
    public int scene;
    public String sessionId;

    private p(boolean z) {
        AppMethodBeat.i(48175);
        this.nIR = z;
        AppMethodBeat.o(48175);
    }

    static {
        AppMethodBeat.i(48183);
        AppMethodBeat.o(48183);
    }

    public static p bUW() {
        return nJZ;
    }

    public static p a(q qVar, String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(48176);
        p pVar = new p(false);
        pVar.sessionId = str;
        AppBrandStatObject appBrandStatObject = qVar.ON().cyA;
        pVar.scene = appBrandStatObject.scene;
        pVar.dCw = appBrandStatObject.dCw;
        pVar.appId = qVar.mAppId;
        pVar.kBw = qVar;
        if (qVar.bsB() == null) {
            pVar.dCv = qVar.kAq.eix + 1;
            pVar.appVersion = qVar.bsC().appVersion;
        } else {
            pVar.dCv = qVar.bsB().leE.kNW + 1;
            pVar.appVersion = qVar.bsB().leE.pkgVersion;
        }
        pVar.nHt = appBrandStatObject.nHt;
        pVar.ecU = appBrandStatObject.ecU;
        pVar.ecV = appBrandStatObject.ecV;
        pVar.nKb.addAll(linkedList);
        AppMethodBeat.o(48176);
        return pVar;
    }

    public final void a(ag agVar, String str) {
        AppMethodBeat.i(48177);
        this.nIU = this.nKb.peekFirst();
        this.nIV = 2;
        this.nIW = str;
        this.nKb.push(agVar.lBI);
        this.nKa = agVar.lBI;
        y(agVar);
        AppMethodBeat.o(48177);
    }

    public final void a(ag agVar, boolean z) {
        AppMethodBeat.i(48178);
        this.nIV = z ? 1 : 7;
        String pollFirst = this.nKb.pollFirst();
        this.nIW = pollFirst;
        this.nIU = pollFirst;
        if (!z) {
            this.nIW = this.nKa;
        }
        y(agVar);
        AppMethodBeat.o(48178);
    }

    public final void y(ag agVar) {
        AppMethodBeat.i(48179);
        a bRM = agVar.bRM();
        if (bRM == null) {
            AppMethodBeat.o(48179);
            return;
        }
        b(agVar, bRM);
        report();
        AppMethodBeat.o(48179);
    }

    private void b(ag agVar, a aVar) {
        AppMethodBeat.i(48180);
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        if (bsB != null) {
            this.appVersion = bsB.leE.pkgVersion;
        }
        ICommLibReader bqZ = agVar.bqZ();
        if (bqZ != null) {
            this.nIX = bqZ.bvd();
        }
        this.mRS = System.currentTimeMillis();
        String url = aVar.getWebView().getUrl();
        if (url == null) {
            url = "";
        }
        this.nKc = com.tencent.mm.compatible.util.q.encode(url);
        this.dCx = agVar.lBI;
        this.nIZ = agVar.nna;
        this.networkType = i.getNetworkType(MMApplicationContext.getContext());
        this.nIY = this.nKd ? 1 : 0;
        this.nKd = false;
        q runtime = agVar.getRuntime();
        AppBrandInitConfigWC bsC = runtime == null ? null : runtime.bsC();
        if (bsC != null) {
            this.apptype = bsC.cyo;
        } else {
            this.apptype = j.aeJ(this.appId);
            Log.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(this.apptype));
        }
        this.apptype += 1000;
        AppMethodBeat.o(48180);
    }

    public final String toString() {
        AppMethodBeat.i(48181);
        String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", usedState=" + this.nHt + ", pagePath='" + this.dCx + '\'' + ", currentUrl='" + this.nKc + '\'' + ", networkType='" + this.networkType + '\'' + ", referPagePath='" + this.nIU + '\'' + ", targetAction=" + this.nIV + ", targetPagePath='" + this.nIW + '\'' + ", clickTimestamp=" + this.mRS + ", publicLibVersion=" + this.nIX + ", preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", isEntrance=" + this.nIY + ", apptype=" + this.apptype + '}';
        AppMethodBeat.o(48181);
        return str;
    }

    private void report() {
        AppMethodBeat.i(48182);
        if (this.nIR) {
            AppMethodBeat.o(48182);
            return;
        }
        Log.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
        final Object[] objArr = {Integer.valueOf(this.scene), this.dCw, this.sessionId, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.nHt), this.dCx, this.nKc, this.networkType, this.nIU, Integer.valueOf(this.nIV), this.nIW, Long.valueOf(this.mRS), Integer.valueOf(this.nIX), Integer.valueOf(this.ecU), this.ecV, Integer.valueOf(this.nIY), this.nIZ, Integer.valueOf(this.apptype)};
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.model.p.AnonymousClass1 */

            public final void run() {
                String encode;
                AppMethodBeat.i(48173);
                try {
                    String str = (String) objArr[18];
                    if (!Util.isNullOrNil(str)) {
                        int indexOf = str.indexOf(63);
                        if (indexOf < 0) {
                            encode = "";
                        } else {
                            encode = com.tencent.mm.compatible.util.q.encode(str.substring(indexOf + 1, str.length()));
                        }
                        objArr[18] = encode;
                    }
                } catch (Exception e2) {
                    objArr[18] = "";
                }
                h.INSTANCE.a(14992, s.k(objArr));
                KVCommCrossProcessReceiver.eOD();
                AppMethodBeat.o(48173);
            }
        };
        if (this.nIT) {
            r1.run();
            try {
                KVCommCrossProcessReceiver.eOD();
                AppMethodBeat.o(48182);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", e2, "sendKV", new Object[0]);
                AppMethodBeat.o(48182);
            }
        } else {
            f.bZn().postToWorker(r1);
            AppMethodBeat.o(48182);
        }
    }
}
