package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class e {
    public static boolean eRU() {
        AppMethodBeat.i(52058);
        c Fu = d.aXu().Fu("100027");
        if (!Fu.isValid()) {
            Log.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
            AppMethodBeat.o(52058);
            return false;
        }
        Map<String, String> gzz = Fu.gzz();
        if (gzz == null) {
            Log.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
            AppMethodBeat.o(52058);
            return false;
        } else if (!gzz.containsKey("showEntrance") || !"1".equals(gzz.get("showEntrance"))) {
            Log.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
            AppMethodBeat.o(52058);
            return false;
        } else {
            AppMethodBeat.o(52058);
            return true;
        }
    }
}
