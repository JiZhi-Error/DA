package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.messenger.foundation.a.r;

public class PluginContact extends f implements b, c {
    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(257871);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.b(r.class, new com.tencent.mm.contact.a.c());
        ab.a((ar) com.tencent.mm.kernel.g.af(r.class));
        AppMethodBeat.o(257871);
    }
}
