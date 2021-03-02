package com.tencent.mm.plugin.appbrand.report.quality;

import com.google.android.gms.common.Scopes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.nn;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appcache.bs;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\f\u0010\r\u001a\u00020\u000e*\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\nH\u0002¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/quality/PkgDownloadProfileReportUtils;", "", "()V", "report", "", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "kv14609", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14609;", "downloadRequest", "Lcom/tencent/mm/plugin/appbrand/appcache/base/BaseWxaPkgDownloadRequest;", Scopes.PROFILE, "Lcom/tencent/mars/cdn/CdnLogic$WebPageProfile;", "fetchWxaPkgInnerVersion", "", "getFinalPkgPath", "", "plugin-appbrand-integration_release"})
public final class i {
    public static final i nKN = new i();

    static {
        AppMethodBeat.i(229319);
        AppMethodBeat.o(229319);
    }

    private i() {
    }

    public static final /* synthetic */ String f(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(229321);
        String d2 = d(aVar);
        AppMethodBeat.o(229321);
        return d2;
    }

    public static final void a(QualitySession qualitySession, kv_14609 kv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a aVar, CdnLogic.WebPageProfile webPageProfile) {
        AppMethodBeat.i(229317);
        p.h(qualitySession, "session");
        p.h(kv_14609, "kv14609");
        p.h(aVar, "downloadRequest");
        p.h(webPageProfile, Scopes.PROFILE);
        d.i(new a(qualitySession, kv_14609, aVar, webPageProfile));
        AppMethodBeat.o(229317);
    }

    private static String d(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(229318);
        if (aVar instanceof bs) {
            String bwC = ((bs) aVar).bwC();
            AppMethodBeat.o(229318);
            return bwC;
        } else if (aVar instanceof aw) {
            String bwb = ((aw) aVar).bwb();
            AppMethodBeat.o(229318);
            return bwb;
        } else {
            String filePath = aVar.getFilePath();
            AppMethodBeat.o(229318);
            return filePath;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ QualitySession nKA;
        final /* synthetic */ kv_14609 nKO;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.appcache.a.a nKP;
        final /* synthetic */ CdnLogic.WebPageProfile nKQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(QualitySession qualitySession, kv_14609 kv_14609, com.tencent.mm.plugin.appbrand.appcache.a.a aVar, CdnLogic.WebPageProfile webPageProfile) {
            super(0);
            this.nKA = qualitySession;
            this.nKO = kv_14609;
            this.nKP = aVar;
            this.nKQ = webPageProfile;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            long j2;
            long j3 = 1;
            AppMethodBeat.i(229316);
            nn nnVar = new nn();
            nnVar.AB(this.nKA.kEY);
            nnVar.AC(this.nKA.appId);
            nnVar.xM((long) this.nKA.nLk);
            nnVar.xN((long) this.nKA.nJE);
            nnVar.xO((long) this.nKA.apptype);
            nnVar.xP(this.nKO.bUQ());
            nnVar.xQ((long) this.nKA.scene);
            nnVar.xR(this.nKO.bUR());
            nnVar.xS(this.nKO.bUS());
            nnVar.AD(this.nKO.cBp);
            nnVar.xT((long) this.nKO.aYR());
            nnVar.xU((long) this.nKO.kMt);
            nnVar.xV((long) this.nKO.mVo);
            nnVar.xW(this.nKO.bNr() ? 1 : 0);
            if (this.nKO.bUU() > 0) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            nnVar.xX(j2);
            i iVar = i.nKN;
            nnVar.xY((long) i.e(this.nKP));
            nnVar.AE(this.nKP.getURL());
            nnVar.AF(t.bUy());
            nnVar.xZ(this.nKQ.redirectStart);
            nnVar.ya(this.nKQ.redirectEnd);
            nnVar.yb(this.nKQ.fetchStart);
            nnVar.yc(this.nKQ.domainLookUpStart);
            nnVar.yd(this.nKQ.domainLookUpEnd);
            nnVar.ye(this.nKQ.connectStart);
            nnVar.yf(this.nKQ.connectEnd);
            nnVar.yg(this.nKQ.SSLconnectionStart);
            nnVar.yh(this.nKQ.SSLconnectionEnd);
            nnVar.yi(this.nKQ.requestStart);
            nnVar.yj(this.nKQ.requestEnd);
            nnVar.yk(this.nKQ.responseStart);
            nnVar.yl(this.nKQ.responseEnd);
            nnVar.AG(this.nKQ.protocol);
            nnVar.mO(this.nKQ.rtt);
            nnVar.mP(this.nKQ.statusCode);
            nnVar.mQ(this.nKQ.networkTypeEstimate);
            nnVar.mR(this.nKQ.httpRttEstimate);
            nnVar.mS(this.nKQ.transportRttEstimate);
            nnVar.mT(this.nKQ.downstreamThroughputKbpsEstimate);
            nnVar.mU(this.nKQ.throughputKbps);
            nnVar.AH(this.nKQ.peerIP);
            nnVar.mV(this.nKQ.port);
            nnVar.ym(this.nKQ.socketReused ? 1 : 0);
            nnVar.yn(this.nKQ.sendBytesCount);
            nnVar.yo(this.nKQ.receivedBytedCount);
            nnVar.yp(this.nKQ.receivedBytedCount);
            nnVar.yq(this.nKO.nJC);
            switch (this.nKO.bUT()) {
                case 1:
                case 2:
                case 3:
                    nnVar.mW(1);
                    break;
                case 4:
                case 5:
                    nnVar.mW(3);
                    break;
                case 6:
                    nnVar.mW(4);
                    break;
            }
            i iVar2 = i.nKN;
            nnVar.AI(WxaPkgIntegrityChecker.Vn(i.f(this.nKP)));
            if (!this.nKO.nJR) {
                j3 = 0;
            }
            nnVar.yr(j3);
            nnVar.bfK();
            x xVar = x.SXb;
            AppMethodBeat.o(229316);
            return xVar;
        }
    }

    public static final /* synthetic */ int e(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(229320);
        String d2 = d(aVar);
        if (d2 != null && s.YS(d2)) {
            int Vg = WxaPkg.Vg(d2);
            AppMethodBeat.o(229320);
            return Vg;
        }
        AppMethodBeat.o(229320);
        return 0;
    }
}
