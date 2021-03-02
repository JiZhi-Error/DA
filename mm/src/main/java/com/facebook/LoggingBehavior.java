package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoggingBehavior {
    REQUESTS,
    INCLUDE_ACCESS_TOKENS,
    INCLUDE_RAW_RESPONSES,
    CACHE,
    APP_EVENTS,
    DEVELOPER_ERRORS,
    GRAPH_API_DEBUG_WARNING,
    GRAPH_API_DEBUG_INFO;

    public static LoggingBehavior valueOf(String str) {
        AppMethodBeat.i(17238);
        LoggingBehavior loggingBehavior = (LoggingBehavior) Enum.valueOf(LoggingBehavior.class, str);
        AppMethodBeat.o(17238);
        return loggingBehavior;
    }

    static {
        AppMethodBeat.i(17239);
        AppMethodBeat.o(17239);
    }
}
