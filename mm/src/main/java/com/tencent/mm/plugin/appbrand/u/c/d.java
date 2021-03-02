package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends b {
    public static a nki;

    public interface a {
        void Q(int i2, int i3, int i4);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.b
    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(147395);
        if (nki == null) {
            Log.d("MicroMsg.NodeReportIDKey", "sDelegate null");
            AppMethodBeat.o(147395);
            return;
        }
        try {
            nki.Q(iVar.getInt("id"), iVar.getInt("key"), iVar.optInt("val", 1));
            AppMethodBeat.o(147395);
        } catch (g e2) {
            Log.e("MicroMsg.NodeReportIDKey", "execute exception : %s", e2);
            cVar.bPU();
            AppMethodBeat.o(147395);
        }
    }
}
