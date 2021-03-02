package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d implements i {
    @Override // com.tencent.mm.modelappbrand.i
    public final void a(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(121239);
        ((e) g.af(e.class)).bub().d(str, 10102, i2, str2, str3);
        AppMethodBeat.o(121239);
    }

    @Override // com.tencent.mm.modelappbrand.i
    public final boolean a(String str, int i2, String str2, final j jVar) {
        AppMethodBeat.i(121240);
        boolean c2 = bj.c(str, 10102, i2, str2, new bj.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.a.d.AnonymousClass1 */
            private long totalLen;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
            public final /* bridge */ /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                this.totalLen = wxaPkgLoadProgress.kNt;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
            public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                AppMethodBeat.i(121238);
                if (jVar != null) {
                    jVar.b(b.a.EnumC0543a.OK.equals(aVar), this.totalLen);
                }
                AppMethodBeat.o(121238);
            }
        });
        AppMethodBeat.o(121240);
        return c2;
    }

    @Override // com.tencent.mm.modelappbrand.i
    public final boolean an(String str, int i2) {
        AppMethodBeat.i(121241);
        Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> D = WxaPkgIntegrityChecker.D(str, 10102, i2);
        if (D == null || D.first != WxaPkgIntegrityChecker.a.APP_READY) {
            AppMethodBeat.o(121241);
            return false;
        }
        AppMethodBeat.o(121241);
        return true;
    }

    @Override // com.tencent.mm.modelappbrand.i
    public final List<x> aXJ() {
        ArrayList<bd> arrayList = null;
        AppMethodBeat.i(121242);
        bh bub = ((e) g.af(e.class)).bub();
        if (bub == null) {
            List<x> list = Collections.EMPTY_LIST;
            AppMethodBeat.o(121242);
            return list;
        }
        Cursor query = bub.kNJ.query("AppBrandWxaPkgManifestRecord", null, "debugType" + " = 10102", null, null, null, null, 2);
        if (query != null) {
            if (!query.moveToFirst()) {
                query.close();
            } else {
                arrayList = new ArrayList();
                do {
                    bd bdVar = new bd();
                    bdVar.convertFrom(query);
                    arrayList.add(bdVar);
                } while (query.moveToNext());
                query.close();
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            List<x> emptyList = Collections.emptyList();
            AppMethodBeat.o(121242);
            return emptyList;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (bd bdVar2 : arrayList) {
            x xVar = new x();
            xVar.dNI = bdVar2.field_appId;
            xVar.version = bdVar2.field_version;
            xVar.md5 = bdVar2.field_versionMd5;
            arrayList2.add(xVar);
        }
        AppMethodBeat.o(121242);
        return arrayList2;
    }
}
