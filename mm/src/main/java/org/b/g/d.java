package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class d {
    private static final Pattern URL_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    static {
        AppMethodBeat.i(40576);
        AppMethodBeat.o(40576);
    }

    public static void j(Object obj, String str) {
        AppMethodBeat.i(40577);
        V(obj != null, str);
        AppMethodBeat.o(40577);
    }

    public static void oM(String str, String str2) {
        AppMethodBeat.i(40578);
        V(str != null && !str.trim().equals(""), str2);
        AppMethodBeat.o(40578);
    }

    private static void V(boolean z, String str) {
        AppMethodBeat.i(40579);
        if (str == null || str.trim().length() <= 0) {
            str = "Received an invalid parameter";
        }
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            AppMethodBeat.o(40579);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(40579);
    }
}
