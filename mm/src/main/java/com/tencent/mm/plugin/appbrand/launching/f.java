package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.km;
import com.tencent.mm.g.b.a.ms;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.an;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.p;
import org.json.JSONObject;

public final class f extends e implements aa {
    private final String kEY;
    private final String kHG;
    private final AppBrandLaunchFromNotifyReferrer kHI;
    private final HalfScreenConfig kHL;
    private final boolean kHM;
    private final int launchMode;
    private final boolean mQD;
    private ak mQE;
    private final LaunchParcel mQF;
    private a mQG;
    private volatile b mQH;

    public interface a {
        void bto();
    }

    f(LaunchParcel launchParcel, String str, boolean z, e.a<AppBrandInitConfigWC> aVar) {
        this(launchParcel, str, z, aVar, null);
    }

    public f(LaunchParcel launchParcel, String str, e.a<AppBrandInitConfigWC> aVar, a aVar2) {
        this(launchParcel, str, false, aVar, aVar2);
    }

    private f(LaunchParcel launchParcel, String str, boolean z, e.a<AppBrandInitConfigWC> aVar, a aVar2) {
        super(launchParcel, aVar);
        AppMethodBeat.i(227056);
        this.mQE = null;
        this.mQG = null;
        this.mQH = b.LEGACY;
        this.mQF = launchParcel;
        this.kEY = str;
        this.kHG = launchParcel.kHG;
        this.launchMode = launchParcel.launchMode;
        this.mQG = aVar2;
        this.kHI = launchParcel.kHI;
        this.mQD = z;
        this.kHL = launchParcel.kHL;
        this.kHM = launchParcel.kHM;
        Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "<init> username[%s] appId[%s] instanceId[%s] forceUseBackupWxaAttrs[%b]", launchParcel.username, launchParcel.appId, str, Boolean.valueOf(this.mQD));
        AppMethodBeat.o(227056);
    }

    public final void a(b bVar) {
        this.mQH = bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aa
    public final boolean bNh() {
        return this.mQF.cyz != b.PRE_RENDER;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e
    public final void run() {
        AppMethodBeat.i(47080);
        Pair<WxaAttributes, Boolean> bNg = bNg();
        WxaAttributes wxaAttributes = (WxaAttributes) bNg.first;
        if (wxaAttributes == null) {
            Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
            ms zX = new ms().zW(this.kEY).zX(this.appId);
            zX.eXc = (long) this.pkgVersion;
            zX.fec = ms.a.mD(this.iOo + 1);
            zX.eYW = 0;
            zX.erW = (long) this.kEH.scene;
            zX.fed = ms.c.common_fail;
            zX.fee = ms.b.sync;
            zX.eJb = (long) g.getNetworkType();
            zX.eoK = zX.x("UserName", this.username, true);
            zX.wL(this.mQE.bNF()).wM(this.mQE.bNG()).wJ(this.mQE.bNH()).bfK();
            onError();
            AppMethodBeat.o(47080);
        } else if (g(wxaAttributes)) {
            c.c(wxaAttributes.field_appId, KSProcessWeAppLaunch.stepCheckBan);
            onError();
            AppMethodBeat.o(47080);
        } else {
            c.b(wxaAttributes.field_appId, KSProcessWeAppLaunch.stepCheckBan);
            AppBrandInitConfigWC c2 = h.bzT().c(wxaAttributes);
            c2.eix = this.iOo;
            c2.kHG = this.kHG;
            c2.launchMode = this.launchMode;
            c2.leb = wxaAttributes.bAo().lgD.leb;
            c2.lec = wxaAttributes.bAo().lgD.lec;
            c2.kHI = this.kHI;
            c2.kHL = this.kHL;
            c2.kHM = this.kHM;
            c2.ldR = this.mQF.ldR;
            c2.ldQ = this.mQF.ldQ;
            c2.kHQ = this.mQF.kHQ;
            this.appId = c2.appId;
            com.tencent.mm.plugin.appbrand.ui.c.a.b bVar = (com.tencent.mm.plugin.appbrand.ui.c.a.b) n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class);
            p.h(c2, "initConfigWC");
            if (c2.ldN) {
                c2.lea = bVar.a(c2.appId, c2.eix, c2.appVersion, ao.isDarkMode());
            }
            c2.ldZ = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ClientBenchmarkLevel", -1);
            c2.ldW = new QualitySession(this.kEY, c2, this.kEH);
            c2.ldW.nLm = !((k) n.W(k.class)).Wt(this.username);
            c2.dC(this.kEY);
            if (((Boolean) bNg.second).booleanValue()) {
                c2.cyy = true;
                ms d2 = g.d(c2.ldW);
                d2.fed = ms.c.ok;
                ms wJ = d2.wL(this.mQE.bNF()).wM(this.mQE.bNG()).wJ(this.mQE.bNH());
                wJ.fee = ms.b.sync;
                wJ.eJb = (long) g.getNetworkType();
                wJ.bfK();
            } else {
                c2.cyy = false;
            }
            if (this.iOo == 0) {
                c2.cBG = wxaAttributes.bAp().lgT;
            } else {
                c2.extInfo = ((t) n.W(t.class)).bU(this.appId, this.iOo);
                try {
                    JSONObject FE = com.tencent.mm.ab.h.FE(c2.extInfo);
                    c2.cBG = FE.optString("device_orientation");
                    c2.cyp = FE.optBoolean("open_remote", false);
                    c2.ldS = FE.optString("debug_launch_info", null);
                    c2.cyv = ac.XM(c2.extInfo);
                    FE.remove("debug_launch_info");
                    ((t) n.W(t.class)).A(this.appId, this.iOo, FE.toString());
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", e2, "run() process extInfo with appId[%s] versionType[%d]", this.appId, Integer.valueOf(this.iOo));
                }
            }
            if (this.kEH == null) {
                this.kEH = new AppBrandStatObject();
            }
            if (this.mQE instanceof aj) {
                c2.led = true;
            }
            if (this.mQF.mYQ != null) {
                c2.lee = (WeAppOpenDeclarePromptBundle) this.mQF.mYQ;
            }
            if (this.mQF.mYR != null) {
                c2.lef = (AppBrandRuntimeReloadReportBundle) this.mQF.mYR;
            }
            a(c2, this.kEH);
            AppMethodBeat.o(47080);
        }
    }

    private static void yg(int i2) {
        AppMethodBeat.i(227057);
        try {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(369, i2);
            AppMethodBeat.o(227057);
        } catch (Throwable th) {
            Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "reportFallbackIDKey key(%d) get exception %s", Integer.valueOf(i2), th);
            AppMethodBeat.o(227057);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.launching.e
    public final Pair<WxaAttributes, Boolean> bNg() {
        Pair<WxaAttributes, Boolean> pair;
        Exception e2;
        Pair<WxaAttributes, Boolean> pair2;
        Pair<WxaAttributes, Boolean> bNI;
        long j2;
        int i2;
        AppMethodBeat.i(47081);
        Pair<WxaAttributes, Boolean> pair3 = new Pair<>(null, Boolean.FALSE);
        try {
            if (j.a.vP(this.iOo)) {
                if (this.mQD) {
                    Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] forceUseBackupWxaAttrs[TRUE]", this.username, this.appId);
                    yg(31);
                    an.b.bV(this.kEY, 0);
                    aj ajVar = new aj(this.username, this.appId);
                    this.mQE = ajVar;
                    Pair<WxaAttributes, Boolean> bNI2 = ajVar.bNI();
                    AppMethodBeat.o(47081);
                    return bNI2;
                } else if (an.ei(this.username, this.appId)) {
                    Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", this.username, this.appId);
                    yg(32);
                    an.b.bV(this.kEY, 0);
                    aj ajVar2 = new aj(this.username, this.appId);
                    this.mQE = ajVar2;
                    Pair<WxaAttributes, Boolean> bNI3 = ajVar2.bNI();
                    AppMethodBeat.o(47081);
                    return bNI3;
                }
            }
            if (this.kEH == null) {
                i2 = 0;
            } else {
                i2 = this.kEH.scene;
            }
            String str = null;
            if (1173 == i2) {
                str = com.tencent.mm.plugin.appbrand.openmaterial.model.a.ado(this.mQF.ldR);
            }
            bc bcVar = new bc(this.username, this.appId, this.iOo, this.pkgVersion, i2, this.kHw, this.kEH, this.cys, this.kEY, this.kHI, str, new aa.f() {
                /* class com.tencent.mm.plugin.appbrand.launching.f.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.config.aa.f
                public final void bAm() {
                    AppMethodBeat.i(174931);
                    if (f.this.mQG != null) {
                        f.this.mQG.bto();
                    }
                    AppMethodBeat.o(174931);
                }
            }, this.mQH);
            this.mQE = bcVar;
            pair = bcVar.bNI();
        } catch (TimeoutException e3) {
            Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes timeout with username[%s] appId[%s] step[%s]", this.username, this.appId, this.mQE.name());
            long bNH = this.mQE.bNH();
            if (!j.a.vP(this.iOo) || !an.bNJ()) {
                pair = pair3;
            } else {
                Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", this.username, this.appId);
                try {
                    an.b.bV(this.kEY, 0);
                    aj ajVar3 = new aj(this.username, this.appId);
                    this.mQE = ajVar3;
                    bNI = ajVar3.bNI();
                    yg(33);
                    WxaAttributes wxaAttributes = (WxaAttributes) bNI.first;
                    if (wxaAttributes != null) {
                        km kmVar = new km();
                        kmVar.xO(wxaAttributes.field_appId);
                        kmVar.xP(wxaAttributes.field_username);
                        if (this.kEH == null) {
                            j2 = 0;
                        } else {
                            j2 = (long) this.kEH.scene;
                        }
                        kmVar.eWc = j2;
                        kmVar.eWd = 0;
                        kmVar.eWe = (long) wxaAttributes.bAp().appVersion;
                        kmVar.eWj = 0;
                        kmVar.eWk = bNH;
                        kmVar.xQ(i.getNetworkType(MMApplicationContext.getContext()));
                        kmVar.eWi = 0;
                        kmVar.xR(this.kEY);
                        kmVar.bfK();
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    pair2 = pair3;
                    Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes fallback with username[%s] appId[%s], get exception[%s]", this.username, this.appId, e2);
                    ax.a(MMApplicationContext.getContext().getString(R.string.pb, ""), this);
                    AppMethodBeat.o(47081);
                    return pair2;
                }
            }
        } catch (Exception e5) {
            Log.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", e5, "get attr ", new Object[0]);
            pair = pair3;
        } catch (Throwable th) {
            try {
                Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() report fallback get exception %s", th);
            } catch (Exception e6) {
                e2 = e6;
                pair2 = bNI;
            }
        }
        AppMethodBeat.o(47081);
        return pair;
        AppMethodBeat.o(47081);
        return bNI;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.launching.e
    public final boolean g(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(47082);
        String str = wxaAttributes.field_appId;
        if (new au(str).bNK()) {
            AppMethodBeat.o(47082);
            return true;
        }
        if (2 == this.iOo) {
            if (this.mQG != null) {
                this.mQG.bto();
            }
            if (!bd.a(str, com.tencent.mm.plugin.appbrand.task.h.bWb().afi(str), this)) {
                AppMethodBeat.o(47082);
                return true;
            }
        }
        if (this.iOo != 0 || bd.a(wxaAttributes, this.mQC)) {
            AppMethodBeat.o(47082);
            return false;
        }
        AppMethodBeat.o(47082);
        return true;
    }
}
