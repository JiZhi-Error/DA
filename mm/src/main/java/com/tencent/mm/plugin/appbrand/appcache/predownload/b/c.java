package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.d;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class c extends a<Boolean, fep> {
    private final boolean kPG;
    private final int scene;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* synthetic */ Boolean c(String str, String str2, fep fep) {
        com.tencent.mm.plugin.appbrand.appcache.predownload.e.c cVar;
        boolean z;
        AppMethodBeat.i(44388);
        fep fep2 = fep;
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode nil appId");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(44388);
            return bool;
        } else if (Util.isNullOrNil(fep2.Md5)) {
            Log.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode(%s | %s), nil md5", str, str2);
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(44388);
            return bool2;
        } else {
            WxaPkgWrappingInfo bS = m.bS(new ad(str2, fep2.NAc, fep2.NAd).toString(), 0);
            if (bS != null && bS.pkgVersion >= fep2.KSa) {
                Log.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call, localUsage(%d) ok, cmd_appId(%s), cmd_version(%d)", Integer.valueOf(bS.pkgVersion), str2, Integer.valueOf(fep2.KSa));
                a aVar = a.INSTANCE;
                a.F((long) fep2.NzO.NzL, 44);
                Boolean bool3 = Boolean.FALSE;
                AppMethodBeat.o(44388);
                return bool3;
            } else if (!fep2.NAb || ((an) n.W(an.class)).A(str2, 1, fep2.KSa) == null) {
                d dVar = (d) n.W(d.class);
                boolean z2 = this.kPG;
                int i2 = this.scene;
                long j2 = ((long) fep2.NzO.NzK) & Util.MAX_32BIT_VALUE;
                if (Util.isNullOrNil(str2) || fep2 == null) {
                    cVar = null;
                } else {
                    com.tencent.mm.plugin.appbrand.appcache.predownload.e.c cVar2 = new com.tencent.mm.plugin.appbrand.appcache.predownload.e.c();
                    cVar2.field_appId = str2;
                    cVar2.field_version = fep2.KSa;
                    cVar2.field_type = fep2.NAb ? 1 : 0;
                    cVar2.field_packageKey = Util.nullAsNil(fep2.NAc);
                    cVar2.field_packageType = fep2.NAd;
                    boolean z3 = dVar.get(cVar2, new String[0]);
                    cVar2.field_firstTimeTried = false;
                    cVar2.field_lastRetryTime = 0;
                    cVar2.field_retriedCount = 0;
                    cVar2.field_retryTimes = fep2.MSo;
                    cVar2.field_retryInterval = (long) fep2.MSq;
                    cVar2.field_networkType = fep2.NAa;
                    cVar2.field_pkgMd5 = fep2.Md5;
                    cVar2.field_reportId = fep2.NzO.NzL;
                    cVar2.field_splitDownloadURLCgi = z2;
                    cVar2.field_scene = i2;
                    cVar2.field_cmdSequence = j2;
                    cVar = z3 ? dVar.update(cVar2, new String[0]) : dVar.insert(cVar2) ? cVar2 : null;
                }
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(cVar != null);
                Log.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode, writeCmd %b", objArr);
                ((b) n.W(b.class)).cy(str2, str);
                if (cVar != null) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(44388);
                return valueOf;
            } else {
                Log.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call IsEncrypt=true, encryptPkg ok, cmd_appId(%s), cmd_version(%d)", str2, Integer.valueOf(fep2.KSa));
                a aVar2 = a.INSTANCE;
                a.F((long) fep2.NzO.NzL, 45);
                Boolean bool4 = Boolean.FALSE;
                AppMethodBeat.o(44388);
                return bool4;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final /* bridge */ /* synthetic */ fem cs(fep fep) {
        return fep.NzO;
    }

    public c(boolean z, int i2) {
        this.kPG = z;
        this.scene = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.appcache.predownload.b.a
    public final String bwQ() {
        return "CmdGetCode";
    }
}
