package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.cdndownloader.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static void a(a aVar) {
        AppMethodBeat.i(120811);
        c cxT = cxT();
        if (cxT != null) {
            Log.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: ".concat(String.valueOf(cxT.insert(aVar))));
        }
        AppMethodBeat.o(120811);
    }

    public static void akv(String str) {
        AppMethodBeat.i(120812);
        c cxT = cxT();
        if (cxT != null) {
            Log.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: ".concat(String.valueOf(cxT.akw(str))));
        }
        AppMethodBeat.o(120812);
    }

    public static c cxT() {
        AppMethodBeat.i(120813);
        c cxT = ((a) g.af(a.class)).cxT();
        AppMethodBeat.o(120813);
        return cxT;
    }
}
