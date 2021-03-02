package com.tencent.mm.plugin.lite.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends o.a {
    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
        AppMethodBeat.i(198850);
        Log.d("MicroMsg.AppLite.LiteAppAppForegroundListener", "onAppForeground");
        AppMethodBeat.o(198850);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
    }
}
