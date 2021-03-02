package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.Log;

public class h extends c<bud> {

    public interface a {
        void a(bud bud);

        void byN();
    }

    public h(int i2, aat aat, long j2, int i3) {
        AppMethodBeat.i(44681);
        Log.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", Integer.valueOf(i2), 5, Long.valueOf(j2), Integer.valueOf(i3));
        d.a aVar = new d.a();
        buc buc = new buc();
        buc.MaL = i2;
        buc.MaM = 5;
        buc.MaN = new vf();
        buc.clK = j2;
        buc.MaO = aat;
        buc.MaP = i3;
        aVar.iLN = buc;
        aVar.iLO = new bud();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
        aVar.funcId = 2778;
        c(aVar.aXF());
        AppMethodBeat.o(44681);
    }

    public static void a(final int i2, final aat aat, final long j2, final a aVar, final int i3) {
        AppMethodBeat.i(44682);
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        f.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appusage.a.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44680);
                new h(i2, aat, j2, i3) {
                    /* class com.tencent.mm.plugin.appbrand.appusage.a.h.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.ak.c
                    public final /* synthetic */ void a(int i2, int i3, String str, bud bud, q qVar) {
                        AppMethodBeat.i(44679);
                        bud bud2 = bud;
                        if (!g.aAc()) {
                            Log.e("MicroMsg.Recommend.CgiGetRecommendWxa", "account nor ready");
                            AppMethodBeat.o(44679);
                            return;
                        }
                        long currentTimeMillis = (System.currentTimeMillis() / 1000) - currentTimeMillis;
                        Log.i("MicroMsg.Recommend.CgiGetRecommendWxa", "CgiGetRecommendWxa errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 != 0 || i3 != 0) {
                            Log.e("MicroMsg.Recommend.CgiGetRecommendWxa", "fetch fail");
                            if (aVar != null) {
                                aVar.byN();
                            }
                            com.tencent.mm.plugin.appbrand.ui.recommend.g.a(currentTimeMillis, null);
                            AppMethodBeat.o(44679);
                        } else if (bud2 == null) {
                            Log.e("MicroMsg.Recommend.CgiGetRecommendWxa", "response is null");
                            if (aVar != null) {
                                aVar.byN();
                            }
                            com.tencent.mm.plugin.appbrand.ui.recommend.g.a(currentTimeMillis, null);
                            AppMethodBeat.o(44679);
                        } else {
                            if (aVar != null) {
                                Log.e("MicroMsg.Recommend.CgiGetRecommendWxa", "get data success");
                                aVar.a(bud2);
                                com.tencent.mm.plugin.appbrand.ui.recommend.g.a(currentTimeMillis, bud2);
                            }
                            AppMethodBeat.o(44679);
                        }
                    }
                }.aYI();
                AppMethodBeat.o(44680);
            }
        });
        AppMethodBeat.o(44682);
    }
}
