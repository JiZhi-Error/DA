package com.tencent.mm.plugin.expansions;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.expansions.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@Keep
public final class PluginExpansions extends f implements a {
    private static final String TAG = "MicroMsg.exp.PluginExpansions";

    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
        AppMethodBeat.i(152979);
        alias(a.class);
        MMApplicationContext.getContext();
        a.cMn();
        a.prepare();
        AppMethodBeat.o(152979);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(152980);
        c.cMv();
        c.cMw();
        if (gVar.aBb()) {
            a.cMl();
            Log.i(TAG, "request Sync at MAIN process");
            a.cMo();
            AppMethodBeat.o(152980);
            return;
        }
        if (!gVar.FY(":push")) {
            a.cMl();
            Log.i(TAG, "request Sync at SUB process");
            a.cMo();
        }
        Log.i(TAG, "execute done");
        AppMethodBeat.o(152980);
    }
}
