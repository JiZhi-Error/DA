package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaAlign {
    AUTO(0),
    FLEX_START(1),
    CENTER(2),
    FLEX_END(3),
    STRETCH(4),
    BASELINE(5),
    SPACE_BETWEEN(6),
    SPACE_AROUND(7);
    
    private final int mIntValue;

    public static YogaAlign valueOf(String str) {
        AppMethodBeat.i(18051);
        YogaAlign yogaAlign = (YogaAlign) Enum.valueOf(YogaAlign.class, str);
        AppMethodBeat.o(18051);
        return yogaAlign;
    }

    static {
        AppMethodBeat.i(18053);
        AppMethodBeat.o(18053);
    }

    private YogaAlign(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaAlign fromInt(int i2) {
        AppMethodBeat.i(18052);
        switch (i2) {
            case 0:
                YogaAlign yogaAlign = AUTO;
                AppMethodBeat.o(18052);
                return yogaAlign;
            case 1:
                YogaAlign yogaAlign2 = FLEX_START;
                AppMethodBeat.o(18052);
                return yogaAlign2;
            case 2:
                YogaAlign yogaAlign3 = CENTER;
                AppMethodBeat.o(18052);
                return yogaAlign3;
            case 3:
                YogaAlign yogaAlign4 = FLEX_END;
                AppMethodBeat.o(18052);
                return yogaAlign4;
            case 4:
                YogaAlign yogaAlign5 = STRETCH;
                AppMethodBeat.o(18052);
                return yogaAlign5;
            case 5:
                YogaAlign yogaAlign6 = BASELINE;
                AppMethodBeat.o(18052);
                return yogaAlign6;
            case 6:
                YogaAlign yogaAlign7 = SPACE_BETWEEN;
                AppMethodBeat.o(18052);
                return yogaAlign7;
            case 7:
                YogaAlign yogaAlign8 = SPACE_AROUND;
                AppMethodBeat.o(18052);
                return yogaAlign8;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18052);
                throw illegalArgumentException;
        }
    }
}
