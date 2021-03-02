package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.w;
import com.tencent.mm.b;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;

public class MMPhotoEditPlugin extends f implements c {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(9276);
        ab.diQ = new b.a();
        AppMethodBeat.o(9276);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(9277);
        a aVar = a.NCE;
        Log.i("MicroMsg.MediaSecurityReport", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        com.tencent.mm.kernel.g.azz().a(110, aVar);
        com.tencent.mm.kernel.g.azz().a(149, aVar);
        com.tencent.mm.kernel.g.b(w.class, a.NCE);
        AppMethodBeat.o(9277);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(9278);
        com.tencent.mm.kernel.g.ag(w.class);
        a aVar = a.NCE;
        Log.i("MicroMsg.MediaSecurityReport", "release");
        com.tencent.mm.kernel.g.azz().b(110, aVar);
        com.tencent.mm.kernel.g.azz().b(149, aVar);
        aVar.uUF.clear();
        AppMethodBeat.o(9278);
    }
}
