package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.g.b.a.mu;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify;
import com.tencent.mm.plugin.appbrand.launching.as;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.launching.ax;
import com.tencent.mm.plugin.appbrand.launching.ay;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fdo;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class c extends com.tencent.mm.ak.c<fdp> {
    final String appId;
    final String cym;
    final int iOo;
    public volatile boolean mWd = false;
    private final ay mXR;
    private final mu mXS;
    public volatile HashMap<String, AppRuntimeApiPermissionBundle> mXT = new HashMap<>();
    final d rr;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, fdp fdp, q qVar) {
        String str2;
        boolean insert;
        AppMethodBeat.i(227131);
        fdp fdp2 = fdp;
        try {
            long nowMilliSecond = Util.nowMilliSecond();
            this.mXS.xa(nowMilliSecond);
            this.mXS.wX(nowMilliSecond - this.mXS.fad);
            if (a.a(i2, i3, fdp2)) {
                this.mXS.feB = 0;
            } else {
                this.mXS.feB = 1;
            }
            this.mXS.bfK();
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.CgiWxaJsApiInfo", "quality report e = %s", e2);
        }
        boolean z = ((fdo) super.rr.iLK.iLR).KOF.LmF;
        if (fdp2 == null) {
            str2 = "NULL";
        } else if (fdp2.Nzk == null) {
            str2 = "NULL_API_INFO_LIST";
        } else {
            str2 = "API_INFO_LIST SIZE:" + fdp2.Nzk.size();
        }
        Log.i("MicroMsg.AppBrand.CgiWxaJsApiInfo", "onCgiBack, errType %d, errCode %d, errMsg %s, req[sync %B], resp[%s], isForPreRender[%b]", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.mWd), str2, Boolean.valueOf(z));
        if (i2 == 0 && i3 == 0 && fdp2 != null && fdp2.Nzk != null) {
            try {
                Iterator<fdr> it = fdp2.Nzk.iterator();
                while (it.hasNext()) {
                    fdr next = it.next();
                    if (next.dIZ == 0) {
                        String str3 = next.Nzl.dNI;
                        if (next.Nzl.qGD == 2) {
                            at buF = n.buF();
                            byte[] byteArray = next.Nzm.toByteArray();
                            if (Util.isNullOrNil(str3) || Util.isNullOrNil(byteArray)) {
                                Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "setWxaJsApiPluginInfoData,invalid input %s", str3);
                            } else {
                                as asVar = new as();
                                asVar.field_appId = str3;
                                boolean z2 = buF.get(asVar, new String[0]);
                                asVar.field_permissionProtoBlob = byteArray;
                                if (z2) {
                                    insert = buF.update(asVar, new String[0]);
                                } else {
                                    insert = buF.insert(asVar);
                                }
                                if (insert) {
                                    Log.i("MicroMsg.LaunchWxaJsApiPluginInfoStorage", "setWxaJsApiPluginInfoData appId:%s ok", str3);
                                }
                            }
                            this.mXT.put(str3, new AppRuntimeApiPermissionBundle(next.Nzm));
                            Log.i("MicroMsg.AppBrand.CgiWxaJsApiInfo", "wxaJs plugin AppId:%s,jsApiControlBytes:%d,bg:%d,suspend:%d", str3, Integer.valueOf(next.Nzm.LjS.zy.length), Integer.valueOf(next.Nzm.LjT.get(0).zy.length), Integer.valueOf(next.Nzm.LjT.get(1).zy.length));
                        }
                    }
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.AppBrand.CgiWxaJsApiInfo", e3, "IOException", new Object[0]);
            }
            if (!this.mWd) {
                ILaunchWxaAppInfoNotify.mUz.a(this.appId, this.iOo, this.cym, this.mXT);
                AppMethodBeat.o(227131);
                return;
            }
        } else if (this.mWd && !z) {
            ax.a(ax.getMMString(R.string.ph, String.format(Locale.US, " (%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3))), this.mXR);
        }
        AppMethodBeat.o(227131);
    }

    public c(String str, int i2, List<e> list, boolean z, String str2, QualitySession qualitySession, ay ayVar, acc acc) {
        mu.b bVar;
        AppMethodBeat.i(227128);
        this.appId = str;
        this.iOo = i2;
        this.cym = str2;
        this.mXR = ayVar;
        this.mXS = g.f(qualitySession);
        mu muVar = this.mXS;
        if (z) {
            bVar = mu.b.sync;
        } else {
            bVar = mu.b.async;
        }
        muVar.feC = bVar;
        this.mXS.eJb = (long) g.getNetworkType();
        fdo fdo = new fdo();
        for (e eVar : list) {
            fdq fdq = new fdq();
            fdq.dNI = eVar.appId;
            fdq.qGD = eVar.appType;
            fdo.Nzk.add(fdq);
        }
        fdo.KOF = (acc) Objects.requireNonNull(acc);
        d.a aVar = new d.a();
        aVar.funcId = 3827;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
        aVar.iLN = fdo;
        aVar.iLO = new fdp();
        d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        Log.i("MicroMsg.AppBrand.CgiWxaJsApiInfo", "<init> appId:%s, versionType:%d, appIdList:%s, sync:%b, sessionId:%s, instanceId:%s, source:%s", str, Integer.valueOf(i2), bN(list), Boolean.valueOf(z), str2, qualitySession.kEY, com.tencent.mm.ah.a.a(acc));
        AppMethodBeat.o(227128);
    }

    private static String bN(List<e> list) {
        AppMethodBeat.i(227129);
        StringBuilder sb = new StringBuilder("[");
        for (e eVar : list) {
            sb.append("{appId:").append(eVar.appId).append(", appType:").append(eVar.appType).append("}");
        }
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(227129);
        return sb2;
    }

    @Override // com.tencent.mm.ak.c
    public final synchronized f<c.a<fdp>> aYI() {
        f<c.a<fdp>> aYI;
        AppMethodBeat.i(227130);
        this.mXS.wZ(Util.nowMilliSecond());
        aYI = super.aYI();
        AppMethodBeat.o(227130);
        return aYI;
    }
}
