package com.tencent.mm.plugin.o;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Map;

public final class a implements b {
    @Override // com.tencent.mm.pluginsdk.wallet.b
    public final Typeface gA(Context context) {
        AppMethodBeat.i(106592);
        Typeface gA = f.gA(context);
        AppMethodBeat.o(106592);
        return gA;
    }

    @Override // com.tencent.mm.pluginsdk.wallet.b
    public final void a(Map<String, Object> map, String str, String str2, int i2, b.a aVar) {
        AppMethodBeat.i(106593);
        Log.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
        q qVar = new q(map, str, str2, i2, aVar);
        g.aAi();
        g.aAg().hqi.a(qVar, 0);
        AppMethodBeat.o(106593);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.b
    public final czu elk() {
        AppMethodBeat.i(106594);
        czu elk = k.elk();
        AppMethodBeat.o(106594);
        return elk;
    }

    @Override // com.tencent.mm.pluginsdk.wallet.b
    public final void he(final int i2, final int i3) {
        AppMethodBeat.i(106595);
        Log.i("MicroMsg.WxPaySevice", "reportLocation %s %s", Integer.valueOf(i2), Integer.valueOf(i3));
        h.RTc.c(new Runnable() {
            /* class com.tencent.mm.plugin.o.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(212682);
                k.aeJ(i2);
                if (k.fQy() != null) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17162, Integer.valueOf(i3), k.fQy().KEG, k.fQy().KEF, k.fQy().KEH);
                }
                AppMethodBeat.o(212682);
            }
        }, "wxpay_report_location");
        AppMethodBeat.o(106595);
    }
}
