package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public final class b implements Callable<WxaPkgWrappingInfo> {
    public static int loI = 0;
    public static int loJ = 1;
    final String appId;
    final int dMe;
    String hes;
    final String id;
    int loG;
    volatile String loK;
    String loL;
    volatile int pkgVersion;

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ WxaPkgWrappingInfo call() {
        AppMethodBeat.i(121404);
        WxaPkgWrappingInfo bCi = bCi();
        AppMethodBeat.o(121404);
        return bCi;
    }

    public b(String str, String str2, String str3, int i2, int i3, int i4, String str4) {
        this(str, str2, str3, i2, i3, i4, str4, "");
    }

    public b(String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5) {
        this.id = str;
        this.appId = str2;
        this.dMe = i2;
        this.pkgVersion = i3;
        this.loK = str4;
        this.loG = i4;
        this.hes = str3;
        this.loL = str5;
    }

    public final WxaPkgWrappingInfo bCi() {
        int[] Vs;
        String str;
        int i2;
        byz byz;
        int i3 = 1;
        AppMethodBeat.i(121401);
        Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> D = WxaPkgIntegrityChecker.D(this.appId, this.dMe, this.pkgVersion);
        if (D.second != null) {
            j.bBN().bG(this.appId, 29);
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) D.second;
            AppMethodBeat.o(121401);
            return wxaPkgWrappingInfo;
        }
        j.bBN().bG(this.appId, 3);
        if (WxaPkgIntegrityChecker.a.APP_BROKEN.equals(D.first)) {
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkg broken appid %s, pkgType %d, pkgVersion %d", this.appId, Integer.valueOf(this.dMe), Integer.valueOf(this.pkgVersion));
            if (this.dMe == 10002 || this.dMe == 10102) {
                bd a2 = ((e) g.af(e.class)).bub().a(this.appId, this.dMe, "version", "versionMd5");
                if (a2 == null) {
                    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecord is null", new Object[0]);
                    a((WxaPkgIntegrityChecker.a) D.first);
                    AppMethodBeat.o(121401);
                    return null;
                }
                if (this.dMe == 10102) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                v.pl(4);
                hr vt = new hr().vt(this.appId);
                vt.eBS = (long) u.Lt(this.id);
                vt.eMi = 13;
                hr vs = vt.vs(this.id);
                vs.eMj = System.currentTimeMillis();
                vs.eMk = 2;
                vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                if (!TextUtils.isEmpty(this.loL)) {
                    byz = new byz();
                    byz.parseFrom(Base64.decode(this.loL, 0));
                    if (TextUtils.isEmpty(byz.url)) {
                        byz = null;
                    } else {
                        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "use preload download data", new Object[0]);
                    }
                } else {
                    byz = null;
                }
                if (byz == null) {
                    c.a a3 = ab.a(((a) com.tencent.luggage.a.e.M(a.class)).a(this.appId, a2.field_version, a2.field_versionMd5, i2));
                    if (a3 != null && a3.errType == 0 && a3.errCode == 0) {
                        byz = (byz) a3.iLC;
                    } else {
                        v.pl(6);
                        hr vt2 = new hr().vt(this.appId);
                        vt2.eBS = (long) u.Lt(this.id);
                        vt2.eMi = 3;
                        hr vs2 = vt2.vs(this.id);
                        vs2.eMj = System.currentTimeMillis();
                        vs2.eMk = 2;
                        vs2.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                        if (this.loG == 1 && this.id != null && this.id.length() > 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString("id", this.id);
                            bundle.putInt("widgetState", 2105);
                            h.a(i.bBL().Yn(this.id), bundle, f.a.class, null);
                        }
                        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail", new Object[0]);
                        AppMethodBeat.o(121401);
                        return null;
                    }
                }
                if (byz == null) {
                    AppMethodBeat.o(121401);
                    return null;
                }
                hr vt3 = new hr().vt(u.Lv(this.id));
                vt3.eBS = (long) u.Lt(this.id);
                vt3.eMi = 3;
                hr vs3 = vt3.vs(this.id);
                vs3.eMj = System.currentTimeMillis();
                vs3.eMk = 1;
                vs3.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                String str2 = byz.Mep;
                v.pl(5);
                u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget downlonad info succ", new Object[0]);
                if (Util.isNullOrNil(byz.url)) {
                    u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "get widget download url fail, reason url empty", new Object[0]);
                    AppMethodBeat.o(121401);
                    return null;
                }
                fcs fcs = new fcs();
                String str3 = byz.url;
                this.loK = str3;
                fcs.NyF = str3;
                int i4 = a2.field_version;
                this.pkgVersion = i4;
                fcs.KSa = i4;
                fcs.NyE = a2.field_versionMd5;
                ((e) g.af(e.class)).bub().a(this.appId, fcs, this.dMe);
                str = str2;
            } else {
                str = null;
            }
            WxaPkgWrappingInfo YB = YB(str);
            if (YB != null) {
                if (this.loG == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14452, this.hes + "-" + this.appId, 7, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.o(121401);
                return YB;
            } else if (this.loG == 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14452, this.hes + "-" + this.appId, 8, Long.valueOf(System.currentTimeMillis()));
            }
        } else if (!WxaPkgIntegrityChecker.a.APP_READY.equals(D.first)) {
            Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "WxaPkgIntegrityChecker.checkPkg  appid %s, pkgType %d,pkgVersion %d return %d", this.appId, Integer.valueOf(this.dMe), Integer.valueOf(this.pkgVersion), Integer.valueOf(((WxaPkgIntegrityChecker.a) D.first).bwv()));
        }
        if ((this.dMe == 10002 || this.dMe == 10102) && (Vs = ((e) g.af(e.class)).bub().Vs(this.appId)) != null && Vs.length > 1) {
            while (true) {
                int i5 = i3 + 1;
                Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> D2 = WxaPkgIntegrityChecker.D(this.appId, this.dMe, Vs[i3]);
                if (D2 != null && D2.first == WxaPkgIntegrityChecker.a.APP_READY && D2.second != null) {
                    WxaPkgWrappingInfo wxaPkgWrappingInfo2 = (WxaPkgWrappingInfo) D2.second;
                    AppMethodBeat.o(121401);
                    return wxaPkgWrappingInfo2;
                } else if (i5 >= Vs.length) {
                    break;
                } else {
                    i3 = i5;
                }
            }
        }
        a((WxaPkgIntegrityChecker.a) D.first);
        AppMethodBeat.o(121401);
        return null;
    }

    private WxaPkgWrappingInfo YB(String str) {
        boolean c2;
        AppMethodBeat.i(121402);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final com.tencent.mm.plugin.appbrand.ac.i iVar = new com.tencent.mm.plugin.appbrand.ac.i();
        AnonymousClass1 r4 = new bj.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.launching.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
            public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                AppMethodBeat.i(121400);
                bj.b bVar2 = bVar;
                u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, appId = %s, return = %s", str, aVar.name());
                if (b.a.EnumC0543a.OK.equals(aVar)) {
                    T t = (T) WxaPkgWrappingInfo.Vx(bVar2.filePath);
                    if (t == null) {
                        u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "onPkgUpdateResult, ret=OK but obtain null appPkgInfo", new Object[0]);
                    } else {
                        ((WxaPkgWrappingInfo) t).pkgVersion = bVar2.version;
                        t.kNX = Util.nowSecond();
                        t.kNW = bVar2.eix;
                        iVar.value = t;
                    }
                    v.pl(8);
                    hr vt = new hr().vt(u.Lv(b.this.id));
                    vt.eBS = (long) u.Lt(b.this.id);
                    vt.eMi = 4;
                    hr vs = vt.vs(b.this.id);
                    vs.eMj = System.currentTimeMillis();
                    vs.eMk = 1;
                    vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                } else if (b.a.EnumC0543a.SEVER_FILE_NOT_FOUND.equals(aVar)) {
                    v.pl(9);
                    hr vt2 = new hr().vt(u.Lv(b.this.id));
                    vt2.eBS = (long) u.Lt(b.this.id);
                    vt2.eMi = 4;
                    hr vs2 = vt2.vs(b.this.id);
                    vs2.eMj = System.currentTimeMillis();
                    vs2.eMk = 2;
                    vs2.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                } else {
                    v.pl(9);
                    hr vt3 = new hr().vt(u.Lv(b.this.id));
                    vt3.eBS = (long) u.Lt(b.this.id);
                    vt3.eMi = 4;
                    hr vs3 = vt3.vs(b.this.id);
                    vs3.eMj = System.currentTimeMillis();
                    vs3.eMk = 2;
                    vs3.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                }
                countDownLatch.countDown();
                AppMethodBeat.o(121400);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
            public final /* bridge */ /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
            }
        };
        v.pl(7);
        if (this.dMe == 10002 || this.dMe == 10102) {
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, debug type is release, start download appId(%s), pkgVersion(%d)", this.appId, Integer.valueOf(this.pkgVersion));
            if (!Util.isNullOrNil(str)) {
                c2 = bt.a(str, this.appId, this.pkgVersion, this.dMe, r4);
            } else {
                c2 = bj.c(this.appId, this.dMe, this.pkgVersion, this.loK, r4);
            }
            if (!c2) {
                v.pl(9);
                hr vt = new hr().vt(u.Lv(this.id));
                vt.eBS = (long) u.Lt(this.id);
                vt.eMi = 4;
                hr vs = vt.vs(this.id);
                vs.eMj = System.currentTimeMillis();
                vs.eMk = 2;
                vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                a(WxaPkgIntegrityChecker.a.ENV_ERR);
                AppMethodBeat.o(121402);
                return null;
            }
        } else {
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, appId = %s, debug type is %d", this.appId, Integer.valueOf(this.dMe));
            if (((e) g.af(e.class)).bub() == null) {
                Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, null storage");
                a(WxaPkgIntegrityChecker.a.ENV_ERR);
                AppMethodBeat.o(121402);
                return null;
            }
            String aX = ((e) g.af(e.class)).bub().aX(this.appId, this.dMe);
            if (Util.isNullOrNil(aX)) {
                u.e("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "triggerDownloading, url is null or nil", new Object[0]);
                a(WxaPkgIntegrityChecker.a.APP_MANIFEST_NULL);
                AppMethodBeat.o(121402);
                return null;
            }
            bj.a(this.appId, this.dMe, aX, r4);
        }
        try {
            countDownLatch.await();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", e2, "tryDownload semaphore exp ", new Object[0]);
        }
        T t = iVar.value;
        AppMethodBeat.o(121402);
        return t;
    }

    private static void a(WxaPkgIntegrityChecker.a aVar) {
        AppMethodBeat.i(121403);
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetPkg", "pkgRecordError %s", aVar.toString());
        if (WxaPkgIntegrityChecker.a.APP_MANIFEST_NULL.equals(aVar)) {
            AppMethodBeat.o(121403);
        } else if (WxaPkgIntegrityChecker.a.APP_NOT_INSTALLED.equals(aVar) || WxaPkgIntegrityChecker.a.PKG_EXPIRED.equals(aVar)) {
            AppMethodBeat.o(121403);
        } else {
            AppMethodBeat.o(121403);
        }
    }
}
