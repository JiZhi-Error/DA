package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaDimension {
    WIDTH(0),
    HEIGHT(1);
    
    private final int mIntValue;

    public static YogaDimension valueOf(String str) {
        AppMethodBeat.i(18065);
        YogaDimension yogaDimension = (YogaDimension) Enum.valueOf(YogaDimension.class, str);
        AppMethodBeat.o(18065);
        return yogaDimension;
    }

    static {
        AppMethodBeat.i(18067);
        AppMethodBeat.o(18067);
    }

    private YogaDimension(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaDimension fromInt(int i2) {
        AppMethodBeat.i(18066);
        switch (i2) {
            case 0:
                YogaDimension yogaDimension = WIDTH;
                AppMethodBeat.o(18066);
                return yogaDimension;
            case 1:
                YogaDimension yogaDimension2 = HEIGHT;
                AppMethodBeat.o(18066);
                return yogaDimension2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18066);
                throw illegalArgumentException;
        }
    }
}
