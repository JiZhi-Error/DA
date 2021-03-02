package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum q {
    EXACT,
    SPAN_FLAGS;

    public static q valueOf(String str) {
        AppMethodBeat.i(181959);
        q qVar = (q) Enum.valueOf(q.class, str);
        AppMethodBeat.o(181959);
        return qVar;
    }

    static {
        AppMethodBeat.i(181960);
        AppMethodBeat.o(181960);
    }
}
