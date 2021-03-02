package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.b.a.mt;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.launching.d.e;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001:\u0001\u0017B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "enterPath", "", "userName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "cgiBack", "getEnterPath", "getUserName", "getPreFetchResult", "timeoutMs", "", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class f extends a<c.a<ddz>> {
    public static final a mYH = new a((byte) 0);
    private final String appId;
    private final String kHw;
    private c.a<ddz> mYG;
    private final String userName;

    static {
        AppMethodBeat.i(50812);
        AppMethodBeat.o(50812);
    }

    @Override // com.tencent.luggage.sdk.e.a
    public final /* synthetic */ Object hS(int i2) {
        AppMethodBeat.i(175196);
        c.a<ddz> yn = yn(i2);
        AppMethodBeat.o(175196);
        return yn;
    }

    public f(String str, String str2, String str3) {
        this.kHw = str;
        this.userName = str2;
        this.appId = str3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.luggage.sdk.e.a
    public final int OY() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.d.a
    public final void b(QualitySession qualitySession) {
        AppMethodBeat.i(228753);
        p.h(qualitySession, "qualitySession");
        if (this.mYG == null) {
            AppMethodBeat.o(228753);
            return;
        }
        long j2 = this.cCt - this.cCs;
        mt mtVar = new mt();
        mtVar.zY(qualitySession.kEY);
        String appId2 = mtVar.getAppId();
        if (appId2 == null) {
            appId2 = "";
        }
        mtVar.zZ(appId2);
        mtVar.wN((long) qualitySession.nLk);
        mtVar.a(mt.a.mE(qualitySession.nJE));
        mtVar.wO((long) qualitySession.apptype);
        mtVar.wP(j2);
        mtVar.wQ((long) qualitySession.scene);
        mtVar.wR(mtVar.aiV());
        mtVar.wS(mtVar.aiW());
        mtVar.a(com.tencent.mm.plugin.appbrand.r.a.d(this.mYG) ? mt.b.ok : mt.b.common_fail);
        mtVar.wT((long) g.getNetworkType());
        mtVar.Aa(this.userName);
        mtVar.ajk();
        mtVar.wU(this.cCu ? 1 : 0);
        mtVar.bfK();
        AppMethodBeat.o(228753);
    }

    public final c.a<ddz> yn(int i2) {
        AppMethodBeat.i(180640);
        c.a<ddz> aVar = (c.a) super.hS(i2);
        if (aVar != null) {
            b.pl(7);
        }
        AppMethodBeat.o(180640);
        return aVar;
    }

    @Override // com.tencent.luggage.sdk.e.a
    public final /* synthetic */ Object OX() {
        int i2;
        WxaPkgWrappingInfo abZ;
        int i3 = -1;
        boolean z = false;
        AppMethodBeat.i(50810);
        b.pl(4);
        Log.i("MicroMsg.AppBrand.PreFetchGetDownloadInfoTask", "preFetch: pkg download info, appId[" + this.appId + "] username[" + this.userName + "] enterPath[" + this.kHw + ']');
        this.cCs = Util.nowMilliSecond();
        b bVar = (b) n.W(b.class);
        String VH = bVar != null ? bVar.VH(this.userName) : null;
        if (Util.isNullOrNil(VH) || (abZ = m.abZ(VH)) == null) {
            i2 = 0;
        } else {
            i2 = abZ.pkgVersion;
        }
        Log.i("MicroMsg.AppBrand.PreFetchGetDownloadInfoTask", "preFetch: appId[" + this.appId + "] username[" + this.userName + "], localPkgVer=" + i2);
        e.a aVar = e.mYF;
        String str = this.appId;
        if (str == null) {
            str = "";
        }
        String str2 = this.kHw;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.userName;
        if (str3 == null) {
            str3 = "";
        }
        boolean bvG = v.bvG();
        p.h(str, "appId");
        p.h(str2, "path");
        ddy ddy = new ddy();
        ddy.dNI = str;
        ddy.Meg = i2;
        ddy.path = str2;
        ddy.MIZ = bvG;
        ddy.username = str3;
        ddy.LVh = 0;
        this.mYG = new e(ddy).bNV();
        this.cCt = Util.nowMilliSecond();
        StringBuilder append = new StringBuilder("preFetch: appId[").append(this.appId).append("] username[").append(this.userName).append("] cost[").append(this.cCt - this.cCs).append(" ms] ret is?=[");
        if (this.mYG == null) {
            z = true;
        }
        StringBuilder append2 = append.append(z).append("], errCode=[");
        c.a<ddz> aVar2 = this.mYG;
        StringBuilder append3 = append2.append(aVar2 != null ? aVar2.errCode : -1).append("], errType=[");
        c.a<ddz> aVar3 = this.mYG;
        if (aVar3 != null) {
            i3 = aVar3.errType;
        }
        Log.i("MicroMsg.AppBrand.PreFetchGetDownloadInfoTask", append3.append(i3).append(']').toString());
        c.a<ddz> aVar4 = this.mYG;
        AppMethodBeat.o(50810);
        return aVar4;
    }
}
