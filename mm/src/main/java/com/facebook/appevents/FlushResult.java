package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FlushResult {
    SUCCESS,
    SERVER_ERROR,
    NO_CONNECTIVITY,
    UNKNOWN_ERROR;

    public static FlushResult valueOf(String str) {
        AppMethodBeat.i(17444);
        FlushResult flushResult = (FlushResult) Enum.valueOf(FlushResult.class, str);
        AppMethodBeat.o(17444);
        return flushResult;
    }

    static {
        AppMethodBeat.i(17445);
        AppMethodBeat.o(17445);
    }
}
