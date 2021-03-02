package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);
    
    private final int mIntValue;

    public static YogaDirection valueOf(String str) {
        AppMethodBeat.i(18069);
        YogaDirection yogaDirection = (YogaDirection) Enum.valueOf(YogaDirection.class, str);
        AppMethodBeat.o(18069);
        return yogaDirection;
    }

    static {
        AppMethodBeat.i(18071);
        AppMethodBeat.o(18071);
    }

    private YogaDirection(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaDirection fromInt(int i2) {
        AppMethodBeat.i(18070);
        switch (i2) {
            case 0:
                YogaDirection yogaDirection = INHERIT;
                AppMethodBeat.o(18070);
                return yogaDirection;
            case 1:
                YogaDirection yogaDirection2 = LTR;
                AppMethodBeat.o(18070);
                return yogaDirection2;
            case 2:
                YogaDirection yogaDirection3 = RTL;
                AppMethodBeat.o(18070);
                return yogaDirection3;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18070);
                throw illegalArgumentException;
        }
    }
}
