package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YogaExperimentalFeature {
    WEB_FLEX_BASIS(0);
    
    private final int mIntValue;

    public static YogaExperimentalFeature valueOf(String str) {
        AppMethodBeat.i(18081);
        YogaExperimentalFeature yogaExperimentalFeature = (YogaExperimentalFeature) Enum.valueOf(YogaExperimentalFeature.class, str);
        AppMethodBeat.o(18081);
        return yogaExperimentalFeature;
    }

    static {
        AppMethodBeat.i(18083);
        AppMethodBeat.o(18083);
    }

    private YogaExperimentalFeature(int i2) {
        this.mIntValue = i2;
    }

    public final int intValue() {
        return this.mIntValue;
    }

    public static YogaExperimentalFeature fromInt(int i2) {
        AppMethodBeat.i(18082);
        switch (i2) {
            case 0:
                YogaExperimentalFeature yogaExperimentalFeature = WEB_FLEX_BASIS;
                AppMethodBeat.o(18082);
                return yogaExperimentalFeature;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(18082);
                throw illegalArgumentException;
        }
    }
}
