package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class b {
    public static boolean fUV() {
        AppMethodBeat.i(129752);
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(129752);
        return booleanValue;
    }

    public static void yD(boolean z) {
        AppMethodBeat.i(129753);
        Log.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", Boolean.valueOf(z));
        g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        g.aAh().azQ().gBI();
        AppMethodBeat.o(129753);
    }

    public static boolean fUW() {
        AppMethodBeat.i(129754);
        g fUX = d.fUX();
        Log.v("MicroMsg.GestureUtil", "alvinluo timeInfo: %d, %d", Long.valueOf(fUX.IvB), Long.valueOf(fUX.IvC));
        if (fUX.IvB != -1) {
            e.a(fUX);
            if (fUX.IvC / 1000 < 600) {
                d.aB(fUX.IvB, fUX.IvC);
                AppMethodBeat.o(129754);
                return true;
            }
            d.fUY();
        }
        AppMethodBeat.o(129754);
        return false;
    }
}
