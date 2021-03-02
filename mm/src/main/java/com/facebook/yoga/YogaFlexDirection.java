package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaFlexDirection {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);
    
    private final int mIntValue;

    public static YogaFlexDirection valueOf(String str) {
        AppMethodBeat.i(18085);
        YogaFlexDirection yogaFlexDirection = (YogaFlexDirection) Enum.valueOf(YogaFlexDirection.class, str);
        AppMethodBeat.o(18085);
        return yogaFlexDirection;
    }

    static {
        AppMethodBeat.i(18087);
        AppMethodBeat.o(18087);
    }

    private YogaFlexDirection(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaFlexDirection fromInt(int i2) {
        AppMethodBeat.i(18086);
        switch (i2) {
            case 0:
                YogaFlexDirection yogaFlexDirection = COLUMN;
                AppMethodBeat.o(18086);
                return yogaFlexDirection;
            case 1:
                YogaFlexDirection yogaFlexDirection2 = COLUMN_REVERSE;
                AppMethodBeat.o(18086);
                return yogaFlexDirection2;
            case 2:
                YogaFlexDirection yogaFlexDirection3 = ROW;
                AppMethodBeat.o(18086);
                return yogaFlexDirection3;
            case 3:
                YogaFlexDirection yogaFlexDirection4 = ROW_REVERSE;
                AppMethodBeat.o(18086);
                return yogaFlexDirection4;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18086);
                throw illegalArgumentException;
        }
    }
}
