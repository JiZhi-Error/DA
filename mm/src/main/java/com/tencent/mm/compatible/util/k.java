package com.tencent.mm.compatible.util;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class k {
    public static boolean alh() {
        AppMethodBeat.i(155906);
        boolean contains = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("samsung".toLowerCase());
        AppMethodBeat.o(155906);
        return contains;
    }

    public static boolean apw() {
        AppMethodBeat.i(155907);
        boolean contains = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("HMD Global".toLowerCase());
        AppMethodBeat.o(155907);
        return contains;
    }

    public static boolean apx() {
        AppMethodBeat.i(155908);
        boolean contains = Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("smartisan".toLowerCase());
        AppMethodBeat.o(155908);
        return contains;
    }
}
