package com.tencent.mm.compatible.h;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b {
    private static int gLf = 0;

    public static boolean apl() {
        AppMethodBeat.i(155860);
        if (gLf == 0) {
            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
            if (defaultPreference == null || !defaultPreference.getBoolean("settings_support_swipe", true)) {
                gLf = 2;
            } else {
                gLf = 1;
            }
        }
        if (gLf == 1) {
            AppMethodBeat.o(155860);
            return true;
        }
        AppMethodBeat.o(155860);
        return false;
    }

    public static void du(boolean z) {
        AppMethodBeat.i(155861);
        SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
        boolean z2 = defaultPreference.getBoolean("settings_support_swipe", true);
        if (z2 != z) {
            defaultPreference.edit().putBoolean("settings_support_swipe", z).commit();
        }
        Log.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(z2), Boolean.valueOf(z));
        AppMethodBeat.o(155861);
    }
}
