package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.concurrent.TimeUnit;

public class g extends c<btt> {
    public g() {
        AppMethodBeat.i(44677);
        Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo");
        d.a aVar = new d.a();
        aVar.iLN = new bts();
        aVar.iLO = new btt();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecallinfo";
        aVar.funcId = 2572;
        c(aVar.aXF());
        AppMethodBeat.o(44677);
    }

    public static void gN(boolean z) {
        AppMethodBeat.i(44678);
        int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_app_brand_recommend_enter_switch, 0);
        if (!(a2 == 1)) {
            Log.e("MicroMsg.Recommend.CgiGetRecallInfo", "ABTestShowRecommend is not open, labValue:%d", Integer.valueOf(a2));
            AppMethodBeat.o(44678);
            return;
        }
        long j2 = (long) AppBrandGlobalSystemConfig.bzP().ldp;
        long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_RECOMMEND_GET_RECALL_INFO_LAST_TIME_LONG_SYNC, (Object) 0L)).longValue();
        final long nowSecond = Util.nowSecond();
        long seconds = TimeUnit.DAYS.toSeconds(1);
        long j3 = nowSecond - longValue;
        Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "weUseRecallInterval:%d, internalTime:%d", Long.valueOf(j2), Long.valueOf(j3));
        if (z || ((j2 > 0 && j3 >= j2) || (j2 <= 0 && j3 >= seconds))) {
            Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "force or It's time to do getRecallInfo");
            f.bZn().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.appusage.a.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(44676);
                    new g() {
                        /* class com.tencent.mm.plugin.appbrand.appusage.a.g.AnonymousClass1.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
                        @Override // com.tencent.mm.ak.c
                        public final /* synthetic */ void a(int i2, int i3, String str, btt btt, q qVar) {
                            AppMethodBeat.i(44675);
                            btt btt2 = btt;
                            if (!com.tencent.mm.kernel.g.aAc()) {
                                Log.e("MicroMsg.Recommend.CgiGetRecallInfo", "account nor ready");
                                AppMethodBeat.o(44675);
                                return;
                            }
                            Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            if (i2 != 0 || i3 != 0) {
                                Log.e("MicroMsg.Recommend.CgiGetRecallInfo", "cgi getRecallInfo fail");
                                AppMethodBeat.o(44675);
                            } else if (btt2 == null) {
                                Log.e("MicroMsg.Recommend.CgiGetRecallInfo", "getRecallInfo response is null");
                                AppMethodBeat.o(44675);
                            } else {
                                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_RECOMMEND_GET_RECALL_INFO_LAST_TIME_LONG_SYNC, Long.valueOf(nowSecond));
                                Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "response.recommend_data_state:%d", Integer.valueOf(btt2.MaD));
                                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_RECOMMEND_DATA_STATE_INT_SYNC, Integer.valueOf(btt2.MaD));
                                AppMethodBeat.o(44675);
                            }
                        }
                    }.aYI();
                    AppMethodBeat.o(44676);
                }
            });
            AppMethodBeat.o(44678);
            return;
        }
        Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "time is not exceed one day, not to getRecallInfo");
        AppMethodBeat.o(44678);
    }
}
