package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

final class p {
    private static void gnT() {
        AppMethodBeat.i(152006);
        if (!g.aAf().azp()) {
            AppMethodBeat.o(152006);
            return;
        }
        g.aAh().azQ().set(ar.a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, Long.valueOf(Util.nowSecond() + 86400));
        AppMethodBeat.o(152006);
    }

    static void cjR() {
        AppMethodBeat.i(152007);
        g.aAg().hqi.a(new m(), 0);
        gnT();
        AppMethodBeat.o(152007);
    }
}
