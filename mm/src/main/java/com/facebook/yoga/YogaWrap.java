package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaWrap {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);
    
    private final int mIntValue;

    public static YogaWrap valueOf(String str) {
        AppMethodBeat.i(18220);
        YogaWrap yogaWrap = (YogaWrap) Enum.valueOf(YogaWrap.class, str);
        AppMethodBeat.o(18220);
        return yogaWrap;
    }

    static {
        AppMethodBeat.i(18222);
        AppMethodBeat.o(18222);
    }

    private YogaWrap(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaWrap fromInt(int i2) {
        AppMethodBeat.i(18221);
        switch (i2) {
            case 0:
                YogaWrap yogaWrap = NO_WRAP;
                AppMethodBeat.o(18221);
                return yogaWrap;
            case 1:
                YogaWrap yogaWrap2 = WRAP;
                AppMethodBeat.o(18221);
                return yogaWrap2;
            case 2:
                YogaWrap yogaWrap3 = WRAP_REVERSE;
                AppMethodBeat.o(18221);
                return yogaWrap3;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18221);
                throw illegalArgumentException;
        }
    }
}
