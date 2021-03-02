package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.Log;

public final class e implements c, com.tencent.mm.plugin.game.api.e {
    private b xtL;
    private r xtM;

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(40841);
        Log.i("MicroMsg.GameService", "GameService onAccountInitialized");
        this.xtL = new b();
        this.xtM = new r();
        AppMethodBeat.o(40841);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(40842);
        Log.i("MicroMsg.GameService", "GameService onAccountRelease");
        AppMethodBeat.o(40842);
    }

    @Override // com.tencent.mm.plugin.game.api.e
    public final b dSI() {
        AppMethodBeat.i(40843);
        g.aAf().azk();
        if (this.xtL == null) {
            this.xtL = new b();
        }
        b bVar = this.xtL;
        AppMethodBeat.o(40843);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.game.api.e
    public final r dSJ() {
        AppMethodBeat.i(40845);
        g.aAf().azk();
        if (this.xtM == null) {
            this.xtM = new r();
        }
        r rVar = this.xtM;
        AppMethodBeat.o(40845);
        return rVar;
    }
}
