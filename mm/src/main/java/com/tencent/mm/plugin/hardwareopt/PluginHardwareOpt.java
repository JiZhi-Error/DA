package com.tencent.mm.plugin.hardwareopt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hardwareopt.a.a.a;
import com.tencent.mm.plugin.hardwareopt.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginHardwareOpt extends f implements c, b {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(55546);
        alias(b.class);
        AppMethodBeat.o(55546);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(55547);
        dependsOn(s.class);
        AppMethodBeat.o(55547);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(55548);
        if (!gVar.aBb()) {
            AppMethodBeat.o(55548);
            return;
        }
        Log.v("MicroMsg.PluginHardwareOpt", "hy: on config");
        com.tencent.mm.kernel.g.b(a.class, new com.tencent.mm.plugin.hardwareopt.a.a());
        AppMethodBeat.o(55548);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(55549);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginHardwareOpt", "hy: on execute. ");
        }
        AppMethodBeat.o(55549);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(55550);
        Log.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
        ((a) com.tencent.mm.kernel.g.af(a.class)).qe(false);
        AppMethodBeat.o(55550);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(55551);
        Log.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
        AppMethodBeat.o(55551);
    }
}
