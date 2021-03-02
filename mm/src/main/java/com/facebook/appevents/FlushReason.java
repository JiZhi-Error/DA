package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public enum FlushReason {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT;

    public static FlushReason valueOf(String str) {
        AppMethodBeat.i(17441);
        FlushReason flushReason = (FlushReason) Enum.valueOf(FlushReason.class, str);
        AppMethodBeat.o(17441);
        return flushReason;
    }

    static {
        AppMethodBeat.i(17442);
        AppMethodBeat.o(17442);
    }
}
