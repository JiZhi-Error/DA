package com.tencent.mm.plugin.appbrand.appcache.predownload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.c;
import com.tencent.mm.pluginsdk.j.a.c.k;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class a implements com.tencent.mm.vending.c.a<Boolean, c> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ Boolean call(c cVar) {
        AppMethodBeat.i(44386);
        c cVar2 = cVar;
        String str = cVar2.field_appId;
        int i2 = cVar2.field_version;
        String str2 = cVar2.field_pkgMd5;
        new ad(str, "");
        final boolean z = cVar2.field_retriedCount > 0;
        final int i3 = cVar2.field_reportId;
        final b hdx = g.hdx();
        hdx.hdw();
        byy byy = new byy();
        byy.dNI = str;
        byy.KXD = i2;
        byy.MbZ = 0;
        byy.Mef = str2;
        if (!Util.isNullOrNil("")) {
            byy.MbW = "";
            byy.MbZ = 4;
        } else {
            byy.MbZ = 0;
        }
        byy.Mei = new cyd();
        byy.Mei.MDc = 0;
        byy.Mei.MDd = 1;
        int i4 = z ? 51 : 46;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i3, (long) i4);
        new h(byy).aYI().j(new com.tencent.mm.vending.c.a<com.tencent.mm.vending.j.c<byy, byz>, c.a<byz>>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.predownload.a.a.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ com.tencent.mm.vending.j.c<byy, byz> call(c.a<byz> aVar) {
                AppMethodBeat.i(44383);
                c.a<byz> aVar2 = aVar;
                if (!com.tencent.mm.plugin.appbrand.r.a.d(aVar2)) {
                    hdx.G(Boolean.FALSE);
                    g.hdx().ej(Boolean.FALSE);
                    int i2 = z ? 50 : 49;
                    com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                    com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i3, (long) i2);
                    AppMethodBeat.o(44383);
                    return null;
                }
                d dVar = (d) aVar2.dGJ.getReqResp();
                com.tencent.mm.vending.j.c Q = com.tencent.mm.vending.j.a.Q((byy) dVar.iLK.iLR, (byz) dVar.iLL.iLR);
                AppMethodBeat.o(44383);
                return Q;
            }
        }).g(new C0547a()).g(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.predownload.a.a.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Boolean bool) {
                int i2;
                AppMethodBeat.i(44382);
                Boolean bool2 = bool;
                if (bool2.booleanValue()) {
                    i2 = z ? 52 : 47;
                } else {
                    i2 = z ? 53 : 48;
                }
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i3, (long) i2);
                hdx.G(bool2);
                Void r0 = QZL;
                AppMethodBeat.o(44382);
                return r0;
            }
        });
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.o(44386);
        return bool;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.a.a$a  reason: collision with other inner class name */
    static class C0547a implements com.tencent.mm.vending.c.a<Boolean, com.tencent.mm.vending.j.c<byy, byz>> {
        C0547a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Boolean call(com.tencent.mm.vending.j.c<byy, byz> cVar) {
            ad adVar;
            AppMethodBeat.i(44385);
            com.tencent.mm.vending.j.c<byy, byz> cVar2 = cVar;
            byy byy = (byy) cVar2.get(0);
            byz byz = (byz) cVar2.get(1);
            if (byy.type == 0) {
                adVar = new ad(byy.dNI);
            } else if (byy.type == 4) {
                adVar = new ad(byy.dNI, byy.MbW);
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("not support request.type %d", Integer.valueOf(byy.type)));
                AppMethodBeat.o(44385);
                throw illegalArgumentException;
            }
            final b hdx = g.hdx();
            hdx.hdw();
            AnonymousClass1 r4 = new b.a<m, k>() {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.a.a.C0547a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                public final /* bridge */ /* synthetic */ void cr(k kVar) {
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, m mVar) {
                    AppMethodBeat.i(44384);
                    com.tencent.mm.vending.g.b bVar = hdx;
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(aVar == b.a.EnumC0543a.OK);
                    bVar.G(objArr);
                    Log.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s onPkgUpdateResult, ret %s", str, aVar.name());
                    AppMethodBeat.o(44384);
                }
            };
            Log.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s downloadPkg, patch_url(%s), full_url(%s)", adVar.toString(), byz.dPS, byz.url);
            l lVar = new l(adVar.toString(), byy.Mei.MDd, byy.KXD, byz.url);
            com.tencent.mm.plugin.appbrand.appcache.k kVar = com.tencent.mm.plugin.appbrand.appcache.k.INSTANCE;
            bj bwA = bj.bwA();
            if (bwA != null) {
                int c2 = bwA.kNU.c(lVar);
                Log.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, addRequest(%s) ret = %d", lVar.toShortString(), Integer.valueOf(c2));
                switch (c2) {
                    case 4:
                        r4.a(lVar.appId, b.a.EnumC0543a.ENV_ERR, null);
                        break;
                    default:
                        kVar.kKy.r(lVar.JYs, r4);
                        break;
                }
            } else {
                Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, null updater");
                r4.a(lVar.appId, b.a.EnumC0543a.ENV_ERR, null);
            }
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(44385);
            return bool;
        }
    }
}
