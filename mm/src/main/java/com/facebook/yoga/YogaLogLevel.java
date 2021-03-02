package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);
    
    private final int mIntValue;

    public static YogaLogLevel valueOf(String str) {
        AppMethodBeat.i(18093);
        YogaLogLevel yogaLogLevel = (YogaLogLevel) Enum.valueOf(YogaLogLevel.class, str);
        AppMethodBeat.o(18093);
        return yogaLogLevel;
    }

    static {
        AppMethodBeat.i(18095);
        AppMethodBeat.o(18095);
    }

    private YogaLogLevel(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaLogLevel fromInt(int i2) {
        AppMethodBeat.i(18094);
        switch (i2) {
            case 0:
                YogaLogLevel yogaLogLevel = ERROR;
                AppMethodBeat.o(18094);
                return yogaLogLevel;
            case 1:
                YogaLogLevel yogaLogLevel2 = WARN;
                AppMethodBeat.o(18094);
                return yogaLogLevel2;
            case 2:
                YogaLogLevel yogaLogLevel3 = INFO;
                AppMethodBeat.o(18094);
                return yogaLogLevel3;
            case 3:
                YogaLogLevel yogaLogLevel4 = DEBUG;
                AppMethodBeat.o(18094);
                return yogaLogLevel4;
            case 4:
                YogaLogLevel yogaLogLevel5 = VERBOSE;
                AppMethodBeat.o(18094);
                return yogaLogLevel5;
            case 5:
                YogaLogLevel yogaLogLevel6 = FATAL;
                AppMethodBeat.o(18094);
                return yogaLogLevel6;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18094);
                throw illegalArgumentException;
        }
    }
}
