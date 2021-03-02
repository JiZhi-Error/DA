package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends b {
    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.b
    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(147397);
        try {
            int i2 = iVar.getInt("level");
            String optString = iVar.optString("message");
            switch (i2) {
                case 2:
                    Log.i("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(147397);
                    return;
                case 3:
                    Log.w("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(147397);
                    return;
                case 4:
                    Log.e("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(147397);
                    return;
                default:
                    Log.d("MicroMsg.NodeJs", optString);
                    AppMethodBeat.o(147397);
                    return;
            }
        } catch (g e2) {
            Log.e("MicroMsg.NodeToXLog", "execute exception : %s", e2);
            cVar.bPU();
            AppMethodBeat.o(147397);
        }
    }
}
