package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l {
    opaque,
    transparent;

    public static l valueOf(String str) {
        AppMethodBeat.i(215027);
        l lVar = (l) Enum.valueOf(l.class, str);
        AppMethodBeat.o(215027);
        return lVar;
    }

    static {
        AppMethodBeat.i(215028);
        AppMethodBeat.o(215028);
    }
}
