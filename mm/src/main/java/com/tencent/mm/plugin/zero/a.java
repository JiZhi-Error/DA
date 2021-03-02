package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.d;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;

public final class a implements c, com.tencent.mm.plugin.zero.b.a {
    private f JRJ = new f();
    private d JRK = new d();

    public a() {
        AppMethodBeat.i(132988);
        AppMethodBeat.o(132988);
    }

    @Override // com.tencent.mm.plugin.zero.b.a
    public final f aqJ() {
        AppMethodBeat.i(132989);
        g.aAi();
        g.aAf().azk();
        f fVar = this.JRJ;
        AppMethodBeat.o(132989);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.zero.b.a
    public final d aqK() {
        AppMethodBeat.i(132990);
        g.aAi();
        g.aAf().azk();
        d dVar = this.JRK;
        AppMethodBeat.o(132990);
        return dVar;
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(132991);
        if (cVar.hrc) {
            d dVar = this.JRK;
            o oVar = new o(b.aKJ() + "configlist/");
            if (oVar.exists()) {
                o oVar2 = new o(d.gMf);
                if (!oVar2.exists()) {
                    Log.d("MicroMsg.ConfigListDecoder", "bugfix");
                    dVar.a(oVar, oVar2);
                }
            }
        }
        this.JRJ.vC();
        this.JRK.init();
        AppMethodBeat.o(132991);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
    }
}
