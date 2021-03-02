package com.tencent.mm.plugin.kidswatch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.kidswatch.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

public class PluginKidsWatch extends f implements c, d, a {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(256389);
        alias(a.class);
        AppMethodBeat.o(256389);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(256390);
        dependsOn(s.class);
        AppMethodBeat.o(256390);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(256391);
        if (!gVar.aBb()) {
            AppMethodBeat.o(256391);
            return;
        }
        Log.v("PluginKidsWatch", "configure");
        AppMethodBeat.o(256391);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(256392);
        Log.v("PluginKidsWatch", "execute");
        AppMethodBeat.o(256392);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-welab";
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseOpened(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.e
    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(256393);
        Log.v("PluginKidsWatch", "onAccountRelease");
        AppMethodBeat.o(256393);
    }
}
