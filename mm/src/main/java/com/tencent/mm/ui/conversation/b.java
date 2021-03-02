package com.tencent.mm.ui.conversation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private static final String[] Qbz = {"M3X", "M5s", "M5", "MX6", "U10", "U20", "M2 E", "M A5", "DIG-AL00", "DIG-TL10", "NCE-AL00", "NCE-TL10", "MYA-TL10", "MYA-AL10", "NEM-AL10"};

    public static boolean gVn() {
        AppMethodBeat.i(38272);
        if (Build.VERSION.SDK_INT == 23 && Build.MODEL != null) {
            for (String str : Qbz) {
                if (str.equalsIgnoreCase(Build.MODEL)) {
                    Log.i("CompatSupportV27", "for weird crash, %s", Build.MODEL);
                    AppMethodBeat.o(38272);
                    return true;
                }
            }
        }
        AppMethodBeat.o(38272);
        return false;
    }
}
