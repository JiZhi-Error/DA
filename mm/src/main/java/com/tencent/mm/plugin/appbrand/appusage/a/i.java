package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.cyj;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public class i extends c<dix> {
    public i(int i2, long j2, long j3, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.i(44686);
        c(a(i2, j2, j3, appBrandRecommendStatObj).aXF());
        AppMethodBeat.o(44686);
    }

    static d.a a(int i2, long j2, long j3, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.i(44687);
        Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), appBrandRecommendStatObj.toString());
        d.a aVar = new d.a();
        diw diw = new diw();
        dks dks = new dks();
        dkl dkl = new dkl();
        dks.clK = appBrandRecommendStatObj.sessionId;
        aat aat = new aat();
        aat.Lmb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        aat.longitude = (double) appBrandRecommendStatObj.dTj;
        aat.latitude = (double) appBrandRecommendStatObj.latitude;
        diw.MNc = dks;
        diw.MNd = dkl;
        dkl.type = i2;
        if (i2 == 1) {
            cyj cyj = new cyj();
            cyj.username = appBrandRecommendStatObj.username;
            cyj.nHd = appBrandRecommendStatObj.nHd;
            cyj.request_id = new StringBuilder().append(System.currentTimeMillis()).toString();
            cyj.nHe = appBrandRecommendStatObj.nHe;
            cyj.dNI = appBrandRecommendStatObj.dNI;
            cyj.nHi = appBrandRecommendStatObj.nHi;
            cyj.position = appBrandRecommendStatObj.position;
            cyj.MDi = (int) j2;
            cyj.KIl = (int) j3;
            dkl.MOn = cyj;
        } else {
            ev evVar = new ev();
            evVar.username = appBrandRecommendStatObj.username;
            evVar.request_id = new StringBuilder().append(System.currentTimeMillis()).toString();
            evVar.nHe = appBrandRecommendStatObj.nHe;
            evVar.dNI = appBrandRecommendStatObj.dNI;
            evVar.nHi = appBrandRecommendStatObj.nHi;
            evVar.position = appBrandRecommendStatObj.position;
            evVar.KIl = (int) j3;
            dkl.MOo = evVar;
        }
        aVar.iLN = diw;
        aVar.iLO = new dix();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
        aVar.funcId = 2799;
        AppMethodBeat.o(44687);
        return aVar;
    }

    public static void b(final int i2, final long j2, final long j3, final AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.i(44688);
        if (appBrandRecommendStatObj == null) {
            AppMethodBeat.o(44688);
            return;
        }
        f.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appusage.a.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44685);
                if (i2 == 1) {
                    IPCRunCgi.a(i.a(i2, j2, j3, appBrandRecommendStatObj).aXF(), new IPCRunCgi.a() {
                        /* class com.tencent.mm.plugin.appbrand.appusage.a.i.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                        public final void a(int i2, int i3, String str, d dVar) {
                            AppMethodBeat.i(44683);
                            Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            if (i2 == 0 && i3 == 0) {
                                Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                                AppMethodBeat.o(44683);
                                return;
                            }
                            Log.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
                            AppMethodBeat.o(44683);
                        }
                    });
                    AppMethodBeat.o(44685);
                    return;
                }
                new i(i2, j2, j3, appBrandRecommendStatObj) {
                    /* class com.tencent.mm.plugin.appbrand.appusage.a.i.AnonymousClass1.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.ak.c
                    public final /* synthetic */ void a(int i2, int i3, String str, dix dix, q qVar) {
                        AppMethodBeat.i(44684);
                        if (!g.aAc()) {
                            Log.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "account nor ready");
                            AppMethodBeat.o(44684);
                            return;
                        }
                        Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick profile click errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                            AppMethodBeat.o(44684);
                            return;
                        }
                        Log.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
                        AppMethodBeat.o(44684);
                    }
                }.aYI();
                AppMethodBeat.o(44685);
            }
        });
        AppMethodBeat.o(44688);
    }
}
