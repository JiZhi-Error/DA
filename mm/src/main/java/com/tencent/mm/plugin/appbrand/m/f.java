package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class f extends d {
    private final IJSRuntime dpQ;
    private final m mNT;
    private final int mNU;

    public f(m mVar, int i2) {
        this.dpQ = mVar.dpQ;
        this.mNT = mVar;
        this.mNU = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.g
    public final boolean bMB() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.g
    public final int bMC() {
        return this.mNU;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.d
    public final IJSRuntime bMz() {
        return this.dpQ;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.m.d
    public final m bMA() {
        return this.mNT;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.u, com.tencent.mm.plugin.appbrand.m.d
    public final void pause() {
        AppMethodBeat.i(144173);
        Log.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
        AppMethodBeat.o(144173);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.u, com.tencent.mm.plugin.appbrand.m.d
    public final void resume() {
        AppMethodBeat.i(144174);
        Log.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
        AppMethodBeat.o(144174);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void setJsExceptionHandler(h hVar) {
        AppMethodBeat.i(144172);
        this.mNT.a(this.mNU, hVar);
        AppMethodBeat.o(144172);
    }
}
