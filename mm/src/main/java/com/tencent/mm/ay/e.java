package com.tencent.mm.ay;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.TimeZone;

public final class e {
    public static boolean bek() {
        AppMethodBeat.i(103250);
        if (bem() || bel()) {
            AppMethodBeat.o(103250);
            return true;
        }
        AppMethodBeat.o(103250);
        return false;
    }

    public static boolean bel() {
        AppMethodBeat.i(103251);
        int i2 = h.aqJ().getInt("ShakeMusicGlobalSwitch", 0);
        Log.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", Integer.valueOf(i2));
        if (i2 == 0) {
            AppMethodBeat.o(103251);
            return false;
        }
        AppMethodBeat.o(103251);
        return true;
    }

    public static boolean bem() {
        AppMethodBeat.i(103252);
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            AppMethodBeat.o(103252);
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!Util.isNullOrNil(networkCountryIso) && !networkCountryIso.equalsIgnoreCase("cn")) {
                AppMethodBeat.o(103252);
                return false;
            }
        }
        AppMethodBeat.o(103252);
        return true;
    }
}
