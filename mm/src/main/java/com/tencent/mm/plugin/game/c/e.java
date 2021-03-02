package com.tencent.mm.plugin.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.b.a.h;
import com.tencent.mm.plugin.game.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class e {

    /* access modifiers changed from: package-private */
    public static final class a {
        static int DOWNLOAD_STATUS_FAILED = 2;
        static int xvU = 0;
        static int xvV = 1;
    }

    public static void report(long j2) {
        AppMethodBeat.i(40884);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null) {
            Log.i("MicroMsg.ReportDownloadAppState", "report, info is null");
            AppMethodBeat.o(40884);
        } else if (!Cw.field_fromWeApp) {
            Log.i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
            AppMethodBeat.o(40884);
        } else if (Cw.field_status != 3 || s.YS(Cw.field_filePath)) {
            h hVar = new h();
            hVar.jfi = Cw.field_appId;
            if (Cw.field_status == 3) {
                hVar.oTW = a.xvV;
            } else if (Cw.field_status == 4) {
                hVar.oTW = a.DOWNLOAD_STATUS_FAILED;
            }
            d.a aVar = new d.a();
            aVar.funcId = 2683;
            aVar.uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
            aVar.iLN = hVar;
            aVar.iLO = new i();
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            aa.a(aVar.aXF(), new aa.a() {
                /* class com.tencent.mm.plugin.game.c.e.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                    AppMethodBeat.i(40883);
                    Log.i("MicroMsg.ReportDownloadAppState", "doCgi, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    AppMethodBeat.o(40883);
                    return 0;
                }
            });
            AppMethodBeat.o(40884);
        } else {
            Log.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
            AppMethodBeat.o(40884);
        }
    }
}
