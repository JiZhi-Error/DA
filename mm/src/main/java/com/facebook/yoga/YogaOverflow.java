package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);
    
    private final int mIntValue;

    public static YogaOverflow valueOf(String str) {
        AppMethodBeat.i(18197);
        YogaOverflow yogaOverflow = (YogaOverflow) Enum.valueOf(YogaOverflow.class, str);
        AppMethodBeat.o(18197);
        return yogaOverflow;
    }

    static {
        AppMethodBeat.i(18199);
        AppMethodBeat.o(18199);
    }

    private YogaOverflow(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaOverflow fromInt(int i2) {
        AppMethodBeat.i(18198);
        switch (i2) {
            case 0:
                YogaOverflow yogaOverflow = VISIBLE;
                AppMethodBeat.o(18198);
                return yogaOverflow;
            case 1:
                YogaOverflow yogaOverflow2 = HIDDEN;
                AppMethodBeat.o(18198);
                return yogaOverflow2;
            case 2:
                YogaOverflow yogaOverflow3 = SCROLL;
                AppMethodBeat.o(18198);
                return yogaOverflow3;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18198);
                throw illegalArgumentException;
        }
    }
}
