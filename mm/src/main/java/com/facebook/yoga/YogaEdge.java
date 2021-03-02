package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaEdge {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);
    
    private final int mIntValue;

    public static YogaEdge valueOf(String str) {
        AppMethodBeat.i(18077);
        YogaEdge yogaEdge = (YogaEdge) Enum.valueOf(YogaEdge.class, str);
        AppMethodBeat.o(18077);
        return yogaEdge;
    }

    static {
        AppMethodBeat.i(18079);
        AppMethodBeat.o(18079);
    }

    private YogaEdge(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaEdge fromInt(int i2) {
        AppMethodBeat.i(18078);
        switch (i2) {
            case 0:
                YogaEdge yogaEdge = LEFT;
                AppMethodBeat.o(18078);
                return yogaEdge;
            case 1:
                YogaEdge yogaEdge2 = TOP;
                AppMethodBeat.o(18078);
                return yogaEdge2;
            case 2:
                YogaEdge yogaEdge3 = RIGHT;
                AppMethodBeat.o(18078);
                return yogaEdge3;
            case 3:
                YogaEdge yogaEdge4 = BOTTOM;
                AppMethodBeat.o(18078);
                return yogaEdge4;
            case 4:
                YogaEdge yogaEdge5 = START;
                AppMethodBeat.o(18078);
                return yogaEdge5;
            case 5:
                YogaEdge yogaEdge6 = END;
                AppMethodBeat.o(18078);
                return yogaEdge6;
            case 6:
                YogaEdge yogaEdge7 = HORIZONTAL;
                AppMethodBeat.o(18078);
                return yogaEdge7;
            case 7:
                YogaEdge yogaEdge8 = VERTICAL;
                AppMethodBeat.o(18078);
                return yogaEdge8;
            case 8:
                YogaEdge yogaEdge9 = ALL;
                AppMethodBeat.o(18078);
                return yogaEdge9;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18078);
                throw illegalArgumentException;
        }
    }
}
