package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.a;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fen;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class b extends a<Boolean, fen> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(String str, String str2, fen fen) {
        boolean z;
        int size;
        int i2 = -1;
        AppMethodBeat.i(44387);
        fen fen2 = fen;
        com.tencent.mm.plugin.appbrand.appcache.predownload.e.b bVar = (com.tencent.mm.plugin.appbrand.appcache.predownload.e.b) n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.class);
        if (Util.isNullOrNil(fen2.NnI) || Util.isNullOrNil(fen2.NzP)) {
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            if (fen2.NnI == null) {
                size = -1;
            } else {
                size = fen2.NnI.size();
            }
            objArr[2] = Integer.valueOf(size);
            if (fen2.NzP != null) {
                i2 = fen2.NzP.size();
            }
            objArr[3] = Integer.valueOf(i2);
            Log.e("MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage", "saveBlockList with username(%s) appId(%s) sceneList.size(%d), blockCgi.size(%d), skip", objArr);
            z = false;
        } else {
            a aVar = new a();
            aVar.field_username = str;
            boolean z2 = bVar.get(aVar, new String[0]);
            aVar.field_appId = str2;
            aVar.field_startTime = (long) fen2.NzQ;
            aVar.field_endTime = (long) fen2.NzR;
            StringBuilder sb = new StringBuilder(";");
            Iterator<Integer> it = fen2.NnI.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue()).append(";");
            }
            aVar.field_sceneList = sb.toString();
            StringBuilder sb2 = new StringBuilder(";");
            Iterator<Integer> it2 = fen2.NzP.iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next().intValue()).append(";");
            }
            aVar.field_cgiList = sb2.toString();
            aVar.field_reportId = fen2.NzO.NzL;
            Log.i("MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage", "saveBlockList, record( %s ), doUpdate %b", aVar, Boolean.valueOf(z2));
            z = z2 ? bVar.update(aVar, new String[0]) : bVar.insert(aVar);
        }
        Log.i("MicroMsg.AppBrand.Predownload.CmdBlockCgiRequest", "saveBlockList with username(%s) appId(%s), ret %b", str, str2, Boolean.valueOf(z));
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(44387);
        return valueOf;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* bridge */ /* synthetic */ fem cs(fen fen) {
        return fen.NzO;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdBlockCgiRequest";
    }
}
