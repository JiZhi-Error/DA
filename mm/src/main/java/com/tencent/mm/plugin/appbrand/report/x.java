package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public interface x {
    void a(fcq fcq);

    void ce(String str, int i2);

    public static class a {
        private static final x nIe = new x() {
            /* class com.tencent.mm.plugin.appbrand.report.x.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.report.x
            public final void a(fcq fcq) {
                AppMethodBeat.i(227375);
                AppBrandIDKeyBatchReport.a(fcq);
                AppMethodBeat.o(227375);
            }

            @Override // com.tencent.mm.plugin.appbrand.report.x
            public final void ce(String str, int i2) {
                AppMethodBeat.i(227376);
                AppBrandIDKeyBatchReport.ce(str, i2);
                AppMethodBeat.o(227376);
            }
        };

        static {
            AppMethodBeat.i(227378);
            AppMethodBeat.o(227378);
        }

        public static x bUB() {
            AppMethodBeat.i(227377);
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_wxa_batch_idkey_report_use_new_impl, 0);
            Log.i("Luggage.WxaCgiIDKeyBatchReportProtocol.Factory", "IMPL() exptVal=%d", Integer.valueOf(a2));
            if (a2 > 0 || BuildInfo.DEBUG) {
                d dVar = d.nGE;
                AppMethodBeat.o(227377);
                return dVar;
            }
            x xVar = nIe;
            AppMethodBeat.o(227377);
            return xVar;
        }
    }
}
