package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.g;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.h;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fev;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i extends a<Boolean, fev> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(String str, String str2, fev fev) {
        boolean update;
        int i2;
        AppMethodBeat.i(44403);
        fev fev2 = fev;
        h hVar = (h) n.W(h.class);
        int i3 = fev2.NAj;
        int i4 = fev2.NzO.NzL;
        if (Util.isNullOrNil(str)) {
            update = false;
        } else {
            g gVar = new g();
            gVar.field_username = str;
            boolean z = hVar.get(gVar, new String[0]);
            gVar.field_appVersion = i3;
            gVar.field_reportId = i4;
            update = z ? hVar.update(gVar, new String[0]) : hVar.insert(gVar);
        }
        Log.i("MicroMsg.AppBrand.Predownload.CmdUpdateVersion", "call, username %s, version %d, reportId %d, update %b", str, Integer.valueOf(fev2.NAj), Integer.valueOf(fev2.NzO.NzL), Boolean.valueOf(update));
        a aVar = a.INSTANCE;
        int i5 = fev2.NzO.NzL;
        if (update) {
            i2 = 155;
        } else {
            i2 = 156;
        }
        a.F((long) i5, (long) i2);
        Boolean valueOf = Boolean.valueOf(update);
        AppMethodBeat.o(44403);
        return valueOf;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* bridge */ /* synthetic */ fem cs(fev fev) {
        return fev.NzO;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdUpdateVersion";
    }
}
