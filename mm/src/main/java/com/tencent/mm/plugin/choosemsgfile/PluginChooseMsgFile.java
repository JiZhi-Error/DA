package com.tencent.mm.plugin.choosemsgfile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.choosemsgfile.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginChooseMsgFile extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(123218);
        Log.d("MicroMsg.PluginChooseMsgFile", "installed");
        alias(a.class);
        AppMethodBeat.o(123218);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(123219);
        Log.d("MicroMsg.PluginChooseMsgFile", "execute");
        com.tencent.mm.kernel.g.b(com.tencent.mm.choosemsgfile.compat.a.class, new com.tencent.mm.plugin.choosemsgfile.b.a());
        AppMethodBeat.o(123219);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(123220);
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        }
        AppMethodBeat.o(123220);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-choosemsgfile";
    }
}
