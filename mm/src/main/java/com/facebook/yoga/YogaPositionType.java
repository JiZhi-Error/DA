package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaPositionType {
    RELATIVE(0),
    ABSOLUTE(1);
    
    private final int mIntValue;

    public static YogaPositionType valueOf(String str) {
        AppMethodBeat.i(18201);
        YogaPositionType yogaPositionType = (YogaPositionType) Enum.valueOf(YogaPositionType.class, str);
        AppMethodBeat.o(18201);
        return yogaPositionType;
    }

    static {
        AppMethodBeat.i(18203);
        AppMethodBeat.o(18203);
    }

    private YogaPositionType(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaPositionType fromInt(int i2) {
        AppMethodBeat.i(18202);
        switch (i2) {
            case 0:
                YogaPositionType yogaPositionType = RELATIVE;
                AppMethodBeat.o(18202);
                return yogaPositionType;
            case 1:
                YogaPositionType yogaPositionType2 = ABSOLUTE;
                AppMethodBeat.o(18202);
                return yogaPositionType2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18202);
                throw illegalArgumentException;
        }
    }
}
