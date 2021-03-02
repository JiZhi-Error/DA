package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static c cCi() {
        AppMethodBeat.i(8962);
        if (g.aAf().azp()) {
            g.aAf();
            if (!a.azj()) {
                if (g.af(d.class) == null) {
                    Log.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
                    AppMethodBeat.o(8962);
                    return null;
                }
                c cBU = ((com.tencent.mm.plugin.downloader_app.api.d) g.af(com.tencent.mm.plugin.downloader_app.api.d.class)).cBU();
                AppMethodBeat.o(8962);
                return cBU;
            }
        }
        Log.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
        AppMethodBeat.o(8962);
        return null;
    }

    public static boolean cX(String str, int i2) {
        AppMethodBeat.i(8963);
        if (cCi() == null) {
            AppMethodBeat.o(8963);
            return false;
        }
        a aVar = new a();
        aVar.field_appId = str;
        aVar.field_status = i2;
        aVar.field_modifyTime = System.currentTimeMillis();
        boolean a2 = cCi().a(aVar);
        AppMethodBeat.o(8963);
        return a2;
    }
}
