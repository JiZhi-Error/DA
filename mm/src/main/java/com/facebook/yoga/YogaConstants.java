package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaConstants {
    public static final float UNDEFINED = Float.NaN;

    public static boolean isUndefined(float f2) {
        AppMethodBeat.i(18063);
        if (Float.compare(f2, Float.NaN) == 0) {
            AppMethodBeat.o(18063);
            return true;
        }
        AppMethodBeat.o(18063);
        return false;
    }

    public static boolean isUndefined(YogaValue yogaValue) {
        return yogaValue.unit == YogaUnit.UNDEFINED;
    }

    public static float getUndefined() {
        return Float.NaN;
    }
}
