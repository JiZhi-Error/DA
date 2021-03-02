package com.tencent.mm.danmaku.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;

public final class d {
    private static HashSet<String> gQZ = new HashSet<>();

    static {
        AppMethodBeat.i(241785);
        AppMethodBeat.o(241785);
    }

    public static boolean isEmpty(Collection<? extends Object> collection) {
        AppMethodBeat.i(241784);
        if (collection == null || collection.size() <= 0) {
            AppMethodBeat.o(241784);
            return true;
        }
        AppMethodBeat.o(241784);
        return false;
    }
}
