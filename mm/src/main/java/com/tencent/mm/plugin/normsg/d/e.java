package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> AGi = Collections.unmodifiableSet(new HashSet(Arrays.asList("US,JP,AU,CA,GB".split("\\s*,\\s*"))));

    static {
        AppMethodBeat.i(187606);
        AppMethodBeat.o(187606);
    }

    public static boolean aIX(String str) {
        AppMethodBeat.i(187605);
        if (b.Pi(str) || AGi.contains(str.toUpperCase())) {
            AppMethodBeat.o(187605);
            return true;
        }
        AppMethodBeat.o(187605);
        return false;
    }
}
