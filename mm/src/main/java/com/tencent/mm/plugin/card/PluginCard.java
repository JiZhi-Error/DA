package com.tencent.mm.plugin.card;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.card.model.am;

public class PluginCard extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(112558);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(112558);
    }

    public am getCore() {
        AppMethodBeat.i(112559);
        am amVar = (am) y.at(am.class);
        AppMethodBeat.o(112559);
        return amVar;
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(201305);
        com.tencent.mm.vfs.y.a("card", "card", 50331648, 7776000000L, 7);
        AppMethodBeat.o(201305);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(112560);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.a(b.class, new e(new com.tencent.mm.plugin.card.c.a()));
        }
        AppMethodBeat.o(112560);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(112561);
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        dependsOn(com.tencent.mm.plugin.card.compat.a.b.class);
        AppMethodBeat.o(112561);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-card";
    }
}
