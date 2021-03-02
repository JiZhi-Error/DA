package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h {
    public static a qLd;
    static g qLe;

    public interface a {
        void kW(boolean z);
    }

    public static g cCc() {
        byte[] azn;
        AppMethodBeat.i(8903);
        if (qLe == null && (azn = ((com.tencent.mm.plugin.game.commlib.a.a) g.af(com.tencent.mm.plugin.game.commlib.a.a.class)).azn("pb_appinfo")) != null) {
            qLe = new g(azn);
        }
        g gVar = qLe;
        AppMethodBeat.o(8903);
        return gVar;
    }

    public static void a(LinkedList<String> linkedList, a aVar) {
        AppMethodBeat.i(8904);
        d.a aVar2 = new d.a();
        com.tencent.mm.plugin.downloader.c.a.a.a aVar3 = new com.tencent.mm.plugin.downloader.c.a.a.a();
        aVar3.qFI = linkedList;
        aVar3.qFK = true;
        aVar2.iLN = aVar3;
        aVar2.iLO = new b();
        aVar2.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
        aVar2.funcId = 2560;
        qLd = aVar;
        aa.a(aVar2.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.downloader_app.a.h.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(8902);
                Log.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 0 && i3 == 0) {
                    h.qLe = new g((b) dVar.iLL.iLR);
                    if (h.qLd != null) {
                        h.qLd.kW(true);
                    }
                } else if (h.qLd != null) {
                    h.qLd.kW(false);
                }
                AppMethodBeat.o(8902);
                return 0;
            }
        });
        AppMethodBeat.o(8904);
    }
}
