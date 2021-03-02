package com.tencent.mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.api.b;
import com.tencent.mm.plugin.downloader_app.api.d;

public class PluginDownloaderApp extends f implements c, com.tencent.mm.plugin.downloader_app.api.f {
    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(8782);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(d.class, new d());
            com.tencent.mm.kernel.g.b(b.class, new a());
        }
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.downloader_app.api.c.class, new c());
        AppMethodBeat.o(8782);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(8783);
        com.tencent.mm.plugin.downloader_app.a.d.cBn();
        j.cCf();
        com.tencent.mm.plugin.downloader_app.a.e cBX = com.tencent.mm.plugin.downloader_app.a.e.cBX();
        ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).a(16, cBX.lqt);
        a.a(cBX.qKT);
        AppMethodBeat.o(8783);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(8784);
        com.tencent.mm.plugin.downloader_app.a.d.cBo();
        j.stop();
        com.tencent.mm.plugin.downloader_app.a.e cBX = com.tencent.mm.plugin.downloader_app.a.e.cBX();
        ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).b(16, cBX.lqt);
        a.b(cBX.qKT);
        AppMethodBeat.o(8784);
    }
}
