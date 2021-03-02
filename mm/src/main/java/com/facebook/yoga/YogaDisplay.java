package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDisplay {
    FLEX(0),
    NONE(1);
    
    private final int mIntValue;

    public static YogaDisplay valueOf(String str) {
        AppMethodBeat.i(18073);
        YogaDisplay yogaDisplay = (YogaDisplay) Enum.valueOf(YogaDisplay.class, str);
        AppMethodBeat.o(18073);
        return yogaDisplay;
    }

    static {
        AppMethodBeat.i(18075);
        AppMethodBeat.o(18075);
    }

    private YogaDisplay(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaDisplay fromInt(int i2) {
        AppMethodBeat.i(18074);
        switch (i2) {
            case 0:
                YogaDisplay yogaDisplay = FLEX;
                AppMethodBeat.o(18074);
                return yogaDisplay;
            case 1:
                YogaDisplay yogaDisplay2 = NONE;
                AppMethodBeat.o(18074);
                return yogaDisplay2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18074);
                throw illegalArgumentException;
        }
    }
}
