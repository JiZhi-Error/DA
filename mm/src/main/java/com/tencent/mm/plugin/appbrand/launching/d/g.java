package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.b.a.mv;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.a.d;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.launching.bb;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fdx;
import com.tencent.mm.protocal.protobuf.fec;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.FutureTask;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001:\u00011B[\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0018\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u000e\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandBasePreFetchTaskWC;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "userName", "", "versionType", "", "enterScene", "enterPath", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "referrer", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "appId", "appbrandPushMsgId", "openMaterialMimeType", "(Ljava/lang/String;IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppbrandPushMsgId", "cgiBack", "getEnterPath", "getEnterScene", "()I", "isBackground", "", "isBackground$annotations", "()V", "isSync", "()Z", "setSync", "(Z)V", "getReferrer", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchReferrer;", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getUserName", "getVersionType", "getPreFetchResult", "timeoutMs", "key", "preFetch", "report", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "setIsUsed", "used", "Companion", "plugin-appbrand-integration_release"})
public final class g extends a<c.a<che>> {
    public static final a mYJ = new a((byte) 0);
    private final String appId;
    private final AppBrandLaunchReferrer cys;
    private final int enterScene;
    private final int iOo;
    private final AppBrandStatObject kEH;
    private final String kHw;
    public boolean kqC;
    private boolean lYx;
    private final String lek;
    private c.a<che> mYG;
    private final String mYI;
    private final String userName;

    static {
        AppMethodBeat.i(50815);
        AppMethodBeat.o(50815);
    }

    @Override // com.tencent.luggage.sdk.e.a
    public final /* synthetic */ Object hS(int i2) {
        AppMethodBeat.i(175198);
        c.a<che> yn = yn(i2);
        AppMethodBeat.o(175198);
        return yn;
    }

