package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaLayoutType {
    LAYOUT(0),
    MEASURE(1),
    CACHED_LAYOUT(2),
    CACHED_MEASURE(3);
    
    private final int mIntValue;

    public static YogaLayoutType valueOf(String str) {
        AppMethodBeat.i(207055);
        YogaLayoutType yogaLayoutType = (YogaLayoutType) Enum.valueOf(YogaLayoutType.class, str);
        AppMethodBeat.o(207055);
        return yogaLayoutType;
    }

    static {
        AppMethodBeat.i(207057);
        AppMethodBeat.o(207057);
    }

    private YogaLayoutType(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaLayoutType fromInt(int i2) {
        AppMethodBeat.i(207056);
        switch (i2) {
            case 0:
                YogaLayoutType yogaLayoutType = LAYOUT;
                AppMethodBeat.o(207056);
                return yogaLayoutType;
            case 1:
                YogaLayoutType yogaLayoutType2 = MEASURE;
                AppMethodBeat.o(207056);
                return yogaLayoutType2;
            case 2:
                YogaLayoutType yogaLayoutType3 = CACHED_LAYOUT;
                AppMethodBeat.o(207056);
                return yogaLayoutType3;
            case 3:
                YogaLayoutType yogaLayoutType4 = CACHED_MEASURE;
                AppMethodBeat.o(207056);
                return yogaLayoutType4;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(207056);
                throw illegalArgumentException;
        }
    }
}
