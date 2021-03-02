package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaNodeType {
    DEFAULT(0),
    TEXT(1);
    
    private final int mIntValue;

    public static YogaNodeType valueOf(String str) {
        AppMethodBeat.i(18193);
        YogaNodeType yogaNodeType = (YogaNodeType) Enum.valueOf(YogaNodeType.class, str);
        AppMethodBeat.o(18193);
        return yogaNodeType;
    }

    static {
        AppMethodBeat.i(18195);
        AppMethodBeat.o(18195);
    }

    private YogaNodeType(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaNodeType fromInt(int i2) {
        AppMethodBeat.i(18194);
        switch (i2) {
            case 0:
                YogaNodeType yogaNodeType = DEFAULT;
                AppMethodBeat.o(18194);
                return yogaNodeType;
            case 1:
                YogaNodeType yogaNodeType2 = TEXT;
                AppMethodBeat.o(18194);
                return yogaNodeType2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18194);
                throw illegalArgumentException;
        }
    }
}
