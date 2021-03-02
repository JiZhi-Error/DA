package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class g {
    private static String hna;
    public static Context sContext;

    public static Context getContext() {
        AppMethodBeat.i(158731);
        Assert.assertNotNull("IPCInvoker not initialize.", sContext);
        Context context = sContext;
        AppMethodBeat.o(158731);
        return context;
    }

    public static boolean Fp(String str) {
        AppMethodBeat.i(158732);
        if (str == null || !str.equals(axZ())) {
            AppMethodBeat.o(158732);
            return false;
        }
        AppMethodBeat.o(158732);
        return true;
    }

    public static String axZ() {
        AppMethodBeat.i(158733);
        if (hna == null || hna.length() == 0) {
            hna = F(sContext, Process.myPid());
        }
        String str = hna;
        AppMethodBeat.o(158733);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a3 A[SYNTHETIC, Splitter:B:44:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ad A[SYNTHETIC, Splitter:B:50:0x00ad] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String F(android.content.Context r8, int r9) {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ipcinvoker.g.F(android.content.Context, int):java.lang.String");
    }
}
