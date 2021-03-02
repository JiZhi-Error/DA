package com.tencent.mm.aa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import java.util.HashMap;
import java.util.Map;

public final class d {
    final Map<String, b> hpo = new HashMap();

    public d() {
        AppMethodBeat.i(144807);
        AppMethodBeat.o(144807);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(144808);
        this.hpo.put(bVar.name, bVar);
        AppMethodBeat.o(144808);
    }
}
