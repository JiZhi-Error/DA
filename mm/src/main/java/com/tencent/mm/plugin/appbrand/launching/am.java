package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class am {

    public enum b {
        SYNC_GET_ATTRS(20),
        SYNC_LAUNCH(21),
        GET_DOWNLOAD_URL(22);
        
        final int eventId;

        public static b valueOf(String str) {
            AppMethodBeat.i(47268);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(47268);
            return bVar;
        }

        static {
            AppMethodBeat.i(47269);
            AppMethodBeat.o(47269);
        }

        private b(int i2) {
            this.eventId = i2;
        }
    }

    public enum a {
        NONE,
        MISSING_PKG,
        NO_USE_RECENT,
        INVALID_FIELDS,
        VERSION_NOT_FOUND,
        PATH_NOT_FOUND,
        CMD_UPDATE_VERSION,
        ATTRS_NOT_FOUND;

        public static a valueOf(String str) {
            AppMethodBeat.i(47265);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(47265);
            return aVar;
        }

        static {
            AppMethodBeat.i(47266);
            AppMethodBeat.o(47266);
        }
    }

    static void a(b bVar, String str, int i2, int i3, int i4, long j2, int i5) {
        AppMethodBeat.i(227090);
        int aeH = i.aeH(str);
        Log.d("MicroMsg.AppBrand.LaunchStepCostReporter", "report %s | %s | %d | %d | %d", bVar.name(), str, Long.valueOf(j2), Integer.valueOf(aeH), Integer.valueOf(i5));
        h.INSTANCE.a(13886, str, Integer.valueOf(i2), Integer.valueOf(i3 + 1), Integer.valueOf(bVar.eventId), "", "", Long.valueOf(j2), 0, 0, Integer.valueOf(i4), 0, 0, Integer.valueOf(aeH), Integer.valueOf(i5));
        AppMethodBeat.o(227090);
    }
}
