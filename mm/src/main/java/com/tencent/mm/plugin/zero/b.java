package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ci;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b implements c, com.tencent.mm.plugin.zero.b.b {
    private ci Via;
    private q Vib;

    @Override // com.tencent.mm.plugin.zero.b.b
    public final q bdS() {
        AppMethodBeat.i(132993);
        g.aAi();
        g.aAf().azk();
        if (this.Vib == null) {
            this.Vib = new q();
            this.Vib.appForegroundListener.alive();
        }
        q qVar = this.Vib;
        AppMethodBeat.o(132993);
        return qVar;
    }

    @Override // com.tencent.mm.plugin.zero.b.b
    public final ci glA() {
        AppMethodBeat.i(132994);
        g.aAi();
        g.aAf().azk();
        if (this.Via == null) {
            this.Via = new ci(new ci.a() {
                /* class com.tencent.mm.plugin.zero.b.AnonymousClass1 */

                @Override // com.tencent.mm.model.ci.a
                public final boolean aWx() {
                    AppMethodBeat.i(132992);
                    if (b.this.bdS().jei == null) {
                        AppMethodBeat.o(132992);
                        return true;
                    }
                    AppMethodBeat.o(132992);
                    return false;
                }
            });
        }
        ci ciVar = this.Via;
        AppMethodBeat.o(132994);
        return ciVar;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(176851);
        if (MMApplicationContext.isMainProcess()) {
            bdS();
        }
        AppMethodBeat.o(176851);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(132995);
        if (this.Vib != null) {
            q qVar = this.Vib;
            Log.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", Integer.valueOf(qVar.jef.size()), Integer.valueOf(qVar.jeg.size()), qVar.jei);
            qVar.jef.clear();
            qVar.jeg.clear();
            this.Vib.appForegroundListener.dead();
        }
        if (this.Via != null) {
            this.Via.aWs();
        }
        AppMethodBeat.o(132995);
    }
}
