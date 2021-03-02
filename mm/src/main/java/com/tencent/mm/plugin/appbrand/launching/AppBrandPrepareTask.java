package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.b.a.ms;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.launching.k;
import com.tencent.mm.plugin.appbrand.launching.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class AppBrandPrepareTask {
    public volatile transient boolean kDW = false;
    public PrepareParams mQJ;
    public volatile transient al<AppBrandSysConfigWC> mQK;
    volatile transient WeakReference<Activity> mQL;

    public interface b<C extends AppBrandSysConfigLU> extends q {
        void AW(long j2);

        void a(C c2, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle);

        void a(com.tencent.mm.plugin.appbrand.jsapi.ab.b bVar, String str);

        void bsQ();

        void bsR();

        void bsS();

        void vz(int i2);
    }

    public AppBrandPrepareTask(Activity activity, q qVar) {
        int i2 = 0;
        AppMethodBeat.i(47107);
        AppBrandStatObject appBrandStatObject = qVar.ON().cyA;
        this.mQJ = new PrepareParams();
        this.mQL = new WeakReference<>(activity);
        this.mQJ.mAppId = qVar.mAppId;
        this.mQJ.mRa = qVar.bsC().username;
        this.mQJ.mDebugType = qVar.kAq.eix;
        this.mQJ.mQY = appBrandStatObject == null ? 0 : appBrandStatObject.ecU;
        this.mQJ.jZJ = appBrandStatObject != null ? appBrandStatObject.scene : i2;
        this.mQJ.mQZ = qVar.bsC().kHw;
        this.mQJ.mRb = qVar.bsC().cys;
        this.mQJ.mRc = qVar.bsC().cym;
        this.mQJ.mRh = qVar.bqZ();
        this.mQJ.mRd = qVar.bsC().cyv;
        this.mQJ.cuy = qVar.NA();
        this.mQJ.mRf = qVar.bsC().cyy;
        this.mQJ.mRg = qVar.bsC().ldW;
        this.mQJ.kHI = qVar.bsC().kHI;
        this.mQJ.mRi = qVar.bsC().startTime;
        this.mQJ.mRj = qVar.bsC().led;
        this.mQJ.mQH = qVar.bsC().cyz;
        this.mQJ.mRk = 1173 == this.mQJ.jZJ ? com.tencent.mm.plugin.appbrand.openmaterial.model.a.ado(qVar.bsC().ldR) : null;
        AppMethodBeat.o(47107);
    }

    public final void interrupt() {
        AppMethodBeat.i(227062);
        Object[] objArr = new Object[2];
        objArr[0] = this.mQJ == null ? null : this.mQJ.mAppId;
        objArr[1] = Integer.valueOf(this.mQJ == null ? -1 : this.mQJ.mDebugType);
        Log.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", objArr);
        this.kDW = true;
        al<AppBrandSysConfigWC> alVar = this.mQK;
        if (alVar != null) {
            alVar.dead();
        }
        AppMethodBeat.o(227062);
    }

    public static final class PrepareParams implements Parcelable {
        public static final Parcelable.Creator<PrepareParams> CREATOR = new Parcelable.Creator<PrepareParams>() {
            /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PrepareParams[] newArray(int i2) {
                return new PrepareParams[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PrepareParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47099);
                PrepareParams prepareParams = new PrepareParams(parcel);
                AppMethodBeat.o(47099);
                return prepareParams;
            }
        };
        boolean cuy;
        int jZJ;
        private AppBrandLaunchFromNotifyReferrer kHI;
        public String mAppId;
        private int mDebugType;
        com.tencent.luggage.sdk.launching.b mQH;
        private int mQY;
        String mQZ;
        String mRa;
        private AppBrandLaunchReferrer mRb;
        private String mRc;
        WxaAttributes.WxaVersionInfo mRd;
        boolean mRe;
        private boolean mRf;
        QualitySession mRg;
        public ICommLibReader mRh;
        private long mRi;
        private boolean mRj;
        private String mRk;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4;
            int i5 = 1;
            AppMethodBeat.i(47100);
            parcel.writeInt(this.mQY);
            parcel.writeInt(this.jZJ);
            parcel.writeString(this.mQZ);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mRa);
            parcel.writeInt(this.mDebugType);
            parcel.writeParcelable(this.mRb, i2);
            parcel.writeString(this.mRc);
            parcel.writeParcelable(this.mRd, i2);
            parcel.writeInt(this.cuy ? 1 : 0);
            if (this.mRe) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            if (this.mRf) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            parcel.writeInt(i4);
            parcel.writeParcelable(this.mRg, i2);
            ICommLibReader.b.a(this.mRh, parcel, i2);
            parcel.writeParcelable(this.kHI, i2);
            parcel.writeLong(this.mRi);
            if (!this.mRj) {
                i5 = 0;
            }
            parcel.writeByte((byte) i5);
            com.tencent.luggage.sdk.launching.b.a(this.mQH, parcel);
            parcel.writeString(this.mRk);
            AppMethodBeat.o(47100);
        }

        PrepareParams() {
        }

        PrepareParams(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(47101);
            this.mQY = parcel.readInt();
            this.jZJ = parcel.readInt();
            this.mQZ = parcel.readString();
            this.mAppId = parcel.readString();
            this.mRa = parcel.readString();
            this.mDebugType = parcel.readInt();
            this.mRb = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
            this.mRc = parcel.readString();
            this.mRd = (WxaAttributes.WxaVersionInfo) parcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader());
            this.cuy = parcel.readInt() == 1;
            if (parcel.readInt() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.mRe = z;
            if (parcel.readInt() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mRf = z2;
            this.mRg = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
            this.mRh = ICommLibReader.b.h(parcel);
            this.kHI = (AppBrandLaunchFromNotifyReferrer) parcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader());
            this.mRi = parcel.readLong();
            this.mRj = parcel.readByte() <= 0 ? false : z3;
            this.mQH = com.tencent.luggage.sdk.launching.b.b(parcel);
            this.mRk = parcel.readString();
            AppMethodBeat.o(47101);
        }

        static {
            AppMethodBeat.i(47102);
            AppMethodBeat.o(47102);
        }
    }

    static final class PrepareResult implements Parcelable {
        public static final Parcelable.Creator<PrepareResult> CREATOR = new Parcelable.Creator<PrepareResult>() {
            /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PrepareResult[] newArray(int i2) {
                return new PrepareResult[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PrepareResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47103);
                PrepareResult prepareResult = new PrepareResult(parcel);
                AppMethodBeat.o(47103);
                return prepareResult;
            }
        };
        private int mRl;
        private AppBrandLaunchErrorAction mRm;
        private AppBrandSysConfigWC mRn;
        private AppStartupPerformanceReportBundle mRo;
        private int mRp;
        private long mRq;
        private com.tencent.mm.plugin.appbrand.jsapi.ab.b mRr;
        private String mRs;
        private int mRt = 0;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47104);
            Log.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%d]", Integer.valueOf(this.mRl));
            parcel.writeInt(this.mRl);
            parcel.writeParcelable(this.mRm, i2);
            parcel.writeParcelable(this.mRn, i2);
            parcel.writeInt(this.mRp);
            parcel.writeLong(this.mRq);
            parcel.writeParcelable(this.mRo, i2);
            parcel.writeInt(this.mRt);
            if (this.mRl == 5) {
                parcel.writeString(this.mRr.toString());
                parcel.writeString(this.mRs);
            }
            AppMethodBeat.o(47104);
        }

        PrepareResult() {
        }

        PrepareResult(Parcel parcel) {
            AppMethodBeat.i(47105);
            this.mRl = parcel.readInt();
            this.mRm = (AppBrandLaunchErrorAction) parcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader());
            this.mRn = (AppBrandSysConfigWC) parcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader());
            this.mRp = parcel.readInt();
            this.mRq = parcel.readLong();
            this.mRo = (AppStartupPerformanceReportBundle) parcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader());
            this.mRt = parcel.readInt();
            if (this.mRl == 5) {
                this.mRr = com.tencent.mm.plugin.appbrand.jsapi.ab.b.aaQ(parcel.readString());
                this.mRs = parcel.readString();
            }
            AppMethodBeat.o(47105);
        }

        static {
            AppMethodBeat.i(47106);
            AppMethodBeat.o(47106);
        }
    }

    public static final class a implements com.tencent.mm.ipcinvoker.b<PrepareParams, PrepareResult> {
        private a() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(PrepareParams prepareParams, final d<PrepareResult> dVar) {
            AppMethodBeat.i(47098);
            final PrepareParams prepareParams2 = prepareParams;
            if (prepareParams2 == null) {
                Log.e("MicroMsg.AppBrandPrepareTask", "PrepareCall invoke NULL input");
                if (dVar != null) {
                    PrepareResult prepareResult = new PrepareResult();
                    prepareResult.mRl = 2;
                    prepareResult.mRn = null;
                    prepareResult.mRm = null;
                    prepareResult.mRo = null;
                    dVar.bn(prepareResult);
                }
                AppMethodBeat.o(47098);
                return;
            }
            final String str = prepareParams2.mRa;
            final String str2 = prepareParams2.mAppId;
            final int i2 = prepareParams2.mDebugType;
            final int i3 = prepareParams2.jZJ;
            String str3 = prepareParams2.mQZ;
            Log.i("MicroMsg.AppBrandPrepareTask", "PrepareCall#invoke username[%s] appId[%s]", str, str2);
            AnonymousClass1 r24 = new k.b() {
                /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.launching.k.b
                public final void bNi() {
                    AppMethodBeat.i(47088);
                    if (dVar != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.mRl = 1;
                        prepareResult.mRq = Util.nowMilliSecond();
                        dVar.bn(prepareResult);
                    }
                    AppMethodBeat.o(47088);
                }

                @Override // com.tencent.mm.plugin.appbrand.launching.k.b
                public final void onDownloadProgress(int i2) {
                    AppMethodBeat.i(47089);
                    if (dVar != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.mRp = i2;
                        prepareResult.mRl = 4;
                        dVar.bn(prepareResult);
                    }
                    AppMethodBeat.o(47089);
                }

                @Override // com.tencent.mm.plugin.appbrand.launching.k.b
                public final void bsQ() {
                    AppMethodBeat.i(47090);
                    if (dVar != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.mRl = 6;
                        dVar.bn(prepareResult);
                    }
                    AppMethodBeat.o(47090);
                }

                @Override // com.tencent.mm.plugin.appbrand.launching.k.b
                public final void bsR() {
                    AppMethodBeat.i(227060);
                    if (dVar != null) {
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.mRl = 8;
                        dVar.bn(prepareResult);
                    }
                    AppMethodBeat.o(227060);
                }

                @Override // com.tencent.mm.plugin.appbrand.launching.k.b
                public final void a(AppBrandSysConfigWC appBrandSysConfigWC, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
                    AppMethodBeat.i(47091);
                    if (dVar != null) {
                        Log.i("MicroMsg.AppBrandPrepareTask", "AppBrandRuntimeProfile| startPrepare onResult %s", prepareParams2.mAppId);
                        PrepareResult prepareResult = new PrepareResult();
                        prepareResult.mRl = 2;
                        prepareResult.mRn = appBrandSysConfigWC;
                        prepareResult.mRm = appBrandLaunchErrorAction;
                        prepareResult.mRo = appStartupPerformanceReportBundle;
                        dVar.bn(prepareResult);
                        if (appBrandSysConfigWC != null) {
                            AnonymousClass1 r0 = new p.a() {
                                /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.launching.p.a
                                public final void a(com.tencent.mm.plugin.appbrand.jsapi.ab.b bVar) {
                                    AppMethodBeat.i(227059);
                                    Log.i("MicroMsg.AppBrandPrepareTask", "[appversion] dispatch %s, %s", prepareParams2.mAppId, bVar);
                                    PrepareResult prepareResult = new PrepareResult();
                                    prepareResult.mRl = 5;
                                    prepareResult.mRr = bVar;
                                    dVar.bn(prepareResult);
                                    AppMethodBeat.o(227059);
                                }
                            };
                            if (prepareParams2.mRf || !j.a.vP(prepareParams2.mDebugType)) {
                                r0.a(com.tencent.mm.plugin.appbrand.jsapi.ab.b.NO_UPDATE);
                                AppMethodBeat.o(47091);
                                return;
                            }
                            p pVar = new p(prepareParams2, r0);
                            if (pVar.mSb == null) {
                                Log.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "start with NULL WxaVersionInfo, notify NO_UPDATE with username(%s) appId(%s)", pVar.mTv.mRa, pVar.mTv.mAppId);
                                pVar.mTw.a(com.tencent.mm.plugin.appbrand.jsapi.ab.b.NO_UPDATE);
                                AppMethodBeat.o(47091);
                                return;
                            }
                            h.RTc.aX(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.launching.p.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(47161);
                                    p pVar = p.this;
                                    String str = pVar.mTv.mRa;
                                    Pair<Boolean, Integer> I = ((b) n.W(b.class)).I(str, 1, pVar.enterScene);
                                    if (((Boolean) I.first).booleanValue()) {
                                        Log.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "sync blocked with username(%s) scene(%d)", str, Integer.valueOf(pVar.enterScene));
                                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) ((Integer) I.second).intValue(), 164);
                                        AppMethodBeat.o(47161);
                                        return;
                                    }
                                    Log.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] start() username %s, scene %d", str, Integer.valueOf(pVar.enterScene));
                                    long nowMilliSecond = Util.nowMilliSecond();
                                    new aa.c() {
                                        /* class com.tencent.mm.plugin.appbrand.launching.p.AnonymousClass2 */

                                        @Override // com.tencent.mm.plugin.appbrand.config.aa.c
                                        public final String aiv() {
                                            return p.this.mTv.mRg.kEY;
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.config.aa.c
                                        public final acc bAl() {
                                            AppMethodBeat.i(227078);
                                            acc acc = new acc();
                                            acc.dUS = p.this.mTv.jZJ;
                                            acc.LmF = com.tencent.luggage.sdk.launching.b.PRE_RENDER == p.this.mTv.mQH;
                                            acc.LmG = 102;
                                            AppMethodBeat.o(227078);
                                            return acc;
                                        }
                                    };
                                    aa.a(pVar.mTv.mRa, true, (aa.b<WxaAttributes>) new aa.b<WxaAttributes>(str, nowMilliSecond) {
                                        /* class com.tencent.mm.plugin.appbrand.launching.p.AnonymousClass3 */
                                        final /* synthetic */ String gtu;
                                        final /* synthetic */ long mTy;

                                        {
                                            this.gtu = r3;
                                            this.mTy = r4;
                                        }

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.config.aa$b$a, java.lang.Object] */
                                        @Override // com.tencent.mm.plugin.appbrand.config.aa.b
                                        public final /* synthetic */ void a(aa.b.a aVar, WxaAttributes wxaAttributes) {
                                            ms.c cVar;
                                            AppMethodBeat.i(227080);
                                            final WxaAttributes wxaAttributes2 = wxaAttributes;
                                            if (wxaAttributes2 == null) {
                                                Log.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "onGetContact with username(%s) maybeNew == NULL", this.gtu);
                                                try {
                                                    p.this.mTw.a(com.tencent.mm.plugin.appbrand.jsapi.ab.b.NO_UPDATE);
                                                    AppMethodBeat.o(227080);
                                                } catch (Exception e2) {
                                                    Log.printErrStackTrace("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", e2, "onGetContact with username(%s) maybeNew == NULL", this.gtu);
                                                    AppMethodBeat.o(227080);
                                                }
                                            } else if (wxaAttributes2.bAp() == null) {
                                                String format = String.format(Locale.US, "onGetContact with username(%s), maybeNew.versionInfo == NULL", this.gtu);
                                                Log.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", format);
                                                try {
                                                    p.this.mTw.a(com.tencent.mm.plugin.appbrand.jsapi.ab.b.NO_UPDATE);
                                                    AppMethodBeat.o(227080);
                                                } catch (Exception e3) {
                                                    Log.printErrStackTrace("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", e3, format, new Object[0]);
                                                    AppMethodBeat.o(227080);
                                                }
                                            } else {
                                                Log.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] onGetContact(%s), result %s, old.version %d, maybeNew.ver %d", this.gtu, aVar, Integer.valueOf(p.this.kMt), Integer.valueOf(wxaAttributes2.bAp().appVersion));
                                                switch (AnonymousClass4.kPJ[aVar.ordinal()]) {
                                                    case 1:
                                                        cVar = ms.c.common_fail;
                                                        break;
                                                    default:
                                                        cVar = ms.c.ok;
                                                        break;
                                                }
                                                long nowMilliSecond = Util.nowMilliSecond();
                                                ms wJ = g.d(p.this.ldW).wL(this.mTy).wM(nowMilliSecond).wJ(nowMilliSecond - this.mTy);
                                                wJ.fed = cVar;
                                                wJ.fee = ms.b.async;
                                                wJ.eJb = (long) g.getNetworkType();
                                                wJ.bfK();
                                                WxaAttributes.WxaVersionInfo wxaVersionInfo = p.this.mSb;
                                                if (wxaAttributes2.bAp().cyu != 0) {
                                                    p.this.mTw.a(com.tencent.mm.plugin.appbrand.jsapi.ab.b.NO_UPDATE);
                                                    AppMethodBeat.o(227080);
                                                } else if (wxaVersionInfo.appVersion >= wxaAttributes2.bAp().appVersion) {
                                                    p.this.mTw.a(com.tencent.mm.plugin.appbrand.jsapi.ab.b.NO_UPDATE);
                                                    AppMethodBeat.o(227080);
                                                } else {
                                                    p.this.mTw.a(com.tencent.mm.plugin.appbrand.jsapi.ab.b.UPDATING);
                                                    h.RTc.b(new Runnable() {
                                                        /* class com.tencent.mm.plugin.appbrand.launching.p.AnonymousClass3.AnonymousClass1 */

                                                        public final void run() {
                                                            WxaPkgWrappingInfo wxaPkgWrappingInfo;
                                                            AppMethodBeat.i(227079);
                                                            try {
                                                                ba baVar = new ba(wxaAttributes2.field_appId, 0, p.this.mTv.mQZ, p.this.enterScene, wxaAttributes2.bAp(), p.this.mTv.cuy, p.this.mTv.mRh, p.this.ldW, p.this.mTv.mQH, true);
                                                                baVar.hX(false);
                                                                wxaPkgWrappingInfo = baVar.bCi();
                                                            } catch (Exception e2) {
                                                                Log.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "%s, prepare pkg exp = %s", wxaAttributes2.field_appId, e2);
                                                                wxaPkgWrappingInfo = null;
                                                            }
                                                            p.this.mTw.a(wxaPkgWrappingInfo == null ? com.tencent.mm.plugin.appbrand.jsapi.ab.b.UPDATE_FAILED : com.tencent.mm.plugin.appbrand.jsapi.ab.b.UPDATE_READY);
                                                            AppMethodBeat.o(227079);
                                                        }
                                                    }, "MicroMsg.AppBrand.Launching.ContactSilentSyncProcess|download|" + this.gtu);
                                                    AppMethodBeat.o(227080);
                                                }
                                            }
                                        }
                                    });
                                    AppMethodBeat.o(47161);
                                }
                            });
                            AppMethodBeat.o(47091);
                            return;
                        }
                        aa.XE(y.Xy(prepareParams2.mAppId));
                    }
                    AppMethodBeat.o(47091);
                }

                @Override // com.tencent.mm.plugin.appbrand.launching.q
                public final void vy(int i2) {
                    AppMethodBeat.i(47092);
                    PrepareResult prepareResult = new PrepareResult();
                    prepareResult.mRl = 7;
                    prepareResult.mRt = i2;
                    dVar.bn(prepareResult);
                    AppMethodBeat.o(47092);
                }

                @Override // com.tencent.mm.plugin.appbrand.launching.k.b
                public final void bNj() {
                    AppMethodBeat.i(227061);
                    Log.i("MicroMsg.AppBrandPrepareTask", "onFallbackBackupWxaAttrsRequested, username[%s] appId[%s]", str, prepareParams2.mAppId);
                    PrepareResult prepareResult = new PrepareResult();
                    prepareResult.mRl = 9;
                    dVar.bn(prepareResult);
                    AppMethodBeat.o(227061);
                }
            };
            final k abX = k.abX(prepareParams2.mRc);
            if (abX == null) {
                abX = new k(str, str2, i2, prepareParams2.mQY, i3, str3, prepareParams2.mRb, prepareParams2.mRc, prepareParams2.mRh, prepareParams2.mRd, prepareParams2.cuy, prepareParams2.mRe, prepareParams2.mRg, prepareParams2.mRi, prepareParams2.mRj, prepareParams2.mQH, prepareParams2.kHI, prepareParams2.mRk);
                AnonymousClass2 r10 = new com.tencent.mm.kernel.api.g() {
                    /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.AnonymousClass2 */

                    @Override // com.tencent.mm.kernel.api.g
                    public final void WY() {
                        AppMethodBeat.i(47096);
                        Log.i("MicroMsg.AppBrandPrepareTask", "PrepareCall#invoke onMMKernelStartupDone username[%s] appId[%s]", str, str2);
                        com.tencent.mm.kernel.g.aAi().b(this);
                        com.tencent.mm.kernel.g.aAf();
                        boolean azo = com.tencent.mm.kernel.a.azo();
                        boolean azj = com.tencent.mm.kernel.a.azj();
                        if (!azo || azj) {
                            Log.i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", Boolean.valueOf(azo), Boolean.valueOf(azj));
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(47093);
                                    Toast.makeText(MMApplicationContext.getContext(), (int) R.string.hq, 0).show();
                                    try {
                                        Intent intent = new Intent();
                                        intent.addFlags(268435456).addFlags(67108864);
                                        c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                                        AppMethodBeat.o(47093);
                                    } catch (Exception e2) {
                                        AppMethodBeat.o(47093);
                                    }
                                }
                            });
                            if (dVar != null) {
                                PrepareResult prepareResult = new PrepareResult();
                                prepareResult.mRl = 3;
                                dVar.bn(prepareResult);
                                AppMethodBeat.o(47096);
                                return;
                            }
                        } else {
                            AnonymousClass2 r0 = new IListener<co>() {
                                /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.AnonymousClass2.AnonymousClass2 */

                                {
                                    AppMethodBeat.i(160602);
                                    this.__eventId = co.class.getName().hashCode();
                                    AppMethodBeat.o(160602);
                                }

                                @Override // com.tencent.mm.sdk.event.IListener
                                public final /* synthetic */ boolean callback(co coVar) {
                                    AppMethodBeat.i(47095);
                                    boolean a2 = a(coVar);
                                    AppMethodBeat.o(47095);
                                    return a2;
                                }

                                private boolean a(co coVar) {
                                    AppMethodBeat.i(47094);
                                    if (coVar != null) {
                                        dead();
                                        Log.i("MicroMsg.AppBrandPrepareTask", "prepareCall account notifyAllDone, start real prepare");
                                    }
                                    abX.bNl();
                                    AppMethodBeat.o(47094);
                                    return false;
                                }
                            };
                            if (com.tencent.mm.kernel.g.aAf().hpY) {
                                r0.callback(null);
                                AppMethodBeat.o(47096);
                                return;
                            }
                            Log.i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
                            r0.alive();
                        }
                        AppMethodBeat.o(47096);
                    }

                    @Override // com.tencent.mm.kernel.api.g
                    public final void cQ(boolean z) {
                        AppMethodBeat.i(47097);
                        com.tencent.mm.kernel.g.aAi().b(this);
                        Log.i("MicroMsg.AppBrandPrepareTask", "kernel onExit(%b), kill prepare process appId[%s] type[%d] scene[%d] sessionId[%s]", Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i3), prepareParams2.mRc);
                        if (dVar != null) {
                            PrepareResult prepareResult = new PrepareResult();
                            prepareResult.mRl = 3;
                            dVar.bn(prepareResult);
                        }
                        AppMethodBeat.o(47097);
                    }
                };
                if (com.tencent.mm.kernel.g.aAi().hrh.hrB) {
                    r10.WY();
                } else {
                    Log.i("MicroMsg.AppBrandPrepareTask", "prepareCall kernel startup not done yet, wait for it, username[%s] appId[%s]", str, str2);
                    com.tencent.mm.kernel.g.aAi().a(r10);
                }
            } else {
                o.a(22, prepareParams2.mAppId, prepareParams2.mRd.appVersion, prepareParams2.mDebugType, prepareParams2.cuy);
                long j2 = abX.mRY;
                if (j2 > 0 && dVar != null) {
                    PrepareResult prepareResult2 = new PrepareResult();
                    prepareResult2.mRl = 1;
                    prepareResult2.mRq = j2;
                    dVar.bn(prepareResult2);
                }
            }
            abX.mRV = r24;
            if (abX.mSq) {
                Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "setCallback, username[%s] appId[%s], invoke onFallbackBackupWxaAttrsRequested", abX.username, abX.appId);
                r24.bNj();
                AppMethodBeat.o(47098);
                return;
            }
            if (abX.started && abX.mRX != null) {
                Log.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify] setResultCallback already done %s %d, errorAction=%s, sessionId:%s, instanceId:%s", abX.appId, Integer.valueOf(abX.iOo), abX.mRX.get(1), abX.mRZ, abX.kEY);
                abX.a(abX.mRX);
            }
            if (abX.mSp) {
                abX.mRV.bsR();
            }
            if (abX.mRW) {
                abX.bNn();
            }
            if (abX.mSl != null && abX.mSl.booleanValue()) {
                abX.mRV.bsQ();
            }
            AppMethodBeat.o(47098);
        }
    }
}
