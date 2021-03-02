package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends b {
    public static a nkj;

    public interface a {
        void kvStat(int i2, String str);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.b
    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(147396);
        if (nkj == null) {
            Log.d("MicroMsg.NodeReportKV", "sDelegate null");
            AppMethodBeat.o(147396);
            return;
        }
        try {
            nkj.kvStat(iVar.getInt("id"), iVar.optString("val"));
            AppMethodBeat.o(147396);
        } catch (g e2) {
            Log.e("MicroMsg.NodeReportKV", "execute exception : %s", e2);
            cVar.bPU();
            AppMethodBeat.o(147396);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 8;
    }
}
