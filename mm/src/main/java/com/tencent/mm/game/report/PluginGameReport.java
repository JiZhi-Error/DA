package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginGameReport extends f implements c {
    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(108252);
        if (gVar.aBb() || gVar.FY(":tools") || gVar.FY(":toolsmp")) {
            a.hhr = new b();
            com.tencent.mm.kernel.g.b(b.class, new com.tencent.mm.game.report.a.a());
        }
        AppMethodBeat.o(108252);
    }
}
