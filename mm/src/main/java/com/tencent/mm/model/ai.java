package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.ci;

public final class ai {
    public static ah Kb(String str) {
        AppMethodBeat.i(150163);
        ah ahVar = new ah("@black.android", null, str, null, true, true);
        AppMethodBeat.o(150163);
        return ahVar;
    }

    public static ah Kc(String str) {
        AppMethodBeat.i(150164);
        ci aEY = ((l) g.af(l.class)).aSW().aEY("@t.qq.com");
        if (aEY == null) {
            AppMethodBeat.o(150164);
            return null;
        }
        ah ahVar = new ah("@t.qq.com", null, str, null, aEY.isEnable(), aEY.gEp());
        AppMethodBeat.o(150164);
        return ahVar;
    }

    private static String aM(String str, String str2) {
        AppMethodBeat.i(150165);
        String str3 = "";
        if (str != null) {
            str3 = str3 + str.replace("@", "");
        }
        if (str2 != null) {
            str3 = str3 + str2;
        }
        AppMethodBeat.o(150165);
        return str3;
    }

    public static ah aN(String str, String str2) {
        AppMethodBeat.i(150166);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(150166);
            return null;
        }
        ci aEY = ((l) g.af(l.class)).aSW().aEY(str);
        if (aEY == null || !aEY.gEq()) {
            AppMethodBeat.o(150166);
            return null;
        }
        ah ahVar = new ah("@domain.android", aEY.name, aM(aEY.OrA.bkR(""), str2), aEY.OrA.bkR(""), aEY.isEnable(), true);
        AppMethodBeat.o(150166);
        return ahVar;
    }
}
