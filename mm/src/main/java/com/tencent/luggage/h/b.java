package com.tencent.luggage.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b {
    public static <L extends List<T>, T> L c(L l, List<T> list) {
        AppMethodBeat.i(140482);
        if (list != null) {
            l.addAll(list);
        }
        AppMethodBeat.o(140482);
        return l;
    }

    public static <T> List<T> G(List<T> list) {
        AppMethodBeat.i(140483);
        if (list == null) {
            List<T> emptyList = Collections.emptyList();
            AppMethodBeat.o(140483);
            return emptyList;
        }
        AppMethodBeat.o(140483);
        return list;
    }
}
