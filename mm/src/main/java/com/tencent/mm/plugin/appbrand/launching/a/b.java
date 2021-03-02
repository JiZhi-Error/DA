package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.luggage.sdk.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.b.a.mv;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify;
import com.tencent.mm.plugin.appbrand.launching.aa;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.launching.ax;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fdx;
import com.tencent.mm.protocal.protobuf.fec;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.c;
import java.util.Locale;
import java.util.Objects;

public final class b extends com.tencent.mm.plugin.appbrand.networking.b<che> {
    final String cym;
    private final String kEY;
    volatile boolean mWd = false;
    public volatile ap mXK;
    public aa mXL;
    private final mv mXM;
    final d rr;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.appbrand.networking.b, com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, che che, q qVar) {
        boolean z;
        long j2;
        AppMethodBeat.i(47400);
        final che che2 = che;
        if (qVar == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            try {
                long nowMilliSecond = Util.nowMilliSecond();
                this.mXM.xg(nowMilliSecond);
                this.mXM.xd(nowMilliSecond - this.mXM.fad);
                mv mvVar = this.mXM;
                if (bNT()) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                mvVar.feN = j2;
                if (!a.a(i2, i3, che2)) {
                    this.mXM.feL = mv.c.common_fail;
                } else if (che2.MmA == null) {
                    this.mXM.feL = mv.c.bundle_null;
                } else if (che2.MmA.LjS == null) {
                    this.mXM.feL = mv.c.jsapi_control_bytes_null;
                } else {
                    this.mXM.feL = mv.c.ok;
                }
                this.mXM.bfK();
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "quality report e = %s", e2);
            }
        }
        final boolean z2 = bNU().KOF.LmF;
        Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "onCgiBack, errType %d, errCode %d, errMsg %s, cgiHash[%d] req[appId %s, bg %B, sync %B, libVersion %d, isForPreRender %b], resp[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(hashCode()), getAppId(), Boolean.valueOf(bNT()), Boolean.valueOf(this.mWd), Integer.valueOf(bNU().Mmp.MqF), Boolean.valueOf(z2), com.tencent.mm.ah.a.a(che2));
        if (i2 == 0 && i3 == 0 && che2 != null) {
            c cVar = c.cCC;
            com.tencent.luggage.sdk.e.b dJ = c.dJ(this.kEY);
            com.tencent.mm.plugin.appbrand.appstorage.b bVar = (com.tencent.mm.plugin.appbrand.appstorage.b) n.W(com.tencent.mm.plugin.appbrand.appstorage.b.class);
            if (!(dJ == null || bVar == null)) {
                ((com.tencent.mm.plugin.appbrand.appstorage.b) n.W(com.tencent.mm.plugin.appbrand.appstorage.b.class)).cy(che2.dNI, getUserName());
            }
            if (z) {
                this.mXK = new ap();
                this.mXK.field_appId = getAppId();
                this.mXK.b(che2);
            } else {
                this.mXK = n.buD().a(getAppId(), che2);
            }
            this.mXK.mWd = this.mWd;
            g.hio().i(new com.tencent.mm.vending.c.a<Void, Void>() {
                /* class com.tencent.mm.plugin.appbrand.launching.a.b.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(Void r4) {
                    AppMethodBeat.i(47393);
                    au.a(b.this.bNU().Mmp.MqF, che2.MmC);
                    Void r0 = QZL;
                    AppMethodBeat.o(47393);
                    return r0;
                }
            }).hdy();
            if (che2.Mmz != null) {
                if (che2.Mmz.Mmg) {
                    if (z2) {
                        Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "onCgiBack cgiHash[%d] sessionId[%s] isForPreRender[true], skip add HistoryList", Integer.valueOf(hashCode()), this.cym);
                        AppMethodBeat.o(47400);
                        return;
                    }
                    g.hio().i(new com.tencent.mm.vending.c.a<Void, Void>() {
                        /* class com.tencent.mm.plugin.appbrand.launching.a.b.AnonymousClass4 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(Void r10) {
                            AppMethodBeat.i(47394);
                            n.buJ().a(y.Xy(b.this.getAppId()), b.this.brf(), b.this.bNT(), ((chd) b.this.rr.iLK.iLR).Mmn.Scene, 1, b.this.cym, z2);
                            AppMethodBeat.o(47394);
                            return null;
                        }
                    }).hdy();
                }
                if (!this.mWd) {
                    ILaunchWxaAppInfoNotify.mUz.a(getAppId(), brf(), this.cym, this.mXK);
                }
            }
            AppMethodBeat.o(47400);
            return;
        }
        if (this.mWd && this.mXL != null && !z2) {
            ax.a(ax.getMMString(R.string.pf, String.format(Locale.US, " (%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3))), this.mXL);
        }
        AppMethodBeat.o(47400);
    }

    public b(String str, boolean z, fcc fcc, fez fez, fds fds, String str2, int i2, QualitySession qualitySession, String str3, AppBrandLaunchFromNotifyReferrer appBrandLaunchFromNotifyReferrer, String str4, acc acc) {
        super(str, str3);
        mv.b bVar;
        AppMethodBeat.i(227124);
        this.cym = str2;
        this.mXM = com.tencent.mm.plugin.appbrand.report.quality.g.e(qualitySession);
        mv mvVar = this.mXM;
        if (z) {
            bVar = mv.b.sync;
        } else {
            bVar = mv.b.async;
        }
        mvVar.feM = bVar;
        this.mXM.eJb = (long) com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
        this.kEY = qualitySession.kEY;
        chd chd = new chd();
        chd.jfi = str;
        chd.Mmn = fcc;
        chd.Mbn = z ? 1 : 2;
        chd.Mmq = fez;
        chd.Mmr = fds;
        chd.Mmv = str3;
        chd.Mmu = this.kEY;
        fdb fdb = new fdb();
        fdb.MqF = i2;
        chd.Mmp = fdb;
        if (chd.Mmn.Scene == 1162 && appBrandLaunchFromNotifyReferrer != null) {
            fec fec = new fec();
            fec.Nzu = appBrandLaunchFromNotifyReferrer.lek;
            chd.Mmw = fec;
        }
        if (1173 == chd.Mmn.Scene) {
            if (Util.isNullOrNil(str4)) {
                Log.w("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init>, openMaterialMimeType is empty");
            } else {
                fdx fdx = new fdx();
                fdx.LXZ = str4;
                chd.Mmy = fdx;
            }
        }
        chd.KOF = (acc) Objects.requireNonNull(acc);
        d.a aVar = new d.a();
        aVar.funcId = 1122;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
        aVar.iLN = chd;
        aVar.iLO = new che();
        d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "<init> cgiHash[%d], username[%s] appId[%s] sync[%b] sessionId[%s] instanceId[%s] libVersion[%d], source:%s", Integer.valueOf(hashCode()), str3, str, Boolean.valueOf(z), str2, this.kEY, Integer.valueOf(i2), com.tencent.mm.ah.a.a(acc));
        AppMethodBeat.o(227124);
    }

    /* access modifiers changed from: package-private */
    public final String getAppId() {
        return ((chd) this.rr.iLK.iLR).jfi;
    }

    private String getUserName() {
        return ((chd) this.rr.iLK.iLR).Mmv;
    }

    /* access modifiers changed from: package-private */
    public final int brf() {
        return ((chd) this.rr.iLK.iLR).Mmn.MjZ;
    }

    /* access modifiers changed from: package-private */
    public final boolean bNT() {
        return ((chd) this.rr.iLK.iLR).Mmn.MqD > 0;
    }

    /* access modifiers changed from: protected */
    public final chd bNU() {
        return (chd) this.rr.iLK.iLR;
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.b
    public final c.a<che> bNV() {
        AppMethodBeat.i(227125);
        this.mWd = true;
        c.a<che> bNV = super.bNV();
        AppMethodBeat.o(227125);
        return bNV;
    }

    public final void bNW() {
        AppMethodBeat.i(47396);
        com.tencent.mm.vending.h.d.LOGIC.arrange(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.launching.a.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(47391);
                b.this.mWd = false;
                b.this.aYI();
                AppMethodBeat.o(47391);
            }
        });
        AppMethodBeat.o(47396);
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.b, com.tencent.mm.ak.c
    public final synchronized f<c.a<che>> aYI() {
        f<c.a<che>> a2;
        com.tencent.mm.plugin.appbrand.launching.d.g a3;
        AppMethodBeat.i(47397);
        a2 = new a().a((chd) this.rr.iLK.iLR, this.mWd, this);
        if (a2 != null) {
            AppMethodBeat.o(47397);
        } else {
            com.tencent.luggage.sdk.e.c cVar = com.tencent.luggage.sdk.e.c.cCC;
            com.tencent.luggage.sdk.e.b dJ = com.tencent.luggage.sdk.e.c.dJ(this.kEY);
            if (!(dJ == null || (a3 = com.tencent.mm.plugin.appbrand.launching.d.c.a(dJ)) == null)) {
                final c.a<che> yn = a3.yn(100);
                a3.kqC = this.mWd;
                if (yn == null || yn.iLC == null || yn.errType != 0 || yn.errCode != 0) {
                    a3.cCu = false;
                } else {
                    a3.cCu = true;
                    a2 = g.c(new c.a<c.a<che>>() {
                        /* class com.tencent.mm.plugin.appbrand.launching.a.b.AnonymousClass2 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // com.tencent.mm.vending.g.c.a
                        public final /* synthetic */ c.a<che> call() {
                            AppMethodBeat.i(47392);
                            c.a a2 = c.a.a(0, 0, "", yn.iLC, null, b.this);
                            AppMethodBeat.o(47392);
                            return a2;
                        }
                    });
                    AppMethodBeat.o(47397);
                }
            }
            b(bNU());
            a(bNU());
            this.mXM.xf(Util.nowMilliSecond());
            a2 = super.aYI();
            AppMethodBeat.o(47397);
        }
        return a2;
    }

    public static void a(chd chd) {
        AppMethodBeat.i(47398);
        try {
            if (ae.gKC.gDy) {
                Log.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "SrvDeviceInfo isLimit benchmarkLevel");
                chd.Mmt = -1;
                AppMethodBeat.o(47398);
                return;
            }
            chd.Mmt = h.aqJ().getInt("ClientBenchmarkLevel", -1);
            if (chd.Mmt == 0) {
                Log.e("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DynamicConfig performanceLevel 0 illegal");
            }
            AppMethodBeat.o(47398);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", e2, "read performanceLevel", new Object[0]);
            AppMethodBeat.o(47398);
        }
    }

    public static void b(chd chd) {
        ag buQ;
        AppMethodBeat.i(47399);
        int i2 = chd.Mmp.MqF;
        if (i2 > 0 && (buQ = n.buQ()) != null) {
            af afVar = new af();
            afVar.field_key = "@LibraryAppId";
            afVar.field_version = i2;
            if (buQ.get(afVar, "key", "version")) {
                chd.Mmp.KHb = (int) afVar.field_updateTime;
                chd.Mmp.NyM = afVar.field_scene;
            }
        }
        AppMethodBeat.o(47399);
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.b
    public final f<c.a<che>> bAe() {
        AppMethodBeat.i(227126);
        if (!com.tencent.mm.plugin.appbrand.networking.a.eA(getAppId(), getUserName())) {
            f<c.a<che>> c2 = g.c(new c.a<c.a<che>>() {
                /* class com.tencent.mm.plugin.appbrand.launching.a.b.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.vending.g.c.a
                public final /* synthetic */ c.a<che> call() {
                    AppMethodBeat.i(227123);
                    c.a a2 = c.a.a(4, -2, "", null, null, b.this);
                    AppMethodBeat.o(227123);
                    return a2;
                }
            });
            AppMethodBeat.o(227126);
            return c2;
        }
        AppMethodBeat.o(227126);
        return null;
    }
}
