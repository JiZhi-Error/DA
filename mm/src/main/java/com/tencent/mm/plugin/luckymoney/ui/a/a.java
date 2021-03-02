package com.tencent.mm.plugin.luckymoney.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.Random;

public final class a {
    public static void gW(int i2, int i3) {
        AppMethodBeat.i(213537);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HB_GETTIMELIMITPROMOT_TIMESTAMP_INT_SYNC, (Object) -1)).intValue();
        Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "new: [%s, %s], old: %s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(intValue));
        if (i3 > intValue) {
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_HB_GETTIMELIMITPROMOT_TIMESTAMP_INT_SYNC, Integer.valueOf(i3));
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_HB_GETTIMELIMITPROMOT_PERCENT_INT_SYNC, Integer.valueOf(i2));
        }
        AppMethodBeat.o(213537);
    }

    public static boolean bfV() {
        AppMethodBeat.i(213538);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HB_GETTIMELIMITPROMOT_PERCENT_INT_SYNC, (Object) 0)).intValue();
        if (intValue <= 0) {
            AppMethodBeat.o(213538);
            return false;
        } else if (intValue >= 100) {
            AppMethodBeat.o(213538);
            return true;
        } else {
            int nextInt = new Random().nextInt(101);
            Log.i("MicroMsg.GetTimeLimitPromotBlindBox", "random: %s, %s", Integer.valueOf(nextInt), Integer.valueOf(intValue));
            if (nextInt <= intValue) {
                AppMethodBeat.o(213538);
                return true;
            }
            AppMethodBeat.o(213538);
            return false;
        }
    }
}
