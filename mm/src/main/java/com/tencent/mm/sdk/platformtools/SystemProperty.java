package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class SystemProperty {
    private static final HashMap<String, String> PROPERTIES = new HashMap<>();

    static {
        AppMethodBeat.i(157840);
        AppMethodBeat.o(157840);
    }

    private SystemProperty() {
    }

    public static String getProperty(String str) {
        AppMethodBeat.i(157838);
        String str2 = PROPERTIES.get(str);
        AppMethodBeat.o(157838);
        return str2;
    }

    public static void setProperty(String str, String str2) {
        AppMethodBeat.i(157839);
        PROPERTIES.put(str, str2);
        AppMethodBeat.o(157839);
    }
}
