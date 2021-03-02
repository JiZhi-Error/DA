package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaJustify {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);
    
    private final int mIntValue;

    public static YogaJustify valueOf(String str) {
        AppMethodBeat.i(18089);
        YogaJustify yogaJustify = (YogaJustify) Enum.valueOf(YogaJustify.class, str);
        AppMethodBeat.o(18089);
        return yogaJustify;
    }

    static {
        AppMethodBeat.i(18091);
        AppMethodBeat.o(18091);
    }

    private YogaJustify(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaJustify fromInt(int i2) {
        AppMethodBeat.i(18090);
        switch (i2) {
            case 0:
                YogaJustify yogaJustify = FLEX_START;
                AppMethodBeat.o(18090);
                return yogaJustify;
            case 1:
                YogaJustify yogaJustify2 = CENTER;
                AppMethodBeat.o(18090);
                return yogaJustify2;
            case 2:
                YogaJustify yogaJustify3 = FLEX_END;
                AppMethodBeat.o(18090);
                return yogaJustify3;
            case 3:
                YogaJustify yogaJustify4 = SPACE_BETWEEN;
                AppMethodBeat.o(18090);
                return yogaJustify4;
            case 4:
                YogaJustify yogaJustify5 = SPACE_AROUND;
                AppMethodBeat.o(18090);
                return yogaJustify5;
            case 5:
                YogaJustify yogaJustify6 = SPACE_EVENLY;
                AppMethodBeat.o(18090);
                return yogaJustify6;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18090);
                throw illegalArgumentException;
        }
    }
}
