package com.tencent.mm.plugin.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

public class PluginTeenMode extends f implements c, d, a {
    private static com.tencent.mm.plugin.teenmode.b.d FWi = new com.tencent.mm.plugin.teenmode.b.d();

    static {
        AppMethodBeat.i(187359);
        AppMethodBeat.o(187359);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(187355);
        alias(a.class);
        AppMethodBeat.o(187355);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(187356);
        Log.d("PluginTeenMode", "execute");
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(b.class, com.tencent.mm.plugin.teenmode.b.b.fvs());
        }
        if (gVar.FZ(":appbrand")) {
            com.tencent.mm.kernel.g.b(b.class, com.tencent.mm.plugin.teenmode.b.c.fvt());
        }
        AppMethodBeat.o(187356);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-teenmode";
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseOpened(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(187357);
        Log.d("PluginTeenMode", "onAccountInitialized");
        FWi.alive();
        AppMethodBeat.o(187357);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(187358);
        Log.v("PluginTeenMode", "onAccountRelease");
        FWi.dead();
        AppMethodBeat.o(187358);
    }
}
