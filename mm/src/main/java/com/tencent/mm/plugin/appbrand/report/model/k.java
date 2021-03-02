package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class k {
    private static final k nIS = new k(true, null);
    public String appId;
    public int appVersion;
    public int apptype;
    public long costTime;
    public int dCv;
    public String dCw;
    public String dCx;
    public long dUy;
    public int ecU;
    public String ecV;
    public AppBrandRuntime kEc;
    public int ldX;
    public long mRS;
    public int nHt;
    public String nHu;
    private final boolean nIR;
    boolean nIT = false;
    public String nIU;
    public int nIV;
    public String nIW;
    public int nIX;
    public int nIY;
    public String nIZ;
    public String nJa;
    public long nJb;
    private final h nay;
    public String networkType;
    public int scene;
    public String sessionId;

    private k(boolean z, h hVar) {
        this.nIR = z;
        this.nay = hVar;
    }

    static {
        AppMethodBeat.i(48141);
        AppMethodBeat.o(48141);
    }

    public static k bUM() {
        return nIS;
    }

    public static k a(q qVar, String str, h hVar) {
        AppMethodBeat.i(48136);
        k kVar = new k(false, hVar);
        kVar.sessionId = str;
        AppBrandStatObject appBrandStatObject = qVar.ON().cyA;
        kVar.scene = appBrandStatObject.scene;
        kVar.dCw = appBrandStatObject.dCw;
        kVar.appId = qVar.mAppId;
        kVar.kEc = qVar;
        kVar.dCv = qVar.bsC().eix + 1;
        kVar.appVersion = qVar.bsC().appVersion;
        kVar.nHt = appBrandStatObject.nHt;
        kVar.ecU = appBrandStatObject.ecU;
        kVar.ecV = appBrandStatObject.ecV;
        AppMethodBeat.o(48136);
        return kVar;
    }

    public final void v(ag agVar) {
        AppMethodBeat.i(48137);
        w(agVar);
        report();
        AppMethodBeat.o(48137);
    }

    /* access modifiers changed from: package-private */
    public final void w(ag agVar) {
        h.b bVar;
        h.c cVar;
        int i2;
        h.c cVar2;
        String str;
        AppBrandInitConfigWC appBrandInitConfigWC = null;
        AppMethodBeat.i(48138);
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        if (bsB != null) {
            this.appVersion = bsB.leE.pkgVersion;
        }
        ICommLibReader bqZ = agVar.bqZ();
        if (bqZ != null) {
            this.nIX = bqZ.bvd();
        }
        this.mRS = agVar.nrs.nIs;
        this.costTime = agVar.nrs.bUD();
        this.dUy = agVar.nrs.bUE();
        this.nJb = agVar.nrs.bUs();
        if (agVar.getRuntime().NA()) {
            if (agVar.nrs.nHc == null) {
                str = agVar.lBI;
            } else {
                str = agVar.nrs.nHc;
            }
            this.dCx = str;
        } else {
            this.dCx = agVar.lBI;
        }
        this.nIZ = agVar.nna;
        this.networkType = i.getNetworkType(MMApplicationContext.getContext());
        this.nHt = agVar.getRuntime().ON().cyA.nHt;
        h.a s = this.nay.s(agVar);
        if (s != null) {
            h.c cVar3 = s.nIH;
            bVar = s.nII;
            cVar = cVar3;
        } else if (agVar.getRuntime() == null || !agVar.getRuntime().SO) {
            Log.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", agVar.nna);
            cVar = null;
            bVar = null;
        } else {
            h.d Uc = com.tencent.mm.plugin.appbrand.h.Uc(agVar.getAppId());
            Log.i("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", agVar.nna, Uc);
            switch (Uc) {
                case CLOSE:
                    cVar2 = new h.c(4);
                    break;
                case BACK:
                    cVar2 = new h.c(5);
                    break;
                default:
                    cVar2 = null;
                    break;
            }
            cVar = cVar2;
            bVar = null;
        }
        this.nIV = cVar == null ? 0 : cVar.type;
        this.nIW = cVar == null ? null : cVar.path;
        this.nIU = bVar == null ? null : bVar.path;
        if (this.nay.aeN(this.nIZ)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.nIY = i2;
        q runtime = agVar.getRuntime();
        if (runtime != null) {
            appBrandInitConfigWC = runtime.bsC();
        }
        if (appBrandInitConfigWC != null) {
            this.apptype = appBrandInitConfigWC.cyo;
        } else {
            this.apptype = j.aeJ(this.appId);
            Log.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(this.apptype));
        }
        this.apptype += 1000;
        this.ldX = agVar.getRuntime().bsC().ldX;
        String str2 = p.Um(agVar.getAppId()).kCY;
        if (!Util.isNullOrNil(str2)) {
            this.nJa = str2;
        }
        AppMethodBeat.o(48138);
    }

    public final String toString() {
        AppMethodBeat.i(48139);
        String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.dCw + '\'' + ", sessionId='" + this.sessionId + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", usedState=" + this.nHt + ", pagePath='" + this.dCx + '\'' + ", networkType='" + this.networkType + '\'' + ", costTime=" + this.costTime + ", stayTime=" + this.dUy + ", referPagePath='" + this.nIU + '\'' + ", targetAction=" + this.nIV + ", targetPagePath='" + this.nIW + '\'' + ", clickTimestamp=" + this.mRS + ", publicLibVersion=" + this.nIX + ", preScene=" + this.ecU + ", preSceneNote='" + this.ecV + '\'' + ", isEntrance=" + this.nIY + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.ldX + ", referAction=" + this.nJa + ", manufacturerAppId=" + this.nHu + ", stayTimeFuncPageStart=" + this.nJb + '}';
        AppMethodBeat.o(48139);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void report() {
        AppMethodBeat.i(48140);
        if (this.nIR) {
            AppMethodBeat.o(48140);
            return;
        }
        final Object[] objArr = {Integer.valueOf(this.scene), this.dCw, this.sessionId, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.nHt), this.dCx, this.networkType, Long.valueOf(this.costTime), Long.valueOf(this.dUy), this.nIU, Integer.valueOf(this.nIV), this.nIW, Long.valueOf(this.mRS), Integer.valueOf(this.nIX), Integer.valueOf(this.ecU), this.ecV, Integer.valueOf(this.nIY), this.nIZ, Integer.valueOf(this.apptype), Integer.valueOf(this.ldX), this.nJa, this.nHu, Long.valueOf(this.nJb)};
        AnonymousClass1 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.model.k.AnonymousClass1 */

            public final void run() {
                String encode;
                AppMethodBeat.i(48135);
                try {
                    String str = (String) objArr[19];
                    if (!Util.isNullOrNil(str)) {
                        int indexOf = str.indexOf(63);
                        if (indexOf < 0) {
                            encode = "";
                        } else {
                            encode = com.tencent.mm.compatible.util.q.encode(str.substring(indexOf + 1, str.length()));
                        }
                        objArr[19] = encode;
                    }
                    String str2 = (String) objArr[19];
                    if (Util.nullAsNil(str2).length() > 1024) {
                        objArr[19] = str2.substring(0, 1024);
                    }
                } catch (Exception e2) {
                    objArr[19] = "";
                    String str3 = (String) objArr[19];
                    if (Util.nullAsNil(str3).length() > 1024) {
                        objArr[19] = str3.substring(0, 1024);
                    }
                } catch (Throwable th) {
                    String str4 = (String) objArr[19];
                    if (Util.nullAsNil(str4).length() > 1024) {
                        objArr[19] = str4.substring(0, 1024);
                    }
                    AppMethodBeat.o(48135);
                    throw th;
                }
                int[] iArr = {1, 11, 13};
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = iArr[i2];
                    String str5 = (String) objArr[i3];
                    if (Util.nullAsNil(str5).length() > 1024) {
                        objArr[i3] = str5.substring(0, 1024);
                    }
                }
                Log.i("MicroMsg.AppBrand.Report.kv_13536", "report " + Arrays.deepToString(objArr));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13536, s.k(objArr));
                KVCommCrossProcessReceiver.eOD();
                AppMethodBeat.o(48135);
            }
        };
        if (this.nIT) {
            r1.run();
            try {
                KVCommCrossProcessReceiver.eOD();
                AppMethodBeat.o(48140);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", e2, "sendKV", new Object[0]);
                AppMethodBeat.o(48140);
            }
        } else {
            f.bZn().postToWorker(r1);
            AppMethodBeat.o(48140);
        }
    }
}
