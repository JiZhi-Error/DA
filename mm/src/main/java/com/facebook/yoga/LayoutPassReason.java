package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LayoutPassReason {
    INITIAL(0),
    ABS_LAYOUT(1),
    STRETCH(2),
    MULTILINE_STRETCH(3),
    FLEX_LAYOUT(4),
    MEASURE(5),
    ABS_MEASURE(6),
    FLEX_MEASURE(7);
    
    private final int mIntValue;

    public static LayoutPassReason valueOf(String str) {
        AppMethodBeat.i(207049);
        LayoutPassReason layoutPassReason = (LayoutPassReason) Enum.valueOf(LayoutPassReason.class, str);
        AppMethodBeat.o(207049);
        return layoutPassReason;
    }

    static {
        AppMethodBeat.i(207051);
        AppMethodBeat.o(207051);
    }

    private LayoutPassReason(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static LayoutPassReason fromInt(int i2) {
        AppMethodBeat.i(207050);
        switch (i2) {
            case 0:
                LayoutPassReason layoutPassReason = INITIAL;
                AppMethodBeat.o(207050);
                return layoutPassReason;
            case 1:
                LayoutPassReason layoutPassReason2 = ABS_LAYOUT;
                AppMethodBeat.o(207050);
                return layoutPassReason2;
            case 2:
                LayoutPassReason layoutPassReason3 = STRETCH;
                AppMethodBeat.o(207050);
                return layoutPassReason3;
            case 3:
                LayoutPassReason layoutPassReason4 = MULTILINE_STRETCH;
                AppMethodBeat.o(207050);
                return layoutPassReason4;
            case 4:
                LayoutPassReason layoutPassReason5 = FLEX_LAYOUT;
                AppMethodBeat.o(207050);
                return layoutPassReason5;
            case 5:
                LayoutPassReason layoutPassReason6 = MEASURE;
                AppMethodBeat.o(207050);
                return layoutPassReason6;
            case 6:
                LayoutPassReason layoutPassReason7 = ABS_MEASURE;
                AppMethodBeat.o(207050);
                return layoutPassReason7;
            case 7:
                LayoutPassReason layoutPassReason8 = FLEX_MEASURE;
                AppMethodBeat.o(207050);
                return layoutPassReason8;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(207050);
                throw illegalArgumentException;
        }
    }
}
