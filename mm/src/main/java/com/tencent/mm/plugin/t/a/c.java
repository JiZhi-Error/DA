package com.tencent.mm.plugin.t.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public final class c {
    private static final a ARS = new a() {
        /* class com.tencent.mm.plugin.t.a.c.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.t.a.a
        public final void eBu() {
            AppMethodBeat.i(224086);
            Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader savePayTestEnvIDs");
            AppMethodBeat.o(224086);
        }

        @Override // com.tencent.mm.plugin.t.a.a
        public final void sC(boolean z) {
            AppMethodBeat.i(224087);
            Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader setPayTestEnvID2RR, isKinda: ".concat(String.valueOf(z)));
            AppMethodBeat.o(224087);
        }

        @Override // com.tencent.mm.plugin.t.a.a
        public final void gL(Context context) {
            AppMethodBeat.i(224088);
            Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader showPayTestEnvIDsUI");
            u.makeText(context, "不支持此功能， 需要支付测试包编译参数。", 1).show();
            AppMethodBeat.o(224088);
        }
    };
    private static final b ART = new b() {
        /* class com.tencent.mm.plugin.t.a.c.AnonymousClass2 */
    };

    static {
        AppMethodBeat.i(224090);
        AppMethodBeat.o(224090);
    }

    public static a eBv() {
        AppMethodBeat.i(224089);
        a aVar = (a) g.af(a.class);
        if (aVar != null) {
            h.INSTANCE.idkeyStat(1490, 0, 1, false);
            AppMethodBeat.o(224089);
            return aVar;
        }
        a aVar2 = ARS;
        AppMethodBeat.o(224089);
        return aVar2;
    }
}
