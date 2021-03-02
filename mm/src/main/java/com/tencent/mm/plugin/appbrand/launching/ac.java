package com.tencent.mm.plugin.appbrand.launching;

import android.util.ArrayMap;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.b.a.ls;
import com.tencent.mm.g.b.a.mr;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class ac {
    private static final int mUG = 1004;
    public static final ac mUH = new ac();

    public static final class d extends q implements kotlin.g.a.b<x.d, kotlin.x> {
        public static final d mUL = new d();

        static {
            AppMethodBeat.i(228663);
            AppMethodBeat.o(228663);
        }

        d() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(x.d dVar) {
            AppMethodBeat.i(228662);
            p.h(dVar, "<anonymous parameter 0>");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228662);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(180606);
        AppMethodBeat.o(180606);
    }

    private ac() {
    }

    public static /* synthetic */ l.a a(QualitySession qualitySession, boolean z) {
        AppMethodBeat.i(228689);
        l.a a2 = a(qualitySession, false, z, d.mUL);
        AppMethodBeat.o(228689);
        return a2;
    }

    public static /* synthetic */ l.a a(QualitySession qualitySession, boolean z, boolean z2, kotlin.g.a.b<? super x.d, kotlin.x> bVar) {
        AppMethodBeat.i(228688);
        p.h(qualitySession, "reportQualitySession");
        p.h(bVar, "onPkgMissed");
        acc acc = new acc();
        acc.dUS = qualitySession.scene;
        acc.LmF = z2;
        acc.LmG = 1;
        if (qualitySession.apptype == mUG) {
            e eVar = new e(z, qualitySession, acc, bVar);
            AppMethodBeat.o(228688);
            return eVar;
        }
        f fVar = new f(qualitySession, acc, bVar);
        AppMethodBeat.o(228688);
        return fVar;
    }

    public static final class e implements l.a {
        final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.gameBatchReporter";
        final /* synthetic */ QualitySession mSX;
        private CopyOnWriteArrayList<a> mUM = new CopyOnWriteArrayList<>();
        private volatile boolean mUN;
        final /* synthetic */ boolean mUO;
        final /* synthetic */ kotlin.g.a.b mUP;
        final /* synthetic */ acc mUi;

        e(boolean z, QualitySession qualitySession, acc acc, kotlin.g.a.b bVar) {
            this.mUO = z;
            this.mSX = qualitySession;
            this.mUi = acc;
            this.mUP = bVar;
            AppMethodBeat.i(228678);
            AppMethodBeat.o(228678);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.x.c
        public final void c(x.d dVar, x.e eVar) {
            AppMethodBeat.i(228679);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(eVar, "response");
            l.a.C0739a.a(dVar, eVar);
            AppMethodBeat.o(228679);
        }

        public final class a {
            int dTz;
            String provider = "";
            int version;

            public a() {
                e.this = r2;
            }

            public final void setProvider(String str) {
                AppMethodBeat.i(228664);
                p.h(str, "<set-?>");
                this.provider = str;
                AppMethodBeat.o(228664);
            }
        }

        private final void bNB() {
            AppMethodBeat.i(228670);
            if (this.mUN) {
                AppMethodBeat.o(228670);
                return;
            }
            this.mUN = true;
            k(1, "", 0);
            AppMethodBeat.o(228670);
        }

        private final void k(int i2, String str, int i3) {
            AppMethodBeat.i(228671);
            Log.i(this.TAG, "addPluginStage stage:%d,provider:%s,version:%d", Integer.valueOf(i2), str, Integer.valueOf(i3));
            a aVar = new a();
            aVar.setProvider(str);
            aVar.dTz = i2;
            aVar.version = i3;
            this.mUM.add(aVar);
            AppMethodBeat.o(228671);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private static void yj(int i2) {
            AppMethodBeat.i(228672);
            switch (i2) {
                case 0:
                    yk(11);
                    AppMethodBeat.o(228672);
                    return;
                case 4:
                    yk(13);
                    break;
                case 6:
                    yk(0);
                    AppMethodBeat.o(228672);
                    return;
                case 12:
                    yk(2);
                    AppMethodBeat.o(228672);
                    return;
                case 13:
                    yk(4);
                    AppMethodBeat.o(228672);
                    return;
                case 22:
                    yk(7);
                    AppMethodBeat.o(228672);
                    return;
                case 23:
                    yk(9);
                    AppMethodBeat.o(228672);
                    return;
            }
            AppMethodBeat.o(228672);
        }

        private static void yk(int i2) {
            AppMethodBeat.i(228673);
            h.INSTANCE.idkeyStat(1027, (long) i2, 1, false);
            AppMethodBeat.o(228673);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.l.a
        public final void bNs() {
            AppMethodBeat.i(228674);
            Log.i(this.TAG, "onAllPkgDownloaded isLaunch:%b", Boolean.valueOf(this.mUO));
            if (this.mUN && this.mUO && this.mUM != null && this.mUM.size() > 0) {
                Log.i(this.TAG, "mStageList size:%d", Integer.valueOf(this.mUM.size()));
                Iterator<a> it = this.mUM.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    mr mrVar = new mr();
                    QualitySession qualitySession = this.mSX;
                    mrVar.zS(qualitySession.appId);
                    mrVar.wC((long) qualitySession.nLk);
                    mrVar.a(mr.a.mC(qualitySession.nJE));
                    mrVar.wD((long) qualitySession.apptype);
                    mrVar.zV(qualitySession.kEY);
                    mrVar.wG((long) qualitySession.scene);
                    mrVar.zU(t.bUy());
                    mrVar.zT(next.provider);
                    mrVar.wE((long) next.version);
                    mrVar.wF((long) next.dTz);
                    mrVar.bfK();
                }
            }
            AppMethodBeat.o(228674);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.x.c
        public final void b(x.d dVar) {
            AppMethodBeat.i(228677);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            this.mUP.invoke(dVar);
            int[] iArr = com.tencent.mm.cp.a.Rxa;
            p.g(iArr, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (!kotlin.a.e.contains(iArr, dVar.packageType)) {
                int[] iArr2 = com.tencent.mm.cp.a.RwY;
                p.g(iArr2, "ConstantsWxaPackageProto…KAGE_TYPES_IN_WIDGET_INFO");
                if (kotlin.a.e.contains(iArr2, dVar.packageType)) {
                    bNB();
                    yj(dVar.packageType);
                }
                AppMethodBeat.o(228677);
            } else if (dVar.mUl instanceof x.g.b) {
                int i2 = ((x.g.b) dVar.mUl).version;
                int[] Vs = n.buL().Vs(dVar.bNz().toString());
                if (Vs == null) {
                    bNB();
                    k(2, dVar.appId, i2);
                    yj(dVar.packageType);
                } else {
                    ArrayList arrayList = new ArrayList();
                    int length = Vs.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        int i4 = Vs[i3];
                        if (!(i4 == ((x.g.b) dVar.mUl).version)) {
                            arrayList.add(Integer.valueOf(i4));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        bNB();
                        k(4, dVar.appId, i2);
                        yj(dVar.packageType);
                    }
                }
                com.tencent.mm.co.g.hio().i(new d(dVar, i2)).hdy();
                AppMethodBeat.o(228677);
            } else {
                bNB();
                k(2, dVar.appId, 0);
                yj(dVar.packageType);
                AppMethodBeat.o(228677);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class b extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ x.d kQl;
            final /* synthetic */ e mUQ;
            final /* synthetic */ x.e mUR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(e eVar, x.d dVar, x.e eVar2) {
                super(0);
                this.mUQ = eVar;
                this.kQl = dVar;
                this.mUR = eVar2;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(228667);
                final ls lsVar = new ls();
                lsVar.za(this.mUQ.mSX.appId);
                lsVar.vh((long) this.mUQ.mSX.nLk);
                lsVar.a(ls.a.md(this.mUQ.mSX.nJE));
                lsVar.vi((long) this.mUQ.mSX.apptype);
                lsVar.zb(this.kQl.appId);
                lsVar.a(ls.b.release);
                lsVar.zc(t.bUy());
                lsVar.zd(this.mUQ.mSX.kEY);
                lsVar.vj((long) this.mUQ.mSX.scene);
                x.b bVar = x.mTR;
                x.b.a(new x.d(this.kQl.appId, this.kQl.cBp, this.kQl.packageType, this.kQl.iOo, ((x.g.a) this.kQl.mUl).bNA(), false), new kotlin.g.a.b<x.e, kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.ac.e.b.AnonymousClass1 */
                    final /* synthetic */ b mUS;

                    {
                        this.mUS = r2;
                    }

                    @Override // kotlin.g.a.b
                    public final /* synthetic */ kotlin.x invoke(x.e eVar) {
                        AppMethodBeat.i(228665);
                        p.h(eVar, LocaleUtil.ITALIAN);
                        Log.i(this.mUS.mUQ.TAG, "update plugin(" + this.mUS.kQl.appId + ") to latest succeed, version=" + this.mUS.mUR.mUo.pkgVersion() + ", source=" + this.mUS.mUR.mUp);
                        lsVar.vk(1);
                        lsVar.bfK();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(228665);
                        return xVar;
                    }
                }, new m<x.a, String, kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.ac.e.b.AnonymousClass2 */
                    final /* synthetic */ b mUS;

                    {
                        this.mUS = r2;
                    }

                    @Override // kotlin.g.a.m
                    public final /* synthetic */ kotlin.x invoke(x.a aVar, String str) {
                        AppMethodBeat.i(228666);
                        x.a aVar2 = aVar;
                        p.h(aVar2, "err");
                        Log.i(this.mUS.mUQ.TAG, "update plugin(" + this.mUS.kQl.appId + ") to latest failed, ERROR(" + aVar2 + ") errMsg(" + str + ')');
                        lsVar.vk(2);
                        lsVar.bfK();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(228666);
                        return xVar;
                    }
                }, null, null, this.mUQ.mUi, null, 184);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(228667);
                return xVar;
            }
        }

        static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ x.d kQl;
            final /* synthetic */ x.e mUR;

            c(x.d dVar, x.e eVar) {
                this.kQl = dVar;
                this.mUR = eVar;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(228668);
                ak.aR(new ad(this.kQl.appId, ModulePkgInfo.PLUGIN_CODE).toString(), this.mUR.mUo.pkgVersion());
                AppMethodBeat.o(228668);
                return null;
            }
        }

        static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ int kQC;
            final /* synthetic */ x.d kQl;

            d(x.d dVar, int i2) {
                this.kQl = dVar;
                this.kQC = i2;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(228669);
                ak.aR(new ad(this.kQl.appId, ModulePkgInfo.PLUGIN_CODE).toString(), this.kQC);
                AppMethodBeat.o(228669);
                return null;
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.launching.l.a
        public final void a(x.d dVar) {
            AppMethodBeat.i(228675);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            switch (dVar.packageType) {
                case 0:
                    yk(12);
                    AppMethodBeat.o(228675);
                    return;
                case 4:
                    yk(14);
                    break;
                case 6:
                    yk(1);
                    AppMethodBeat.o(228675);
                    return;
                case 12:
                    yk(3);
                    AppMethodBeat.o(228675);
                    return;
                case 13:
                    yk(5);
                    AppMethodBeat.o(228675);
                    return;
                case 22:
                    yk(8);
                    AppMethodBeat.o(228675);
                    return;
                case 23:
                    yk(10);
                    AppMethodBeat.o(228675);
                    return;
            }
            AppMethodBeat.o(228675);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.x.c
        public final void b(x.d dVar, x.e eVar) {
            AppMethodBeat.i(228676);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(eVar, "response");
            if ((dVar.mUl instanceof x.g.a) && !((x.g.a) dVar.mUl).mUt) {
                int[] iArr = com.tencent.mm.cp.a.Rxa;
                p.g(iArr, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
                if (kotlin.a.e.contains(iArr, dVar.packageType)) {
                    Log.i(this.TAG, "onPkgCached, will update plugin(" + dVar.appId + ") to latest in background...");
                    com.tencent.mm.ac.d.i(new b(this, dVar, eVar));
                }
            }
            int[] iArr2 = com.tencent.mm.cp.a.Rxa;
            p.g(iArr2, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (kotlin.a.e.contains(iArr2, dVar.packageType)) {
                k(3, dVar.appId, eVar.mUo.pkgVersion());
                com.tencent.mm.co.g.hio().i(new c(dVar, eVar)).hdy();
            }
            AppMethodBeat.o(228676);
        }
    }

    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(180589);
            int a2 = kotlin.b.a.a(Integer.valueOf(t2.packageType), Integer.valueOf(t.packageType));
            AppMethodBeat.o(180589);
            return a2;
        }
    }

    public static final class g<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(180599);
            int a2 = kotlin.b.a.a(Integer.valueOf(t2.packageType), Integer.valueOf(t.packageType));
            AppMethodBeat.o(180599);
            return a2;
        }
    }

    public static final class f implements l.a {
        final String TAG = "MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils.defaultBatchReporter";
        final /* synthetic */ QualitySession mSX;
        final /* synthetic */ kotlin.g.a.b mUP;
        final /* synthetic */ acc mUi;

        f(QualitySession qualitySession, acc acc, kotlin.g.a.b bVar) {
            this.mSX = qualitySession;
            this.mUi = acc;
            this.mUP = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.l.a
        public final void a(x.d dVar) {
            AppMethodBeat.i(228686);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            AppMethodBeat.o(228686);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.l.a
        public final void bNs() {
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.x.c
        public final void c(x.d dVar, x.e eVar) {
            AppMethodBeat.i(228687);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(eVar, "response");
            l.a.C0739a.a(dVar, eVar);
            AppMethodBeat.o(228687);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.x.c
        public final void b(x.d dVar) {
            AppMethodBeat.i(228684);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            this.mUP.invoke(dVar);
            int[] iArr = com.tencent.mm.cp.a.Rxa;
            p.g(iArr, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (kotlin.a.e.contains(iArr, dVar.packageType)) {
                mr mrVar = new mr();
                a(mrVar, this.mSX);
                mrVar.zU(t.bUy());
                mrVar.zT(dVar.appId);
                if (dVar.mUl instanceof x.g.b) {
                    mrVar.wE((long) ((x.g.b) dVar.mUl).version);
                    int[] Vs = n.buL().Vs(dVar.bNz().toString());
                    if (Vs == null) {
                        mrVar.wF(2);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        int length = Vs.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            int i3 = Vs[i2];
                            if (!(i3 == ((x.g.b) dVar.mUl).version)) {
                                arrayList.add(Integer.valueOf(i3));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            mrVar.wF(4);
                        }
                    }
                } else {
                    mrVar.wE(0);
                    mrVar.wF(2);
                }
                mrVar.bfK();
            }
            AppMethodBeat.o(228684);
        }

        private static void a(mr mrVar, QualitySession qualitySession) {
            AppMethodBeat.i(228685);
            mrVar.zS(qualitySession.appId);
            mrVar.wC((long) qualitySession.nLk);
            mrVar.a(mr.a.mC(qualitySession.nJE));
            mrVar.wD((long) qualitySession.apptype);
            mrVar.zV(qualitySession.kEY);
            mrVar.wG((long) qualitySession.scene);
            AppMethodBeat.o(228685);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.x.c
        public final void b(x.d dVar, x.e eVar) {
            AppMethodBeat.i(228683);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(eVar, "response");
            if ((dVar.mUl instanceof x.g.a) && !((x.g.a) dVar.mUl).mUt) {
                int[] iArr = com.tencent.mm.cp.a.Rxa;
                p.g(iArr, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
                if (kotlin.a.e.contains(iArr, dVar.packageType)) {
                    Log.i(this.TAG, "onPkgCached, will update plugin(" + dVar.appId + ") to latest in background...");
                    com.tencent.mm.ac.d.i(new a(this, dVar, eVar));
                }
            }
            int[] iArr2 = com.tencent.mm.cp.a.Rxa;
            p.g(iArr2, "ConstantsWxaPackageProto….PLUGINCODE_PACKAGE_TYPES");
            if (kotlin.a.e.contains(iArr2, dVar.packageType)) {
                mr mrVar = new mr();
                a(mrVar, this.mSX);
                mrVar.zU(t.bUy());
                mrVar.zT(dVar.appId);
                mrVar.wE((long) eVar.mUo.pkgVersion());
                mrVar.wF(3);
                mrVar.bfK();
            }
            AppMethodBeat.o(228683);
        }

        /* access modifiers changed from: package-private */
        public static final class a extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ x.d kQl;
            final /* synthetic */ x.e mUR;
            final /* synthetic */ f mUU;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar, x.d dVar, x.e eVar) {
                super(0);
                this.mUU = fVar;
                this.kQl = dVar;
                this.mUR = eVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(228682);
                final ls lsVar = new ls();
                lsVar.za(this.mUU.mSX.appId);
                lsVar.vh((long) this.mUU.mSX.nLk);
                lsVar.a(ls.a.md(this.mUU.mSX.nJE));
                lsVar.vi((long) this.mUU.mSX.apptype);
                lsVar.zb(this.kQl.appId);
                lsVar.a(ls.b.release);
                lsVar.zc(t.bUy());
                lsVar.zd(this.mUU.mSX.kEY);
                lsVar.vj((long) this.mUU.mSX.scene);
                x.b bVar = x.mTR;
                x.b.a(new x.d(this.kQl.appId, this.kQl.cBp, this.kQl.packageType, this.kQl.iOo, ((x.g.a) this.kQl.mUl).bNA(), false), new kotlin.g.a.b<x.e, kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.ac.f.a.AnonymousClass1 */
                    final /* synthetic */ a mUV;

                    {
                        this.mUV = r2;
                    }

                    @Override // kotlin.g.a.b
                    public final /* synthetic */ kotlin.x invoke(x.e eVar) {
                        AppMethodBeat.i(228680);
                        p.h(eVar, LocaleUtil.ITALIAN);
                        Log.i(this.mUV.mUU.TAG, "update plugin(" + this.mUV.kQl.appId + ") to latest succeed, version=" + this.mUV.mUR.mUo.pkgVersion() + ", source=" + this.mUV.mUR.mUp);
                        lsVar.vk(1);
                        lsVar.bfK();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(228680);
                        return xVar;
                    }
                }, new m<x.a, String, kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.ac.f.a.AnonymousClass2 */
                    final /* synthetic */ a mUV;

                    {
                        this.mUV = r2;
                    }

                    @Override // kotlin.g.a.m
                    public final /* synthetic */ kotlin.x invoke(x.a aVar, String str) {
                        AppMethodBeat.i(228681);
                        x.a aVar2 = aVar;
                        p.h(aVar2, "err");
                        Log.i(this.mUV.mUU.TAG, "update plugin(" + this.mUV.kQl.appId + ") to latest failed, ERROR(" + aVar2 + ") errMsg(" + str + ')');
                        lsVar.vk(2);
                        lsVar.bfK();
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(228681);
                        return xVar;
                    }
                }, null, null, this.mUU.mUi, null, 184);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(228682);
                return xVar;
            }
        }
    }

    public static /* synthetic */ void aca(String str) {
        ddz ddz;
        AppMethodBeat.i(180601);
        p.h(str, "instanceId");
        com.tencent.luggage.sdk.e.c cVar = com.tencent.luggage.sdk.e.c.cCC;
        com.tencent.luggage.sdk.e.b dJ = com.tencent.luggage.sdk.e.c.dJ(str);
        com.tencent.luggage.sdk.e.a<?> aVar = dJ.cCy.get(1);
        if (aVar == null) {
            aVar = null;
        } else if (aVar == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
            AppMethodBeat.o(180601);
            throw tVar;
        }
        if (aVar == null) {
            AppMethodBeat.o(180601);
            return;
        }
        c.a aVar2 = (c.a) aVar.hS(100);
        if (aVar2 == null || (ddz = (ddz) aVar2.iLC) == null) {
            AppMethodBeat.o(180601);
            return;
        }
        HashMap hashMap = new HashMap();
        LinkedList<cye> linkedList = ddz.MJa;
        p.g(linkedList, "preGetResp.package_info_list");
        for (T t : linkedList) {
            if (!t.LVl) {
                y.b bVar = new y.b();
                String str2 = t.dNI;
                p.g(str2, "info.appid");
                bVar.setAppId(str2);
                bVar.cBp = t.MbW;
                bVar.packageType = t.MbZ;
                bVar.iOo = 0;
                bVar.appVersion = t.version;
                bVar.mUu = t.Mel;
                bmm[] bmmArr = (bmm[]) hashMap.get(bVar);
                if (bmmArr == null) {
                    bmmArr = (bmm[]) new a(bVar, hashMap).invoke();
                }
                p.g(bmmArr, "map[indexRequest] ?: {\n …  ret\n                }()");
                bmm bmm = new bmm();
                bmm.url = t.url;
                bmm.md5 = t.md5;
                bmm.LVf = new doo();
                bmm.LVf.dNI = t.dNI;
                bmm.LVf.MbW = t.MbW;
                bmm.LVf.MbZ = t.MbZ;
                bmm.LVf.KXC = 0;
                if (t.LVm) {
                    bmm.LVl = false;
                    bmm.LVm = true;
                    bmmArr[1] = bmm;
                } else {
                    bmm.LVl = false;
                    bmm.LVm = false;
                    bmmArr[0] = bmm;
                }
            }
        }
        if (hashMap.size() > 0) {
            v vVar = v.mTG;
            v.W(hashMap);
            c cVar2 = new c(hashMap);
            p.h(cVar2, "l");
            dJ.cCz.add(cVar2);
        }
        AppMethodBeat.o(180601);
    }

    private static boolean a(ICommLibReader iCommLibReader, boolean z) {
        AppMethodBeat.i(180602);
        if (z) {
            AppMethodBeat.o(180602);
            return true;
        }
        String UN = iCommLibReader.UN("injectAppSeparatedPlugin");
        if (UN == null || !Boolean.parseBoolean(UN)) {
            AppMethodBeat.o(180602);
            return false;
        }
        AppMethodBeat.o(180602);
        return true;
    }

    public static boolean a(String str, int i2, int i3, boolean z, ICommLibReader iCommLibReader) {
        AppMethodBeat.i(180603);
        p.h(str, "appId");
        if (!j.a.sE(i2)) {
            switch (ad.$EnumSwitchMapping$0[((com.tencent.mm.plugin.appbrand.appcache.b) n.W(com.tencent.mm.plugin.appbrand.appcache.b.class)).aM(str, i3).ordinal()]) {
                case 1:
                case 2:
                    if (iCommLibReader == null || !a(iCommLibReader, z)) {
                        AppMethodBeat.o(180603);
                        return false;
                    }
                    AppMethodBeat.o(180603);
                    return true;
                default:
                    AppMethodBeat.o(180603);
                    return false;
            }
        } else if (iCommLibReader == null || !a(iCommLibReader, z)) {
            AppMethodBeat.o(180603);
            return false;
        } else {
            AppMethodBeat.o(180603);
            return true;
        }
    }

    public static /* synthetic */ Map<String, WxaAttributes.WxaWidgetInfo> a(WxaAttributes.WxaVersionInfo wxaVersionInfo, String str, boolean z) {
        boolean z2;
        WxaAttributes.WxaWidgetInfo wxaWidgetInfo;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        AppMethodBeat.i(180604);
        p.h(wxaVersionInfo, "$this$pickAppropriateWidgetInfoList");
        p.h(str, "appId");
        List<WxaAttributes.WxaVersionModuleInfo> list = wxaVersionInfo.moduleList;
        if (!(list == null || list.isEmpty())) {
            ArrayMap arrayMap = new ArrayMap(wxaVersionInfo.moduleList.size());
            for (WxaAttributes.WxaVersionModuleInfo wxaVersionModuleInfo : wxaVersionInfo.moduleList) {
                if (!z) {
                    wxaWidgetInfo = new WxaAttributes.WxaWidgetInfo();
                    wxaWidgetInfo.packageType = 4;
                    wxaWidgetInfo.lhj = wxaVersionModuleInfo.md5;
                } else {
                    List<WxaAttributes.WxaWidgetInfo> list2 = wxaVersionModuleInfo.lhh;
                    if (list2 == null || list2.isEmpty()) {
                        List<WxaAttributes.WxaPluginCodeInfo> list3 = wxaVersionModuleInfo.lhg;
                        if (!(list3 == null || list3.isEmpty())) {
                            WxaAttributes.WxaWidgetInfo wxaWidgetInfo2 = new WxaAttributes.WxaWidgetInfo();
                            wxaWidgetInfo2.lhj = wxaVersionModuleInfo.lha;
                            wxaWidgetInfo2.packageType = 13;
                            wxaWidgetInfo2.lhk = new LinkedList(wxaVersionModuleInfo.lhg);
                            wxaWidgetInfo = wxaWidgetInfo2;
                        } else {
                            wxaWidgetInfo = new WxaAttributes.WxaWidgetInfo();
                            wxaWidgetInfo.packageType = 4;
                            wxaWidgetInfo.lhj = wxaVersionModuleInfo.md5;
                        }
                    } else {
                        List<WxaAttributes.WxaWidgetInfo> list4 = wxaVersionModuleInfo.lhh;
                        p.g(list4, "this.wxaWidgetInfoList");
                        for (Object obj : kotlin.a.j.a((Iterable) list4, (Comparator) new b())) {
                            if (((WxaAttributes.WxaWidgetInfo) obj).packageType <= 23) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                wxaWidgetInfo = (WxaAttributes.WxaWidgetInfo) obj;
                            }
                        }
                        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
                        AppMethodBeat.o(180604);
                        throw noSuchElementException;
                    }
                }
                arrayMap.put(wxaVersionModuleInfo.name, wxaWidgetInfo);
            }
            ArrayMap arrayMap2 = arrayMap;
            AppMethodBeat.o(180604);
            return arrayMap2;
        } else if (!z) {
            WxaAttributes.WxaWidgetInfo wxaWidgetInfo3 = new WxaAttributes.WxaWidgetInfo();
            wxaWidgetInfo3.packageType = 0;
            wxaWidgetInfo3.lhj = wxaVersionInfo.lgS;
            Map<String, WxaAttributes.WxaWidgetInfo> I = I(ModulePkgInfo.MAIN_MODULE_NAME, wxaWidgetInfo3);
            AppMethodBeat.o(180604);
            return I;
        } else {
            List<WxaAttributes.WxaWidgetInfo> list5 = wxaVersionInfo.jmL;
            if (list5 == null || list5.isEmpty()) {
                List<WxaAttributes.WxaPluginCodeInfo> list6 = wxaVersionInfo.lgV;
                if (list6 != null && !list6.isEmpty()) {
                    z4 = false;
                }
                if (!z4) {
                    WxaAttributes.WxaWidgetInfo wxaWidgetInfo4 = new WxaAttributes.WxaWidgetInfo();
                    wxaWidgetInfo4.lhj = wxaVersionInfo.lha;
                    wxaWidgetInfo4.packageType = 12;
                    wxaWidgetInfo4.lhk = new LinkedList(wxaVersionInfo.lgV);
                    Map<String, WxaAttributes.WxaWidgetInfo> I2 = I(ModulePkgInfo.MAIN_MODULE_NAME, wxaWidgetInfo4);
                    AppMethodBeat.o(180604);
                    return I2;
                }
                WxaAttributes.WxaWidgetInfo wxaWidgetInfo5 = new WxaAttributes.WxaWidgetInfo();
                wxaWidgetInfo5.packageType = 0;
                wxaWidgetInfo5.lhj = wxaVersionInfo.lgS;
                Map<String, WxaAttributes.WxaWidgetInfo> I3 = I(ModulePkgInfo.MAIN_MODULE_NAME, wxaWidgetInfo5);
                AppMethodBeat.o(180604);
                return I3;
            }
            List<WxaAttributes.WxaWidgetInfo> list7 = wxaVersionInfo.jmL;
            p.g(list7, "this.widgetInfoList");
            for (Object obj2 : kotlin.a.j.a((Iterable) list7, (Comparator) new g())) {
                if (((WxaAttributes.WxaWidgetInfo) obj2).packageType <= 23) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    WxaAttributes.WxaWidgetInfo wxaWidgetInfo6 = (WxaAttributes.WxaWidgetInfo) obj2;
                    List<WxaAttributes.WxaPluginCodeInfo> list8 = wxaWidgetInfo6.lhk;
                    if (list8 == null || list8.isEmpty()) {
                        z5 = true;
                    }
                    if (z5) {
                        Log.e("MicroMsg.AppBrand.LaunchCheckPkgBatchGetCodeUtils", "WxaVersionInfo.pickAppropriateWidgetInfoList appId(" + str + ") module(FALSE) split_plugin(TRUE) widgetInfo.wxaPluginCodeInfo isNullOrEmpty");
                        wxaWidgetInfo6.lhk = wxaVersionInfo.lgV;
                    }
                    Map<String, WxaAttributes.WxaWidgetInfo> I4 = I(ModulePkgInfo.MAIN_MODULE_NAME, obj2);
                    AppMethodBeat.o(180604);
                    return I4;
                }
            }
            NoSuchElementException noSuchElementException2 = new NoSuchElementException("Collection contains no element matching the predicate.");
            AppMethodBeat.o(180604);
            throw noSuchElementException2;
        }
    }

    private static <K, V> Map<K, V> I(K k, V v) {
        AppMethodBeat.i(180605);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put(k, v);
        ArrayMap arrayMap2 = arrayMap;
        AppMethodBeat.o(180605);
        return arrayMap2;
    }

    public static final class a extends q implements kotlin.g.a.a<bmm[]> {
        final /* synthetic */ y.b mUI;
        final /* synthetic */ HashMap mUJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y.b bVar, HashMap hashMap) {
            super(0);
            this.mUI = bVar;
            this.mUJ = hashMap;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ bmm[] invoke() {
            AppMethodBeat.i(180588);
            bmm[] bmmArr = new bmm[3];
            this.mUJ.put(this.mUI, bmmArr);
            AppMethodBeat.o(180588);
            return bmmArr;
        }
    }

    public static final class c extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ HashMap mUK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(HashMap hashMap) {
            super(0);
            this.mUK = hashMap;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(180591);
            Set<y.b> keySet = this.mUK.keySet();
            p.g(keySet, "map.keys");
            for (y.b bVar : keySet) {
                v vVar = v.mTG;
                p.g(bVar, "key");
                v.a(bVar);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(180591);
            return xVar;
        }
    }
}
