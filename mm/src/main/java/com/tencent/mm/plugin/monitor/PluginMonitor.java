package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginMonitor extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(51497);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(51497);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(51498);
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
            pin(new y(b.class));
        }
        AppMethodBeat.o(51498);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-monitor";
    }
}
