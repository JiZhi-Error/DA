package com.tencent.mm.plugin.appbrand.launching;

import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.sdk.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.n;
import com.tencent.mm.g.a.abb;
import com.tencent.mm.g.a.abc;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.b.a.km;
import com.tencent.mm.g.b.a.mt;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.x;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.b.b;
import com.tencent.mm.plugin.appbrand.appstorage.e;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;
import com.tencent.mm.plugin.appbrand.launching.an;
import com.tencent.mm.plugin.appbrand.launching.e.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vfs.aa;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.Assert;
import org.apache.commons.a.e;

public final class k implements ILaunchWxaAppInfoNotify, aa {
    private static final android.support.v4.e.a<String, k> mRQ = new android.support.v4.e.a<>();
    private static final MultiProcessMMKV mRR = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]");
    private static final ConcurrentHashMap<String, QualitySession> mRU = new ConcurrentHashMap<>();
    private static final d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> mSr = com.tencent.mm.vending.j.a.i(null, null, null);
    final String appId;
    private final boolean cuy;
    final AppBrandLaunchReferrer cys;
    final int ecU;
    final int enterScene;
    final int iOo;
    final String kEY;
    private AppBrandLaunchFromNotifyReferrer kHI;
    final String kHw;
    private final QualitySession ldW;
    final ICommLibReader leM;
    private final com.tencent.luggage.sdk.launching.b mQH;
    private final long mRS;
    private final boolean mRT;
    volatile b mRV;
    volatile boolean mRW;
    volatile d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> mRX;
    volatile long mRY;
    final String mRZ;
    private final String mRk;
    final boolean mSa;
    private final WxaAttributes.WxaVersionInfo mSb;
    private boolean mSc;
    private final AppStartupPerformanceReportBundle mSd;
    private volatile long mSe;
    private final List<kv_14609> mSf;
    private final IListener<lf> mSg;
    private final List<mt> mSh;
    private final IListener<abb> mSi;
    private final IListener<abc> mSj;
    private volatile ap mSk;
    volatile Boolean mSl;
    private volatile HashMap<String, AppRuntimeApiPermissionBundle> mSn;
    volatile boolean mSp;
    volatile boolean mSq;
    volatile boolean started;
    final String username;

    /* access modifiers changed from: package-private */
    public interface b extends q {
        void a(AppBrandSysConfigWC appBrandSysConfigWC, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle);

        void bNi();

        void bNj();

        void bsQ();

        void bsR();

        void onDownloadProgress(int i2);
    }

    static /* synthetic */ void a(k kVar, d dVar) {
        AppMethodBeat.i(227070);
        kVar.b(dVar);
        AppMethodBeat.o(227070);
    }

    static /* synthetic */ void f(k kVar) {
        AppMethodBeat.i(227071);
        kVar.yh(56);
        AppMethodBeat.o(227071);
    }

    static {
        AppMethodBeat.i(47151);
        AppMethodBeat.o(47151);
    }

    static k abX(String str) {
        k remove;
        AppMethodBeat.i(47132);
        synchronized (mRQ) {
            try {
                remove = mRQ.remove(str);
            } finally {
                AppMethodBeat.o(47132);
            }
        }
        String stackTraceString = Log.getStackTraceString(new Throwable());
        if (remove != null) {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s), stacktrace=%s", remove.appId, Integer.valueOf(remove.iOo), str, stackTraceString);
        } else {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess sessionId(%s) get NULL, stacktrace=%s", str, stackTraceString);
        }
        return remove;
    }

    static k abY(String str) {
        k kVar;
        AppMethodBeat.i(47133);
        synchronized (mRQ) {
            try {
                kVar = mRQ.get(str);
            } finally {
                AppMethodBeat.o(47133);
            }
        }
        return kVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    k(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        this(appBrandInitConfigWC.username, appBrandInitConfigWC.appId, appBrandInitConfigWC.eix, appBrandStatObject.ecU, appBrandStatObject.scene, appBrandInitConfigWC.kHw, appBrandInitConfigWC.cys, appBrandInitConfigWC.cym, i.bOk(), appBrandInitConfigWC.cyv, appBrandInitConfigWC.NA(), appBrandInitConfigWC.cyp, appBrandInitConfigWC.ldW, appBrandInitConfigWC.startTime, appBrandInitConfigWC.led, appBrandInitConfigWC.cyz, appBrandInitConfigWC.kHI, 1173 == appBrandStatObject.scene ? com.tencent.mm.plugin.appbrand.openmaterial.model.a.ado(appBrandInitConfigWC.ldR) : null);
        AppMethodBeat.i(47135);
        AppMethodBeat.o(47135);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends MTimerHandler {
        public a(final String str, final String str2, final QualitySession qualitySession) {
            super(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.appbrand.launching.k.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(47130);
                    c cVar = c.cCC;
                    com.tencent.luggage.sdk.e.b dJ = c.dJ(str2);
                    if (dJ instanceof com.tencent.mm.plugin.appbrand.launching.d.c) {
                        ((com.tencent.mm.plugin.appbrand.launching.d.c) dJ).c(qualitySession);
                    }
                    c cVar2 = c.cCC;
                    c.dK(str2);
                    k.mRU.remove(str2);
                    k abX = k.abX(str);
                    if (abX != null) {
                        o.a(23, abX.appId, abX.mSb == null ? 0 : abX.mSb.appVersion, abX.iOo, abX.cuy);
                    }
                    AppMethodBeat.o(47130);
                    return false;
                }
            }, false);
            AppMethodBeat.i(47131);
            AppMethodBeat.o(47131);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aa
    public final boolean bNh() {
        return this.mQH != com.tencent.luggage.sdk.launching.b.PRE_RENDER;
    }

    private void yh(int i2) {
        AppMethodBeat.i(47136);
        if (this.mSc) {
            AppMethodBeat.o(47136);
        } else if (!"wxb6d22f922f37b35a".equals(this.appId)) {
            AppMethodBeat.o(47136);
        } else if (!j.a.vP(this.iOo)) {
            AppMethodBeat.o(47136);
        } else {
            this.mSc = true;
            h.INSTANCE.dN(1089, i2);
            com.tencent.mm.plugin.appbrand.report.i.b(this.appId, this.mSb == null ? 0 : this.mSb.appVersion, this.iOo, 1089, i2);
            AppMethodBeat.o(47136);
        }
    }

    public k(String str, String str2, int i2, int i3, int i4, String str3, AppBrandLaunchReferrer appBrandLaunchReferrer, String str4, ICommLibReader iCommLibReader, WxaAttributes.WxaVersionInfo wxaVersionInfo, boolean z, boolean z2, QualitySession qualitySession, long j2, boolean z3, com.tencent.luggage.sdk.launching.b bVar, AppBrandLaunchFromNotifyReferrer appBrandLaunchFromNotifyReferrer, String str5) {
        AppMethodBeat.i(227067);
        this.mRY = -1;
        this.mSc = false;
        this.mSf = new CopyOnWriteArrayList();
        this.mSg = new IListener<lf>() {
            /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass1 */

            {
                AppMethodBeat.i(160603);
                this.__eventId = lf.class.getName().hashCode();
                AppMethodBeat.o(160603);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(lf lfVar) {
                AppMethodBeat.i(47120);
                lf lfVar2 = lfVar;
                if (k.this.appId.equals(lfVar2.dQt.dQu.appId) && k.this.mSb.appVersion == lfVar2.dQt.dQu.mVo) {
                    lfVar2.dQt.dQu.mWO = k.this.ldW;
                    k.this.mSf.add(lfVar2.dQt.dQu);
                    lfVar2.dQt.dQv.cancel();
                    AppMethodBeat.o(47120);
                    return true;
                } else if (lfVar2.dQt.dQu.dMe == 6) {
                    k.this.mSf.add(lfVar2.dQt.dQu);
                    lfVar2.dQt.dQu.mWO = k.this.ldW;
                    lfVar2.dQt.dQv.cancel();
                    AppMethodBeat.o(47120);
                    return true;
                } else {
                    AppMethodBeat.o(47120);
                    return false;
                }
            }
        };
        this.mSh = new CopyOnWriteArrayList();
        this.mSi = new IListener<abb>() {
            /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass2 */

            {
                AppMethodBeat.i(160604);
                this.__eventId = abb.class.getName().hashCode();
                AppMethodBeat.o(160604);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(abb abb) {
                mt.b bVar;
                AppMethodBeat.i(47121);
                abb abb2 = abb;
                if (k.this.appId.equals(((byy) abb2.ein.eio.rr.iLK.iLR).dNI) && k.this.mSb.appVersion == ((byy) abb2.ein.eio.rr.iLK.iLR).KXD && (abb2.ein.eio.bvh() == 0 || abb2.ein.eio.bvh() == 4)) {
                    mt mtVar = new mt();
                    mtVar.fep = mt.a.release;
                    mtVar.wP(abb2.ein.dcl - abb2.ein.eiq);
                    mtVar.wR(abb2.ein.eiq);
                    mtVar.wS(abb2.ein.dcl);
                    if (com.tencent.mm.plugin.appbrand.r.a.d(abb2.ein.eip)) {
                        bVar = mt.b.ok;
                    } else {
                        bVar = mt.b.common_fail;
                    }
                    mtVar.feq = bVar;
                    mtVar.eJb = (long) g.getNetworkType();
                    k.this.mSh.add(mtVar);
                    AppMethodBeat.o(47121);
                    return true;
                }
                AppMethodBeat.o(47121);
                return false;
            }
        };
        this.mSj = new IListener<abc>() {
            /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass3 */

            {
                AppMethodBeat.i(160605);
                this.__eventId = abc.class.getName().hashCode();
                AppMethodBeat.o(160605);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(abc abc) {
                mt.b bVar;
                AppMethodBeat.i(47122);
                abc abc2 = abc;
                if (!k.this.appId.equals(((bwb) abc2.eir.eis.rr.iLK.iLR).dNI) || ((bwb) abc2.eir.eis.rr.iLK.iLR).Lcr != k.this.iOo) {
                    AppMethodBeat.o(47122);
                    return false;
                }
                mt mtVar = new mt();
                mtVar.fep = mt.a.mE(k.this.iOo + 1);
                mtVar.wP(abc2.eir.dcl - abc2.eir.eiq);
                mtVar.wR(abc2.eir.eiq);
                mtVar.wS(abc2.eir.dcl);
                if (com.tencent.mm.plugin.appbrand.r.a.d(abc2.eir.eip)) {
                    bVar = mt.b.ok;
                } else {
                    bVar = mt.b.common_fail;
                }
                mtVar.feq = bVar;
                mtVar.eJb = (long) g.getNetworkType();
                k.this.mSh.add(mtVar);
                AppMethodBeat.o(47122);
                return true;
            }
        };
        this.mSl = null;
        this.mSp = false;
        this.mSq = false;
        this.username = str;
        this.appId = str2;
        this.iOo = i2;
        this.ecU = i3;
        this.enterScene = i4;
        this.kHw = str3;
        this.cys = appBrandLaunchReferrer;
        this.mRZ = str4;
        this.leM = iCommLibReader;
        this.kEY = qualitySession.kEY;
        this.mRS = j2;
        this.mRT = z3;
        this.mQH = bVar;
        this.kHI = appBrandLaunchFromNotifyReferrer;
        this.mRk = str5;
        Assert.assertNotNull("<init> NULL wxaVersionInfo ".concat(String.valueOf(str2)), wxaVersionInfo);
        this.mSb = wxaVersionInfo;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> username[%s] appId[%s] versionType[%d] appVersion[%d], scene[%d] sessionId[%s] instanceId[%s] mIsLaunchedByBackupWxaAttrs[%b]", this.username, this.appId, Integer.valueOf(this.iOo), Integer.valueOf(wxaVersionInfo.appVersion), Integer.valueOf(this.enterScene), this.mRZ, this.kEY, Boolean.valueOf(this.mRT));
        if (iCommLibReader == null) {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> NULL acceptedLibReader, instanceId[%s]", this.kEY);
        }
        this.cuy = z;
        this.mSa = z2;
        this.ldW = qualitySession;
        this.mSd = new AppStartupPerformanceReportBundle(qualitySession.kEY);
        mRU.put(qualitySession.kEY, qualitySession);
        if (z) {
            x.Va(str2);
        }
        AppMethodBeat.o(227067);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.vending.j.d<com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC, com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction, com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle> r12) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.k.a(com.tencent.mm.vending.j.d):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
    public final void a(String str, int i2, String str2, ap apVar) {
        AppMethodBeat.i(47139);
        if (this.mRX != null) {
            AppBrandLaunchErrorAction.a aVar = AppBrandLaunchErrorAction.CREATOR;
            AppBrandLaunchErrorAction a2 = AppBrandLaunchErrorAction.a.a(this.appId, this.iOo, apVar);
            if (a2 != null) {
                this.mRX = com.tencent.mm.vending.j.a.i(null, a2, this.mSd);
                AppMethodBeat.o(47139);
                return;
            }
            AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) this.mRX.get(0);
            if (appBrandSysConfigWC == null) {
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", str);
                AppMethodBeat.o(47139);
                return;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%s]", str, Integer.valueOf(i2), str2, apVar);
            apVar.b(appBrandSysConfigWC);
            this.mRX = com.tencent.mm.vending.j.a.i(appBrandSysConfigWC, null, this.mSd);
            AppMethodBeat.o(47139);
            return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] set mMaybeUpdatedLaunchPB appId[%s] type[%d] sessionId[%s] info[%s]", str, Integer.valueOf(i2), str2, apVar);
        this.mSk = apVar;
        AppMethodBeat.o(47139);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify
    public final void a(String str, int i2, String str2, HashMap<String, AppRuntimeApiPermissionBundle> hashMap) {
        int i3 = 0;
        AppMethodBeat.i(227068);
        if (this.mRX != null) {
            AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) this.mRX.get(0);
            if (appBrandSysConfigWC == null) {
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", str);
                AppMethodBeat.o(227068);
                return;
            }
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str2;
            if (hashMap != null) {
                i3 = hashMap.size();
            }
            objArr[3] = Integer.valueOf(i3);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%d]", objArr);
            appBrandSysConfigWC.cyH = hashMap;
            this.mRX = com.tencent.mm.vending.j.a.i(appBrandSysConfigWC, null, this.mSd);
            AppMethodBeat.o(227068);
            return;
        }
        Object[] objArr2 = new Object[4];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = str2;
        if (hashMap != null) {
            i3 = hashMap.size();
        }
        objArr2[3] = Integer.valueOf(i3);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] set mMaybeUpdatedPluginPermissionMap appId[%s] type[%d] sessionId[%s] info[%d]", objArr2);
        this.mSn = hashMap;
        AppMethodBeat.o(227068);
    }

    public final void bNl() {
        AppMethodBeat.i(47140);
        if (this.started) {
            AppMethodBeat.o(47140);
            return;
        }
        com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceGroup);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
        this.started = true;
        this.mSe = Util.nowMilliSecond();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm appId[%s] type[%d] scene[%d], instanceId[%s], sessionId[%s]", this.appId, Integer.valueOf(this.iOo), Integer.valueOf(this.enterScene), this.kEY, this.mRZ);
        synchronized (mRQ) {
            try {
                mRQ.put(this.mRZ, this);
            } catch (Throwable th) {
                AppMethodBeat.o(47140);
                throw th;
            }
        }
        new a(this.mRZ, this.kEY, this.ldW).startTimer(TimeUnit.SECONDS.toMillis(300));
        if (this.mSb == null) {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "startPrepare() NULL wxaVersionInfo username[%s], appId[%s]", this.username, this.appId);
            ax.a((int) R.string.nc, this);
            b(mSr);
            AppMethodBeat.o(47140);
            return;
        }
        new MMHandler(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", this.appId, Integer.valueOf(this.iOo))).post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(47123);
                try {
                    k.a(k.this, k.this.bNm());
                    com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
                    if (k.this.leM != null) {
                        e.closeQuietly(k.this.leM);
                        AppMethodBeat.o(47123);
                        return;
                    }
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", e2, "call() exp ", new Object[0]);
                    com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess, e2.getLocalizedMessage());
                    ax.a((int) R.string.nb, k.this);
                    k.a(k.this, k.mSr);
                    k.f(k.this);
                    if (k.this.leM != null) {
                        e.closeQuietly(k.this.leM);
                        AppMethodBeat.o(47123);
                        return;
                    }
                } catch (Throwable th) {
                    if (k.this.leM != null) {
                        e.closeQuietly(k.this.leM);
                    }
                    AppMethodBeat.o(47123);
                    throw th;
                }
                AppMethodBeat.o(47123);
            }
        });
        AppMethodBeat.o(47140);
    }

    private void b(d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> dVar) {
        AppMethodBeat.i(47141);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process, sessionId:%s, instanceId:%s", this.appId, Integer.valueOf(this.iOo), this.mRZ, this.kEY);
        a(dVar);
        c cVar = c.cCC;
        com.tencent.luggage.sdk.e.b dJ = c.dJ(this.kEY);
        if (dJ instanceof com.tencent.mm.plugin.appbrand.launching.d.c) {
            ((com.tencent.mm.plugin.appbrand.launching.d.c) dJ).c(this.ldW);
        }
        c cVar2 = c.cCC;
        c.dK(this.kEY);
        mRU.remove(this.kEY);
        AppMethodBeat.o(47141);
    }

    private boolean a(AppBrandSysConfigWC appBrandSysConfigWC, com.tencent.mm.plugin.appbrand.ac.i<AppBrandLaunchErrorAction> iVar) {
        int i2;
        AnonymousClass6 r18;
        Future future;
        Object obj;
        boolean z;
        long j2;
        AppMethodBeat.i(227069);
        this.mSg.alive();
        if (this.iOo == 0) {
            this.mSi.alive();
        } else {
            this.mSj.alive();
        }
        appBrandSysConfigWC.leM = this.leM;
        AnonymousClass5 r2 = new ba(appBrandSysConfigWC.appId, this.iOo, this.kHw, this.enterScene, this.mSb, this.cuy, this.leM, this.ldW, this.mQH) {
            /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass5 */

            {
                AppMethodBeat.i(227063);
                boolean z = k.this.mSa;
                if (this.mWN instanceof ae) {
                    ((ae) this.mWN).mSa = z;
                }
                hX(k.this.bNh());
                AppMethodBeat.o(227063);
            }

            @Override // com.tencent.mm.plugin.appbrand.launching.ba
            public final void bNi() {
                AppMethodBeat.i(47124);
                super.bNi();
                k.g(k.this);
                AppMethodBeat.o(47124);
            }

            @Override // com.tencent.mm.plugin.appbrand.launching.ba
            public final void onDownloadProgress(int i2) {
                AppMethodBeat.i(47126);
                super.onDownloadProgress(i2);
                if (k.this.mRV != null) {
                    k.this.mRV.onDownloadProgress(i2);
                }
                AppMethodBeat.o(47126);
            }
        };
        Future bNN = r2.bNN();
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_wagame_isolated_plugin_permission, true);
        Object[] objArr = new Object[1];
        if (a2) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PkgABTest", "openGameIsolatedPluginPermissionCheck exp:%d", objArr);
        if (a2) {
            AnonymousClass6 r3 = new ay(this.appId, this.iOo, this.cuy, this.mSb, this.enterScene, this.mRZ, this.ldW, this.mQH) {
                /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass6 */

                /* access modifiers changed from: package-private */
                @Override // com.tencent.mm.plugin.appbrand.launching.ay
                public final void bsR() {
                    AppMethodBeat.i(227064);
                    k.h(k.this);
                    AppMethodBeat.o(227064);
                }
            };
            r18 = r3;
            future = r3.bNN();
        } else {
            r18 = null;
            future = null;
        }
        AnonymousClass7 r32 = new bb(this.appId, this.iOo, this.ecU, this.enterScene, this.kHw, this.cys, this.mRZ, this.leM, this.ldW, this.username, this.kHI, this.mRk, this.mQH) {
            /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass7 */

            /* access modifiers changed from: package-private */
            @Override // com.tencent.mm.plugin.appbrand.launching.bb
            public final void bsQ() {
                AppMethodBeat.i(227065);
                k.i(k.this);
                AppMethodBeat.o(227065);
            }
        };
        r32.hX(bNh());
        ap apVar = (ap) r32.bNO();
        this.mSd.mSz = ((bb) r32).mWG;
        this.mSd.mSA = ((bb) r32).mWH;
        if (apVar == null) {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", this.username, this.appId);
            AppMethodBeat.o(227069);
            return false;
        }
        AppBrandLaunchErrorAction.a aVar = AppBrandLaunchErrorAction.CREATOR;
        T t = (T) AppBrandLaunchErrorAction.a.a(this.appId, this.iOo, apVar);
        if (t != null) {
            iVar.value = t;
            yh(54);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", this.username, this.appId, Integer.valueOf(apVar.field_launchAction.KCD));
            AppMethodBeat.o(227069);
            return false;
        }
        this.mSd.mSG = apVar.mWd;
        if (apVar.field_jsapiInfo == null || apVar.field_jsapiInfo.LjS == null) {
            yh(54);
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", this.username, this.appId);
            AppMethodBeat.o(227069);
            return false;
        }
        apVar.b(appBrandSysConfigWC);
        c cVar = c.cCC;
        boolean z2 = false;
        for (com.tencent.luggage.sdk.e.a<?> aVar2 : c.dJ(this.kEY).cCy.values()) {
            if (aVar2.cCu) {
                z2 = true;
            } else {
                z2 = z2;
            }
        }
        this.mSd.mSF = z2 ? 1 : 0;
        if (!j.a.vP(this.iOo) || this.mRT) {
            obj = null;
            z = false;
            j2 = Long.MAX_VALUE;
        } else {
            Object acf = an.acf(this.appId);
            if (acf instanceof an.c.a) {
                j2 = ((an.c.a) acf).mWa - (Util.nowMilliSecond() - this.mRS);
                if (j2 <= 0) {
                    j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                    obj = acf;
                    z = false;
                } else {
                    obj = acf;
                    z = true;
                }
            } else {
                j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                obj = acf;
                z = false;
            }
        }
        Object[] objArr2 = new Object[7];
        objArr2[0] = this.username;
        objArr2[1] = this.appId;
        objArr2[2] = Integer.valueOf(this.iOo);
        objArr2[3] = Boolean.valueOf(this.mRT);
        objArr2[4] = Long.valueOf(this.mRS);
        objArr2[5] = z ? j2 + LocaleUtil.MALAY : "false";
        objArr2[6] = obj;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig() before get app pkg, username[%s] appId[%s] versionType[%d] mIsLaunchedByBackupWxaAttrs[%b] clickTimestamp[%d] timeoutStrategy=[%s], fallbackStrategy[%s]", objArr2);
        try {
            bNN.get(j2, TimeUnit.MILLISECONDS);
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) bNN.get();
            this.mRW = true;
            bNn();
            this.mSg.dead();
            this.mSi.dead();
            this.mSj.dead();
            this.mSd.mSw.addAll(this.mSh);
            this.mSd.mSx.addAll(this.mSf);
            this.mSd.mSB = ((ba) r2).mWG;
            this.mSd.mSC = ((ba) r2).mWH;
            if (wxaPkgWrappingInfo == null) {
                if (j.a.vP(this.iOo)) {
                    an.ef(this.username, this.appId);
                }
                yh(55);
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", this.username, this.appId);
                AppMethodBeat.o(227069);
                return false;
            }
            appBrandSysConfigWC.leE = wxaPkgWrappingInfo;
            if (appBrandSysConfigWC.leE.kNW != 0) {
                appBrandSysConfigWC.leE.pkgVersion = 0;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username:%s, appId:%s, instanceId:%s, sessionId:%s, pkg:%s", this.username, appBrandSysConfigWC.appId, this.kEY, this.mRZ, appBrandSysConfigWC.leE);
            if (com.tencent.mm.plugin.appbrand.ui.recommend.e.cs(this.appId, this.iOo)) {
                h.INSTANCE.dN(1089, (this.mRY > 0 ? 1 : (this.mRY == 0 ? 0 : -1)) <= 0 ? 53 : 52);
            }
            if (!(r18 == null || future == null)) {
                this.mSd.mSD = ((ay) r18).mWG;
                this.mSd.mSE = ((ay) r18).mWH;
                if (future.get() != null) {
                    HashMap hashMap = (HashMap) ((Pair) future.get()).first;
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(hashMap != null ? hashMap.size() : 0);
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "checkWxaJsApiInfoHashMap size:%d", objArr3);
                    appBrandSysConfigWC.cyH = hashMap;
                    this.mSd.mSH = ((Boolean) ((Pair) future.get()).second).booleanValue();
                }
            }
            appBrandSysConfigWC.czd = AppBrandGlobalSystemConfig.bzP();
            com.tencent.mm.plugin.appbrand.message.h hVar = com.tencent.mm.plugin.appbrand.message.h.INSTANCE;
            Long ev = com.tencent.mm.plugin.appbrand.message.h.ev(this.appId, "copypath");
            appBrandSysConfigWC.czc = ev == null ? 0 : ev.longValue();
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + appBrandSysConfigWC.czc);
            final WxaPkgWrappingInfo wxaPkgWrappingInfo2 = appBrandSysConfigWC.leE;
            com.tencent.f.h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(47129);
                    String[] Xv = y.Xv(k.this.username);
                    if (Xv != null && Xv.length > 0) {
                        for (String str : Xv) {
                            com.tencent.mm.modelappbrand.a.b.aXY().LF(str);
                        }
                    }
                    if (k.bNq()) {
                        com.tencent.mm.kernel.g.aAg().hqi.a(new n(12), 0);
                    }
                    bp.a.a(k.this.appId, wxaPkgWrappingInfo2);
                    AppMethodBeat.o(47129);
                }
            }, "AppLaunchPrepareProcess#ExtraWorks");
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", this.username, this.appId);
            bNo();
            b.a aVar3 = com.tencent.mm.plugin.appbrand.appstorage.b.b.kTO;
            String Wr = b.a.Wr(aa.z(new com.tencent.mm.vfs.o(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").her()));
            if (Wr == null) {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: srcBaseDirPath ==null");
            } else if (com.tencent.mm.sdcard_migrate.b.bhQ(Wr)) {
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: Migrated");
            } else {
                com.tencent.mm.kernel.g.aAf();
                String string = p.getString(com.tencent.mm.kernel.a.getUin());
                com.tencent.mm.plugin.appbrand.appstorage.b.b bVar = new com.tencent.mm.plugin.appbrand.appstorage.b.b();
                kotlin.g.b.p.h(string, OpenSDKTool4Assistant.EXTRA_UIN);
                bVar.uin = string;
                com.tencent.mm.plugin.appbrand.appstorage.b.b Wq = bVar.Wq(this.appId);
                MultiProcessMMKV multiProcessMMKV = Wq.cQe;
                StringBuilder sb = new StringBuilder();
                String str = Wq.appId;
                if (str == null) {
                    kotlin.g.b.p.btv("appId");
                }
                StringBuilder append = sb.append(str);
                String str2 = Wq.uin;
                if (str2 == null) {
                    kotlin.g.b.p.btv(OpenSDKTool4Assistant.EXTRA_UIN);
                }
                if (multiProcessMMKV.getBoolean(append.append(str2).toString(), false)) {
                    h.INSTANCE.dN(1323, 2);
                    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForCompatibility: appId = [%s] isTransferred", this.appId);
                } else {
                    String str3 = at.o(string, this.appId) + FilePathGenerator.ANDROID_DIR_SEP;
                    String str4 = at.o(string, this.appId, "opendata") + FilePathGenerator.ANDROID_DIR_SEP;
                    String str5 = at.o(string, this.appId, "clientdata") + FilePathGenerator.ANDROID_DIR_SEP;
                    String aKJ = com.tencent.mm.loader.j.b.aKJ();
                    com.tencent.mm.plugin.appbrand.appstorage.b.b Wq2 = bVar.Wq(this.appId);
                    kotlin.g.b.p.h(aKJ, "path");
                    if (!kotlin.n.n.nm(aKJ, FilePathGenerator.ANDROID_DIR_SEP)) {
                        aKJ = aKJ + '/';
                    }
                    Wq2.kTM = aKJ;
                    kotlin.g.b.p.h(str3, "nonFlattenedFSPath");
                    kotlin.g.b.p.h(str4, "nonFlattenedOpenFSPath");
                    kotlin.g.b.p.h(str5, "nonFlattenedClientFSPath");
                    String str6 = Wq2.jpM;
                    if (str6 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    String str7 = kotlin.n.n.nm(str6, FilePathGenerator.ANDROID_DIR_SEP) ? Wq2.jpM : Wq2.jpM + FilePathGenerator.ANDROID_DIR_SEP;
                    StringBuilder append2 = new StringBuilder().append(str7).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.wxafiles.dir).append('/');
                    String str8 = Wq2.appId;
                    if (str8 == null) {
                        kotlin.g.b.p.btv("appId");
                    }
                    String sb2 = append2.append(str8).append('/').toString();
                    StringBuilder sb3 = new StringBuilder();
                    String str9 = Wq2.kTM;
                    if (str9 == null) {
                        kotlin.g.b.p.btv("appBrandTargetFolder");
                    }
                    StringBuilder append3 = sb3.append(str9).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.wxafiles.dir).append('/');
                    String str10 = Wq2.appId;
                    if (str10 == null) {
                        kotlin.g.b.p.btv("appId");
                    }
                    Wq2.kTN.add(new com.tencent.mm.plugin.appbrand.appstorage.b.c(sb2, append3.append(str10).append('/').toString()));
                    Wq2.kTN.add(new com.tencent.mm.plugin.appbrand.appstorage.b.c(str7 + com.tencent.mm.plugin.appbrand.appstorage.b.d.wxanewfiles.dir + kotlin.n.n.oD(str3, com.tencent.mm.plugin.appbrand.appstorage.b.d.wxanewfiles.dir), str3));
                    Wq2.kTN.add(new com.tencent.mm.plugin.appbrand.appstorage.b.c(str7 + com.tencent.mm.plugin.appbrand.appstorage.b.d.wxanewfiles.dir + kotlin.n.n.oD(str4, com.tencent.mm.plugin.appbrand.appstorage.b.d.wxanewfiles.dir), str4));
                    Wq2.kTN.add(new com.tencent.mm.plugin.appbrand.appstorage.b.c(str7 + com.tencent.mm.plugin.appbrand.appstorage.b.d.wxanewfiles.dir + kotlin.n.n.oD(str5, com.tencent.mm.plugin.appbrand.appstorage.b.d.wxanewfiles.dir), str5));
                    Wq2.commit();
                }
            }
            e.a aVar4 = com.tencent.mm.plugin.appbrand.appstorage.e.AkJ;
            appBrandSysConfigWC.leF = e.a.bxm(this.appId);
            appBrandSysConfigWC.leG = f.kRZ.bxk();
            int i3 = appBrandSysConfigWC.leF;
            if (i3 == 2) {
                h.INSTANCE.n(1016, 7, 1);
            } else if (i3 == 3) {
                h.INSTANCE.n(1016, 8, 1);
            } else if (i3 == 1) {
                if (f.kRZ.bxj()) {
                    h.INSTANCE.n(1016, 10, 1);
                } else {
                    h.INSTANCE.n(1016, 9, 1);
                }
            }
            AppMethodBeat.o(227069);
            return true;
        } catch (TimeoutException e2) {
            if (z) {
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, get app pkg timeout, try fallback backup wxaattrs, username[%s] appId[%s] awaitTimeout[%d]", this.username, this.appId, Long.valueOf(j2));
                this.mSq = true;
                b bVar2 = this.mRV;
                Object[] objArr4 = new Object[3];
                objArr4[0] = this.username;
                objArr4[1] = this.appId;
                objArr4[2] = Boolean.valueOf(bVar2 == null);
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyFallbackBackupWxaAttrs username[%s] appId[%s] null==callback[%b]", objArr4);
                if (bVar2 != null) {
                    bVar2.bNj();
                }
                km kmVar = new km();
                kmVar.xO(this.appId);
                kmVar.xP(this.username);
                kmVar.eWc = (long) this.enterScene;
                kmVar.eWd = (long) this.mSb.appVersion;
                kmVar.eWe = (long) ((v) com.tencent.mm.plugin.appbrand.app.n.W(v.class)).e(this.appId, "versionInfo").bAp().appVersion;
                kmVar.eWj = 1;
                kmVar.eWk = ((an.c.a) obj).mWa;
                kmVar.xQ(com.tencent.mm.plugin.appbrand.report.i.getNetworkType(MMApplicationContext.getContext()));
                kmVar.eWi = 0;
                kmVar.xR(this.ldW.kEY);
                kmVar.bfK();
                an.b.a(this.ldW.kEY, kmVar);
                an.b.bV(this.ldW.kEY, 2);
            } else {
                AppMethodBeat.o(227069);
                throw e2;
            }
        } catch (Throwable th) {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, report fallback get exception %s", th);
        }
        AppMethodBeat.o(227069);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void bNn() {
        AppMethodBeat.i(47143);
        if (this.mRV != null) {
            this.mRV.onDownloadProgress(100);
        }
        AppMethodBeat.o(47143);
    }

    private void bNo() {
        boolean z = false;
        AppMethodBeat.i(174932);
        Object[] objArr = new Object[2];
        objArr[0] = this.appId;
        objArr[1] = Boolean.valueOf(this.mRV != null);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForDB start with appId:%s callback!=null:%b ", objArr);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.tencent.mm.plugin.appbrand.launching.k.AnonymousClass9 */

            public final void run() {
                boolean z = false;
                AppMethodBeat.i(227066);
                Object[] objArr = new Object[2];
                objArr[0] = k.this.appId;
                if (k.this.mRV != null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD with appId:%s, callback!=null:%b", objArr);
                if (k.this.mRV != null) {
                    k.this.mRV.vy(3);
                }
                AppMethodBeat.o(227066);
            }
        }, 5000);
        Object[] objArr2 = new Object[2];
        objArr2[0] = this.appId;
        objArr2[1] = Boolean.valueOf(this.mRV != null);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START with appId:%s, callback!=null:%b", objArr2);
        if (this.mRV != null) {
            this.mRV.vy(1);
        }
        as[] asVarArr = {new com.tencent.mm.plugin.appbrand.appstorage.e(this.appId)};
        for (int i2 = 0; i2 <= 0; i2++) {
            as asVar = asVarArr[0];
            if (asVar.rT(com.tencent.mm.protocal.d.KyO)) {
                asVar.transfer(com.tencent.mm.protocal.d.KyO);
            }
        }
        timer.cancel();
        Object[] objArr3 = new Object[2];
        objArr3[0] = this.appId;
        if (this.mRV != null) {
            z = true;
        }
        objArr3[1] = Boolean.valueOf(z);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH with appId:%s, callback!=null:%b", objArr3);
        if (this.mRV != null) {
            this.mRV.vy(2);
        }
        AppMethodBeat.o(174932);
    }

    public final d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> bNm() {
        WxaAttributes wxaAttributes;
        int i2 = 0;
        AppMethodBeat.i(47142);
        AppBrandSysConfigWC Xu = y.Xu(this.appId);
        if (Xu == null) {
            ax.a(com.tencent.mm.plugin.appbrand.utils.f.getMMString(R.string.pb, ""), this);
        }
        if (Xu == null) {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!, username:%s, appId:%s", this.username, this.appId);
            o.a(7, this.appId, this.mSb == null ? 0 : this.mSb.appVersion, this.iOo, this.cuy);
            d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> dVar = mSr;
            AppMethodBeat.o(47142);
            return dVar;
        }
        ((com.tencent.mm.plugin.appbrand.appusage.k) com.tencent.mm.plugin.appbrand.app.n.W(com.tencent.mm.plugin.appbrand.appusage.k.class)).P(y.Xy(this.appId), Util.nowSecond());
        com.tencent.mm.plugin.appbrand.ac.i<AppBrandLaunchErrorAction> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
        if (!a(Xu, iVar)) {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", this.username, this.appId);
            if (this.mSb != null) {
                i2 = this.mSb.appVersion;
            }
            o.a(8, this.appId, i2, this.iOo, this.cuy);
            d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> i3 = com.tencent.mm.vending.j.a.i(null, iVar.value, this.mSd);
            AppMethodBeat.o(47142);
            return i3;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", this.username, this.appId);
        if (j.a.vP(this.iOo)) {
            try {
                WxaAttributes ace = an.ace(this.username);
                if (ace == null || ace.bAp().appVersion != this.mSb.appVersion) {
                    wxaAttributes = ((com.tencent.mm.plugin.appbrand.config.x) com.tencent.mm.plugin.appbrand.app.n.W(com.tencent.mm.plugin.appbrand.config.x.class)).d(this.username, new String[0]);
                } else {
                    wxaAttributes = ace;
                }
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs with username(%s) appId(%s), now.versionInfo.appVersion:%d, record.versionInfo.appVersion:%d", this.username, this.appId, Integer.valueOf(this.mSb.appVersion), Integer.valueOf(wxaAttributes.bAp().appVersion));
                if (wxaAttributes.bAp().appVersion == this.mSb.appVersion) {
                    ((v) com.tencent.mm.plugin.appbrand.app.n.W(v.class)).d(wxaAttributes);
                }
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs failed with username(%s) appId(%s) by exception:%s", this.username, this.appId, e2);
            }
        }
        an.ee(this.username, this.appId);
        an.eg(this.username, this.appId);
        this.mSd.mSe = this.mSe;
        this.mSd.mSy = Util.nowMilliSecond();
        d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> i4 = com.tencent.mm.vending.j.a.i(Xu, null, this.mSd);
        AppMethodBeat.o(47142);
        return i4;
    }

    static /* synthetic */ void g(k kVar) {
        AppMethodBeat.i(47149);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "preDownload, appId %s, versionType %d", kVar.appId, Integer.valueOf(kVar.iOo));
        kVar.mRY = Util.nowMilliSecond();
        if (kVar.mRV != null) {
            kVar.mRV.bNi();
        }
        AppMethodBeat.o(47149);
    }

    static /* synthetic */ void h(k kVar) {
        AppMethodBeat.i(227072);
        if (kVar.mRV != null) {
            kVar.mRV.bsR();
            AppMethodBeat.o(227072);
            return;
        }
        kVar.mSp = true;
        AppMethodBeat.o(227072);
    }

    static /* synthetic */ void i(k kVar) {
        AppMethodBeat.i(227073);
        if (kVar.mRV != null) {
            kVar.mRV.bsQ();
            AppMethodBeat.o(227073);
            return;
        }
        kVar.mSl = Boolean.TRUE;
        AppMethodBeat.o(227073);
    }

    static /* synthetic */ boolean bNq() {
        AppMethodBeat.i(227074);
        if (mRR != null) {
            long j2 = mRR.getLong("CONFIG_KEY_LAST_RCPT_ADDRESS_CHECK_TICK", 0);
            long currentTicks = Util.currentTicks();
            if (currentTicks - j2 >= TimeUnit.MINUTES.toMillis(5)) {
                mRR.putLong("CONFIG_KEY_LAST_RCPT_ADDRESS_CHECK_TICK", currentTicks);
                AppMethodBeat.o(227074);
                return true;
            }
        }
        AppMethodBeat.o(227074);
        return false;
    }
}
