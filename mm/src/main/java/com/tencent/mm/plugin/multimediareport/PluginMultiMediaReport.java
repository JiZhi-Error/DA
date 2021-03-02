package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.zero.a.d;

public class PluginMultiMediaReport extends f implements b {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(194285);
        alias(b.class);
        AppMethodBeat.o(194285);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(194286);
        dependsOn(d.class);
        AppMethodBeat.o(194286);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(194287);
        new e();
        AppMethodBeat.o(194287);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }
}
