package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaPrintOptions {
    LAYOUT(1),
    STYLE(2),
    CHILDREN(4);
    
    private final int mIntValue;

    public static YogaPrintOptions valueOf(String str) {
        AppMethodBeat.i(18205);
        YogaPrintOptions yogaPrintOptions = (YogaPrintOptions) Enum.valueOf(YogaPrintOptions.class, str);
        AppMethodBeat.o(18205);
        return yogaPrintOptions;
    }

    static {
        AppMethodBeat.i(18207);
        AppMethodBeat.o(18207);
    }

    private YogaPrintOptions(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaPrintOptions fromInt(int i2) {
        AppMethodBeat.i(18206);
        switch (i2) {
            case 1:
                YogaPrintOptions yogaPrintOptions = LAYOUT;
                AppMethodBeat.o(18206);
                return yogaPrintOptions;
            case 2:
                YogaPrintOptions yogaPrintOptions2 = STYLE;
                AppMethodBeat.o(18206);
                return yogaPrintOptions2;
            case 3:
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18206);
                throw illegalArgumentException;
            case 4:
                YogaPrintOptions yogaPrintOptions3 = CHILDREN;
                AppMethodBeat.o(18206);
                return yogaPrintOptions3;
        }
    }
}
