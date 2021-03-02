package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaMeasureOutput {
    public static long make(float f2, float f3) {
        AppMethodBeat.i(18100);
        int floatToRawIntBits = Float.floatToRawIntBits(f2);
        long floatToRawIntBits2 = ((long) Float.floatToRawIntBits(f3)) | (((long) floatToRawIntBits) << 32);
        AppMethodBeat.o(18100);
        return floatToRawIntBits2;
    }

    public static long make(int i2, int i3) {
        AppMethodBeat.i(18101);
        long make = make((float) i2, (float) i3);
        AppMethodBeat.o(18101);
        return make;
    }

    public static float getWidth(long j2) {
        AppMethodBeat.i(18102);
        float intBitsToFloat = Float.intBitsToFloat((int) (-1 & (j2 >> 32)));
        AppMethodBeat.o(18102);
        return intBitsToFloat;
    }

    public static float getHeight(long j2) {
        AppMethodBeat.i(18103);
        float intBitsToFloat = Float.intBitsToFloat((int) (-1 & j2));
        AppMethodBeat.o(18103);
        return intBitsToFloat;
    }
}
