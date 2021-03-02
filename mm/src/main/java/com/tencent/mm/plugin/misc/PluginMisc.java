package com.tencent.mm.plugin.misc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.misc.b.b;

public class PluginMisc extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(127602);
        alias(a.class);
        AppMethodBeat.o(127602);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(127603);
        dependsOn(s.class);
        AppMethodBeat.o(127603);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(127604);
        com.tencent.mm.kernel.g.b(a.class, new b());
        pin(com.tencent.mm.plugin.misc.b.a.eiW());
        AppMethodBeat.o(127604);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-misc";
    }
}
