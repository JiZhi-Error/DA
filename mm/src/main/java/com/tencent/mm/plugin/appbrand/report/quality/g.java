package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.sdk.config.c;
import com.tencent.luggage.sdk.config.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mb;
import com.tencent.mm.g.b.a.mk;
import com.tencent.mm.g.b.a.ms;
import com.tencent.mm.g.b.a.mu;
import com.tencent.mm.g.b.a.mv;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u001e\u001a\u00020\u0012*\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010 \u001a\u00020\u0012*\u00020!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "TAG", "", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createJsApiInfoReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemJsApiInfoCGIStruct;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", f.NAME, "", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "hasPreLoading", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "appId", "reportGetA8KeyIfScanEnterBeforeLaunch", "instanceId", "assignFromQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class g {
    public static final g nKK = new g();

    static {
        AppMethodBeat.i(51058);
        AppMethodBeat.o(51058);
    }

    private g() {
    }

    public static final int getNetworkType() {
        AppMethodBeat.i(51049);
        String networkType = i.getNetworkType(MMApplicationContext.getContext());
        if (networkType == null) {
            p.hyc();
        }
        if (p.j(networkType, i.nHj)) {
            AppMethodBeat.o(51049);
            return 0;
        } else if (p.j(networkType, i.nHk)) {
            AppMethodBeat.o(51049);
            return 1;
        } else if (p.j(networkType, i.nHl)) {
            AppMethodBeat.o(51049);
            return 2;
        } else if (p.j(networkType, i.nHm)) {
            AppMethodBeat.o(51049);
            return 3;
        } else if (p.j(networkType, i.nHn)) {
            AppMethodBeat.o(51049);
            return 4;
        } else if (p.j(networkType, "offline")) {
            AppMethodBeat.o(51049);
            return 5;
        } else {
            AppMethodBeat.o(51049);
            return 10000;
        }
    }

    public static final ms d(QualitySession qualitySession) {
        AppMethodBeat.i(51050);
        p.h(qualitySession, "session");
        ms msVar = new ms();
        msVar.zX(qualitySession.appId);
        msVar.zW(qualitySession.kEY);
        msVar.a(ms.a.mD(qualitySession.nJE));
        msVar.wI((long) qualitySession.apptype);
        msVar.wK((long) qualitySession.scene);
        msVar.wH((long) qualitySession.nLk);
        AppMethodBeat.o(51050);
        return msVar;
    }

    public static final mv e(QualitySession qualitySession) {
        AppMethodBeat.i(51051);
        p.h(qualitySession, "session");
        mv mvVar = new mv();
        mvVar.Ae(qualitySession.appId);
        mvVar.Ad(qualitySession.kEY);
        mvVar.a(mv.a.mH(qualitySession.nJE));
        mvVar.xc((long) qualitySession.apptype);
        mvVar.xe((long) qualitySession.scene);
        mvVar.xb((long) qualitySession.nLk);
        AppMethodBeat.o(51051);
        return mvVar;
    }

    public static final mu f(QualitySession qualitySession) {
        AppMethodBeat.i(229313);
        p.h(qualitySession, "session");
        mu muVar = new mu();
        muVar.Ac(qualitySession.appId);
        muVar.Ab(qualitySession.kEY);
        muVar.a(mu.a.mG(qualitySession.nJE));
        muVar.wW((long) qualitySession.apptype);
        muVar.wY((long) qualitySession.scene);
        muVar.wV((long) qualitySession.nLk);
        AppMethodBeat.o(229313);
        return muVar;
    }

    public static final QualitySessionRuntime g(QualitySession qualitySession) {
        AppMethodBeat.i(51052);
        p.h(qualitySession, "session");
        Parcel obtain = Parcel.obtain();
        p.g(obtain, "Parcel.obtain()");
        obtain.setDataPosition(0);
        qualitySession.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        QualitySessionRuntime qualitySessionRuntime = new QualitySessionRuntime(obtain);
        obtain.recycle();
        AppMethodBeat.o(51052);
        return qualitySessionRuntime;
    }

    public static final void a(q qVar, boolean z, boolean z2) {
        long j2 = 1;
        AppMethodBeat.i(51053);
        p.h(qVar, "runtime");
        QualitySessionRuntime aeU = b.aeU(qVar.getAppId());
        if (aeU != null) {
            mk mkVar = new mk();
            mkVar.zC(aeU.appId);
            mkVar.we((long) aeU.nLk);
            mkVar.a(mk.a.mw(aeU.nJE));
            mkVar.wf((long) aeU.apptype);
            mkVar.wg((long) qVar.Nz().scene);
            mkVar.zD(t.el(MMApplicationContext.getContext()));
            mkVar.zE(qVar.bsC().username);
            mkVar.zB(aeU.kEY);
            AppBrandInitConfigWC bsC = qVar.bsC();
            p.g(bsC, "runtime.initConfig");
            mkVar.zJ(bsC.NB());
            mkVar.wi(z ? 0 : 1);
            mkVar.wh(System.currentTimeMillis());
            if (!z2) {
                j2 = 0;
            }
            mkVar.wj(j2);
            p.g(aeU, "session");
            mkVar.wk(aeU.bVj());
            mkVar.zF(com.tencent.mm.compatible.util.q.encode(qVar.brs()));
            AppBrandRuntimeReloadReportBundle appBrandRuntimeReloadReportBundle = qVar.bsC().lef;
            if (appBrandRuntimeReloadReportBundle != null) {
                mkVar.zG(appBrandRuntimeReloadReportBundle.mZr);
                mkVar.zH(appBrandRuntimeReloadReportBundle.mZs);
            }
            mkVar.mv(aeU.nLm ? 1 : 0);
            mkVar.wl((long) qVar.bsC().launchMode);
            mkVar.wm(qVar.bsC().cyz.OC());
            Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen report appId[" + qVar.getAppId() + "], instanceId[" + mkVar.aiv() + "], sessionId[" + mkVar.getSessionId() + ']');
            mkVar.bfK();
            AppMethodBeat.o(51053);
            return;
        }
        new a(qVar).invoke();
        AppMethodBeat.o(51053);
    }

    public static final String c(LaunchParcel launchParcel, String str) {
        String NI;
        long j2;
        int i2;
        AppMethodBeat.i(229314);
        p.h(launchParcel, "parcel");
        String co = h.bWb().co(str, launchParcel.iOo);
        String str2 = co;
        if (!(str2 == null || str2.length() == 0)) {
            j2 = 0;
            NI = co;
        } else {
            NI = c.a.czh.NI();
            p.g(NI, "MPInstanceIdFactory.IMPL…STANCE.createInstanceId()");
            j2 = 1;
        }
        String NJ = d.a.czj.NJ();
        launchParcel.acj(NJ);
        mk mkVar = new mk();
        mkVar.zB(NI);
        mkVar.wi(j2);
        mkVar.zC(launchParcel.appId);
        mkVar.we((long) launchParcel.version);
        mkVar.a(mk.a.mw(launchParcel.iOo + 1));
        mkVar.wg((long) launchParcel.mYK.scene);
        mkVar.zD(t.el(MMApplicationContext.getContext()));
        mkVar.zE(launchParcel.username);
        String str3 = launchParcel.kHw;
        if (str3 == null) {
            str3 = "";
        }
        mkVar.zF(com.tencent.mm.compatible.util.q.encode(str3));
        Parcelable parcelable = launchParcel.mYR;
        if (!(parcelable instanceof AppBrandRuntimeReloadReportBundle)) {
            parcelable = null;
        }
        AppBrandRuntimeReloadReportBundle appBrandRuntimeReloadReportBundle = (AppBrandRuntimeReloadReportBundle) parcelable;
        if (appBrandRuntimeReloadReportBundle != null) {
            mkVar.zG(appBrandRuntimeReloadReportBundle.mZr);
            mkVar.zH(appBrandRuntimeReloadReportBundle.mZs);
        }
        String str4 = launchParcel.username;
        if (!(str4 == null || str4.length() == 0) && MMApplicationContext.isMainProcess()) {
            if (((k) n.W(k.class)).Wt(launchParcel.username)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            mkVar.mv(i2);
        }
        mkVar.wl((long) launchParcel.launchMode);
        mkVar.wm(launchParcel.cyz.OC());
        mkVar.zI(launchParcel.kHQ);
        mkVar.wh(System.currentTimeMillis());
        mkVar.zJ(NJ);
        Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpenBeforeLaunch username[" + launchParcel.username + "] appId[" + str + "] instanceId[" + mkVar.aiv() + "] sessionId[" + mkVar.getSessionId() + ']');
        mkVar.bfK();
        AppMethodBeat.o(229314);
        return NI;
    }

    public static final void a(LaunchParcel launchParcel, String str, String str2) {
        AppMethodBeat.i(229315);
        p.h(launchParcel, "parcel");
        p.h(str, "instanceId");
        if (launchParcel.mYK.nHw != null) {
            mb mbVar = new mb();
            mbVar.zl(str);
            mbVar.mp(launchParcel.mYK.nHw.getInt("CgiSpeedOutSideStructCgiNo"));
            mbVar.zo(launchParcel.mYK.nHw.getString("CgiSpeedOutSideStructNetworkType"));
            mbVar.zn(launchParcel.username);
            mbVar.zm(str2);
            mbVar.mo(launchParcel.mYK.nHw.getInt("CgiSpeedOutSideStructBizRet"));
            mbVar.vD(launchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructCostTime"));
            mbVar.vC(launchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructEndTimeStamp"));
            mbVar.vE(launchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructResponseSize"));
            mbVar.mn(launchParcel.mYK.nHw.getInt("CgiSpeedOutSideStructRet"));
            mbVar.vB(launchParcel.mYK.nHw.getLong("CgiSpeedOutSideStructStartTimeStamp"));
            mbVar.bfK();
        }
        AppMethodBeat.o(229315);
    }

    public static final void a(kv_14609 kv_14609, QualitySession qualitySession) {
        AppMethodBeat.i(51057);
        p.h(kv_14609, "$this$assignFromQualitySession");
        p.h(qualitySession, "session");
        kv_14609.aeS(qualitySession.kEY);
        kv_14609.appType = qualitySession.apptype;
        kv_14609.scene = qualitySession.scene;
        AppMethodBeat.o(51057);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ q kAi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar) {
            super(0);
            this.kAi = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(51047);
            Log.i("MicroMsg.AppStartupPerformanceReportUtil", "qualityOpen NULL session, appId[" + this.kAi.getAppId() + ']');
            x xVar = x.SXb;
            AppMethodBeat.o(51047);
            return xVar;
        }
    }
}
