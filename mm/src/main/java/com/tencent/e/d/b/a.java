package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class a {
    public static boolean isEmpty(Collection collection) {
        AppMethodBeat.i(224040);
        if (collection == null || collection.isEmpty()) {
            AppMethodBeat.o(224040);
            return true;
        }
        AppMethodBeat.o(224040);
        return false;
    }
}
