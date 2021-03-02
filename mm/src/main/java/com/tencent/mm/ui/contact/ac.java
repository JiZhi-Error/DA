package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ac {
    public static final void u(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(102927);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(102927);
            return;
        }
        String format = String.format("%s,%d,%d,%d,%d", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), 0);
        Log.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", format);
        h.INSTANCE.kvStat(13234, format);
        AppMethodBeat.o(102927);
    }

    public static void anJ(int i2) {
        AppMethodBeat.i(102928);
        Log.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomClick %d %d", 13941, Integer.valueOf(i2));
        h.INSTANCE.a(13941, Integer.valueOf(i2));
        AppMethodBeat.o(102928);
    }
}
