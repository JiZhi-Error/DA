package com.tencent.mm.plugin.trafficmonitor;

import android.content.IntentFilter;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.trafficmonitor.a.a;

public class PluginTrafficMonitor extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(123900);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(123900);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(123901);
        if (gVar.aBb() && Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT > 19) {
            gVar.ca.registerReceiver(new TrafficClickFlowReceiver(), new IntentFilter("com.tencent.mm.Intent.ACTION_NET_STATS"));
            g.fAk();
            g.fAl();
        }
        AppMethodBeat.o(123901);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-trafficmonitor";
    }
}
