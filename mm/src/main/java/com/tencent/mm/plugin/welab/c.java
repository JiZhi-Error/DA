package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.plugin.welab.d.a.a;

public final class c implements d {
    @Override // com.tencent.mm.plugin.welab.a.a.d
    public final void a(String str, b bVar) {
        AppMethodBeat.i(146210);
        a.gjg().JFS.put(str, bVar);
        AppMethodBeat.o(146210);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.d
    public final void a(b bVar) {
        AppMethodBeat.i(146211);
        a.gjg().JFT = bVar;
        AppMethodBeat.o(146211);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.d
    public final ec bbA(String str) {
        AppMethodBeat.i(146212);
        a bbz = a.gjg().bbz(str);
        AppMethodBeat.o(146212);
        return bbz;
    }
}
