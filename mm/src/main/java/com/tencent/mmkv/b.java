package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    LevelDebug,
    LevelInfo,
    LevelWarning,
    LevelError,
    LevelNone;

    public static b valueOf(String str) {
        AppMethodBeat.i(13538);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(13538);
        return bVar;
    }

    static {
        AppMethodBeat.i(13539);
        AppMethodBeat.o(13539);
    }
}
