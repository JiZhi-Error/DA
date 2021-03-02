package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaMeasureMode {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);
    
    private final int mIntValue;

    public static YogaMeasureMode valueOf(String str) {
        AppMethodBeat.i(18097);
        YogaMeasureMode yogaMeasureMode = (YogaMeasureMode) Enum.valueOf(YogaMeasureMode.class, str);
        AppMethodBeat.o(18097);
        return yogaMeasureMode;
    }

    static {
        AppMethodBeat.i(18099);
        AppMethodBeat.o(18099);
    }

    private YogaMeasureMode(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaMeasureMode fromInt(int i2) {
        AppMethodBeat.i(18098);
        switch (i2) {
            case 0:
                YogaMeasureMode yogaMeasureMode = UNDEFINED;
                AppMethodBeat.o(18098);
                return yogaMeasureMode;
            case 1:
                YogaMeasureMode yogaMeasureMode2 = EXACTLY;
                AppMethodBeat.o(18098);
                return yogaMeasureMode2;
            case 2:
                YogaMeasureMode yogaMeasureMode3 = AT_MOST;
                AppMethodBeat.o(18098);
                return yogaMeasureMode3;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18098);
                throw illegalArgumentException;
        }
    }
}
