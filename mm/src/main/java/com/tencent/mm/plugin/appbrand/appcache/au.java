package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dfy;
import com.tencent.mm.protocal.protobuf.fcg;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;

public enum au {
    ;

    public static au valueOf(String str) {
        AppMethodBeat.i(44343);
        au auVar = (au) Enum.valueOf(au.class, str);
        AppMethodBeat.o(44343);
        return auVar;
    }

    static /* synthetic */ void b(int i2, fch fch, a aVar) {
        AppMethodBeat.i(44349);
        a(i2, fch, aVar);
        AppMethodBeat.o(44349);
    }

    public static void gH(final boolean z) {
        AppMethodBeat.i(44344);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appcache.au.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44337);
                if (z) {
                    Log.i("MicroMsg.WxaCommLibVersionChecker", "cgiCheckUpdate, force true");
                    g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG, Long.valueOf(Util.nowSecond() - 1));
                }
                au.access$000();
                AppMethodBeat.o(44337);
            }
        }, "WxaCommLibVersionChecker");
        AppMethodBeat.o(44344);
    }

    private static void a(int i2, fch fch, a aVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(44345);
        switch (aVar) {
            case CGI:
                if (fch.Nyg > 0) {
                    h.INSTANCE.dN(1509, 3);
                }
                if (fch.MKJ > 0) {
                    h.INSTANCE.dN(1509, 4);
                    break;
                }
                break;
            case Launch:
                if (fch.Nyg > 0) {
                    h.INSTANCE.dN(1509, 22);
                }
                if (fch.MKJ > 0) {
                    h.INSTANCE.dN(1509, 23);
                    break;
                }
                break;
        }
        if (n.buL() != null) {
            PInt pInt = new PInt();
            n.buL().a(fch, pInt);
            if (pInt.value > 0) {
                z = true;
            } else {
                z = false;
            }
            int aY = n.buL().aY("@LibraryAppId", 0);
            if (WxaPkgIntegrityChecker.r(true, true).first == WxaPkgIntegrityChecker.a.APP_BROKEN) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                switch (aVar) {
                    case CGI:
                        h.INSTANCE.dN(1509, 5);
                        h.INSTANCE.dN(1509, z2 ? 7 : 6);
                        break;
                    case Launch:
                        h.INSTANCE.dN(1509, 24);
                        h.INSTANCE.dN(1509, z2 ? 26 : 25);
                        break;
                }
            }
            Log.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, scene %s, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s, localMaxVersion = %d", Integer.valueOf(i2), aVar.name(), Boolean.valueOf(z2), Integer.valueOf(fch.version), Integer.valueOf(fch.MKJ), fch.md5, fch.url, Integer.valueOf(aY));
            if (z2) {
                if (i2 <= 0 || Util.isNullOrNil(fch.dPS)) {
                    y.INSTANCE.W(-1, null);
                } else {
                    y.INSTANCE.W(i2, fch.dPS);
                }
                y.INSTANCE.gB(true);
                af afVar = new af();
                afVar.field_key = "@LibraryAppId";
                afVar.field_version = fch.version;
                if (!n.buQ().get(afVar, "key", "version")) {
                    afVar.field_updateTime = Util.nowSecond();
                    afVar.field_scene = aVar.ordinal() + 1;
                    n.buQ().insert(afVar);
                }
            }
            if (fch.MKJ > 0 && pInt.value > 0) {
                as.bvR();
            }
            AppMethodBeat.o(44345);
            return;
        }
        Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
        AppMethodBeat.o(44345);
    }

    public static void a(int i2, dfy dfy) {
        AppMethodBeat.i(44346);
        if (dfy != null) {
            h.INSTANCE.dN(1509, 21);
            fch fch = new fch();
            fch.url = dfy.url;
            fch.md5 = dfy.md5;
            fch.version = dfy.version;
            fch.MKJ = dfy.MKJ;
            fch.Nyg = dfy.LXH ? 1 : 0;
            fch.dPS = dfy.dPS;
            a(i2, fch, a.Launch);
        }
        AppMethodBeat.o(44346);
    }

    public static void a(fch fch) {
        AppMethodBeat.i(44347);
        a(-1, fch, a.NewXml);
        AppMethodBeat.o(44347);
    }

    public enum a {
        CGI,
        NewXml,
        Launch;

        public static a valueOf(String str) {
            AppMethodBeat.i(44340);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44340);
            return aVar;
        }

        static {
            AppMethodBeat.i(44341);
            AppMethodBeat.o(44341);
        }
    }

    static /* synthetic */ boolean access$000() {
        int i2;
        AppMethodBeat.i(44348);
        if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
            Log.e("MicroMsg.WxaCommLibVersionChecker", "check MMCore null, skip");
            AppMethodBeat.o(44348);
            return false;
        }
        Long l = (Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG, (Object) 0L);
        long nowSecond = Util.nowSecond();
        Log.i("MicroMsg.WxaCommLibVersionChecker", "check, nextSec = %d, nowSec = %d", l, Long.valueOf(nowSecond));
        if (nowSecond < l.longValue()) {
            AppMethodBeat.o(44348);
            return false;
        }
        d.a aVar = new d.a();
        fcg fcg = new fcg();
        if (n.buL() == null) {
            i2 = ay.VERSION;
        } else {
            bd a2 = n.buL().a("@LibraryAppId", 0, "version");
            if (a2 == null) {
                i2 = ay.VERSION;
            } else {
                i2 = a2.field_version;
            }
        }
        fcg.version = i2;
        aVar.iLN = fcg;
        aVar.iLO = new fch();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getpubliclibinfo";
        aVar.funcId = 1168;
        h.INSTANCE.dN(1509, 0);
        aa.a(aVar.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.appbrand.appcache.au.AnonymousClass2 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(44338);
                h.INSTANCE.idkeyStat(368, 40, 1, false);
                if (g.aAc()) {
                    g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_PUBLIC_LIB_UPDATE_NEXT_TIME_SEC_LONG, Long.valueOf(86400 + Util.nowSecond()));
                }
                if (i2 == 0 && i3 == 0) {
                    h.INSTANCE.dN(1509, 1);
                    try {
                        au.b(((fcg) dVar.iLK.iLR).version, (fch) dVar.iLL.iLR, a.CGI);
                    } catch (RuntimeException e2) {
                        Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, e %s", e2);
                    }
                    AppMethodBeat.o(44338);
                    return 0;
                }
                Log.e("MicroMsg.WxaCommLibVersionChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                h.INSTANCE.dN(1509, 2);
                AppMethodBeat.o(44338);
                return 0;
            }
        }, true);
        AppMethodBeat.o(44348);
        return true;
    }
}