    public g(String str, int i2, int i3, String str2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, String str4, String str5) {
        this.userName = str;
        this.iOo = i2;
        this.enterScene = i3;
        this.kHw = str2;
        this.kEH = appBrandStatObject;
        this.cys = appBrandLaunchReferrer;
        this.appId = str3;
        this.lek = str4;
        this.mYI = str5;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.luggage.sdk.e.a
    public final int OY() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.d.a
    public final void b(QualitySession qualitySession) {
        mv.b bVar;
        AppMethodBeat.i(228754);
        p.h(qualitySession, "qualitySession");
        if (this.mYG == null) {
            AppMethodBeat.o(228754);
            return;
        }
        mv e2 = com.tencent.mm.plugin.appbrand.report.quality.g.e(qualitySession);
        String str = this.appId;
        if (str == null) {
            str = "";
        }
        e2.Ae(str);
        e2.Af(this.userName);
        e2.ajl();
        e2.xh((long) com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType());
        if (this.kqC) {
            bVar = mv.b.sync;
        } else {
            bVar = mv.b.async;
        }
        e2.a(bVar);
        e2.xf(this.cCs);
        e2.xg(this.cCt);
        e2.xd(this.cCt - this.cCs);
        e2.xi(this.lYx ? 1 : 0);
        c.a<che> aVar = this.mYG;
        if (aVar == null) {
            p.hyc();
        }
        int i2 = aVar.errType;
        c.a<che> aVar2 = this.mYG;
        if (aVar2 == null) {
            p.hyc();
        }
        int i3 = aVar2.errCode;
        c.a<che> aVar3 = this.mYG;
        if (aVar3 == null) {
            p.hyc();
        }
        if (com.tencent.mm.plugin.appbrand.r.a.a(i2, i3, aVar3.iLC)) {
            c.a<che> aVar4 = this.mYG;
            if (aVar4 == null) {
                p.hyc();
            }
            T t = aVar4.iLC;
            if (t == null) {
                p.hyc();
            }
            if (((che) t).MmA == null) {
                e2.a(mv.c.bundle_null);
            } else {
                c.a<che> aVar5 = this.mYG;
                if (aVar5 == null) {
                    p.hyc();
                }
                T t2 = aVar5.iLC;
                if (t2 == null) {
                    p.hyc();
                }
                if (((che) t2).MmA.LjS == null) {
                    e2.a(mv.c.jsapi_control_bytes_null);
                } else {
                    e2.a(mv.c.ok);
                }
            }
        } else {
            e2.a(mv.c.common_fail);
        }
        e2.bfK();
        AppMethodBeat.o(228754);
    }

    @Override // com.tencent.luggage.sdk.e.a
    public final /* synthetic */ Object OX() {
        String str;
        String VH;
        boolean z;
        fdx fdx;
        String str2;
        AppMethodBeat.i(50813);
        b.pl(3);
        String str3 = this.appId;
        if (!(str3 == null || str3.length() == 0)) {
            str = this.appId;
        } else {
            b bVar = (b) n.W(b.class);
            if (bVar == null || (VH = bVar.VH(this.userName)) == null) {
                str = "";
            } else {
                str = VH;
            }
        }
        ao buD = n.buD();
        ap apVar = new ap();
        Log.i("MicroMsg.AppBrand.PreFetchLaunchTask", "preFetch: start with username[" + this.userName + "] savedAppId[" + str + "] enterPath[" + this.kHw + ']');
        apVar.field_appId = str;
        if (buD != null) {
            if (!bb.yl(this.enterScene)) {
                if (buD.a(apVar, "appId") && bb.b(apVar) && apVar.field_launchAction != null && 1 == apVar.field_launchAction.KCD) {
                    z = false;
                }
            }
            z = true;
        } else {
            z = true;
        }
        this.kqC = z;
        ICommLibReader bvT = at.bvT();
        int bvd = bvT != null ? bvT.bvd() : -1;
        fcc fcc = new fcc();
        fcc.MjZ = this.iOo;
        fcc.KSa = 0;
        fcc.Scene = this.enterScene;
        fcc.MqD = this.lYx ? 1 : 0;
        fcc.MqE = this.kHw;
        AppBrandStatObject appBrandStatObject = this.kEH;
        fcc.MqC = appBrandStatObject != null ? appBrandStatObject.ecU : 0;
        fez b2 = d.b(this.cys);
        fds c2 = d.c(this.cys);
        fec fec = new fec();
        fec.Nzu = this.lek;
        String str4 = this.mYI;
        if (str4 == null || str4.length() == 0) {
            fdx = null;
        } else {
            fdx = new fdx();
            fdx.LXZ = this.mYI;
        }
        d.a aVar = d.mYC;
        String str5 = this.userName;
        String str6 = this.appId;
        boolean z2 = this.kqC;
        chd chd = new chd();
        chd.Mmn = fcc;
        chd.Mbn = z2 ? 1 : 2;
        chd.Mmq = b2;
        chd.Mmr = c2;
        if (str6 == null) {
            str2 = "";
        } else {
            str2 = str6;
        }
        chd.jfi = str2;
        chd.Mem = true;
        fdb fdb = new fdb();
        fdb.MqF = bvd;
        chd.Mmp = fdb;
        chd.Mmv = str5;
        chd.Mmw = fec;
        chd.Mmy = fdx;
        d dVar = new d(chd, z2);
        this.cCs = Util.nowMilliSecond();
        this.mYG = dVar.bNV();
        this.cCt = Util.nowMilliSecond();
        StringBuilder append = new StringBuilder("preFetch: done with username[").append(this.userName).append("] savedAppId[").append(str).append("] enterPath[").append(this.kHw).append("] cost[").append(this.cCt - this.cCs).append(" ms] ret is? = [").append(this.mYG == null).append("],errCode=[");
        c.a<che> aVar2 = this.mYG;
        StringBuilder append2 = append.append(aVar2 != null ? aVar2.errCode : -1).append("], errType=[");
        c.a<che> aVar3 = this.mYG;
        Log.i("MicroMsg.AppBrand.PreFetchLaunchTask", append2.append(aVar3 != null ? aVar3.errType : -1).append("], isSync=[").append(this.kqC).append(']').toString());
        c.a<che> aVar4 = this.mYG;
        AppMethodBeat.o(50813);
        return aVar4;
    }

    public final c.a<che> yn(int i2) {
        AppMethodBeat.i(180641);
        if (this.cCr == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(180641);
            throw illegalStateException;
        }
        FutureTask<T> futureTask = this.cCr;
        if (futureTask == null) {
            p.btv("futureTask");
        }
        if (futureTask.isDone()) {
            b.pl(5);
        } else {
            b.pl(6);
        }
        c.a<che> aVar = (c.a) super.hS(i2);
        AppMethodBeat.o(180641);
        return aVar;
    }
}
