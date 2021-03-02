package com.tencent.mm.model.gdpr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public enum a {
    MINI_PROGRAM("miniProgram", 1),
    BIZ("officialAccount", 0),
    OPENSDK("OPENSDK", 2);
    
    public final String iGP;
    public final int iGQ;

    public static a valueOf(String str) {
        AppMethodBeat.i(40078);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(40078);
        return aVar;
    }

    static {
        AppMethodBeat.i(40081);
        AppMethodBeat.o(40081);
    }

    private a(String str, int i2) {
        this.iGP = str;
        this.iGQ = i2;
    }

    public static boolean KZ(String str) {
        AppMethodBeat.i(40079);
        if (La(str) != null) {
            AppMethodBeat.o(40079);
            return true;
        }
        AppMethodBeat.o(40079);
        return false;
    }

    public static a La(String str) {
        AppMethodBeat.i(40080);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(40080);
            return null;
        }
        a[] values = values();
        for (a aVar : values) {
            if (str.equals(aVar.iGP)) {
                AppMethodBeat.o(40080);
                return aVar;
            }
        }
        AppMethodBeat.o(40080);
        return null;
    }
}
