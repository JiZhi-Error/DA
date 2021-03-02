package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaUnit {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);
    
    private final int mIntValue;

    public static YogaUnit valueOf(String str) {
        AppMethodBeat.i(18209);
        YogaUnit yogaUnit = (YogaUnit) Enum.valueOf(YogaUnit.class, str);
        AppMethodBeat.o(18209);
        return yogaUnit;
    }

    static {
        AppMethodBeat.i(18211);
        AppMethodBeat.o(18211);
    }

    private YogaUnit(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaUnit fromInt(int i2) {
        AppMethodBeat.i(18210);
        switch (i2) {
            case 0:
                YogaUnit yogaUnit = UNDEFINED;
                AppMethodBeat.o(18210);
                return yogaUnit;
            case 1:
                YogaUnit yogaUnit2 = POINT;
                AppMethodBeat.o(18210);
                return yogaUnit2;
            case 2:
                YogaUnit yogaUnit3 = PERCENT;
                AppMethodBeat.o(18210);
                return yogaUnit3;
            case 3:
                YogaUnit yogaUnit4 = AUTO;
                AppMethodBeat.o(18210);
                return yogaUnit4;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18210);
                throw illegalArgumentException;
        }
    }
}
