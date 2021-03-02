package com.tencent.mm.plugin.cloudvoip.cloudvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.a.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginCloudVoice extends f implements c, a {
    private static final String[] qrx = {"confService", "ilink_network", "ilink_xlog"};

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(90783);
        Log.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice execute");
        AppMethodBeat.o(90783);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(90784);
        super.configure(gVar);
        Log.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice configure");
        AppMethodBeat.o(90784);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(90785);
        Log.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: account release. uninit openvoice so");
        com.tencent.mm.plugin.expansions.a.cMr();
        q qVar = q.INSTANCE;
        qVar.aj(qVar.qtQ);
        AppMethodBeat.o(90785);
    }
}
