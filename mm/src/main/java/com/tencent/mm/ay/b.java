package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean beh() {
        AppMethodBeat.i(137004);
        if (!a.bee() || a.bec()) {
            AppMethodBeat.o(137004);
            return false;
        }
        a.bdZ();
        AppMethodBeat.o(137004);
        return true;
    }

    public static boolean bei() {
        AppMethodBeat.i(137005);
        if (a.bec()) {
            a.bdY();
            AppMethodBeat.o(137005);
            return true;
        }
        AppMethodBeat.o(137005);
        return false;
    }

    public static boolean bej() {
        AppMethodBeat.i(137006);
        if (a.bee()) {
            a.bea();
            AppMethodBeat.o(137006);
            return true;
        }
        AppMethodBeat.o(137006);
        return false;
    }

    public static boolean Po(String str) {
        AppMethodBeat.i(137007);
        f bef = a.bef();
        if (bef == null || !bef.jfb.equals(str)) {
            AppMethodBeat.o(137007);
            return false;
        }
        AppMethodBeat.o(137007);
        return true;
    }
}
