package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;

public final class e {
    public static boolean apn() {
        boolean z = false;
        AppMethodBeat.i(155875);
        try {
            z = new File(b.aKD()).canWrite();
            AppMethodBeat.o(155875);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CUtil", e2, "summer isSDCardAvail 1 e: " + e2.getMessage() + " SDCARD_ROOT: " + b.aKD(), new Object[0]);
            AppMethodBeat.o(155875);
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean apo() {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.util.e.apo():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean yV(long r14) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.util.e.yV(long):boolean");
    }
}
