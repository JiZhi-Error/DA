package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class z {
    private static final Set<String> dml;

    static {
        AppMethodBeat.i(160098);
        HashSet hashSet = new HashSet();
        dml = hashSet;
        hashSet.add(":nospace");
        dml.add(":cuploader");
        dml.add(":dexopt");
        dml.add(":recovery");
        dml.add(":fallback");
        dml.add(":isolated_process0");
        dml.add(":extmig");
        AppMethodBeat.o(160098);
    }

    public static String gj(String str) {
        AppMethodBeat.i(160095);
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            String substring = str.substring(indexOf);
            AppMethodBeat.o(160095);
            return substring;
        }
        AppMethodBeat.o(160095);
        return "";
    }

    public static boolean gk(String str) {
        AppMethodBeat.i(160096);
        boolean contains = dml.contains(gj(str));
        AppMethodBeat.o(160096);
        return contains;
    }

    public static boolean gl(String str) {
        AppMethodBeat.i(160097);
        boolean endsWith = str.endsWith(":nospace");
        AppMethodBeat.o(160097);
        return endsWith;
    }
}
