package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.pluginsdk.j.a.b.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;

public enum k implements b<l, m, com.tencent.mm.pluginsdk.j.a.c.k> {
    INSTANCE;
    
    public final h<String, b.a<m, com.tencent.mm.pluginsdk.j.a.c.k>> kKy = new h<>();

    private k(String str) {
        AppMethodBeat.i(90546);
        AppMethodBeat.o(90546);
    }

    public static k valueOf(String str) {
        AppMethodBeat.i(90545);
        k kVar = (k) Enum.valueOf(k.class, str);
        AppMethodBeat.o(90545);
        return kVar;
    }

    static {
        AppMethodBeat.i(90548);
        AppMethodBeat.o(90548);
    }

    public final void a(l lVar, m mVar) {
        b.a.EnumC0543a aVar;
        b.a.EnumC0543a aVar2;
        AppMethodBeat.i(90547);
        if (mVar.status != 2) {
            Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", mVar);
            if (!(mVar.Kab instanceof a)) {
                switch (mVar.httpStatusCode) {
                    case 403:
                    case 404:
                        aVar = b.a.EnumC0543a.SEVER_FILE_NOT_FOUND;
                        break;
                    default:
                        aVar = b.a.EnumC0543a.FAILED;
                        break;
                }
            } else {
                aVar = b.a.EnumC0543a.DISK_FULL;
            }
        } else {
            an buc = ((e) g.af(e.class)).buc();
            if (buc == null) {
                Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
                aVar2 = b.a.EnumC0543a.ENV_ERR;
            } else {
                am z = buc.z(lVar.appId, lVar.kKA, lVar.version);
                if (z == null) {
                    Log.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", lVar.toShortString());
                    aVar2 = b.a.EnumC0543a.ENV_ERR;
                } else {
                    z.field_pkgPath = lVar.getFilePath();
                    boolean a2 = an.a(z);
                    Log.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", Boolean.valueOf(a2), lVar.toShortString());
                    if (a2) {
                        buc.update(z, new String[0]);
                        aVar2 = b.a.EnumC0543a.OK;
                    } else {
                        aVar2 = b.a.EnumC0543a.PKG_INTEGRITY_FAILED;
                    }
                }
            }
            aVar = aVar2;
        }
        Set<b.a<m, com.tencent.mm.pluginsdk.j.a.c.k>> cN = this.kKy.cN(lVar.JYs);
        if (cN != null) {
            for (b.a<m, com.tencent.mm.pluginsdk.j.a.c.k> aVar3 : cN) {
                aVar3.a(lVar.appId, aVar, mVar);
            }
        }
        AppMethodBeat.o(90547);
    }
}
